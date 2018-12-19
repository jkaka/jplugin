package com.kaka.jplugin.autocode.enums;

public enum TemplateType {

    // client
    DTO("client/dto", "template/valueobject.vm", "/client/src/main/java/", "DTO", "java"),
    DUBBOSERVICE("client/service", "template/dubboservice.vm", "/client/src/main/java/", "ReadService", "java"),
    DUBBOWRITESERVICE("client/service", "template/dubbowriteservice.vm", "/client/src/main/java/", "WriteService", "java"),

    // openservice
    DUBBOSERVICEIMP("openservice/service/impl", "template/dubboserviceimpl.vm", "/openservice/src/main/java/", "ReadServiceImpl", "java"),
    DUBBOWRITESERVICEIMP("openservice/service/impl", "template/dubbowriteserviceimpl.vm", "/openservice/src/main/java/", "WriteServiceImpl", "java"),


    DATAOBJECT("biz/dataobject", "template/dataobject.vm", "/biz/src/main/java/", "DO", "java"),
    SERVICE("biz/service", "template/service.vm", "/biz/src/main/java/", "Service", "java"),
    SERVICEIMPL("biz/service/impl", "template/serviceimpl.vm", "/biz/src/main/java/", "ServiceImpl", "java"),
    MAPPER("biz/mapper", "template/mapper.vm", "/biz/src/main/java/", "Mapper", "java"),
    MAPPING("biz/mapper", "template/mapping.vm", "/biz/src/main/resources/", "Mapping", "xml"),

    // boot
    CONTROLLER("boot/controller", "template/controller.vm", "/boot/src/main/java/", "Controller", "java"),

    CONTROLLER_TEST("boot/controller", "template/controllerTest.vm", "/boot/src/test/java/", "ControllerTest", "java"),
    DUBBO_READE_SERVICE_TEST("client/service", "template/dubboReadServiceTest.vm", "/boot/src/test/java/", "ReadServiceTest", "java"),
    DUBBO_WRITE_SERVICE_TEST("client/service", "template/dubboWriteServiceTest.vm", "/boot/src/test/java/", "WriteServiceTest", "java"),

    // 消费者
    DUBBOCALLSERVICE("call/service", "template/dubbocallservice.vm", "/consumer/call/src/main/java/", "CallService", "java"),
    DUBBOCALLSERVICEIMP("call/service/impl", "template/dubbocallserviceimpl.vm", "/consumer/call/src/main/java/", "CallServiceImpl", "java"),
    DUBBOCONTROLLER("boot/controller", "template/dubbocontroller.vm", "/consumer/boot/src/main/java/", "Controller", "java"),
    DUBBO_CONTROLLER_TEST("boot/controller", "template/dubboControllerTest.vm", "/consumer/boot/src/test/java/", "ControllerTest", "java");


    /**
     * 功能包名,不包含groupId
     */
    private String functionPackage;
    private String templateName;
    private String resPath;
    /**
     * 实体类后缀名
     */
    private String type;
    /**
     * 文件扩展名
     */
    private String suffix;

    TemplateType(String functionPackage, String templateName, String resPath, String type, String suffix) {
        this.functionPackage = functionPackage;
        this.templateName = templateName;
        this.resPath = resPath;
        this.type = type;
        this.suffix = suffix;
    }

    public String getFunctionPackage() {
        return functionPackage;
    }

    public void setFunctionPackage(String functionPackage) {
        this.functionPackage = functionPackage;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getResPath() {
        return resPath;
    }

    public void setResPath(String resPath) {
        this.resPath = resPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
