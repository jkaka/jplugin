package com.kaka.jplugin.autocode;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.File;

/**
 * 自动生成代码测试类
 * 测试前需要先install插件
 */
public class AutoCodingTest extends AbstractMojoTestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testAutoCoding() throws Exception {

        File pom = getTestFile("src/test/resources/plugin-test.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        AutoCoding myMojo = (AutoCoding) lookupMojo("code", pom);
        assertNotNull(myMojo);
        myMojo.execute();
    }
}