package com.polidea.hierarchyviewer.internal.gson;

import android.widget.ImageView;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ScaleTypeSerializer implements JsonDeserializer<ImageView.ScaleType>, JsonSerializer<ImageView.ScaleType> {

    @Override
    public ImageView.ScaleType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return ImageView.ScaleType.valueOf(json.getAsString());
    }

    @Override
    public JsonElement serialize(ImageView.ScaleType src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }
}
