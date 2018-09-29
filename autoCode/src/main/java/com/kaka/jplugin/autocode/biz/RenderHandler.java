package com.kaka.jplugin.autocode.biz;

import com.kaka.jplugin.autocode.util.VelocityUtils;
import com.kaka.jplugin.autocode.vo.ContextVO;
import org.apache.velocity.VelocityContext;

/**
 * Created by springyu on 17-7-2.
 */
public class RenderHandler implements Handler<String> {


    private ContextVO contextVO;

    private String ecnoding;

    private String loaderPath;

    public RenderHandler(ContextVO contextVO,String loaderPath) {
        this(contextVO, loaderPath,ENCODING);
    }

    public RenderHandler(ContextVO contextVO, String loaderPath,String ecnoding) {
        this.contextVO = contextVO;
        this.ecnoding = ecnoding;
        this.loaderPath = loaderPath;

    }

    @Override
    public String excute() {
        if (null != contextVO) {
            VelocityContext context = new VelocityContext();
            context.put("context", contextVO);
            VelocityUtils velocityUtils = new VelocityUtils(loaderPath);
            return velocityUtils.renderTemplate(contextVO.getTemplateName(), context, ecnoding);
        }
        return null;
    }
}
