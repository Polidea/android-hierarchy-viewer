package com.polidea.hierarchyviewer.internal.model;

import android.view.View;
import com.google.gson.annotations.SerializedName;

public enum Visibility {
    @SerializedName(Metadata.VISIBLE)
    VISIBLE,
    @SerializedName(Metadata.INVISIBLE)
    INVISIBLE,
    @SerializedName(Metadata.GONE)
    GONE;

    interface Metadata {

        String VISIBLE = "visible";
        String INVISIBLE = "invisible";
        String GONE = "gone";
    }

   static Visibility getFromViewVisibility(int visibility) {
        switch (visibility) {
            case View.VISIBLE:
                return VISIBLE;
            case View.INVISIBLE:
                return INVISIBLE;
            case View.GONE:
                return GONE;
            default:
                throw new IllegalArgumentException("The argument should be one of VISIBLE, INVISIBLE and GONE from View.");
        }
    }
}
