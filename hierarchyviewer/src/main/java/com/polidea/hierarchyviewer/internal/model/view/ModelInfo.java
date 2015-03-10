package com.polidea.hierarchyviewer.internal.model.view;

import android.view.View;
import com.polidea.hierarchyviewer.internal.logic.Converter;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public interface ModelInfo {

    void setDataFromView(View view, ConvertersContainer convertersContainer);

}
