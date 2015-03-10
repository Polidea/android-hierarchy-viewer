package com.polidea.hierarchyviewer.internal.model;

import com.google.gson.annotations.SerializedName;

public class ThrowableModel {

    interface Metadata {

        String NAME = "name";
        String STACK_TRACE = "stackTrace";
        String CAUSE = "cause";

    }

    @SerializedName(Metadata.NAME)
    String name;

    @SerializedName(Metadata.STACK_TRACE)
    String stackTrace;

    @SerializedName(Metadata.CAUSE)
    ThrowableModel cause;

    public void setDataFromException(Throwable e) {
        name = e.getClass().getName();
        stackTrace = e.getMessage();
        Throwable causeThrowable = e.getCause();
        if (causeThrowable != null) {
            cause = new ThrowableModel();
            cause.setDataFromException(causeThrowable);
        }
    }

}
