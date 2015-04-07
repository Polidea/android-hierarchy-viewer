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
import javax.inject.Inject;

public class HierarchyViewerService extends Service {

    @Inject
    WebServer server;

    @Inject
    Config config;

    @Inject
    ConvertersContainer convertersContainer;

    @Inject
    NotificationProvider notificationProvider;

    @Inject
    DeviceInfoProvider deviceInfoProvider;

    private static boolean isRunning = false;

    @Override
    public void onCreate() {
        super.onCreate();
        HierarchyViewer.component().inject(this);

        addCustomConvertersFromConfig();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!isRunning) {
            startServerAndShowNotification();
        }
        if(notificationProvider.isTurnOffNotificationIntent(intent)) {
            stopSelf();
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        server.stop();
        isRunning = false;

        notificationProvider.cancelServerAddressNotificationWithUrl();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static boolean isRunning() {
        return isRunning;
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

    private void addCustomConvertersFromConfig() {
        for (Map.Entry<? extends Class<? extends View>, ? extends ModelInfo> entry : config.getConvertersHashMap().entrySet()) {
            convertersContainer.addConverterForView(entry.getKey(), entry.getValue());
        }
    }

}
