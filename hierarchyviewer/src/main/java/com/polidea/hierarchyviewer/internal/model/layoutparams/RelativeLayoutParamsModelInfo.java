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
    public void setDataFromLayoutParams(ViewGroup.LayoutParams viewGroupLayoutParams) {
        super.setDataFromLayoutParams(viewGroupLayoutParams);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroupLayoutParams;
        rules = layoutParams.getRules();
    }
}
