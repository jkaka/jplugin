package com.kaka.jplugin.autocode.biz;

/**
 * Created by springyu on 17-7-2.
 */
public interface Handler<T> {
       String BACKSLASH="/";
       String POINT =".";
       String ENCODING="utf-8";


    T excute();

}
