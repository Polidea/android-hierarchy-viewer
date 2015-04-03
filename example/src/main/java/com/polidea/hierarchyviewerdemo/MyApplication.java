package com.polidea.hierarchyviewerdemo;

import android.app.Application;
import com.polidea.hierarchyviewer.Config;
import com.polidea.hierarchyviewer.HierarchyViewer;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Config config = new Config.Builder()
                .add(MyTextView.class, new MyTextViewModelInfo())
                .build();
        HierarchyViewer.setDefaultConfig(this, config);
    }
}
