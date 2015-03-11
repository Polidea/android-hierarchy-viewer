package com.polidea.hierarchyviewer.internal.model.view;


import android.view.View;
import android.widget.RatingBar;
import com.google.gson.annotations.SerializedName;
import com.polidea.hierarchyviewer.internal.logic.ConvertersContainer;

public class RatingBarModelInfo extends AbsSeekBarModelInfo {

    interface Metadata {

        String RATING = "rating";
        String STEP_SIZE = "stepSize";
        String NUM_STAR = "numStar";
        String IS_INDICATOR = "isIndicator";
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
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);
        RatingBar ratingBar = (RatingBar) view;
        rating = ratingBar.getRating();
        stepSize = ratingBar.getStepSize();
        numStar = ratingBar.getNumStars();
        isIndicator = ratingBar.isIndicator();
    }
}
