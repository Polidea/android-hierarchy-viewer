package com.polidea.hierarchyviewerdemo;

import android.view.View;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.model.view.TextViewModelInfo;

public class MyTextViewModelInfo extends TextViewModelInfo {

    @SerializedName("my_custom_item_value")
    String myCustomItem;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);
        myCustomItem = ((MyTextView) view).getSupperHint();
    }
}
