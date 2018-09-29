package com.kaka.jplugin.autocode.vo;

/**
 * Created by springyu on 17-7-1.
 */
public class ColumnVO extends BaseVO {

    /**
     * 字段名称
     */
    private String colName;
    /**
     * 数据库类型
     */
    private String colType;
    /**
     * 字段描述
     */
    private String colDesc;
    /**
     * 对应javabean属性
     */
    private String attrName;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 对应java数据类型
     */
    private String javaType;

    /**
     * 是否为空
     */
    private Boolean isNotNull;
    /**
     * 是否主键
     */
    private Boolean isPrimaryKey ;


    public Boolean getNotNull() {
        return isNotNull;
    }

    public void setNotNull(Boolean notNull) {
        isNotNull = notNull;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public String getColDesc() {
        return colDesc;
    }

    public void setColDesc(String colDesc) {
        this.colDesc = colDesc;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public Boolean getPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(Boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }
}
