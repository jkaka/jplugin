package com.kaka.jplugin.autocode.biz;

/**
 * @author jsk
 */
public interface Handler<T> {
    String BACKSLASH = "/";
    String POINT = ".";
    String ENCODING = "utf-8";

    T excute();
}
