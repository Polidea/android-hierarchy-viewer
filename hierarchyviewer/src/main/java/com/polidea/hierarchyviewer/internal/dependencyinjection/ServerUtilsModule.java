package com.polidea.hierarchyviewer.internal.dependencyinjection;

import android.content.Context;

import com.polidea.hierarchyviewer.Config;
import com.polidea.hierarchyviewer.internal.provider.DeviceInfoProvider;
import com.polidea.hierarchyviewer.internal.provider.NotificationProvider;
import com.polidea.hierarchyviewer.internal.provider.ServerInfoProvider;
import com.polidea.hierarchyviewer.internal.provider.WebServer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class ServerUtilsModule {

    private Context context;

    ServerUtilsModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    ServerInfoProvider provideServerInfoProvider() {
        return new ServerInfoProvider(context);
    }

    @Singleton
    @Provides
    NotificationProvider provideNotificationProvider(){
        return new NotificationProvider(context);
    }


    @Singleton
    @Provides
    WebServer provideWebServer(Config config) {
        return new WebServer(context, config.getPort());
    }

    @Singleton
    @Provides
    DeviceInfoProvider provideDeviceInfoProvider() {
        return new DeviceInfoProvider(context);
    }

}
