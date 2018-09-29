package com.kaka.jplugin.autocode.util;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.util.Properties;

/**
 * Created by springyu on 17-7-1.
 */
public class VelocityUtils {

    public VelocityUtils(String loaderPath) {
        Properties p = new Properties();
        //设置velocity资源加载方式为file
        p.setProperty("resource.loader", "file");
        //设置velocity资源加载方式为file时的处理类
        //p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        p.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        //p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, loaderPath);
        // 初始化Velocity引擎，init对引擎VelocityEngine配置了一组默认的参数
        Velocity.init(p);
    }

    public String renderTemplate(String templateName, VelocityContext context, String encoding) {
        // 获取渲染后的模板内容
        Template template = Velocity.getTemplate(templateName, encoding);
        // 把模板内容写入StringWriter
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        return writer.toString();
    }

}
