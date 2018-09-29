package com.kaka.jplugin.autocode.biz;

import com.kaka.jplugin.autocode.enums.TemplateType;
import com.kaka.jplugin.autocode.jdbc.MySql;
import com.kaka.jplugin.autocode.util.StringUtil;
import com.kaka.jplugin.autocode.vo.CodeVO;
import com.kaka.jplugin.autocode.vo.ColumnVO;
import com.kaka.jplugin.autocode.vo.ContextVO;
import com.kaka.jplugin.autocode.vo.TableVO;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by springyu on 17-7-2.
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
            tableList = mySql.getTablesList();
            if (null != tableList && !tableList.isEmpty()) {
                for (TableVO table : tableList) {
                    mySql.getColumnsInfo(table);
                }
            }
        } finally {
            mySql.close();
        }

        // 2.获取生成路径
        String resPath = codeVO.getGeneratePath();
        if (StringUtils.isNotBlank(resPath)) {
            if (!resPath.endsWith(BACKSLASH)) {
                resPath = resPath + BACKSLASH;
            }
        }

        // 3.把表信息封装到contextVO中
        List<ContextVO> contextVOList = new ArrayList<ContextVO>();
        if (null != tableList && !tableList.isEmpty()) {
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
                        contextVO.setBeanName(table.getBeanName());
                        contextVO.setTableName(table.getTableName());
                        contextVO.setDesc(table.getTableRemark());
                        contextVO.setEntity(table.getEntity());
                        contextVO.setColumns(table.getColumnList());
                        contextVO.setColKey(primaryKey);
                        contextVO.setSuffix(templateType.getSuffix());
                        contextVO.setTemplateName(templateType.getTemplateName());
                        contextVO.setDubboConsumerSysCode(codeVO.getDubboConsumerSysCode());
                        contextVO.setSysCode(codeVO.getSysCode());
                        contextVO.setType(StringUtil.upperCaseFirst(StringUtil.toCamelCase(templateType.getType())));
                        contextVO.setResPath(resPath + templateType.getResPath());
                        contextVO.setRootPackage(codeVO.getRootPackage());
                        contextVO.setConsumerRootPackage(codeVO.getConsumerRootPackage());
                        if(templateType.getResPath().startsWith("/consumer")){
                            // com.demo.ota + . + biz.service
                            contextVO.setPackagePath((codeVO.getConsumerRootPackage() + "." + templateType.getPack()).replace(BACKSLASH, POINT));
                        }else{
                            contextVO.setPackagePath((codeVO.getRootPackage() + "." + templateType.getPack()).replace(BACKSLASH, POINT));
                        }
                        contextVOList.add(contextVO);
                    }
                }
            }

        }

        return contextVOList;
    }


}
