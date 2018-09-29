package com.kaka.jplugin.autocode.enums;

public enum TemplateType {

    // client
    DTO("client/dto","template/valueobject.vm","/client/src/main/java/","DTO","java"),
    DUBBOSERVICE("client/service","template/dubboservice.vm","/client/src/main/java/","ReadService","java"),
    DUBBOWRITESERVICE("client/service","template/dubbowriteservice.vm","/client/src/main/java/","WriteService","java"),

    // openservice
    DUBBOSERVICEIMP("openservice/service/impl","template/dubboserviceimpl.vm","/openservice/src/main/java/","ReadServiceImpl","java"),
    DUBBOWRITESERVICEIMP("openservice/service/impl","template/dubbowriteserviceimpl.vm","/openservice/src/main/java/","WriteServiceImpl","java"),


    DATAOBJECT("biz/dataobject","template/dataobject.vm","/biz/src/main/java/","DO","java"),
    SERVICE("biz/service","template/service.vm","/biz/src/main/java/","service","java"),
    SERVICEIMPL("biz/service/impl","template/serviceimpl.vm","/biz/src/main/java/","serviceImpl","java"),
    MAPPER("biz/mapper","template/mapper.vm","/biz/src/main/java/","mapper","java"),
    MAPPING("biz/mapper","template/mapping.vm","/biz/src/main/resources/","mapping","xml"),

    CONTROLLER("boot/controller","template/controller.vm","/boot/src/main/java/","controller","java"),

    DUBBOCALLSERVICE("call/service","template/dubbocallservice.vm","/consumer/call/src/main/java/","CallService","java"),
    DUBBOCALLSERVICEIMP("call/service/impl","template/dubbocallserviceimpl.vm","/consumer/call/src/main/java/","CallServiceImpl","java"),
    DUBBOCONTROLLER("boot/controller","template/dubbocontroller.vm","/consumer/boot/src/main/java/","controller","java");


    private String pack;
    private String templateName;
    private String resPath;
    private String type;
    private String suffix;

     TemplateType(String pack, String templateName, String resPath, String type, String suffix){
        this.pack = pack;
        this.templateName = templateName;
        this.resPath = resPath;
        this.type = type;
        this.suffix = suffix;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
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
