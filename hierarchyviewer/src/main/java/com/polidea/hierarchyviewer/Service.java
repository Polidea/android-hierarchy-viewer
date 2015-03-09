package com.polidea.hierarchyviewer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.io.IOException;

public class Service extends android.app.Service {

    private HTTPServer server;

    public Service() {
    }

    public Service(String name) {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            server = new HTTPServer(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
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


}
