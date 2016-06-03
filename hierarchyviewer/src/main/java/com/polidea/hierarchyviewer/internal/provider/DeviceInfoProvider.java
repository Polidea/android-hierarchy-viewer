package com.polidea.hierarchyviewer.internal.provider;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.polidea.hierarchyviewer.Config;
import com.polidea.hierarchyviewer.HierarchyViewer;
import com.polidea.hierarchyviewer.R;

public class DeviceInfoProvider {

    private final static String LOG_TAG = "Hierarchy Viewer";
    private final Context context;
    private ServerInfoProvider serverInfoProvider;
    private Config config;

    public DeviceInfoProvider(Context context) {
        this.context = context;
        serverInfoProvider = HierarchyViewer.injector().getServerInfoProvider();
        config = HierarchyViewer.injector().getConfig();
    }

    private boolean isEmulator() {
        return Build.FINGERPRINT.startsWith("generic");
    }

    public void logServerAddressInfoMessage() {
        int port = config.getPort();

        Log.i(LOG_TAG, "##############################");
        Log.i(LOG_TAG, context.getString(R.string.open_this_webpage) + " " + serverInfoProvider.getIpAddress() + ":" + port);
        if (isEmulator()) {
            Log.i(LOG_TAG, String.format(context.getString(R.string.emulator_info), port, port));
        }
        Log.i(LOG_TAG, "##############################");
    }
}
