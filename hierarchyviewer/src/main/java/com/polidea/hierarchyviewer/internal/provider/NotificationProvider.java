package com.polidea.hierarchyviewer.internal.provider;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import com.polidea.hierarchyviewer.BuildConfig;
import com.polidea.hierarchyviewer.HierarchyViewer;
import com.polidea.hierarchyviewer.R;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NotificationProvider {

    private static final int NOTIFICATION_ID = 1000;

    @Inject
    NotificationManager notificationManager;

    @Inject
    ServerInfoProvider serverInfoProvider;

    private final Context context;

    public NotificationProvider(Context context) {
        this.context = context;
        HierarchyViewer.component().inject(this);
    }


    public void showServerAddressNotificationWithUrl() {
        final Notification notification = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_stat_hardware_laptop)
                .setContentTitle(context.getString(R.string.server_address))
                .setContentText(serverInfoProvider.getIpAddress() + ":" + BuildConfig.PORT)
                .setOngoing(true)
                .build();
        notification.flags = Notification.DEFAULT_LIGHTS | Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

    public void cancelServerAddressNotificationWithUrl(){
        notificationManager.cancel(NOTIFICATION_ID);
    }

}
