package com.polidea.hierarchyviewer.internal.model.view;

import android.view.View;
import android.widget.Spinner;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class SpinnerModelInfo extends AbsSpinnerModelInfo {

    interface Metadata {

        String GRAVITY = "gravity";

        String DROP_DOWN_HORIZONTAL_OFFSET = "drop_down_horizontal_offset";

        String DROP_DOWN_VERTICAL_OFFSET = "drop_down_vertical_offset";

        String DROP_DOWN_WIDTH = "drop_down_width";

        String PROMPT = "prompt";
    }

    @SerializedName(Metadata.GRAVITY)
    int gravity;

    @SerializedName(Metadata.DROP_DOWN_HORIZONTAL_OFFSET)
    int dropDownHorizontalOffset;

    @SerializedName(Metadata.DROP_DOWN_VERTICAL_OFFSET)
    int dropDownVerticalOffset;

    @SerializedName(Metadata.DROP_DOWN_WIDTH)
    int dropDownWidth;

    @SerializedName(Metadata.PROMPT)
    String prompt;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);

        Spinner spinner = (Spinner) view;

        if (android.os.Build.VERSION.SDK_INT >= 16) {
            dropDownHorizontalOffset = spinner.getDropDownHorizontalOffset();
            dropDownVerticalOffset = spinner.getDropDownVerticalOffset();
            dropDownWidth = spinner.getDropDownWidth();
            gravity = spinner.getGravity();
        }

        CharSequence prompt = spinner.getPrompt();
        if(prompt != null) {
            this.prompt = prompt.toString();
        }
    }
}
