package com.polidea.hierarchyviewer.internal.model;


import android.view.View;
import com.google.gson.annotations.SerializedName;
import java.util.UUID;

public class ViewModelInfo {

    interface Metadata {

        String NAME = "name";
        String ID = "id";
        String GENERATE_ID = "generateId";
        String ENABLED = "enabled";
        String VISIBILITY = "visibility";
    }

    @SerializedName(Metadata.NAME)
    String name;

    @SerializedName(Metadata.ID)
    int id;

    @SerializedName(Metadata.GENERATE_ID)
    long generateId;

    @SerializedName(Metadata.ENABLED)
    boolean enabled;

    @SerializedName(Metadata.VISIBILITY)
    Visibility visibility;

    public void setDataFromView(View view) {
        generateId = UUID.randomUUID().getMostSignificantBits();
        name = view.getClass().getSimpleName();
        id = view.getId();
        enabled = view.isEnabled();
        visibility = Visibility.getFromViewVisibility(view.getVisibility());
    }
}
