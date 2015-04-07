package com.polidea.hierarchyviewer;

import android.content.Context;
import android.content.Intent;
import com.polidea.hierarchyviewer.internal.HierarchyViewerService;
import com.polidea.hierarchyviewer.internal.dependencyinjection.HierarchyViewerComponent;

public class HierarchyViewer {

    private static HierarchyViewerComponent component;

    public static void start(Context context) {
        start(context, new Config.Builder().build());
    }

    public static void start(Context context, Config config) {
        if(HierarchyViewerService.isRunning()) {
            return;
        }

        component = HierarchyViewerComponent.Initializer.init(context, config);

        context.startService(new Intent(context, HierarchyViewerService.class));
    }

    public static HierarchyViewerComponent component() {
        return component;
    }

    public static boolean isComponent() {
        return component != null;
    }
}
