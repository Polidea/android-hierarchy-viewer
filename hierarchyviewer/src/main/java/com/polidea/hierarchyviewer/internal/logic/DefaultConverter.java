package com.polidea.hierarchyviewer.internal.logic;

import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;

public class DefaultConverter implements ViewConverter<ModelInfo> {

    private ModelInfo modelInfo;

    public DefaultConverter(ModelInfo modelInfo) {
        this.modelInfo = modelInfo;
    }

    @Override
    public ModelInfo getModelInfo() {
        return modelInfo;
    }
}
