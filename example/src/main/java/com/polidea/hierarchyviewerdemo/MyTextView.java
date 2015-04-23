package com.polidea.hierarchyviewerdemo;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.google.gson.annotations.SerializedName;

public class MyTextView extends TextView {

    private String supperHint;

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        supperHint = "Default super hint";
    }

    public void setSupperHint(String supperHint){
        this.supperHint = supperHint;
    }

    public String getSupperHint() {
        return supperHint;
    }
}
