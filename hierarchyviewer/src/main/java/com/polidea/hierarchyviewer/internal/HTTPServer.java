package com.polidea.hierarchyviewer.internal;


import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.polidea.hierarchyviewer.BuildConfig;
import com.polidea.hierarchyviewer.internal.provider.ServerInfoProvider;
import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HTTPServer extends NanoHTTPD {


    private final WindowManager windowManager;

    private final ServerInfoProvider serverInfoProvider;

    public HTTPServer(ServerInfoProvider serverInfoProvider, WindowManager windowManager){
        super(BuildConfig.PORT);
        this.windowManager = windowManager;
        this.serverInfoProvider = serverInfoProvider;
    }

    @Override
    public void start() throws IOException {
        super.start();
        Log.i("HierarchyViewer", "Open website: " + serverInfoProvider.getIpAddress() + ":" + BuildConfig.PORT);
     }

    @Override
    public Response serve(IHTTPSession session) {
        Response response;
        try {
            List<View> mainViewList = getApplicationMainViewList(windowManager);
            final String html = "<html><head><head><body>" + toHtml(mainViewList) + "</body></html>";
            response = new Response(Response.Status.OK, MIME_HTML, html);
        } catch (Exception e) {
            final String html = "<html><head><head><body><h1>Exception: " + e.toString() + "</h1></body></html>";
            response = new Response(Response.Status.INTERNAL_ERROR, MIME_HTML, html);
        }
        return response;
    }

    private String toHtml(List<View> viewList) {
        return toHtml(viewList, 0);
    }

    private String toHtml(List<View> viewList, int level) {
        String html = "";
        for (View view : viewList) {
            for (int i = 0; i < level; i++) {
                html += "&nbsp;&nbsp;";
            }
            html += view + "<br/>";
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                List<View> innerViewList = new ArrayList<>(viewGroup.getChildCount());
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    innerViewList.add(viewGroup.getChildAt(i));
                }
                html += toHtml(innerViewList, level + 1);
            }
        }
        return html;
    }

    private List<View> getApplicationMainViewList(WindowManager windowManager) throws NoSuchFieldException, IllegalAccessException {
        Field windowManagerGlobalField = windowManager.getClass().getDeclaredField("mGlobal");
        windowManagerGlobalField.setAccessible(true);
        Object windowManagerGlobal = windowManagerGlobalField.get(windowManager);

        Field mainViewListField = windowManagerGlobal.getClass().getDeclaredField("mViews");
        mainViewListField.setAccessible(true);

        List<View> viewList;

        Object views = mainViewListField.get(windowManagerGlobal);
        if (Build.VERSION.SDK_INT >= 21) {
            viewList = (List<View>) views;
        } else {
            View[] viewsArray = (View[]) views;
            viewList = new ArrayList<>(Arrays.asList(viewsArray));
        }
        return viewList;
    }
}
