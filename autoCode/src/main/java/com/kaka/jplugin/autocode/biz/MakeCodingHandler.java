package com.kaka.jplugin.autocode.biz;


import com.kaka.jplugin.autocode.vo.ContextVO;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jsk
 */
public class MakeCodingHandler implements Handler<String> {

    private ContextVO contextVO;

    private String ecnoding;
    private String content;

    public MakeCodingHandler(ContextVO contextVO, String content) {
        this(contextVO, content, ENCODING);
    }

    public MakeCodingHandler(ContextVO contextVO, String content, String ecnoding) {
        this.contextVO = contextVO;
        this.ecnoding = ecnoding;
        this.content = content;
    }

    @Override
    public String excute() {
        // com.demo.ota.   biz.service
        String packagePath = contextVO.getPackagePath().replace(POINT, BACKSLASH);
        String filePath = contextVO.getResPath() + packagePath + BACKSLASH;
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        Boolean success = Boolean.FALSE;
        StringBuilder fileName = new StringBuilder(contextVO.getEntity());
        if (StringUtils.isNotBlank(contextVO.getType())) {
            fileName.append(contextVO.getType());
        }
        //System.out.println("contextVO.getType()==="+contextVO.getType());
        //if("Controller".equals(contextVO.getType())) {
        // fileName.append("1");
        //}
        fileName.append(POINT).append(contextVO.getSuffix());
        File f = new File(file, fileName.toString());
        byte[] buff = new byte[0];

        if (!f.exists()) {
            FileOutputStream out = null;

            try {
                f.createNewFile();
                buff = content.getBytes(ecnoding);
                out = new FileOutputStream(f);
                out.write(buff, 0, buff.length);
                success = Boolean.TRUE;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null != out) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        if (success) {
            return f.getName();
        }

        return null;
    }
}
