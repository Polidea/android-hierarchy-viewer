package com.polidea.hierarchyviewerdemo;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.google.gson.annotations.SerializedName;

public class MyTextView extends TextView {

    @SerializedName("my_custom_item_value")
    private String myCustomItem;
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        myCustomItem = "Test item";
    }

    public String getMyCustomItem() {
        return myCustomItem;
    }
}
