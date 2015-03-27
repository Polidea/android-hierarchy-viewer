package com.polidea.hierarchyviewer.internal.model.view;

import android.view.View;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public interface ModelInfo {

    int ID_NOT_FOUND = -1;

    void setDataFromView(View view, ConvertersContainer convertersContainer);
}
