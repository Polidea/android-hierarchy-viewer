package com.polidea.hierarchyviewerdemo;

import android.view.View;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.model.view.TextViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ViewModelInfo;
import com.polidea.hierarchyviewer.internal.provider.FileUtilsProvider;

public class MyTextViewModelInfo extends TextViewModelInfo {

    @SerializedName("myCustomItem")
    String myCustomItem;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer, FileUtilsProvider fileUtilsProvider) {
        super.setDataFromView(view, convertersContainer, fileUtilsProvider);
        myCustomItem = ((MyTextView) view).getMyCustomItem();
    }
}
