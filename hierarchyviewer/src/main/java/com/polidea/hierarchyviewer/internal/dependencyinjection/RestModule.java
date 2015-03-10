package com.polidea.hierarchyviewer.internal.dependencyinjection;

import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
class RestModule {

    @Provides
    @Singleton
    Gson provideGson(){
       return new Gson();
    }
}
