package com.polidea.hierarchyviewer;

import android.content.Context;
import android.content.Intent;
import com.polidea.hierarchyviewer.internal.HierarchyViewerService;
import com.polidea.hierarchyviewer.internal.dependencyinjection.HierarchyViewerComponent;

public class HierarchyViewer {

    private static HierarchyViewerComponent component;


    public static void start(Config config) {
        config.context.startService(new Intent(config.context, HierarchyViewerService.class));
    }
    public static void initializeComponent(Context context) {
        component = HierarchyViewerComponent.Initializer.init(context);
    }

    public static HierarchyViewerComponent component() {
        return component;
    }

    public static void shouldStop(Context context){
        context.stopService(new Intent(context, HierarchyViewerService.class));
    }
    public static boolean isComponent() {
        return component != null;
    }
}
