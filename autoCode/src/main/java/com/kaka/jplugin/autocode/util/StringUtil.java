package com.kaka.jplugin.autocode.util;

import org.apache.commons.lang3.StringUtils;

public final class StringUtil {
    private static String SEPARATOR_CHARS = "_";

    /**
     * 把以下线分隔开的字符串转成以驼峰命名法
     *
     * @param name
     * @return
     */
    public static String toCamelCase(String name) {
        if (StringUtils.isBlank(name)) {
            return name;
        }
        String[] names = StringUtils.split(name, SEPARATOR_CHARS);

        StringBuilder sb = new StringBuilder(lowerCaseFirst(names[0]));
        for (int i = 1; i < names.length; i++) {
            sb.append(upperCaseFirst(names[i]));
        }
        return sb.toString();
    }

    /**
     * 首字母大写
     *
     * @param name
     * @return
     */
    public static String upperCaseFirst(String name) {
        if (org.apache.commons.lang3.StringUtils.isBlank(name)) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    /**
     * 首字母小写
     *
     * @param name
     * @return
     */
    public static String lowerCaseFirst(String name) {
        if (org.apache.commons.lang3.StringUtils.isBlank(name)) {
            return name;
        }
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }
}