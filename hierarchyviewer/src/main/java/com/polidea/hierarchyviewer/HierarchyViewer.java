package com.polidea.hierarchyviewer;

import android.content.Context;
import android.content.Intent;
import com.polidea.hierarchyviewer.internal.HierarchyViewerService;
import com.polidea.hierarchyviewer.internal.dependencyinjection.HierarchyViewerComponent;

public class HierarchyViewer {

    private static HierarchyViewerComponent component;

    public static void setDefaultConfig(Context context, Config config) {
        component = HierarchyViewerComponent.Initializer.init(context, config);
    }

    public static void start(Context context) {
        if(component == null) {
            setDefaultConfig(context, new Config.Builder().build());
        }

        context.startService(new Intent(context, HierarchyViewerService.class));
    }

    public static void shouldStop(Context context){
        context.stopService(new Intent(context, HierarchyViewerService.class));
    }

    public static HierarchyViewerComponent component() {
        return component;
    }

    public static boolean isComponent() {
        return component != null;
    }
}
