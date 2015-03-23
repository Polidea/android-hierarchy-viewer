package com.polidea.hierarchyviewer;


import android.view.View;
import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;
import java.util.HashMap;
import java.util.Map;

public class Config {

    private static final int DEFAULT_PORT = 4000;

    private HashMap<Class<? extends View>, ModelInfo> convertersHashMap;

    private int port;

    private Config(Builder configBuilder) {
        convertersHashMap = new HashMap<>();
        for (Map.Entry<? extends Class<? extends View>, ? extends ModelInfo> entry : configBuilder.convertersHashMap.entrySet()) {
            convertersHashMap.put(entry.getKey(), entry.getValue());
        }
        port = configBuilder.port;
    }

    public HashMap<Class<? extends View>, ModelInfo> getConvertersHashMap() {
        return convertersHashMap;
    }

    public int getPort() {
        return port;
    }

    public static class Builder {

        private HashMap<Class<? extends View>, ModelInfo> convertersHashMap;

        private int port;

        public Builder() {
            convertersHashMap = new HashMap<>();
            port = DEFAULT_PORT;
        }

        public Builder add(Class<? extends View> clazz, ModelInfo modelInfo) {
            convertersHashMap.put(clazz, modelInfo);
            return this;
        }

        public Builder port(int port) {
            port = port;
            return this;
        }

        public Config build() {
            return new Config(this);
        }
    }
}
