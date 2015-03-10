package com.polidea.hierarchyviewer.internal.logic;


import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;

public interface Converter<T extends  ModelInfo> {

    abstract T getModelInfo();
}
