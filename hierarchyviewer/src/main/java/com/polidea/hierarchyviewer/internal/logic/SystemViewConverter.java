package com.polidea.hierarchyviewer.internal.logic;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsSpinner;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.polidea.hierarchyviewer.internal.model.view.AbsListViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.AbsSpinnerModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.AdapterViewAnimatorModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.AdapterViewFlipperModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.AdapterViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ButtonModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.CheckBoxModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.CheckedTextViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.CompoundButtonModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ExpandableListViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.GridLayoutModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.GridViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ImageViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ListViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ProgressBarModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.RadioButtonModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.RadioGroupModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.RatingBarModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.RecyclerViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.SpinnerModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.SwitchModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.TextViewModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ToggleButtonModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ViewGroupModelInfo;
import com.polidea.hierarchyviewer.internal.model.view.ViewModelInfo;

public enum SystemViewConverter implements ViewConverter {

    GRID_LAYOUT(GridLayout.class) {
        @Override
        public GridLayoutModelInfo getModelInfo() {
            return new GridLayoutModelInfo();
        }
    },
    RADIO_GROUP(RadioGroup.class) {
        @Override
        public RadioGroupModelInfo getModelInfo() {
            return new RadioGroupModelInfo();
        }
    },
    RATING_BAR(RatingBar.class) {
        @Override
        public RatingBarModelInfo getModelInfo() {
            return new RatingBarModelInfo();
        }
    },

    TOGGLE_BUTTON(ToggleButton.class) {
        @Override
        public ToggleButtonModelInfo getModelInfo() {
            return new ToggleButtonModelInfo();
        }
    },

    SWITCH(Switch.class) {
        @Override
        public SwitchModelInfo getModelInfo() {
            return new SwitchModelInfo();
        }
    },

    RADIO_BUTTON(RadioButton.class) {
        @Override
        public RadioButtonModelInfo getModelInfo() {
            return new RadioButtonModelInfo();
        }
    },

    CHECK_BOX(CheckBox.class) {
        @Override
        public CheckBoxModelInfo getModelInfo() {
            return new CheckBoxModelInfo();
        }
    },

    COMPOUND_BUTTON(CompoundButton.class) {
        @Override
        public CompoundButtonModelInfo getModelInfo() {
            return new CompoundButtonModelInfo();
        }
    },

    BUTTON(Button.class) {
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

    SPINNER(Spinner.class) {
        @Override
        public ModelInfo getModelInfo() {
            return new SpinnerModelInfo();
        }
    },

    GRID_VIEW(GridView.class) {
        @Override
        public ModelInfo getModelInfo() {
            return new GridViewModelInfo();
        }
    },

    EXPANDABLE_LIST_VIEW(ExpandableListView.class) {
        @Override
        public ModelInfo getModelInfo() {
            return new ExpandableListViewModelInfo();
        }
    },

    LIST_VIEW(ListView.class) {
        @Override
        public ModelInfo getModelInfo() {
            return new ListViewModelInfo();
        }
    },

    ADAPTER_VIEW_FLIPPER(AdapterViewFlipper.class) {
        @Override
        public ModelInfo getModelInfo() {
            return new AdapterViewFlipperModelInfo();
        }
    },

    ABS_LIST_VIEW(AbsListView.class) {
        @Override
        public AbsListViewModelInfo getModelInfo() {
            return new AbsListViewModelInfo();
        }
    },

    ABS_SPINNER(AbsSpinner.class) {
        @Override
        public ModelInfo getModelInfo() {
            return new AbsSpinnerModelInfo();
        }
    },

    ADAPTER_VIEW_ANIMATOR(AdapterViewAnimator.class) {
        @Override
        public ModelInfo getModelInfo() {
            return new AdapterViewAnimatorModelInfo();
        }
    },

    ADAPTER_VIEW(AdapterView.class) {
        @Override
        public AdapterViewModelInfo getModelInfo() {
            return new AdapterViewModelInfo();
        }
    },

    RECYCLER_VIEW(RecyclerView.class) {
        @Override
        public ModelInfo getModelInfo() {
            return new RecyclerViewModelInfo();
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

    SystemViewConverter(Class clazz) {
        this.clazz = clazz;
    }

    Class<? extends View> clazz;
}
