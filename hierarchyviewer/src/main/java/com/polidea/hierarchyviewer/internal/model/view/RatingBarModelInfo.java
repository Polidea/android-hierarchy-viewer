package com.polidea.hierarchyviewer.internal.model.view;


import android.view.View;
import android.widget.RatingBar;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;
import com.polidea.hierarchyviewer.internal.provider.FileUtilsProvider;

public class RatingBarModelInfo extends AbsSeekBarModelInfo {

    interface Metadata {

        String RATING = "rating";
        String STEP_SIZE = "step_size";
        String NUM_STAR = "numStar";
        String IS_INDICATOR = "is_indicator";
    }

    @SerializedName(Metadata.RATING)
    float rating;

    @SerializedName(Metadata.STEP_SIZE)
    float stepSize;

    @SerializedName(Metadata.NUM_STAR)
    int numStar;

    @SerializedName(Metadata.IS_INDICATOR)
    boolean isIndicator;


    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer, FileUtilsProvider fileUtilsProvider) {
        super.setDataFromView(view, convertersContainer, fileUtilsProvider);
        RatingBar ratingBar = (RatingBar) view;
        rating = ratingBar.getRating();
        stepSize = ratingBar.getStepSize();
        numStar = ratingBar.getNumStars();
        isIndicator = ratingBar.isIndicator();
    }
}
