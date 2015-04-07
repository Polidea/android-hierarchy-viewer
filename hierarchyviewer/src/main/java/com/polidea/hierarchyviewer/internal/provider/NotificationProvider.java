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
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NotificationProvider {

    private static final int NOTIFICATION_ID = 1000;

    private static final int NOTIFICATION_TURN_OFF_REQUEST_CODE = 2000;

    public static final String NOTIFICATION_ACTION_KEY = "NOTIFICATION_ACTION_KEY";

    public static final int NOTIFICATION_TURN_OFF_ACTION = 3000;

    @Inject
    NotificationManager notificationManager;

    @Inject
    ServerInfoProvider serverInfoProvider;

    @Inject
    Config config;

    private final Context context;

    public NotificationProvider(Context context) {
        this.context = context;
        HierarchyViewer.component().inject(this);
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

    public void cancelServerAddressNotificationWithUrl() {
        notificationManager.cancel(NOTIFICATION_ID);
    }

    public boolean isTurnOffNotificationIntent(Intent intent) {
        return intent.getIntExtra(NOTIFICATION_ACTION_KEY, -1) == NOTIFICATION_TURN_OFF_ACTION;
    }
}
