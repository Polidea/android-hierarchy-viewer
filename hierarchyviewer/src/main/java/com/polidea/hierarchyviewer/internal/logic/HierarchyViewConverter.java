package com.polidea.hierarchyviewer.internal.logic;

import android.view.View;
import com.google.gson.Gson;
import com.polidea.hierarchyviewer.internal.HierarchyViewerService;
import com.polidea.hierarchyviewer.internal.model.HierarchyViewModel;
import com.polidea.hierarchyviewer.internal.model.ThrowableModel;
import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;
import com.polidea.hierarchyviewer.internal.provider.FileUtilsProvider;
import com.polidea.hierarchyviewer.internal.provider.HierarchyViewProvider;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;

public class HierarchyViewConverter {

    @Inject
    HierarchyViewProvider hierarchyViewProvider;

    @Inject
    Gson gson;

    @Inject
    ConvertersContainer convertersContainer;

    @Inject
    FileUtilsProvider fileUtilsProvider;

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
        final HierarchyViewModel hierarchyView = new HierarchyViewModel();

        for (final View view : viewList) {

            ModelInfo modelInfo = convertersContainer.getModelInfoForClass(view.getClass());
            modelInfo.setDataFromView(view, convertersContainer);
            String fileName = UUID.randomUUID().toString();
            if (fileUtilsProvider.saveViewInFile(view, fileName)) {
                modelInfo.setLinkToFile(fileName);
            }
            hierarchyView.add(modelInfo);
        }
        return gson.toJson(hierarchyView);
    }
}
