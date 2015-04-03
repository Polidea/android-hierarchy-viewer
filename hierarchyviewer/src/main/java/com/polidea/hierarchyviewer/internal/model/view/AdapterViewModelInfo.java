package com.polidea.hierarchyviewer.internal.model.view;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class AdapterViewModelInfo extends ViewGroupModelInfo {

    interface Metadata {

        String ITEM_COUNT = "item_count";

        String SELECTED_ITEM_POSITION = "selected_item_position";

        String SELECTED_ITEM_ID = "selected_item_id";

        String FIRST_VISIBLE_POSITION = "first_visible_position";

        String LAST_VISIBLE_POSITION = "last_visible_position";

        String ADAPTER_VIEW_TYPE_COUNT = "adapter_view_type_count";
    }

    @SerializedName(Metadata.ITEM_COUNT)
    int itemCount;

    @SerializedName(Metadata.SELECTED_ITEM_POSITION)
    int selectedItemPosition;

    @SerializedName(Metadata.SELECTED_ITEM_ID)
    long selectedItemId;

    @SerializedName(Metadata.FIRST_VISIBLE_POSITION)
    int firstVisiblePosition;

    @SerializedName(Metadata.LAST_VISIBLE_POSITION)
    int lastVisiblePosition;

    @SerializedName(Metadata.ADAPTER_VIEW_TYPE_COUNT)
    int adapterViewTypeCount;


    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);

        AdapterView adapterView = (AdapterView) view;
        itemCount = adapterView.getCount();
        selectedItemPosition = adapterView.getSelectedItemPosition();
        selectedItemId = adapterView.getSelectedItemId();
        firstVisiblePosition = adapterView.getFirstVisiblePosition();
        lastVisiblePosition = adapterView.getLastVisiblePosition();
        Adapter adapter = adapterView.getAdapter();
        if(adapter != null) {
            adapterViewTypeCount = adapter.getViewTypeCount();
        }
    }
}
