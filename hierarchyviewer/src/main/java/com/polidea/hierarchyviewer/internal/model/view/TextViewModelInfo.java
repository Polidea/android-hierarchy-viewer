package com.polidea.hierarchyviewer.internal.model.view;


import android.view.View;
import android.widget.TextView;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class TextViewModelInfo extends ViewModelInfo {
    interface Metadata {
        String TEXT = "text";
    }

    @SerializedName(Metadata.TEXT)
    String text;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);
        TextView textView = (TextView) view;
        text = textView.getText().toString();
    }
}
