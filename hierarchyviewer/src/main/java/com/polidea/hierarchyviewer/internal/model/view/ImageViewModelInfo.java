package com.polidea.hierarchyviewer.internal.model.view;


import android.view.View;
import android.widget.ImageView;
import com.google.gson.annotations.Expose;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class ImageViewModelInfo extends ViewModelInfo{

    @Expose
    ImageView.ScaleType scaleType;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);
        final ImageView imageView = (ImageView) view;
        scaleType = imageView.getScaleType();
    }
}
