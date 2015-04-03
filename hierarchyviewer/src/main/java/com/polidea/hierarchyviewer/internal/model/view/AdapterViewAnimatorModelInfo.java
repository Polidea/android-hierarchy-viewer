package com.polidea.hierarchyviewer.internal.model.view;

import android.view.View;
import android.widget.AdapterViewAnimator;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class AdapterViewAnimatorModelInfo extends AdapterViewModelInfo {

    interface Metadata {

        String DISPLAYED_CHILD = "displayed_child";
    }

    @SerializedName(Metadata.DISPLAYED_CHILD)
    int displayedChild;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);

        AdapterViewAnimator adapterViewAnimator = (AdapterViewAnimator) view;
        displayedChild = adapterViewAnimator.getDisplayedChild();
    }
}
