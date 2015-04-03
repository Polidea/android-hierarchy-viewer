package com.polidea.hierarchyviewer.internal.model.view;


import android.view.View;
import android.widget.AdapterViewFlipper;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class AdapterViewFlipperModelInfo extends AdapterViewAnimatorModelInfo {

    interface Metadata {

        String FLIP_INTERVAL = "flip_interval";

        String IS_AUTO_START = "is_auto_start";
    }

    @SerializedName(Metadata.FLIP_INTERVAL)
    int flipInterval;

    @SerializedName(Metadata.IS_AUTO_START)
    boolean isAutoStart;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);

        AdapterViewFlipper flipper = (AdapterViewFlipper) view;
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            flipInterval = flipper.getFlipInterval();
        }
        isAutoStart = flipper.isAutoStart();
    }
}
