package com.kaka.jplugin.autocode;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.kaka.jplugin.autocode.biz.MakeCodingHandler;
import com.kaka.jplugin.autocode.biz.MySqlDbHandler;
import com.kaka.jplugin.autocode.biz.RenderHandler;
import com.kaka.jplugin.autocode.vo.CodeVO;
import com.kaka.jplugin.autocode.vo.ContextVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;
import java.util.Properties;

/**
 * Goal which touches a timestamp file.
 *
 * @goal touch
 * @phase process-sources
 */
@Mojo(name = "code")
public class AutoCoding
        extends AbstractMojo {

    @Parameter
    private Properties dataSource;
    @Parameter
    private CodeVO codeVO;

    @Override
    public void execute() {

        getLog().info(dataSource.toString());
        getLog().info(codeVO.toString());
        try {
            MySqlDbHandler mySqlDbHandler = new MySqlDbHandler(dataSource, codeVO);
            List<ContextVO> contextVOList = mySqlDbHandler.excute();
            if (CollectionUtils.isNotEmpty(contextVOList)) {
                for (ContextVO contextVO : contextVOList) {
                    // 1.把context信息渲染到Velocity信息
                    RenderHandler renderHandler = new RenderHandler(contextVO, null);
                    String content = renderHandler.excute();

                    // 2.渲染后的内容输出到文件
                    MakeCodingHandler makeCoding = new MakeCodingHandler(contextVO, content);
                    String fileName = makeCoding.excute();
                    if (StringUtils.isNotBlank(fileName)) {
                        getLog().info("生成文件：" + fileName);
                    }
                }
            }
        } catch (Exception e) {
            getLog().info("生成代码出错", e);
        }

    }
}
