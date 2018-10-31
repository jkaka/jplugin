package com.kaka.jplugin.autocode.vo;


import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author jsk
 * @Date 2018/9/29 16:10
 */
@Data
public class ContextVO extends BaseVO{
    /**
     * 系统代码
     */
    private String sysCode;

    /**
     * dubbo消费者系统代码
     */
    private String consumerSysCode;

    /**
     * 系统groupId
     */
    private String rootPackage;
    /**
     * 消费方groupId
     */
    private String consumerRootPackage;

    /**
     * java类完整包名：com.**.ota.service
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
     * 类路径:E://xx/xx/.../consumer/boot/src/main/java/
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

    private Date date = new Date();
    /**
     * 文件后缀
     */
    private String suffix;

    private String desc;
    private String codeStatus;
    private String uriPrefix;
    private String consumerUriPrefix;
}
