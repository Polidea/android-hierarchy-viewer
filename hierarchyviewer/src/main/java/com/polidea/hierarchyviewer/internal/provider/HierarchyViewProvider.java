package com.polidea.hierarchyviewer.internal.provider;


import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;

public class HierarchyViewProvider {

    private final WindowManager windowManager;

    @Inject
    HierarchyViewProvider(WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    public List<View> getViewList() throws IllegalAccessException, NoSuchFieldException {
        Field windowManagerGlobalField = windowManager.getClass().getDeclaredField("mGlobal");
        windowManagerGlobalField.setAccessible(true);
        Object windowManagerGlobal = windowManagerGlobalField.get(windowManager);

        Field mainViewListField = windowManagerGlobal.getClass().getDeclaredField("mViews");
        mainViewListField.setAccessible(true);

        List<View> viewList;
        Object views = mainViewListField.get(windowManagerGlobal);
        if (views instanceof List) {
            viewList = new ArrayList<>((List<View>) views);
        } else {
            View[] viewsArray = (View[]) views;
            viewList = new ArrayList<>(Arrays.asList(viewsArray));
        }

        sortByWindowType(viewList);

        return viewList;
    }

    private void sortByWindowType(List<View> viewList) {
        Collections.sort(viewList, new Comparator<View>() {
            @Override
            public int compare(View lhs, View rhs) {
                WindowManager.LayoutParams lhsLayoutParams = (WindowManager.LayoutParams) lhs.getLayoutParams();
                WindowManager.LayoutParams rhsLayoutParams = (WindowManager.LayoutParams) rhs.getLayoutParams();
                return Integer.valueOf(lhsLayoutParams.type).compareTo(rhsLayoutParams.type);
            }
        });
    }
}
