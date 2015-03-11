package com.polidea.hierarchyviewer.internal.model.view;

import android.view.View;
import android.widget.CompoundButton;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class CompoundButtonModelInfo extends ButtonModelInfo {

    public interface Metadata {

        String IS_CHECKED = "isChecked";
    }

    @SerializedName(Metadata.IS_CHECKED)
    boolean isChecked;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);
        CompoundButton compoundButton = (CompoundButton) view;
        isChecked = compoundButton.isChecked();
    }
}
