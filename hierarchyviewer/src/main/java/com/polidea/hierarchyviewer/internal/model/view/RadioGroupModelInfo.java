package com.polidea.hierarchyviewer.internal.model.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.provider.FileUtilsProvider;

public class RadioGroupModelInfo extends ViewGroupModelInfo {

    interface Metadata{
        String CHECKED_ITEM_ID = "checked_item_id";
    }

    @SerializedName(Metadata.CHECKED_ITEM_ID)
    int checkedItemId;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer, FileUtilsProvider fileUtilsProvider) {
        super.setDataFromView(view, convertersContainer, fileUtilsProvider);
        final RadioGroup radioGroup = (RadioGroup) view;
        checkedItemId = radioGroup.getCheckedRadioButtonId();
    }
}
