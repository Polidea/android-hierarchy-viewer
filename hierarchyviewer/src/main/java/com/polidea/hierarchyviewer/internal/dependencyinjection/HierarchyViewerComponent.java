package com.polidea.hierarchyviewer.internal.dependencyinjection;

import android.content.Context;
import com.polidea.hierarchyviewer.internal.HierarchyViewerService;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {ServerUtilsModule.class, SystemModule.class})
public interface HierarchyViewerComponent {

    public final static class Initializer {

        public static HierarchyViewerComponent init(Context context) {
            return Dagger_HierarchyViewerComponent.builder()
                    .systemModule(new SystemModule(context))
                    .serverUtilsModule(new ServerUtilsModule(context))
                    .build();
        }
    }

    void inject(HierarchyViewerService hierarchyViewerService);
}
