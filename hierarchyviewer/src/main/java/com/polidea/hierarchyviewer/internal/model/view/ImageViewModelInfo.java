package com.polidea.hierarchyviewer.internal.model.view;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class ImageViewModelInfo extends ViewModelInfo {

    interface Metadata {

        String SCALE_TYPE = "scale_type";

        String BITMAP_WIDTH = "bitmap_width";
        String BITMAP_HEIGHT = "bitmap_height";
    }

    @SerializedName(Metadata.SCALE_TYPE)
    ImageView.ScaleType scaleType;


    @SerializedName(Metadata.BITMAP_WIDTH)
    Integer bitmapImageWidth;

    @SerializedName(Metadata.BITMAP_HEIGHT)
    Integer bitmapImageHeight;

    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);
        final ImageView imageView = (ImageView) view;
        scaleType = imageView.getScaleType();

        final Drawable drawable = imageView.getDrawable();

        if (drawable instanceof BitmapDrawable) {
            final BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            final Bitmap bmp = bitmapDrawable.getBitmap();
            if (bmp != null) {
                bitmapImageWidth = bmp.getWidth();
                bitmapImageHeight = bmp.getHeight();
            }
        }
    }
}
