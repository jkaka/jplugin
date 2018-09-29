package com.kaka.jplugin.autocode.vo;


import java.util.Date;
import java.util.List;

/**
 * @author jsk
 * @Date 2018/9/29 16:10
 */
public class ContextVO extends BaseVO{

    /**
     * 系统代码
     */
    private String sysCode;

    /**
     * dubbo消费者系统代码
     */
    private String dubboConsumerSysCode;

    /**
     * 系统groupId
     */
    private String rootPackage;
    /**
     * 消费方groupId
     */
    private String consumerRootPackage;

    /**
     * java类路径：com.**.ota.service
     */
    private String packagePath;

    /**
     * 主键
     */
    private ColumnVO colKey;

    /**
     * 主键列表
     */
    private List<ColumnVO> colKeys;

    /**
     * 所有字段
     */
    private List<ColumnVO> columns;

    /**
     * 类路径:E://xx/xx/.../src/main/java
     */
    private String resPath;

    /**
     * 类型
     */
    private String entity;

    private String beanName;
    /**
     * 表名
     */
    private String tableName;

    /**
     * 模板
     */
    private String templateName;

    /**
     * 文件类型
     */
    private String type;

    private Date date= new Date();
    /**
     * 文件后缀
     */
    private String suffix;

    private String desc;

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getDubboConsumerSysCode() {
        return dubboConsumerSysCode;
    }

    public void setDubboConsumerSysCode(String dubboConsumerSysCode) {
        this.dubboConsumerSysCode = dubboConsumerSysCode;
    }

    public String getRootPackage() {
        return rootPackage;
    }

    public void setRootPackage(String rootPackage) {
        this.rootPackage = rootPackage;
    }

    public String getConsumerRootPackage() {
        return consumerRootPackage;
    }

    public void setConsumerRootPackage(String consumerRootPackage) {
        this.consumerRootPackage = consumerRootPackage;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public ColumnVO getColKey() {
        return colKey;
    }

    public void setColKey(ColumnVO colKey) {
        this.colKey = colKey;
    }

    public List<ColumnVO> getColKeys() {
        return colKeys;
    }

    public void setColKeys(List<ColumnVO> colKeys) {
        this.colKeys = colKeys;
    }

    public List<ColumnVO> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnVO> columns) {
        this.columns = columns;
    }

    public String getResPath() {
        return resPath;
    }

    public void setResPath(String resPath) {
        this.resPath = resPath;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
