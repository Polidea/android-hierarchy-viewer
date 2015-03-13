package com.polidea.hierarchyviewer.internal.dependencyinjection;

import android.app.NotificationManager;
import android.content.Context;
import android.view.WindowManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
class SystemModule {

    private Context context;

    public SystemModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    WindowManager provideWindowManager() {
        return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }

    @Singleton
    @Provides
    NotificationManager provideNotificationManager() {
        return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }
}
