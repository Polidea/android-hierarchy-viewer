package com.polidea.hierarchyviewer.internal.model.view;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class AbsListViewModelInfo extends AdapterViewModelInfo {

    interface Metadata {

        String CAN_SCROLL_LIST_DOWN = "can_scroll_list_down";

        String CAN_SCROLL_LIST_UP = "can_scroll_list_up";

        String CACHE_COLOR_HINT = "cache_color_hint";

        String CHECKED_ITEM_COUNT = "checked_item_count";

        String CHECKED_ITEM_POSITIONS = "checked_item_position";

        String CHOICE_MODE = "choice_mode";

        String LIST_PADDING_TOP = "list_padding_top";

        String LIST_PADDING_LEFT = "list_padding_left";

        String LIST_PADDING_BOTTOM = "list_padding_bottom";

        String LIST_PADDING_RIGHT = "list_padding_right";

        String SOLID_COLOR = "solid_color";

        String HAS_TEXT_FILTER = "has_text_filter";

        String FAST_SCROLL_ALWAYS_VISIBLE = "fast_scroll_always_visible";

        String SCROLLING_CACHE_ENABLED = "scrolling_cache_enabled";

        String SMOOTH_SCROLLBAR_ENABLED = "smooth_scrollbar_enabled";

        String STACK_FROM_BOTTOM = "stack_from_bottom";

        String TEXT_FILTER_ENABLED = "text_filter_enabled";
    }

    @SerializedName(Metadata.CAN_SCROLL_LIST_DOWN)
    boolean canScrollListDown;

    @SerializedName(Metadata.CAN_SCROLL_LIST_UP)
    boolean canScrollListUp;

    @SerializedName(Metadata.CACHE_COLOR_HINT)
    int cacheColorHint;

    @SerializedName(Metadata.CHECKED_ITEM_COUNT)
    int checkedItemCount;

    @SerializedName(Metadata.CHECKED_ITEM_POSITIONS)
    SparseBooleanArray checkedItemPositions;

    @SerializedName(Metadata.CHOICE_MODE)
    String choiceMode;

    @SerializedName(Metadata.LIST_PADDING_TOP)
    int listPaddingTop;

    @SerializedName(Metadata.LIST_PADDING_LEFT)
    int listPaddingLeft;

    @SerializedName(Metadata.LIST_PADDING_BOTTOM)
    int listPaddingBottom;

    @SerializedName(Metadata.LIST_PADDING_RIGHT)
    int listPaddingRight;

    @SerializedName(Metadata.SOLID_COLOR)
    int solidColor;

    @SerializedName(Metadata.HAS_TEXT_FILTER)
    boolean hasTextFilter;

    @SerializedName(Metadata.FAST_SCROLL_ALWAYS_VISIBLE)
    boolean fastScrollAlwaysVisible;

    @SerializedName(Metadata.SCROLLING_CACHE_ENABLED)
    boolean scrollingCacheEnabled;

    @SerializedName(Metadata.SMOOTH_SCROLLBAR_ENABLED)
    boolean smoothScrollbarEnabled;

    @SerializedName(Metadata.STACK_FROM_BOTTOM)
    boolean stackFromBottom;

    @SerializedName(Metadata.TEXT_FILTER_ENABLED)
    boolean textFilterEnabled;

    private transient SparseArray<String> choiceModeToStringMap = new SparseArray<String>(4) {
        {
            put(AbsListView.CHOICE_MODE_NONE, "CHOICE_MODE_NONE");
            put(AbsListView.CHOICE_MODE_SINGLE, "CHOICE_MODE_SINGLE");
            put(AbsListView.CHOICE_MODE_MULTIPLE, "CHOICE_MODE_MULTIPLE");
            put(AbsListView.CHOICE_MODE_MULTIPLE_MODAL, "CHOICE_MODE_MULTIPLE_MODAL");
        }
    };

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);

        AbsListView absListView = (AbsListView) view;
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            canScrollListDown = absListView.canScrollList(1);
            canScrollListUp = absListView.canScrollList(-1);
        }
        cacheColorHint = absListView.getCacheColorHint();
        checkedItemCount = absListView.getCheckedItemCount();
        checkedItemPositions = absListView.getCheckedItemPositions();
        choiceMode = choiceModeToStringMap.get(absListView.getChoiceMode());
        listPaddingTop = absListView.getListPaddingTop();
        listPaddingLeft = absListView.getListPaddingLeft();
        listPaddingBottom = absListView.getListPaddingBottom();
        listPaddingRight = absListView.getListPaddingRight();
        solidColor = absListView.getSolidColor();
        hasTextFilter = absListView.hasTextFilter();
        fastScrollAlwaysVisible = absListView.isFastScrollAlwaysVisible();
        scrollingCacheEnabled = absListView.isScrollingCacheEnabled();
        smoothScrollbarEnabled = absListView.isSmoothScrollbarEnabled();
        stackFromBottom = absListView.isStackFromBottom();
        textFilterEnabled = absListView.isTextFilterEnabled();
    }
}
