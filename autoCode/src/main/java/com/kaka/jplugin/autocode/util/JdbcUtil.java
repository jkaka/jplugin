package com.kaka.jplugin.autocode.util;

import org.apache.commons.lang.StringUtils;

import java.sql.JDBCType;
import java.util.Date;

/**
 * @Description： DB操作工具类
 * @PackageName: com.kaka.jplugin.autocode.util
 * @project： auto-code-maven-plugin
 * @author: jsk
 * @dep: ***部门
 *
 * @address: hundsun
 * @date： 2017-08-19 星期六 下午2:31
 */
public class JdbcUtil {
    /**
     * DB类型转java类型
     *
     * @param colType
     * @return
     */
    public static String colType2JavaType(String colType) {
       // System.out.println("colType===="+colType);
        if (StringUtils.isBlank(colType)) {
            return colType;
        }
        if(JDBCType.TINYINT.getName().equals(colType)
                ||JDBCType.SMALLINT.getName().equals(colType)){
            return Integer.class.getName();
        }
        if(JDBCType.INTEGER.getName().equals(colType)
                ||JDBCType.BIGINT.getName().equals(colType)
                ||JDBCType.NUMERIC.getName().equals(colType)){
            return Long.class.getName();
        }
        if(JDBCType.FLOAT.getName().equals(colType)
                ||JDBCType.REAL.getName().equals(colType)){
            return Float.class.getName();
        }
        if(JDBCType.DOUBLE.getName().equals(colType)
                ||JDBCType.DECIMAL.getName().equals(colType)){
            return Double.class.getName();
        }
        if (JDBCType.CHAR.getName().equals(colType)
                ||JDBCType.VARCHAR.getName().equals(colType)
                ||JDBCType.LONGVARCHAR.getName().equals(colType)) {
            return String.class.getName();
        }
        if (JDBCType.DATE.getName().equals(colType)
                ||JDBCType.TIME.getName().equals(colType)
                ||JDBCType.TIMESTAMP.getName().equals(colType)) {
            return Date.class.getName();
        }
        String lowerColType = colType.toLowerCase();
        if ("number".equals(lowerColType)
                ||"numeric".equals(lowerColType)
                ||"long".equals(lowerColType)
                || "bigint".equals(lowerColType)
                || "int".equals(lowerColType)
                || "tinyint".equals(lowerColType) ) {
            return Long.class.getName();
        }
        if ("int unsigned".equals(lowerColType)||"tinyint unsigned".equals(lowerColType)) {
            return Integer.class.getName();
        }
        if ("varchar".equals(lowerColType)||"char".equals(lowerColType)
                ||"longtext".equals(lowerColType)) {
            return String.class.getName();
        }
        if ("date".equals(lowerColType)||"timestamp".equals(lowerColType)||"datetime".equals(lowerColType)) {
            return Date.class.getName();
        }

        return null;
    }
}
