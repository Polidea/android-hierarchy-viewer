package com.polidea.hierarchyviewer.internal.model.layoutparams;

public enum LayoutGravity {

    NONE, TOP, BOTTOM, LEFT, RIGHT, START, END, CENTER_VERTICAL, FILL_VERTICAL, CENTER_HORIZONTAL, FILL_HORIZONTAL, CENTER, FILL;

    public static LayoutGravity intToGravity(int gravity) {
        switch (gravity) {
            case android.view.Gravity.TOP:
                return TOP;
            case android.view.Gravity.BOTTOM:
                return BOTTOM;
            case android.view.Gravity.LEFT:
                return LEFT;
            case android.view.Gravity.RIGHT:
                return RIGHT;
            case android.view.Gravity.START:
                return START;
            case android.view.Gravity.END:
                return END;
            case android.view.Gravity.CENTER_VERTICAL:
                return CENTER_VERTICAL;
            case android.view.Gravity.FILL_VERTICAL:
                return FILL_VERTICAL;
            case android.view.Gravity.CENTER_HORIZONTAL:
                return CENTER_HORIZONTAL;
            case android.view.Gravity.FILL_HORIZONTAL:
                return FILL_HORIZONTAL;
            case android.view.Gravity.CENTER:
                return CENTER;
            case android.view.Gravity.FILL:
                return FILL;
            case android.view.Gravity.NO_GRAVITY:
            default:
                return NONE;
        }

    }


}