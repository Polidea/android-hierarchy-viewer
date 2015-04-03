package com.polidea.hierarchyviewer.internal.model.view;

import android.view.View;
import android.widget.ExpandableListView;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class ExpandableListViewModelInfo extends ListViewModelInfo {

    interface Metadata {

        String SELECTED_ID = "selected_id";

        String SELECTED_POSITION = "selected_position";
    }

    @SerializedName(Metadata.SELECTED_ID)
    long selectedId;

    @SerializedName(Metadata.SELECTED_POSITION)
    long selectedPosition;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);

        ExpandableListView expandableListView = (ExpandableListView) view;
        selectedId = expandableListView.getSelectedId();
        selectedPosition = expandableListView.getSelectedPosition();
    }
}
