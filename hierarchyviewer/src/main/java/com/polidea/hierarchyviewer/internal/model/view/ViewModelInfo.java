package com.polidea.hierarchyviewer.internal.model.view;


import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.model.layoutparams.LayoutParamsModelInfo;
import java.lang.reflect.Field;
import java.util.UUID;

public class ViewModelInfo implements ModelInfo {

    interface Metadata {

        String PACKAGE_NAME = "package_name";
        String NAME = "name";
        String ID = "id";
        String ID_RES_NAME = "id_res_name";
        String GENERATE_ID = "generate_id";
        String ENABLED = "enabled";
        String VISIBILITY = "visibility";

        String X = "x";
        String Y = "y";

        String WIDTH = "width";
        String HEIGHT = "height";

        String PATH_TO_FILE = "path_to_file";

        String LAYOUT_PARAM = "layout_param";

        String ALPHA = "alpha";
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

    @SerializedName(Metadata.ALPHA)
    float alpha;

    @SerializedName(Metadata.LAYOUT_PARAM)
    LayoutParamsModelInfo layoutParamModelInfo;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        packageName = view.getClass().getPackage().getName();
        generateId = UUID.randomUUID().getMostSignificantBits();
        name = view.getClass().getSimpleName();
        id = view.getId();
        if (id != ID_NOT_FOUND) {
            try {
                idResName = view.getContext().getResources().getResourceEntryName(id);
            } catch (Resources.NotFoundException ignored) {}
        }

        enabled = view.isEnabled();
        visibility = Visibility.getFromViewVisibility(view.getVisibility());

        width = view.getWidth();
        height = view.getHeight();

        Pair<Float, Float> point = calculateLocation(view);
        x = point.first;
        y = point.second;

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParamModelInfo = convertersContainer.getLayoutParamsModelInfo(layoutParams.getClass());
            layoutParamModelInfo.setDataFromLayoutParams(layoutParams);
        }
        alpha = view.getAlpha();
    }

    private Pair<Float, Float> calculateLocation(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.getClass() == WindowManager.LayoutParams.class) {
            return calculateRootViewLocation(view, (WindowManager.LayoutParams) layoutParams);
        }
        return new Pair<>(view.getX(), view.getY());
    }

    private Pair<Float, Float> calculateRootViewLocation(View view, WindowManager.LayoutParams windowLayoutParams) {
        float x = view.getX();
        float y = view.getY();
        if (windowLayoutParams.width != ViewGroup.LayoutParams.MATCH_PARENT && windowLayoutParams.height != ViewGroup.LayoutParams.MATCH_PARENT) {
            try {
                ViewParent parent = view.getParent();
                Field winFrameField = parent.getClass().getDeclaredField("mWinFrame");
                winFrameField.setAccessible(true);
                Rect rect = (Rect) winFrameField.get(parent);
                x = rect.left;
                y = rect.top;
            } catch (Exception ignored) {

            }
        }
        return new Pair<>(x, y);
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }
}
