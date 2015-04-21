package com.polidea.hierarchyviewer.internal.logic;


import android.support.v7.widget.LinearLayoutCompat;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.polidea.hierarchyviewer.internal.model.layoutparams.FrameLayoutParamsModelInfo;
import com.polidea.hierarchyviewer.internal.model.layoutparams.LinearLayoutCompatParamsModelInfo;
import com.polidea.hierarchyviewer.internal.model.layoutparams.LinearLayoutParamsModelInfo;
import com.polidea.hierarchyviewer.internal.model.layoutparams.RelativeLayoutParamsModelInfo;
import com.polidea.hierarchyviewer.internal.model.layoutparams.ViewGroupLayoutParamsModelInfo;
import com.polidea.hierarchyviewer.internal.model.layoutparams.ViewGroupMarginLayoutParamsModelInfo;

enum SystemLayoutParamsConverter implements LayoutParamsConverter {



    FRAME_LAYOUT_PARAMS_MODEL_INFO(FrameLayout.LayoutParams.class) {
        @Override
        public FrameLayoutParamsModelInfo getLayoutParamsModelInfo() {
            return new FrameLayoutParamsModelInfo();
        }
    },
    LINEAR_LAYOUT_COMPAT_PARAMS_MODEL_INFO(LinearLayoutCompat.LayoutParams.class) {
        @Override
        public LinearLayoutCompatParamsModelInfo getLayoutParamsModelInfo() {
            return new LinearLayoutCompatParamsModelInfo();
        }
    },
    LINEAR_LAYOUT_PARAMS_MODEL_INFO(LinearLayout.LayoutParams.class) {
        @Override
        public LinearLayoutParamsModelInfo getLayoutParamsModelInfo() {
            return new LinearLayoutParamsModelInfo();
        }
    },
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
