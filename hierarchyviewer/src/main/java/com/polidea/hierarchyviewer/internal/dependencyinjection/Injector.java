package com.polidea.hierarchyviewer.internal.dependencyinjection;

import android.app.NotificationManager;
import android.content.Context;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.polidea.hierarchyviewer.Config;
import com.polidea.hierarchyviewer.internal.gson.ScaleTypeSerializer;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.logic.HierarchyViewConverter;
import com.polidea.hierarchyviewer.internal.provider.DeviceInfoProvider;
import com.polidea.hierarchyviewer.internal.provider.FileUtilsProvider;
import com.polidea.hierarchyviewer.internal.provider.HierarchyViewProvider;
import com.polidea.hierarchyviewer.internal.provider.NotificationProvider;
import com.polidea.hierarchyviewer.internal.provider.ServerInfoProvider;
import com.polidea.hierarchyviewer.internal.provider.WebServer;

public class Injector {

    private Context context;
    private Config config;
    private WindowManager windowManager;
    private NotificationManager notificationManager;
    private ServerInfoProvider serverInfoProvider;
    private NotificationProvider notificationProvider;
    private WebServer webServer;
    private DeviceInfoProvider deviceInfoProvider;
    private Gson gson;
    private ConvertersContainer convertersContainer;
    private HierarchyViewConverter hierarchyViewConverter;
    private HierarchyViewProvider hierarchyViewProvider;
    private FileUtilsProvider fileUtilsProvider;

    public Injector(Context context, Config config) {
        this.context = context.getApplicationContext();
        this.config = config;
    }

    public Config getConfig() {
        return config;
    }

    public ConvertersContainer getConvertersContainer() {

        if (convertersContainer == null) {
            convertersContainer = new ConvertersContainer();
        }

        return convertersContainer;
    }

    public DeviceInfoProvider getDeviceInfoProvider() {

        if (deviceInfoProvider == null) {
            deviceInfoProvider = new DeviceInfoProvider(context);
        }

        return deviceInfoProvider;
    }

    public FileUtilsProvider getFileUtilsProvider() {

        if (fileUtilsProvider == null) {
            fileUtilsProvider = new FileUtilsProvider();
        }

        return fileUtilsProvider;
    }

    public Gson getGson() {

        if (gson == null) {
            gson = new GsonBuilder()
                    .registerTypeAdapter(ImageView.ScaleType.class, new ScaleTypeSerializer())
                    .create();
        }

        return gson;
    }

    public HierarchyViewConverter getHierarchyViewConverter() {

        if (hierarchyViewConverter == null) {
            hierarchyViewConverter = new HierarchyViewConverter();
        }

        return hierarchyViewConverter;
    }

    public HierarchyViewProvider getHierarchyViewProvider() {

        if (hierarchyViewProvider == null) {
            hierarchyViewProvider = new HierarchyViewProvider(getWindowManager());
        }

        return hierarchyViewProvider;
    }

    public NotificationManager getNotificationManager() {

        if (notificationManager == null) {
            notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return notificationManager;
    }

    public NotificationProvider getNotificationProvider() {

        if (notificationProvider == null) {
            notificationProvider = new NotificationProvider(context);
        }

        return notificationProvider;
    }

    public ServerInfoProvider getServerInfoProvider() {

        if (serverInfoProvider == null) {
            serverInfoProvider = new ServerInfoProvider(context);
        }

        return serverInfoProvider;
    }

    public WebServer getWebServer() {

        if (webServer == null) {
            webServer = new WebServer(context, getConfig().getPort());
        }

        return webServer;
    }

    public WindowManager getWindowManager() {

        if (windowManager == null) {
            windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        }

        return windowManager;
    }
}
