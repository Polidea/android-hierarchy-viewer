package com.polidea.hierarchyviewer.internal.model.view;

import android.view.View;
import android.widget.ProgressBar;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class ProgressBarModelInfo extends ViewModelInfo {

    interface Metadata {

        String MAX = "max";
        String PROGRESS = "progress";
        String SECONDARY_PROGRESS = "secondary_progress";
    }

    @SerializedName(Metadata.MAX)
    int max;

    @SerializedName(Metadata.PROGRESS)
    int progress;

    @SerializedName(Metadata.SECONDARY_PROGRESS)
    int secondaryProgress;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);
        ProgressBar progressBar = (ProgressBar) view;
        max = progressBar.getMax();
        progress = progressBar.getProgress();
        secondaryProgress = progressBar.getSecondaryProgress();
    }
}
