###3.0.1-SNAPSHOT版本修改点
1. DO和DTO
    1. service层中DO给DTO赋值时，使用BeanUtils工具类 
    2. DTO和DO使用@Data注解(无需写setter、getter方法)
    3. DTO和DO使用@JsonInclude注解(某属性为null的时候,该属性不返回给前端)
    
2. 逻辑调整
    1. param为空，默认返回20条数据
    2. 新增数据时,给status、lastUser、createUser设置默认值
    3. client层：捕捉业务层的异常，并使用BaseResultUtil把错误码信息返回给call层。
    4. call层：先校验参数，决定是否放行,不放行时直接使用BaseResultUtil返回结果；捕捉dubbo异常(client不抛出异常)
    5. 批量更新、新增的serviceImpl使用lambda把集合的DTO属性值复制到DO
    6. 解决update的SQL拼接bug  会多一个逗号(使用set标签)

3. 扩展功能
    1. 支持新、旧两种项目骨架结构
        > 新结构：com.kaka.demo.biz.service      com.kaka.demo.biz.service.impl
    
        > 旧结构：com.kaka.demo.service
    
        > \<codeStatus>old\</codeStatus>
    
    2. 支持指定表生成代码
        > \<tableNameList>jsk_test\</tableNameList>
    3. 支持指定服务uri前缀
        >服务提供方uri前缀 \<uriPrefix>admindemo\</uriPrefix>
        
        >消费方uri前缀 \<consumerUriPrefix>admindemo\</consumerUriPrefix>
    4. 消费方代码
        > \<consumerSysCode>tsp-admin-demo\</consumerSysCode> 消费方服务名
        
        > \<consumerRootPackage>com.kaka.admin.demo\</consumerRootPackage> 消费方基础包，如:com.kaka.demo
        
        
        
        
### 2018-12-19 更新
1. 单元测试
    1. controllerTest    服务提供方api接口
    2. dubboControllerTest   服务消费方api接口
    3. dubboReadServiceTest 服务提供方dubbo读接口
    4. dubboWriteServiceTest 服务提供方dubbo写接口
    
2. controller层新增和修改的接口
    > 使用同一个api、用请求类型区分是修改数据还是新增数据
    
3. 服务提供方的controller查询接口
    > 如果数据为空，不报错，返回空数据