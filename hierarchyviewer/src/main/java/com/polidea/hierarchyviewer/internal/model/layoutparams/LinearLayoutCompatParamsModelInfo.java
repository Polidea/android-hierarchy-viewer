package com.polidea.hierarchyviewer.internal.model.layoutparams;


import android.support.v7.widget.*;
import android.view.ViewGroup;
import com.google.gson.annotations.SerializedName;

public class LinearLayoutCompatParamsModelInfo extends ViewGroupMarginLayoutParamsModelInfo {

    interface Metadata {

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

        LinearLayoutCompat.LayoutParams linearLayoutParams = (LinearLayoutCompat.LayoutParams) viewGroupLayoutParams;
        weight = linearLayoutParams.weight;
        layoutGravity = LayoutGravity.intToGravity(linearLayoutParams.gravity);
    }
}
