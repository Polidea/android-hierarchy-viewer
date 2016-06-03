package com.polidea.hierarchyviewer.internal.provider;

import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileUtilsProvider {

    private static final String SERVER_CACHE_DIR = Environment.getExternalStorageDirectory().toString() + "/serverCache";

    boolean clearCacheFolder() {
        File dir = new File(SERVER_CACHE_DIR);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
        return true;
    }

    boolean createCacheFolderIfNotExist() {
        File dir = new File(SERVER_CACHE_DIR);
        return dir.exists() || dir.mkdir();
    }

    File getFile(String linkToFile) {
        return new File(new File(SERVER_CACHE_DIR), "IMG_" + linkToFile + ".png");
    }

    public boolean saveViewInFile(View view, String fileName) {
        view.setDrawingCacheEnabled(true);

        Bitmap cacheBitmap = view.getDrawingCache();

        if (cacheBitmap == null) {
            view.setDrawingCacheEnabled(false);
            return false;
        }
        Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);
        view.setDrawingCacheEnabled(false);
        File imageFile = getFile(fileName);

        try {
            OutputStream fout = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fout);
            fout.flush();
            fout.close();

        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
