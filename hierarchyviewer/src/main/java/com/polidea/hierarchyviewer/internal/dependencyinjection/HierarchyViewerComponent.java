package com.polidea.hierarchyviewer.internal.dependencyinjection;

import android.content.Context;
import com.polidea.hierarchyviewer.Config;
import com.polidea.hierarchyviewer.internal.HTTPServer;
import com.polidea.hierarchyviewer.internal.HierarchyViewerService;
import com.polidea.hierarchyviewer.internal.logic.HierarchyViewConverter;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {ServerUtilsModule.class, SystemModule.class, RestModule.class})
public interface HierarchyViewerComponent {


    public final static class Initializer {

        public static HierarchyViewerComponent init(Context context) {
            return Dagger_HierarchyViewerComponent.builder()
                    .serverUtilsModule(new ServerUtilsModule(context))
                    .systemModule(new SystemModule(context))
                    .build();
        }

    }

    void inject(HierarchyViewerService hierarchyViewerService);

    void inject(HTTPServer httpServer);

    void inject(HierarchyViewConverter hierarchyViewConverter);

    void inject(Config config);
}
