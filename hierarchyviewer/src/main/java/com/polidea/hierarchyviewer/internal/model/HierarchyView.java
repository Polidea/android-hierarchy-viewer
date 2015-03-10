package com.polidea.hierarchyviewer.internal.model;


import com.google.gson.annotations.SerializedName;
import java.util.LinkedList;
import java.util.List;

public class HierarchyView {

    interface Metadata {

        String VIEW_LIST = "viewList";
    }

    @SerializedName(Metadata.VIEW_LIST)
    List<ViewModelInfo> list;

    public void add(ViewModelInfo viewModelInfo) {
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(viewModelInfo);
    }
}
