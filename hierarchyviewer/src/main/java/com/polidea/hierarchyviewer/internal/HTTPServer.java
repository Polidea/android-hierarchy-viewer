package com.polidea.hierarchyviewer.internal;


import android.util.Log;
import com.polidea.hierarchyviewer.BuildConfig;
import com.polidea.hierarchyviewer.HierarchyViewer;
import com.polidea.hierarchyviewer.internal.logic.HierarchyViewConverter;
import com.polidea.hierarchyviewer.internal.provider.FileUtilsProvider;
import com.polidea.hierarchyviewer.internal.provider.ServerInfoProvider;
import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import javax.inject.Inject;

public class HTTPServer extends NanoHTTPD {

    @Inject
    HierarchyViewConverter hierarchyViewConverter;

    @Inject
    FileUtilsProvider fileUtilsProvider;

    @Inject
    ServerInfoProvider serverInfoProvider;

    public HTTPServer() {
        super(BuildConfig.PORT);
        HierarchyViewer.component().inject(this);
    }

    @Override
    public void start() throws IOException {
        super.start();
        Log.i("HierarchyViewer", "Open website: " + serverInfoProvider.getIpAddress() + ":" + BuildConfig.PORT);
    }

    @Override
    public Response serve(IHTTPSession session) {
        switch (session.getUri()) {
            case "/hierarchyView":
                fileUtilsProvider.clearCacheFolder();
                return new Response(Response.Status.OK, MIME_PLAINTEXT, hierarchyViewConverter.getHierarchyViewJson());
            default:
                return new Response(Response.Status.NOT_FOUND, MIME_HTML, "<p> PAGE NOT FOUND</p>");
        }
    }


}
