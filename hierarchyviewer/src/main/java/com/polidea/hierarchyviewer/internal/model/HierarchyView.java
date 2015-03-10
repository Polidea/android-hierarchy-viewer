package com.polidea.hierarchyviewer.internal.model;


import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ViewModelInfo;
import java.util.LinkedList;
import java.util.List;

public class HierarchyView {

    interface Metadata {

        String VIEW_LIST = "viewList";
    }

    @SerializedName(Metadata.VIEW_LIST)
    List<ModelInfo> list;

    public void add(ModelInfo viewModelInfo) {
        if (list == null) {
            list = new LinkedList<>();
        }
        list.add(viewModelInfo);
    }
}
