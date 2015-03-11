package com.polidea.hierarchyviewer.internal.logic;


import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;

public interface ViewConverter<T extends  ModelInfo> {

    abstract T getModelInfo();
}
