package com.polidea.hierarchyviewer.internal.model.layoutparams;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.gson.annotations.SerializedName;

public class FrameLayoutParamsModelInfo extends ViewGroupMarginLayoutParamsModelInfo {

    interface Metadata {

        String GRAVITY = "gravity";
    }

    @SerializedName(Metadata.GRAVITY)
    int gravity;

    @Override
    public void setDataFromLayoutParams(ViewGroup.LayoutParams viewGroupLayoutParams) {
        super.setDataFromLayoutParams(viewGroupLayoutParams);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroupLayoutParams;
        gravity = layoutParams.gravity;
    }
}
