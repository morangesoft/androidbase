package com.morangesoft.gm.models;

import android.view.View;
import android.widget.ImageView;

public class ClieSelector {
    public int index;
    public View selector;
    public ImageView edit;
    public ImageView kill;
    public Object data;

    public ClieSelector(){

    }

    public ClieSelector(int idx, View anyselector, ImageView anyedit, ImageView anykill){
        this.index = idx;
        this.selector = anyselector;
        this.edit = anyedit;
        this.kill = anykill;
    }

    public ClieSelector(int idx, View anyselector, ImageView anyedit, ImageView anykill, Object info){
        this.index = idx;
        this.selector = anyselector;
        this.edit = anyedit;
        this.kill = anykill;
        this.data = info;
    }

}
