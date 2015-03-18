package com.polidea.hierarchyviewer.internal.model.view;

import android.view.View;
import android.widget.CompoundButton;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.provider.FileUtilsProvider;

public class CompoundButtonModelInfo extends ButtonModelInfo {

    public interface Metadata {

        String IS_CHECKED = "is_checked";
    }

    @SerializedName(Metadata.IS_CHECKED)
    boolean isChecked;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer, FileUtilsProvider fileUtilsProvider) {
        super.setDataFromView(view, convertersContainer, fileUtilsProvider);
        CompoundButton compoundButton = (CompoundButton) view;
        isChecked = compoundButton.isChecked();
    }
}
