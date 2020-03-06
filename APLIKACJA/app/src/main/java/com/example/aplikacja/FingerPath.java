package com.example.aplikacja;

import android.graphics.Path;


public class FingerPath {


    public int color;
    public boolean emboss;
    public boolean blur;
    public int strokWidth;
    public Path path;

    public FingerPath(int color, boolean emboss, boolean blur, int strokWidth, Path path) {
        this.color = color;
        this.emboss = emboss;
        this.blur = blur;
        this.strokWidth = strokWidth;
        this.path = path;
    }


}
