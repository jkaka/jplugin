package com.kaka.jplugin.autocode.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class BaseVO implements Serializable {

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
