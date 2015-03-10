package com.polidea.hierarchyviewer.internal.logic;

import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.polidea.hierarchyviewer.internal.HierarchyViewerService;
import com.polidea.hierarchyviewer.internal.model.HierarchyView;
import com.polidea.hierarchyviewer.internal.model.ThrowableModel;
import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ViewGroupModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ViewModelInfo;
import com.polidea.hierarchyviewer.internal.provider.HierarchyViewProvider;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

public class HierarchyViewConverter {

    @Inject
    HierarchyViewProvider hierarchyViewProvider;

    @Inject
    Gson gson;

    @Inject
    ConvertersContainer convertersContainer;

    @Singleton
    @Inject
    HierarchyViewConverter() {
        HierarchyViewerService.component().inject(this);
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

            ModelInfo modelInfo =convertersContainer.getModelInfoForClass(view.getClass());

            modelInfo.setDataFromView(view, convertersContainer);
            hierarchyView.add(modelInfo);
        }
        return gson.toJson(hierarchyView);
    }
}
