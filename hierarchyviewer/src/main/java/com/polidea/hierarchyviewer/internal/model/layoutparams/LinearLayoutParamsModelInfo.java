package com.polidea.hierarchyviewer.internal.model.layoutparams;


import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.gson.annotations.SerializedName;

public class LinearLayoutParamsModelInfo extends ViewGroupMarginLayoutParamsModelInfo {

    interface Metadata{
        String WEIGHT = "weight";
        String GRAVITY = "layout_gravity";
    }

    @SerializedName(Metadata.WEIGHT)
    float weight;

    @SerializedName(Metadata.GRAVITY)
    LayoutGravity layoutGravity;

    @Override
    public void setDataFromLayoutParams(ViewGroup.LayoutParams viewGroupLayoutParams) {
        super.setDataFromLayoutParams(viewGroupLayoutParams);

        LinearLayout.LayoutParams linearLayoutParams = (LinearLayout.LayoutParams) viewGroupLayoutParams;
        weight = linearLayoutParams.weight;
        layoutGravity = LayoutGravity.intToGravity(linearLayoutParams.gravity);
    }
}
