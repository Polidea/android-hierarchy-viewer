package com.polidea.hierarchyviewer.internal.model;


import android.view.View;
import android.view.ViewGroup;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import java.util.List;

public class ViewGroupModelInfo extends ViewModelInfo {

    interface Metadata {
        String CHILDREN = "children";
        String COUNT_CHILDREN = "countChildren";
    }

    @SerializedName(Metadata.COUNT_CHILDREN)
    int countChildren;

    @SerializedName(Metadata.CHILDREN)
    List<ViewModelInfo> children;

    public void setDataFromView(View view) {
        ViewGroup viewGroup = (ViewGroup) view;
        super.setDataFromView(view);
        countChildren = viewGroup.getChildCount();
        if(countChildren > 0){
            children = new LinkedList<>();
        }
        for (int index = 0; index < countChildren; index++) {
            View child = viewGroup.getChildAt(index);
            final ViewModelInfo viewModelInfo;
            if (child instanceof ViewGroup) {
                viewModelInfo = new ViewGroupModelInfo();
            } else {
                 viewModelInfo = new ViewModelInfo();
            }
            viewModelInfo.setDataFromView(child);
            children.add(viewModelInfo);
        }
    }
}
