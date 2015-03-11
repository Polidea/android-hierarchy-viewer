package com.polidea.hierarchyviewer.internal.logic;


import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.polidea.hierarchyviewer.internal.model.layoutparams.RelativeLayoutParamsModelInfo;
import com.polidea.hierarchyviewer.internal.model.layoutparams.ViewGroupLayoutParamsModelInfo;
import com.polidea.hierarchyviewer.internal.model.layoutparams.ViewGroupMarginLayoutParamsModelInfo;

enum SystemLayoutParamsConverter implements LayoutParamsConverter {

    RELATIVE_LAYOUT_PARAMS_MODEL_INFO(RelativeLayout.LayoutParams.class) {
        @Override
        public RelativeLayoutParamsModelInfo getLayoutParamsModelInfo() {
            return new RelativeLayoutParamsModelInfo();
        }
    },
    VIEW_GROUP_MARGIN_LAYOUT_PARAM(ViewGroup.MarginLayoutParams.class) {
        @Override
        public ViewGroupMarginLayoutParamsModelInfo getLayoutParamsModelInfo() {
            return new ViewGroupMarginLayoutParamsModelInfo();
        }
    },
    VIEW_GROUP_LAYOUT_PARAM(ViewGroup.LayoutParams.class) {
        @Override
        public ViewGroupLayoutParamsModelInfo getLayoutParamsModelInfo() {
            return new ViewGroupLayoutParamsModelInfo();
        }
    };

    Class<? extends ViewGroup.LayoutParams> clazz;

    SystemLayoutParamsConverter(Class<? extends ViewGroup.LayoutParams> clazz) {
        this.clazz = clazz;
    }
}
