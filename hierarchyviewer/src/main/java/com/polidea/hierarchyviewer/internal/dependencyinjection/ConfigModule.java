package com.polidea.hierarchyviewer.internal.dependencyinjection;

import com.polidea.hierarchyviewer.Config;
import dagger.Module;
import dagger.Provides;

@Module
public class ConfigModule {

    private Config config;

    public ConfigModule(Config config) {
        this.config = config;
    }

    @Provides
    Config provideConfig() {
        return config;
    }
}
