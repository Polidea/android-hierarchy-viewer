package com.polidea.hierarchyviewer.internal.logic;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.polidea.hierarchyviewer.internal.model.view.ImageViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.TextViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ViewGroupModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ViewModelInfo;

public enum SystemConverter implements Converter {

    IMAGE_VIEW(ImageView.class) {
        @Override
        public ImageViewModelInfo getModelInfo() {
            return new ImageViewModelInfo();
        }
    },

    TEXT_VIEW(TextView.class) {
        @Override
        public TextViewModelInfo getModelInfo() {
            return new TextViewModelInfo();
        }
    },

    VIEW_GROUP(ViewGroup.class)  {
        @Override
        public ViewGroupModelInfo getModelInfo() {
            return new ViewGroupModelInfo();
        }
    },

    VIEW(View.class) {
        @Override
        public ViewModelInfo getModelInfo() {
            return new ViewModelInfo();
        }
    };

    SystemConverter(Class clazz) {
        this.clazz = clazz;
    }

    Class clazz;


}
