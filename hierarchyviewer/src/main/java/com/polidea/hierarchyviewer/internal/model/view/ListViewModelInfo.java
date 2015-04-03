package com.polidea.hierarchyviewer.internal.model.view;


import android.view.View;
import android.widget.ListView;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class ListViewModelInfo extends AbsListViewModelInfo {

    interface Metadata {

        String ARE_HEADER_DIVIDERS_ENABLED = "are_header_dividers_enabled";

        String ARE_FOOTER_DIVIDERS_ENABLED = "are_footer_dividers_enabled";

        String DIVIDER_HEIGHT = "divider_height";

        String FOOTER_VIEWS_COUNT = "footer_views_count";

        String HEADER_VIEWS_COUNT = "header_views_count";

        String ITEMS_CAN_FOCUS = "items_can_focus";

        String MAX_SCROLL_AMOUNT = "max_scroll_amount";
    }

    @SerializedName(Metadata.ARE_HEADER_DIVIDERS_ENABLED)
    boolean areHeaderDividersEnabled;

    @SerializedName(Metadata.ARE_FOOTER_DIVIDERS_ENABLED)
    boolean areFooterDividersEnabled;

    @SerializedName(Metadata.DIVIDER_HEIGHT)
    int dividerHeight;

    @SerializedName(Metadata.FOOTER_VIEWS_COUNT)
    int footerViewsCount;

    @SerializedName(Metadata.HEADER_VIEWS_COUNT)
    int headerViewsCount;

    @SerializedName(Metadata.ITEMS_CAN_FOCUS)
    boolean itemsCanFocus;

    @SerializedName(Metadata.MAX_SCROLL_AMOUNT)
    int maxScrollAmount;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);

        ListView listView = (ListView) view;
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            areHeaderDividersEnabled = listView.areHeaderDividersEnabled();
            areFooterDividersEnabled = listView.areFooterDividersEnabled();
        }

        dividerHeight = listView.getDividerHeight();
        footerViewsCount = listView.getFooterViewsCount();
        headerViewsCount = listView.getHeaderViewsCount();
        itemsCanFocus = listView.getItemsCanFocus();
        maxScrollAmount = listView.getMaxScrollAmount();
    }
}
