package com.polidea.hierarchyviewer.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.polidea.hierarchyviewer.internal.dependencyinjection.HierarchyViewerComponent;
import java.io.IOException;
import javax.inject.Inject;

public class HierarchyViewerService extends Service {

    private static HierarchyViewerComponent component;

    @Inject
    HTTPServer server;

    @Override
    public void onCreate() {
        super.onCreate();
        HierarchyViewerService.initializeComponent(this);
        HierarchyViewerService.component().inject(this);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return START_STICKY_COMPATIBILITY;
    }

    @Override
    public void onDestroy() {
        server.stop();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void initializeComponent(Context context) {
        component = HierarchyViewerComponent.Initializer.init(context);
    }

    public static HierarchyViewerComponent component() {
        return component;
    }
}
