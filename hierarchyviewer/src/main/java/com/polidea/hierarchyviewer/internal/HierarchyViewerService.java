package com.polidea.hierarchyviewer.internal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.polidea.hierarchyviewer.HierarchyViewer;
import com.polidea.hierarchyviewer.internal.provider.WebServer;

import java.io.IOException;

import javax.inject.Inject;

public class HierarchyViewerService extends Service {


    @Inject
    WebServer server;

    @Override
    public void onCreate() {
        super.onCreate();
        HierarchyViewer.component().inject(this);
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
        super.onDestroy();
        server.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
