package com.polidea.hierarchyviewer;


import android.content.Context;
import android.view.View;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

public class Config {

    final Context context;

    @Inject
    ConvertersContainer convertersContainer;

    protected Config(Context context) {
        HierarchyViewer.initializeComponent(context);
        this.context = context;
        HierarchyViewer.component().inject(this);
    }

    private Config(Builder configBuilder) {
        this(configBuilder.context);
        for (Map.Entry<? extends Class<? extends View>, ? extends ModelInfo> entry : configBuilder.convertersHashMap.entrySet()) {
            convertersContainer.addConverterForView(entry.getKey(), entry.getValue());
        }
    }


    public static class Builder {

        private final Context context;

        private HashMap<Class<? extends View>, ModelInfo> convertersHashMap;

        public Builder(Context context) {
            this.context = context;
            convertersHashMap = new HashMap<>();
        }

        public Builder add(Class<? extends View> clazz, ModelInfo modelInfo) {
            convertersHashMap.put(clazz, modelInfo);
            return this;
        }

        public Config build() {
            return new Config(this);
        }

    }
}
