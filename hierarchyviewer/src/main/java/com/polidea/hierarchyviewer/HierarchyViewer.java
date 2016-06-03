package com.polidea.hierarchyviewer;

import android.content.Context;
import android.content.Intent;

import com.polidea.hierarchyviewer.internal.HierarchyViewerService;
import com.polidea.hierarchyviewer.internal.dependencyinjection.Injector;

public class HierarchyViewer {

    private static Injector injector;

    public static Injector injector() {
        return injector;
    }

    public static boolean isInjector() {
        return injector != null;
    }

    public static void start(Context context) {
        start(context, new Config.Builder().build());
    }

    public static void start(Context context, Config config) {
        if (HierarchyViewerService.isRunning()) {
            return;
        }

        injector = new Injector(context, config);

        context.startService(new Intent(context, HierarchyViewerService.class));
    }
}
