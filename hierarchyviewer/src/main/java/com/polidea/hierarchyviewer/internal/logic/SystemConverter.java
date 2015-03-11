package com.polidea.hierarchyviewer.internal.logic;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.polidea.hierarchyviewer.internal.model.view.ButtonModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.CheckBoxModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.CheckedTextViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.CompoundButtonModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ImageViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ProgressBarModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.RadioButtonModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.SwitchModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.TextViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ToggleButtonModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ViewGroupModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ViewModelInfo;

public enum SystemConverter implements Converter {

    TOGGLE_BUTTON(CheckedTextView.class) {
        @Override
        public ToggleButtonModelInfo getModelInfo() {
            return new ToggleButtonModelInfo();
        }
    },

    SWITCH(CheckedTextView.class) {
        @Override
        public SwitchModelInfo getModelInfo() {
            return new SwitchModelInfo();
        }
    },

    RADIO_BUTTON(CheckedTextView.class) {
        @Override
        public RadioButtonModelInfo getModelInfo() {
            return new RadioButtonModelInfo();
        }
    },

    CHECK_BOX(CheckedTextView.class) {
        @Override
        public CheckBoxModelInfo getModelInfo() {
            return new CheckBoxModelInfo();
        }
    },

    COMPOUND_BUTTON(CheckedTextView.class) {
        @Override
        public CompoundButtonModelInfo getModelInfo() {
            return new CompoundButtonModelInfo();
        }
    },

    BUTTON(CheckedTextView.class) {
        @Override
        public ButtonModelInfo getModelInfo() {
            return new ButtonModelInfo();
        }
    },

    CHECKED_TEXT_VIEW(CheckedTextView.class) {
        @Override
        public CheckedTextViewModelInfo getModelInfo() {
            return new CheckedTextViewModelInfo();
        }
    },

    IMAGE_VIEW(ImageView.class) {
        @Override
        public ImageViewModelInfo getModelInfo() {
            return new ImageViewModelInfo();
        }
    },

    PROGRESS_BAR(ProgressBar.class) {
        @Override
        public ProgressBarModelInfo getModelInfo() {
            return new ProgressBarModelInfo();
        }
    },

    TEXT_VIEW(TextView.class) {
        @Override
        public TextViewModelInfo getModelInfo() {
            return new TextViewModelInfo();
        }
    },

    VIEW_GROUP(ViewGroup.class) {
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
