package com.polidea.hierarchyviewer.internal.model.view;

import android.util.SparseArray;
import android.view.View;
import android.widget.GridView;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class GridViewModelInfo extends AbsListViewModelInfo {

    interface Metadata {

        String COLUMN_WIDTH = "column_width";

        String GRAVITY = "gravity";

        String HORIZONTAL_SPACING = "horizontal_spacing";

        String NUM_COLUMNS = "num_columns";

        String REQUESTED_COLUMN_WIDTH = "requested_column_width";

        String REQUESTED_HORIZONTAL_SPACING = "requested_horizontal_spacing";

        String STRETCH_MODE = "stretch_mode";

        String VERTICAL_SPACING = "vertical_spacing";
    }

    @SerializedName(Metadata.COLUMN_WIDTH)
    int columnWidth;

    @SerializedName(Metadata.GRAVITY)
    int gravity;

    @SerializedName(Metadata.HORIZONTAL_SPACING)
    int horizontalSpacing;

    @SerializedName(Metadata.NUM_COLUMNS)
    int numColumns;

    @SerializedName(Metadata.REQUESTED_COLUMN_WIDTH)
    int requestedColumnWidth;

    @SerializedName(Metadata.REQUESTED_HORIZONTAL_SPACING)
    int requestedHorizontalSpacing;

    @SerializedName(Metadata.STRETCH_MODE)
    String stretchMode;

    @SerializedName(Metadata.VERTICAL_SPACING)
    int verticalSpacing;

    private SparseArray<String> stretchModeToStringMap = new SparseArray<String>(4) {
        {
            put(GridView.NO_STRETCH, "NO_STRETCH");
            put(GridView.STRETCH_SPACING, "STRETCH_SPACING");
            put(GridView.STRETCH_COLUMN_WIDTH, "STRETCH_COLUMN_WIDTH");
            put(GridView.STRETCH_SPACING_UNIFORM, "STRETCH_SPACING_UNIFORM");
        }
    };

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);

        GridView gridView = (GridView) view;
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            columnWidth = gridView.getColumnWidth();
            gravity = gridView.getGravity();
            horizontalSpacing = gridView.getHorizontalSpacing();
            requestedColumnWidth = gridView.getRequestedColumnWidth();
            requestedHorizontalSpacing = gridView.getRequestedHorizontalSpacing();
            verticalSpacing = gridView.getVerticalSpacing();
        }
        numColumns = gridView.getNumColumns();
        stretchMode = stretchModeToStringMap.get(gridView.getStretchMode());
    }
}
