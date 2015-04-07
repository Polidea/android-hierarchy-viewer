package com.polidea.hierarchyviewer.internal.provider;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.polidea.hierarchyviewer.Config;
import com.polidea.hierarchyviewer.HierarchyViewer;
import com.polidea.hierarchyviewer.R;
import javax.inject.Inject;

public class DeviceInfoProvider {

    public final static String LOG_TAG = "Hierarchy Viewer";

    @Inject
    ServerInfoProvider serverInfoProvider;

    @Inject
    Config config;

    private final Context context;

    public DeviceInfoProvider(Context context) {
        this.context = context;
        HierarchyViewer.component().inject(this);
    }

    public boolean isEmulator() {
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
