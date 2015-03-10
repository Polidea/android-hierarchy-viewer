package com.polidea.hierarchyviewer.internal.dependencyinjection;

import android.content.Context;
import com.polidea.hierarchyviewer.internal.HTTPServer;
import com.polidea.hierarchyviewer.internal.provider.ServerInfoProvider;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

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
    HTTPServer provideHttpServer() {
        return new HTTPServer();
    }

}
