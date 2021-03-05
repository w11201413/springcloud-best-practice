# springcloud-best-practice

## 业务描述
* 微服务最佳实践尝试(个人所认为的最佳架构组合，组合成直接可用的最小业务实践)

## 基本环境
* JDK11+
* MySQL: 8.0.22
* SpringBoot: 2.2.13.RELEASE
* SpringCloud: Hoxton.SR9
* SpringCloudAlibaba: 2.2.1.RELEASE

## 业务服务(子服务)
* cloud-common: 通用基础类库管理
  * cloud-common-core: 通用基础类库模块
* cloud-provider: 模拟服务提供方
* cloud-consumer: 模拟服务调用方 

## 技术架构
### 公共类库(cloud-common-core)
* 业务异常架构
    * 采用异常Enum方式保存业务异常信息
        * BizCodeInterface做为扩展接口, 可被各子模块扩展
        * BizBaseCode作为系统级异常
        * 各子模块以BizCode作为业务级异常
    * 异常信息参数填充方案：采用异常Enum 做为模板 + Exception保存参数, 最终由全局异常捕获拼装。
    * 全局异常捕获: com.wang.common.exception.handler.GlobalExceptionHandler

### 各服务基本的架构
* 持久层方案: SpringDataJpa + Druid + MySQL
* 数据库版本管理: flyway

### 服务注册与配置中心
* 技术选型: Nacos
* 命名空间: dev(default), verify, prod