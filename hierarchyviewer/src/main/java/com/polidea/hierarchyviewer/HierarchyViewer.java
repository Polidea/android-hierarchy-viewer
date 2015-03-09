package com.polidea.hierarchyviewer;

import android.content.Context;
import android.content.Intent;

public class HierarchyViewer {

    public static void start(Context context) {
        context.startService(new Intent(context, Service.class));
    }
}
