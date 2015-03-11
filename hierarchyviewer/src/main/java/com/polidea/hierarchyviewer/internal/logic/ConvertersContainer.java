package com.polidea.hierarchyviewer.internal.logic;


import android.view.View;
import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ConvertersContainer {

    private final HashMap<Class, Converter> converters;

    @Inject
    ConvertersContainer() {
        converters = new HashMap<>();
        init();
    }

    private void init() {
        SystemConverter[] systemConverters = SystemConverter.values();
        for (SystemConverter systemConverter : systemConverters) {
            converters.put(systemConverter.clazz, systemConverter);
        }
    }

    public ModelInfo getModelInfoForClass(Class<? extends View> clazz) {
        Converter converter;
        Class clazzKey = clazz;
        do {
            converter = converters.get(clazzKey);
            if (converter == null) {
                clazzKey = clazzKey.getSuperclass();
                if (clazzKey == null) {
                    throw new IllegalArgumentException("Shouldn't happens");
                }
            }
        } while (converter == null);

        return converter.getModelInfo();
    }

     public  void addConverterForView(Class<? extends  View> clazz, ModelInfo modelInfo){
        converters.put(clazz, new DefaultConverter(modelInfo));
    }
}
