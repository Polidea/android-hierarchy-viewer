package com.polidea.hierarchyviewerdemo;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView {

    private String myCustomItem;
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        myCustomItem = "Test item";
    }

    public String getMyCustomItem() {
        return myCustomItem;
    }
}
