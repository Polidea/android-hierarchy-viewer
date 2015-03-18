package com.polidea.hierarchyviewer.internal.model.view;


import android.view.View;
import android.view.ViewGroup;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.provider.FileUtilsProvider;
import java.util.LinkedList;
import java.util.List;

public class ViewGroupModelInfo extends ViewModelInfo{

    interface Metadata {
        String CHILDREN = "children";
        String COUNT_CHILDREN = "count_children";
    }

    @SerializedName(Metadata.COUNT_CHILDREN)
    int countChildren;

    @SerializedName(Metadata.CHILDREN)
    List<ModelInfo> children;

    @Override
    public void setDataFromView(View view,  ConvertersContainer convertersContainer, FileUtilsProvider fileUtilsProvider) {
        super.setDataFromView(view, convertersContainer, fileUtilsProvider);
        ViewGroup viewGroup = (ViewGroup) view;
        countChildren = viewGroup.getChildCount();
        if(countChildren > 0){
            children = new LinkedList<>();
        }
        for (int index = 0; index < countChildren; index++) {
            View child = viewGroup.getChildAt(index);
            final ModelInfo viewModelInfo = convertersContainer.getModelInfoForClass(child.getClass());
            viewModelInfo.setDataFromView(child, convertersContainer, fileUtilsProvider);
            children.add(viewModelInfo);
        }
    }
}
