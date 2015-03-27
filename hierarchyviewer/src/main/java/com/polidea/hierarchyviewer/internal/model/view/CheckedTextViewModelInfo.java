package com.polidea.hierarchyviewer.internal.model.view;

import android.view.View;
import android.widget.CheckedTextView;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class CheckedTextViewModelInfo extends TextViewModelInfo {

    public interface Metadata {

        String IS_CHECKED = "isChecked";
    }

    @SerializedName(Metadata.IS_CHECKED)
    boolean isChecked;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);
        CheckedTextView checkedTextView = (CheckedTextView) view;
        isChecked = checkedTextView.isChecked();
    }
}
