package com.polidea.hierarchyviewer.internal.provider;

import android.content.Context;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;


public class ServerInfoProvider {

    private Context context;

    public ServerInfoProvider(Context context) {
        this.context = context;
    }

    String getIpAddress() {
        String ipAddress = getIpAddress(true);
        if (ipAddress == null) {
            ipAddress = getIpAddress(false);
        }
        return ipAddress;
    }

    private String getIpAddress(boolean useIPv4) {
        String result = null;
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                result = getIpAddress(intf, useIPv4);
                if (result != null) {
                    break;
                }
            }
        } catch (Exception ignored) {
        }

        return result;
    }

    private String getIpAddress(NetworkInterface intf, boolean useIPv4) {
        String result = null;

        List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
        for (InetAddress addr : addrs) {
            if (!addr.isLoopbackAddress()) {
                String sAddr = addr.getHostAddress().toUpperCase();
                boolean isIPv4 = addr instanceof Inet4Address;
                if (useIPv4 && isIPv4) {
                    result = sAddr;
                    break;
                } else if (!useIPv4 && !isIPv4) {
                    result = sAddr;
                    break;
                }
            }
        }

        return result;
    }
}