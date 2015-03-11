package com.polidea.hierarchyviewer.internal.logic;

import com.polidea.hierarchyviewer.internal.model.layoutparams.LayoutParamsModelInfo;

public interface LayoutParamsConverter<LAYOUT_PARAM_MODEL_INFO extends LayoutParamsModelInfo> {

    LAYOUT_PARAM_MODEL_INFO getLayoutParamsModelInfo();
}
