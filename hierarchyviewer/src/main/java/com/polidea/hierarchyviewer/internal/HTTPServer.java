package com.polidea.hierarchyviewer.internal;


import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.polidea.hierarchyviewer.BuildConfig;
import com.polidea.hierarchyviewer.internal.logic.HierarchyViewConverter;
import com.polidea.hierarchyviewer.internal.model.ThrowableModel;
import com.polidea.hierarchyviewer.internal.provider.ServerInfoProvider;
import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class HTTPServer extends NanoHTTPD {

    @Inject
    HierarchyViewConverter hierarchyViewConverter;

    @Inject
    ServerInfoProvider serverInfoProvider;

    public HTTPServer() {
        super(BuildConfig.PORT);
        HierarchyViewerService.component().inject(this);
    }

    @Override
    public void start() throws IOException {
        super.start();
        Log.i("HierarchyViewer", "Open website: " + serverInfoProvider.getIpAddress() + ":" + BuildConfig.PORT);
    }

    @Override
    public Response serve(IHTTPSession session) {
        return new Response(Response.Status.OK, MIME_PLAINTEXT, hierarchyViewConverter.getHierarchyViewJson());
    }


}
