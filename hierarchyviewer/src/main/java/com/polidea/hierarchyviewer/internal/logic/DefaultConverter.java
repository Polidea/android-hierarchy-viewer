package com.polidea.hierarchyviewer.internal.logic;

import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;

/**
 * Created by Konrad on 10/03/15.
 */
public class DefaultConverter implements Converter<ModelInfo> {

    private ModelInfo modelInfo;

    public DefaultConverter(ModelInfo modelInfo) {
        this.modelInfo = modelInfo;
    }

    @Override
    public ModelInfo getModelInfo() {
        return modelInfo;
    }
}
