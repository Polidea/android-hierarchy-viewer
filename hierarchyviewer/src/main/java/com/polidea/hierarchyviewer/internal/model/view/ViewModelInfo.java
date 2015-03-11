package com.polidea.hierarchyviewer.internal.model.view;


import android.view.View;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.model.Visibility;
import java.util.UUID;

public class ViewModelInfo implements ModelInfo {

    interface Metadata {

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
    }

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

    @SerializedName(value = Metadata.PATH_TO_FILE)
    String pathToFile;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
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
    }

    @Override
    public void setLinkToFile(String linkToFile) {
        this.pathToFile = linkToFile;
    }
}
