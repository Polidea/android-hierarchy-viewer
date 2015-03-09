package com.polidea.hierarchyviewer.internal.provider;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;


public class ServerInfoProvider {

    private Context context;

    public ServerInfoProvider(Context context){
        this.context = context;
    }

    public String getIpAddress() {
        WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
    }
}
