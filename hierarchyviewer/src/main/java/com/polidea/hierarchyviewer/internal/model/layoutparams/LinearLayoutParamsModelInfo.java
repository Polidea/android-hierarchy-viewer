package com.polidea.hierarchyviewer.internal.model.layoutparams;


import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.gson.annotations.SerializedName;

public class LinearLayoutParamsModelInfo extends ViewGroupMarginLayoutParamsModelInfo {

    interface Metadata{
        String WEIGHT = "weight";
        String GRAVITY = "layoutGravity";
    }

    @SerializedName(Metadata.WEIGHT)
    float weight;

    @SerializedName(Metadata.GRAVITY)
    LayoutGravity layoutGravity;

    @Override
    public void setDataFromLayoutParams(ViewGroup.LayoutParams viewGroup) {
        super.setDataFromLayoutParams(viewGroup);

        LinearLayout.LayoutParams linearLayoutParams = (LinearLayout.LayoutParams) viewGroup;
        weight = linearLayoutParams.weight;
        layoutGravity = LayoutGravity.intToGravity(linearLayoutParams.gravity);
    }
}
