package com.kaka.jplugin.autocode.vo;


/**
 * 表对应主键
 */
public class PrimaryKeyVO extends BaseVO{
    /**
     * 表名
     */
    private String tableName;
    /**
     * 列名
     */
    private String colName;

    /**
     * 主键名称
     */
    private String pkName;
    /**
     * 序列号(主键内值1表示第一列的主键，值2代表主键内的第二列)
     */
    private int keySeq;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getPkName() {
        return pkName;
    }

    public void setPkName(String pkName) {
        this.pkName = pkName;
    }

    public int getKeySeq() {
        return keySeq;
    }

    public void setKeySeq(int keySeq) {
        this.keySeq = keySeq;
    }
}
