package com.polidea.hierarchyviewer;

import android.content.Context;
import android.content.Intent;
import com.polidea.hierarchyviewer.internal.HierarchyViewerService;

public class HierarchyViewer {

    public static void start(Context context) {
        context.startService(new Intent(context, HierarchyViewerService.class));
    }
}
