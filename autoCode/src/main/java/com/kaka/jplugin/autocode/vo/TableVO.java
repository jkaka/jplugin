package com.kaka.jplugin.autocode.vo;

import java.util.List;
import java.util.Map;

public class TableVO extends BaseVO{

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表主键信息
     */
    private Map<String,PrimaryKeyVO> primaryKeys;

    /**
     * 表列列表
     */
    private List<ColumnVO> columnList;

    /**
     * 表注释
     */
    private String tableRemark;
    /**
     * 表对应实体名
     */
    private String beanName;
    /**
     * 所在系统代码
     */
    private String sysCode;

    /**
     * 类型
     */
    private String entity;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public List<ColumnVO> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnVO> columnList) {
        this.columnList = columnList;
    }

    public Map<String, PrimaryKeyVO> getPrimaryKeys() {
        return primaryKeys;
    }

    public void setPrimaryKeys(Map<String, PrimaryKeyVO> primaryKeys) {
        this.primaryKeys = primaryKeys;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableRemark() {
        return tableRemark;
    }

    public void setTableRemark(String tableRemark) {
        this.tableRemark = tableRemark;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }
}
