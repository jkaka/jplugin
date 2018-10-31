package com.kaka.jplugin.autocode.biz;

import com.kaka.jplugin.autocode.enums.TemplateType;
import com.kaka.jplugin.autocode.jdbc.MySql;
import com.kaka.jplugin.autocode.vo.CodeVO;
import com.kaka.jplugin.autocode.vo.ColumnVO;
import com.kaka.jplugin.autocode.vo.ContextVO;
import com.kaka.jplugin.autocode.vo.TableVO;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author jsk
 */
public class MySqlDbHandler implements Handler<List<ContextVO>> {


    private Properties dataSource;

    private CodeVO codeVO;

    public MySqlDbHandler(Properties dataSource, CodeVO codeVO) {
        this.dataSource = dataSource;
        this.codeVO = codeVO;
    }

    @Override
    public List<ContextVO> excute() {
        // 1.获取数据库信息
        MySql mySql = new MySql(dataSource);
        List<TableVO> tableList = null;
        try {
            String tableNameString = codeVO.getTableNameList();
            List<String> tableNameList = new ArrayList<>();
            if (org.apache.commons.lang3.StringUtils.isNotBlank(tableNameString)) {
                String[] split = tableNameString.split(",");
                tableNameList = Arrays.asList(split);
            }
            tableList = mySql.getTablesList(tableNameList);
            if (CollectionUtils.isNotEmpty(tableList)) {
                for (TableVO table : tableList) {
                    mySql.getColumnsInfo(table);
                }
            }
        } finally {
            mySql.close();
        }

        // 2.获取生成路径
        String generatePath = codeVO.getGeneratePath();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(generatePath)) {
            if (!generatePath.endsWith(BACKSLASH)) {
                generatePath = generatePath + BACKSLASH;
            }
        }

        // 3.把表信息封装到contextVO中
        List<ContextVO> contextVOList = new ArrayList<ContextVO>();
        if (CollectionUtils.isNotEmpty(tableList)) {
            for (TableVO table : tableList) {
                List<ColumnVO> columnList = table.getColumnList();
                ColumnVO primaryKey = null;
                if (null != columnList && !columnList.isEmpty()) {
                    for (ColumnVO columnVO : columnList) {
                        if (columnVO.getPrimaryKey()) {
                            primaryKey = columnVO;
                            break;
                        }
                    }

                }
                TemplateType[] templateTypes = TemplateType.values();
                if (null != templateTypes && templateTypes.length > 0) {
                    for (TemplateType templateType : templateTypes) {
                        ContextVO contextVO = new ContextVO();

                        // 兼容老版本的代码结构
                        if (org.apache.commons.lang3.StringUtils.isNotEmpty(codeVO.getCodeStatus()) && org.apache.commons.lang3.StringUtils.equals(codeVO.getCodeStatus(), "old")) {
                            String pack = templateType.getFunctionPackage().replace("client/", "")
                                    .replace("/impl", "")
                                    .replace("biz/", "")
                                    .replace("boot/", "");
                            if (templateType.getSuffix().equals("xml")) {
                                pack = "dataobject";
                            }
                            if (templateType.getType().contains("CallService")) {
                                pack = "call";
                            }
                            if (templateType.getFunctionPackage().startsWith("openservice")) {
                                pack = "openservice";
                            }
                            templateType.setFunctionPackage(pack);
                            contextVO.setCodeStatus("old");
                        }

                        // 服务uri默认为sysCode
                        if (org.apache.commons.lang3.StringUtils.isNotEmpty(codeVO.getUriPrefix())) {
                            contextVO.setUriPrefix(codeVO.getUriPrefix());
                        } else {
                            contextVO.setUriPrefix(codeVO.getSysCode());
                        }
                        if (org.apache.commons.lang3.StringUtils.isNotEmpty(codeVO.getConsumerUriPrefix())) {
                            contextVO.setConsumerUriPrefix(codeVO.getConsumerUriPrefix());
                        } else {
                            contextVO.setConsumerUriPrefix(codeVO.getConsumerSysCode());
                        }

                        contextVO.setBeanName(table.getBeanName());
                        contextVO.setTableName(table.getTableName());
                        contextVO.setDesc(table.getTableRemark());
                        contextVO.setEntity(table.getEntity());
                        contextVO.setColumns(table.getColumnList());
                        contextVO.setColKey(primaryKey);
                        contextVO.setSuffix(templateType.getSuffix());
                        contextVO.setTemplateName(templateType.getTemplateName());
                        contextVO.setConsumerSysCode(codeVO.getConsumerSysCode());
                        contextVO.setSysCode(codeVO.getSysCode());
                        contextVO.setType(templateType.getType());
                        // E://xx/xx/.../consumer/boot/src/main/java/
                        contextVO.setResPath(generatePath + templateType.getResPath());
                        contextVO.setRootPackage(codeVO.getRootPackage());
                        contextVO.setConsumerRootPackage(codeVO.getConsumerRootPackage());
                        if (templateType.getResPath().startsWith("/consumer")) {
                            // com.demo.ota + . + biz.service
                            contextVO.setPackagePath((codeVO.getConsumerRootPackage() + "." + templateType.getFunctionPackage()).replace(BACKSLASH, POINT));
                        } else {
                            contextVO.setPackagePath((codeVO.getRootPackage() + "." + templateType.getFunctionPackage()).replace(BACKSLASH, POINT));
                        }
                        contextVOList.add(contextVO);
                    }
                }
            }

        }

        return contextVOList;
    }


}
