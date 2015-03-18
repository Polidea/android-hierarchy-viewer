package com.polidea.hierarchyviewer.internal.model.layoutparams;

import android.os.Build;
import android.view.ViewGroup;
import com.google.gson.annotations.SerializedName;

public class ViewGroupMarginLayoutParamsModelInfo extends ViewGroupLayoutParamsModelInfo {

    interface Metadata {

        String BOTTOM_MARGIN = "bottom_margin";
        String LEFT_MARGIN = "left_margin";
        String RIGHT_MARGIN = "right_margin";
        String TOP_MARGIN = "top_margin";
        String START_MARGIN = "start_margin";
        String END_MARGIN = "end_margin";
        String LAYOUT_DIRECTION = "layout_direction";
    }

    @SerializedName(Metadata.BOTTOM_MARGIN)
    int bottomMargin;

    @SerializedName(Metadata.LEFT_MARGIN)
    int leftMargin;

    @SerializedName(Metadata.RIGHT_MARGIN)
    int rightMargin;

    @SerializedName(Metadata.TOP_MARGIN)
    int topMargin;

    @SerializedName(Metadata.START_MARGIN)
    Integer startMargin;

    @SerializedName(Metadata.END_MARGIN)
    Integer endMargin;

    @SerializedName(Metadata.LAYOUT_DIRECTION)
    LayoutDirection layoutDirection;

    @Override
    public void setDataFromLayoutParams(ViewGroup.LayoutParams viewGroupLayoutParams) {
        super.setDataFromLayoutParams(viewGroupLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroupLayoutParams;
        bottomMargin = marginLayoutParams.bottomMargin;
        leftMargin = marginLayoutParams.leftMargin;
        rightMargin = marginLayoutParams.rightMargin;
        topMargin = marginLayoutParams.topMargin;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            startMargin = marginLayoutParams.getMarginStart();
            endMargin = marginLayoutParams.getMarginEnd();
            layoutDirection = LayoutDirection.getLayoutDirection(marginLayoutParams.getLayoutDirection());
        }
    }
}
