package com.polidea.hierarchyviewer.internal.provider;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.polidea.hierarchyviewer.Config;
import com.polidea.hierarchyviewer.HierarchyViewer;
import com.polidea.hierarchyviewer.R;
import com.polidea.hierarchyviewer.internal.HierarchyViewerService;

public class NotificationProvider {

    private static final String NOTIFICATION_ACTION_KEY = "NOTIFICATION_ACTION_KEY";
    private static final int NOTIFICATION_TURN_OFF_ACTION = 3000;
    private static final int NOTIFICATION_ID = 1000;
    private static final int NOTIFICATION_TURN_OFF_REQUEST_CODE = 2000;
    private final Context context;
    private NotificationManager notificationManager;
    private ServerInfoProvider serverInfoProvider;
    private Config config;

    public NotificationProvider(Context context) {
        this.context = context;
        notificationManager = HierarchyViewer.injector().getNotificationManager();
        serverInfoProvider = HierarchyViewer.injector().getServerInfoProvider();
        config = HierarchyViewer.injector().getConfig();
    }

    public void cancelServerAddressNotificationWithUrl() {
        notificationManager.cancel(NOTIFICATION_ID);
    }

    public boolean isTurnOffNotificationIntent(Intent intent) {
        return intent.getIntExtra(NOTIFICATION_ACTION_KEY, -1) == NOTIFICATION_TURN_OFF_ACTION;
    }

    public void showServerAddressNotificationWithUrl() {
        Intent turnOffIntent = new Intent(context, HierarchyViewerService.class);
        turnOffIntent.putExtra(NOTIFICATION_ACTION_KEY, NOTIFICATION_TURN_OFF_ACTION);
        PendingIntent turnOffPendingIntent = PendingIntent.getService(context, NOTIFICATION_TURN_OFF_REQUEST_CODE, turnOffIntent, PendingIntent.FLAG_ONE_SHOT);

        final Notification notification = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_stat_hardware_laptop)
                .setContentText(context.getString(R.string.open_this_webpage))
                .setContentTitle("http://" + serverInfoProvider.getIpAddress() + ":" + config.getPort())
                .addAction(android.R.drawable.ic_delete, context.getString(R.string.turn_off), turnOffPendingIntent)
                .setOngoing(true)
                .build();
        notification.flags = notification.flags | Notification.DEFAULT_LIGHTS;
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
