package com.polidea.hierarchyviewer.internal.model.layoutparams;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.gson.annotations.SerializedName;

public class RelativeLayoutParamsModelInfo extends ViewGroupMarginLayoutParamsModelInfo {

    interface Metadata {

        String RULES = "rules";
    }

    @SerializedName(Metadata.RULES)
    int[] rules;

    @Override
    public void setDataFromLayoutParams(ViewGroup.LayoutParams viewGroup) {
        super.setDataFromLayoutParams(viewGroup);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup;
        rules = layoutParams.getRules();
    }
}
