package com.polidea.hierarchyviewer.internal.logic;


import android.view.View;
import android.view.ViewGroup;

import com.polidea.hierarchyviewer.internal.model.layoutparams.LayoutParamsModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;

import java.util.HashMap;

public class ConvertersContainer {

    private final HashMap<Class<? extends View>, ViewConverter> viewConverters;

    private final HashMap<Class<? extends ViewGroup.LayoutParams>, LayoutParamsConverter> layoutPramsConverter;

    public ConvertersContainer() {
        viewConverters = new HashMap<>();
        layoutPramsConverter = new HashMap<>();
        initViewConverters();
        initLayoutParamsConverters();
    }

    public void addConverterForView(Class<? extends View> clazz, ModelInfo modelInfo) {
        viewConverters.put(clazz, new DefaultConverter(modelInfo));
    }

    public LayoutParamsModelInfo getLayoutParamsModelInfo(Class<? extends ViewGroup.LayoutParams> clazz) {
        LayoutParamsConverter converter;
        Class clazzKey = clazz;
        do {
            converter = layoutPramsConverter.get(clazzKey);
            if (converter == null) {
                clazzKey = clazzKey.getSuperclass();
                if (clazzKey == null) {
                    throw new IllegalArgumentException("Shouldn't happens");
                }
            }
        } while (converter == null);

        return converter.getLayoutParamsModelInfo();
    }

    public ModelInfo getModelInfoForClass(Class<? extends View> clazz) {
        ViewConverter converter;
        Class clazzKey = clazz;
        do {
            converter = viewConverters.get(clazzKey);
            if (converter == null) {
                clazzKey = clazzKey.getSuperclass();
                if (clazzKey == null) {
                    throw new IllegalArgumentException("Shouldn't happens");
                }
            }
        } while (converter == null);

        return converter.getModelInfo();
    }

    private void initLayoutParamsConverters() {
        SystemLayoutParamsConverter[] systemLayoutParamsConverters = SystemLayoutParamsConverter.values();
        for (SystemLayoutParamsConverter systemLayoutParamsConverter : systemLayoutParamsConverters) {
            layoutPramsConverter.put(systemLayoutParamsConverter.clazz, systemLayoutParamsConverter);
        }
    }

    private void initViewConverters() {
        SystemViewConverter[] systemViewConverters = SystemViewConverter.values();
        for (SystemViewConverter systemViewConverter : systemViewConverters) {
            viewConverters.put(systemViewConverter.clazz, systemViewConverter);
        }
    }
}
