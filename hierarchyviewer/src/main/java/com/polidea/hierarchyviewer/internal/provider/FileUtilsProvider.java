package com.polidea.hierarchyviewer.internal.provider;

import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.inject.Inject;
import javax.inject.Singleton;

public class FileUtilsProvider {

    public static final String SERVER_CACHE_DIR = Environment.getExternalStorageDirectory().toString() + "/serverCache";

    @Singleton
    @Inject
    FileUtilsProvider() {

    }

    public boolean createCacheFolderIfNotExist() {
        File dir = new File(SERVER_CACHE_DIR);
        if (!dir.exists()) {
            return dir.mkdir();
        }
        return true;
    }

    public boolean clearCacheFolder() {
        File dir = new File(SERVER_CACHE_DIR);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
        return true;
    }

    public boolean saveViewInFile(View view, String fileName) {
        File dir = new File(SERVER_CACHE_DIR);
        view.setDrawingCacheEnabled(true);

        Bitmap cacheBitmap = view.getDrawingCache();

        if (cacheBitmap == null) {
            view.setDrawingCacheEnabled(false);
            return false;
        }
        Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);
        view.setDrawingCacheEnabled(false);
        File imageFile = new File(dir, "IMG_" + fileName + ".png");

        try {
            OutputStream fout = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fout);
            fout.flush();
            fout.close();

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public File getFile(String linkToFile) {
        return new File(new File(SERVER_CACHE_DIR), "IMG_" + linkToFile + ".png");
    }
}
