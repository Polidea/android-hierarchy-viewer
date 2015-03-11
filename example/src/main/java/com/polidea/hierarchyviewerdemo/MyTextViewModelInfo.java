package com.polidea.hierarchyviewerdemo;

import android.view.View;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.model.view.ViewModelInfo;

public class MyTextViewModelInfo extends ViewModelInfo {

    @SerializedName("myCustomItem")
    String myCustomItem;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);
        myCustomItem = ((MyTextView) view).getMyCustomItem();
    }
}
