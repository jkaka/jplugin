package com.kaka.jplugin.autocode.vo;

import lombok.Data;

/**
 * @Description： 代码生成配置项
 * @PackageName: com.kaka.jplugin.autocode
 * @project： auto-code-maven-plugin
 * @author: jsk
 * @dep: ***部门
 * @address: ****
 * @date： 2017-08-19 星期六 下午1:58
 */
@Data
public class CodeVO extends BaseVO {
    /**
     * 系统代码(系统项目名)
     */
    private String sysCode;

    /**
     * 包目录
     */
    private String rootPackage;

    /**
     * uri前缀
     */
    private String uriPrefix;

    /**
     * dubbo消费者系统代码(消费者系统项目名)
     */
    private String consumerSysCode;

    /**
     * 消费方的包目录
     */
    private String consumerRootPackage;

    private String consumerUriPrefix;

    /**
     * 应用根目录(应用各模块生成位置)
     */
    private String generatePath;

    /**
     * 生成代码的表名
     *
     * @return
     */
    private String tableNameList;

    private String codeStatus;
}
