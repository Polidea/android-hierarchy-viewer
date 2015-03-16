package com.polidea.hierarchyviewer.internal.model.view;


import android.view.View;
import android.view.ViewGroup;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.model.Visibility;
import com.polidea.hierarchyviewer.internal.model.layoutparams.LayoutParamsModelInfo;
import java.util.UUID;

public class ViewModelInfo implements ModelInfo {

    interface Metadata {

        String PACKAGE_NAME = "packageName";
        String NAME = "name";
        String ID = "id";
        String ID_RES_NAME = "idResName";
        String GENERATE_ID = "generateId";
        String ENABLED = "enabled";
        String VISIBILITY = "visibility";

        String X = "x";
        String Y = "y";

        String WIDTH = "width";
        String HEIGHT = "height";

        String PATH_TO_FILE = "pathToFile";

        String LAYOUT_PARAM = "layoutParam";
    }

    @SerializedName(Metadata.PACKAGE_NAME)
    String packageName;

    @SerializedName(Metadata.NAME)
    String name;

    @SerializedName(Metadata.ID)
    int id;

    @SerializedName(Metadata.ID_RES_NAME)
    String idResName;

    @SerializedName(Metadata.GENERATE_ID)
    long generateId;

    @SerializedName(Metadata.ENABLED)
    boolean enabled;

    @SerializedName(Metadata.VISIBILITY)
    Visibility visibility;

    @SerializedName(Metadata.X)
    float x;

    @SerializedName(Metadata.Y)
    float y;

    @SerializedName(Metadata.WIDTH)
    float width;

    @SerializedName(Metadata.HEIGHT)
    float height;

    @SerializedName(Metadata.PATH_TO_FILE)
    String pathToFile;

    @SerializedName(Metadata.LAYOUT_PARAM)
    LayoutParamsModelInfo layoutParamModelInfo;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        packageName = view.getClass().getPackage().getName();
        generateId = UUID.randomUUID().getMostSignificantBits();
        name = view.getClass().getSimpleName();
        id = view.getId();
        if (id != ID_NOT_FOUND) {
            idResName = view.getContext().getResources().getResourceEntryName(id);
        }

        enabled = view.isEnabled();
        visibility = Visibility.getFromViewVisibility(view.getVisibility());
        x = view.getX();
        y = view.getY();
        width = view.getWidth();
        height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParamModelInfo = convertersContainer.getLayoutParamsModelInfo(layoutParams.getClass());
            layoutParamModelInfo.setDataFromLayoutParams(layoutParams);
        }

    }

    @Override
    public void setLinkToFile(String linkToFile) {
        this.pathToFile = linkToFile;
    }
}
