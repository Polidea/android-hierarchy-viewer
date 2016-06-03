package com.polidea.hierarchyviewer.internal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;

import com.polidea.hierarchyviewer.Config;
import com.polidea.hierarchyviewer.HierarchyViewer;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;
import com.polidea.hierarchyviewer.internal.provider.DeviceInfoProvider;
import com.polidea.hierarchyviewer.internal.provider.NotificationProvider;
import com.polidea.hierarchyviewer.internal.provider.WebServer;

import java.io.IOException;
import java.util.Map;

public class HierarchyViewerService extends Service {

    private static boolean isRunning = false;
    private WebServer server;
    private Config config;
    private ConvertersContainer convertersContainer;
    private NotificationProvider notificationProvider;
    private DeviceInfoProvider deviceInfoProvider;

    public static boolean isRunning() {
        return isRunning;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        server = HierarchyViewer.injector().getWebServer();
        config = HierarchyViewer.injector().getConfig();
        convertersContainer = HierarchyViewer.injector().getConvertersContainer();
        notificationProvider = HierarchyViewer.injector().getNotificationProvider();
        deviceInfoProvider = HierarchyViewer.injector().getDeviceInfoProvider();

        addCustomConvertersFromConfig();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        server.stop();
        isRunning = false;

        notificationProvider.cancelServerAddressNotificationWithUrl();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!isRunning) {
            startServerAndShowNotification();
        }
        if (notificationProvider.isTurnOffNotificationIntent(intent)) {
            stopSelf();
        }
        return START_NOT_STICKY;
    }

    private void addCustomConvertersFromConfig() {
        for (Map.Entry<? extends Class<? extends View>, ? extends ModelInfo> entry : config.getConvertersHashMap().entrySet()) {
            convertersContainer.addConverterForView(entry.getKey(), entry.getValue());
        }
    }

    private void startServerAndShowNotification() {
        try {
            server.start();
            isRunning = true;

            notificationProvider.showServerAddressNotificationWithUrl();
            deviceInfoProvider.logServerAddressInfoMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
