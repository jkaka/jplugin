package com.kaka.jplugin.autocode.vo;

/**
 * @Description： 代码生成配置项
 * @PackageName: com.kaka.jplugin.autocode
 * @project： auto-code-maven-plugin
 * @author: springyu 一只很土的狼  pingchunyu@kaka.com.cn
 * @dep: 云端技术部
 * @company: 浙江亿咖通科技有限公司  Zhejiang e-CarX Technology Co., Ltd
 * @address: 浙江省杭州市滨江区泰安路杭州印B座17楼(华联 · 星光大道2期西)
 * @date： 2017-08-19 星期六 下午1:58
 */
public class CodeVO extends BaseVO {
    /**
     * 系统代码(系统项目名)
     */
    private String sysCode;

    /**
     * dubbo消费者系统代码(消费者系统项目名)
     */
    private String dubboConsumerSysCode;

    /**
     * 包目录
     */
    private String rootPackage;

    /**
     * 消费方的包目录
     */
    private String consumerRootPackage;

    /**
     * 应用根目录(应用各模块生成位置)
     */
    private String generatePath;

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getRootPackage() {
        return rootPackage;
    }

    public void setRootPackage(String rootPackage) {
        this.rootPackage = rootPackage;
    }

    public String getGeneratePath() {
        return generatePath;
    }

    public void setGeneratePath(String generatePath) {
        this.generatePath = generatePath;
    }

    public String getDubboConsumerSysCode() {
        return dubboConsumerSysCode;
    }

    public void setDubboConsumerSysCode(String dubboConsumerSysCode) {
        this.dubboConsumerSysCode = dubboConsumerSysCode;
    }

    public String getConsumerRootPackage() {
        return consumerRootPackage;
    }

    public void setConsumerRootPackage(String consumerRootPackage) {
        this.consumerRootPackage = consumerRootPackage;
    }
}
