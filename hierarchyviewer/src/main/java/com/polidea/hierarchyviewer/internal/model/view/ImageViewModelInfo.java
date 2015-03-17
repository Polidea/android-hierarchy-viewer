package com.polidea.hierarchyviewer.internal.model.view;


import android.view.View;
import android.widget.ImageView;
import com.google.gson.annotations.Expose;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.provider.FileUtilsProvider;

public class ImageViewModelInfo extends ViewModelInfo{

    @Expose
    ImageView.ScaleType scaleType;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer, FileUtilsProvider fileUtilsProvider) {
        super.setDataFromView(view, convertersContainer, fileUtilsProvider);
        final ImageView imageView = (ImageView) view;
        scaleType = imageView.getScaleType();
    }
}
