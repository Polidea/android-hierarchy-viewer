package com.polidea.hierarchyviewer.internal.model.layoutparams;


import android.view.View;
import com.google.gson.annotations.SerializedName;

public enum LayoutDirection {

    @SerializedName(Metadata.LAYOUT_DIRECTION_LTR)
    LAYOUT_DIRECTION_LTR,
    @SerializedName(Metadata.LAYOUT_DIRECTION_RTL)
    LAYOUT_DIRECTION_RTL,
    @SerializedName(Metadata.UNKNOWN)
    UNKNOWN;


    interface  Metadata{
        String LAYOUT_DIRECTION_LTR  = "LAYOUT_DIRECTION_LTR";
        String LAYOUT_DIRECTION_RTL = "LAYOUT_DIRECTION_RTL";
        String UNKNOWN = "UNKNOWN";
    }
    public static LayoutDirection getLayoutDirection(int layoutDirection) {
        switch (layoutDirection) {
            case View.LAYOUT_DIRECTION_LTR:
                return LAYOUT_DIRECTION_LTR;
            case View.LAYOUT_DIRECTION_RTL:
                return LAYOUT_DIRECTION_RTL;
            default:
                return UNKNOWN;
        }
    }
}
