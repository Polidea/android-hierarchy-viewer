package com.polidea.hierarchyviewer.internal.dependencyinjection;

import android.widget.ImageView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.polidea.hierarchyviewer.internal.gson.ScaleTypeSerializer;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
class RestModule {

    @Provides
    @Singleton
    Gson provideGson(){
       return new GsonBuilder()
               .registerTypeAdapter(ImageView.ScaleType.class, new ScaleTypeSerializer())
               .create();
    }
}
