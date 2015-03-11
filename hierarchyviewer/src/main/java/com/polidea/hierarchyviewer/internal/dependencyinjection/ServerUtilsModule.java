package com.polidea.hierarchyviewer.internal.dependencyinjection;

import android.content.Context;

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
    WebServer provideWebServer() {
        return new WebServer(context);
    }

}
