package com.jll.zoro.multitype;

import android.content.Context;

/**
 * @Author : Zoro.
 * @Date : 2017/4/11.
 * @Describe :
 */

public class Song {

    public String text;
    public int drawable;
    public Context context;

    public Song(String text,int drawable,Context context) {
        this.text = text;
        this.drawable = drawable;
        this.context = context;
    }
}
