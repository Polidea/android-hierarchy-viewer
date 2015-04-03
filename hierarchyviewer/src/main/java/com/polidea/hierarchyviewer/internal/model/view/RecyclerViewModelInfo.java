package com.polidea.hierarchyviewer.internal.model.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class RecyclerViewModelInfo extends ViewGroupModelInfo {

    interface Metadata {

        String HAS_FIXED_SIZE = "has_fixed_size";

        String CAN_SCROLL_HORIZONTALLY = "can_scroll_horizontally";

        String CAN_SCROLL_VERTICALLY = "can_scroll_vertically";

        String ITEM_COUNT = "item_count";

        String SMOOTH_SCROLLING = "smooth_scrolling";

        String SUPPORT_PREDICTIVE_ITEM_ANIMATIONS = "support_predictive_item_animations";

        String LAYOUT_MANAGER_CLASS_NAME = "layout_manager_class_name";
    }

    @SerializedName(Metadata.LAYOUT_MANAGER_CLASS_NAME)
    String layoutManagerClassName;

    @SerializedName(Metadata.HAS_FIXED_SIZE)
    boolean hasFixedSize;

    @SerializedName(Metadata.CAN_SCROLL_HORIZONTALLY)
    boolean canScrollHorizontally;

    @SerializedName(Metadata.CAN_SCROLL_VERTICALLY)
    boolean canScrollVertically;

    @SerializedName(Metadata.ITEM_COUNT)
    int itemCount;

    @SerializedName(Metadata.SMOOTH_SCROLLING)
    boolean smoothScrolling;

    @SerializedName(Metadata.SUPPORT_PREDICTIVE_ITEM_ANIMATIONS)
    boolean supportsPredictiveItemAnimations;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);

        RecyclerView recyclerView = (RecyclerView) view;
        hasFixedSize = recyclerView.hasFixedSize();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            layoutManagerClassName = layoutManager.getClass().getSimpleName();
            canScrollHorizontally = layoutManager.canScrollHorizontally();
            canScrollVertically = layoutManager.canScrollVertically();
            itemCount = layoutManager.getItemCount();
            smoothScrolling = layoutManager.isSmoothScrolling();
            supportsPredictiveItemAnimations = layoutManager.supportsPredictiveItemAnimations();
        }
    }
}
