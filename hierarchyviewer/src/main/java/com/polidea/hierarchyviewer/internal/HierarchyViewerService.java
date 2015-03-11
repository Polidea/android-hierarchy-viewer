package com.polidea.hierarchyviewer.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.polidea.hierarchyviewer.HierarchyViewer;
import com.polidea.hierarchyviewer.internal.dependencyinjection.HierarchyViewerComponent;
import com.polidea.hierarchyviewer.internal.provider.FileUtilsProvider;
import java.io.IOException;
import javax.inject.Inject;

public class HierarchyViewerService extends Service {


    @Inject
    HTTPServer server;

    @Inject
    FileUtilsProvider fileUtilsProvider;

    @Override
    public void onCreate() {
        super.onCreate();
        HierarchyViewer.component().inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        fileUtilsProvider.createCacheFolderIfNotExist();
        fileUtilsProvider.clearCacheFolder();
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

}
