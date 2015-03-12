package com.polidea.hierarchyviewer.internal.provider;

import android.content.Context;

import com.polidea.hierarchyviewer.BuildConfig;
import com.polidea.hierarchyviewer.HierarchyViewer;
import com.polidea.hierarchyviewer.internal.logic.HierarchyViewConverter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

import fi.iki.elonen.NanoHTTPD;

import static fi.iki.elonen.NanoHTTPD.Response.Status.OK;

public class WebServer extends NanoHTTPD {

    private static final String WEBAPP_PATH = "webapp";

    public static final String
            MIME_PLAINTEXT = "text/plain",
            MIME_HTML = "text/html",
            MIME_JS = "application/javascript",
            MIME_CSS = "text/css",
            MIME_PNG = "image/png",
            MIME_JSON = "application/json",
            MIME_DEFAULT_BINARY = "application/octet-stream",
            MIME_XML = "text/xml",
            API_HIERARCHY = "/api/hierarchy",
            API_SCREEN = "/api/screen/";


    @Inject
    HierarchyViewConverter hierarchyViewConverter;

    @Inject
    FileUtilsProvider fileUtilsProvider;

    private final Context context;

    public WebServer(Context ctx) {
        super(BuildConfig.PORT);
        context = ctx;
        System.out.println("Started with IP: " + new ServerInfoProvider(context).getIpAddress()+":"+ BuildConfig.PORT);
        HierarchyViewer.component().inject(this);
    }

    @Override
    public void start() throws IOException {
        super.start();
        fileUtilsProvider.createCacheFolderIfNotExist();
        fileUtilsProvider.clearCacheFolder();
    }

    @Override
    public Response serve(IHTTPSession session) {
        String uri = session.getUri();
        System.out.println("SERVER URI " + uri);
        InputStream buffer;
        try {
            if (uri != null) {
                if (uri.equals(API_HIERARCHY)) {
                    fileUtilsProvider.clearCacheFolder();
                    return new NanoHTTPD.Response(OK, MIME_JSON, hierarchyViewConverter.getHierarchyViewJson());
                } else if (uri.startsWith(API_SCREEN)) {
                    String path = uri.replace(API_SCREEN, "");
                    buffer = new FileInputStream(fileUtilsProvider.getFile(path));
                    Response streamResponse = new Response(OK, MIME_PNG, buffer);
                    streamResponse.addHeader("Connection", "Keep-alive");
                    return streamResponse;
                } else if (uri.contains(".js")) {
                    buffer = getFileFromAssets(uri.substring(1));
                    return new NanoHTTPD.Response(OK, MIME_JS, buffer);
                } else if (uri.contains(".css")) {
                    buffer = getFileFromAssets(uri.substring(1));
                    return new NanoHTTPD.Response(OK, MIME_CSS, buffer);
                } else if (uri.contains(".png")) {
                    buffer = getFileFromAssets(uri.substring(1));
                    return new NanoHTTPD.Response(OK, MIME_PNG, buffer);
                } else if (uri.contains(".html")) {
                    buffer = getFileFromAssets(uri.substring(1));
                    return new NanoHTTPD.Response(OK, MIME_HTML, buffer);
                } else {
                    return new NanoHTTPD.Response(OK, MIME_HTML, getFileFromAssets("index.html"));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private InputStream getFileFromAssets(String path) throws IOException {
        return context.getAssets().open(WEBAPP_PATH + "/" + path);
    }
}
