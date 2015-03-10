package com.polidea.hierarchyviewer.internal.logic;

import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.polidea.hierarchyviewer.internal.model.HierarchyView;
import com.polidea.hierarchyviewer.internal.model.ThrowableModel;
import com.polidea.hierarchyviewer.internal.model.ViewGroupModelInfo;
import com.polidea.hierarchyviewer.internal.model.ViewModelInfo;
import com.polidea.hierarchyviewer.internal.provider.HierarchyViewProvider;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

public class HierarchyViewConverter {

    private final HierarchyViewProvider hierarchyViewProvider;

    private final Gson gson;

    @Singleton
    @Inject
    HierarchyViewConverter(HierarchyViewProvider hierarchyViewProvider, Gson gson) {
        this.hierarchyViewProvider = hierarchyViewProvider;
        this.gson = gson;
    }

    public String getHierarchyViewJson() {

        try {
            List<View> list = hierarchyViewProvider.getViewList();
            return toJson(list);
        } catch (Exception e) {
            ThrowableModel throwableModel = new ThrowableModel();
            throwableModel.setDataFromException(e);
            return gson.toJson(throwableModel);
        }
    }

    private String toJson(List<View> viewList) {
        final HierarchyView hierarchyView = new HierarchyView();
        for (final View view : viewList) {
            final ViewModelInfo viewModelInfo;
            if (view instanceof ViewGroup) {
                viewModelInfo = new ViewGroupModelInfo();

            } else {
                viewModelInfo = new ViewModelInfo();
            }
            viewModelInfo.setDataFromView(view);
            hierarchyView.add(viewModelInfo);
        }
        return gson.toJson(hierarchyView);
    }
}
