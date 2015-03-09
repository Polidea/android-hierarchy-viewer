package com.polidea.hierarchyviewer;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

public class Utils {

    public static String getIpAddress(Context context) {
        WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
    }
}