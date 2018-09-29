package com.kaka.jplugin.autocode.util;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {
    private static String EMAIL = "^([a-zA-Z0-9]*[-_.]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";

    private static Pattern P_EMAIL = Pattern.compile(EMAIL);
    private static Pattern P_MOBILE = Pattern.compile("^((1[3-8][0-9]))\\d{8}$");
    private static Pattern P_USERNAME = Pattern.compile("^([a-zA-Z][a-zA-Z0-9]*[-_.]?[a-zA-Z0-9]+)*$");

    /**
     * 处理类似：responseformat=2; charset=UTF-8  转换成map结构
     * @param name
     * @param separatorChars0
     * @param separatorChars1
     * @return
     */
    public static Map<String, String> split(String name, String separatorChars0, String separatorChars1) {
        Map<String, String> data = new HashMap<String, String>();
        if (StringUtils.isNotBlank(name)) {
            String[] accepts = name.split(separatorChars0);
            if (null != accepts && accepts.length > 0) {
                for (String acc : accepts) {
                    if (StringUtils.isNotBlank(acc)) {
                        String[] accs = acc.split(separatorChars1);
                        if (null != accs && accs.length >= 2) {
                            data.put(accs[0], accs[1]);
                        }
                    }
                }
            }
        }
        return data;
    }
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
        String[] names = StringUtils.split(name, "_");

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
        if (StringUtils.isBlank(name)) {
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
        if (StringUtils.isBlank(name)) {
            return name;
        }
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }

    /**
     * 邮箱验证
     *
     * @param email
     * @return
     */
    public static Boolean isEmail(String email) {
        Matcher m = P_EMAIL.matcher(email);
        return m.matches();
    }

    /**
     * 手机号验证
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        Matcher m = P_MOBILE.matcher(mobiles);
        return m.matches();
    }

    /**
     * 用户名验证
     *
     * @param userName
     * @return
     */
    public static boolean isUserName(String userName) {
        Matcher m = P_USERNAME.matcher(userName);
        return m.matches();
    }

    public static void main(String[] args) {

        System.out.println(isUserName("ygpc.springyahoocom.cn"));
    }
}