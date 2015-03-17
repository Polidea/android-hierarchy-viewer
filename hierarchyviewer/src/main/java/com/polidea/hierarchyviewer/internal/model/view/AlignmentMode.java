package com.polidea.hierarchyviewer.internal.model.view;

import android.widget.GridLayout;

public enum AlignmentMode {

    UNKNOWN,
    ALIGN_BOUNDS,
    ALIGN_MARGINS;

    public static AlignmentMode getAlignmentMode(int alignmentMode){
        switch (alignmentMode){
            case GridLayout.ALIGN_BOUNDS:
                return ALIGN_BOUNDS;
            case GridLayout.ALIGN_MARGINS:
                return ALIGN_MARGINS;
            default:
                return UNKNOWN;
        }
    }
}
