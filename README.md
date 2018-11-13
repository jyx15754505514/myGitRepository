# 项目介绍
### 目录结构(增加项目请增加相应注释)
```aidl
bims-backend/  项目根
├── entrance-module  业务model,服务消费者
│   ├── entrance-fin-web   示例业务层
├── middle-module  中台层model,服务提供者
│   ├── middle-common        公共类
│   ├── middle-customer      客户中心
│   │   ├── middle-customer-api       接口
│   │   ├── middle-customer-common    公共类,可存放DO，DTO
│   │   ├── middle-customer-provider  接口实现,提供者
│   ├── middle-fin            结算中心
│   │   ├── middle-fin-api          接口
│   │   ├── middle-fin-common       公共类,可存放DO，DTO
│   │   ├── middle-fin-provider     接口实现,提供者
│   ├── middle-order          订单中心
│   │   ├── middle-order-api        接口
│   │   ├── middle-order-common     公共类,可存放DO，DTO
│   │   ├── middle-order-provider   接口实现,提供者
│   ├── middle-product        产品中心
│   │   ├── middle-product-api      接口
│   │   ├── middle-product-common   公共类,可存放DO，DTO
│   │   ├── middle-product-provider 接口实现,提供者
│   ├── middle-system        工具项目（组织架构、数据字典等）
│   │   ├── middle-system-api      接口
│   │   ├── middle-system-common   公共类,可存放DO，DTO
│   │   ├── middle-system-provider 接口实现,提供者
│   ├── middle-resource           资源
│   │   ├── middle-resource-api      接口
│   │   ├── middle-resource-common   公共类,可存放DO，DTO
│   │   ├── middle-resource-provider 接口实现,提供者
├── pom.xml
└── README.md
```
#### 消费者包结构描述
```aidl
├── entrance-fin-web
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── ccicnavi
│           │           └── bims
│           │               └── fin
│           │                   ├── controller  web接入层,http接口提供
│           │                   │   └── EqlDemoController.java
│           │                   ├── EntranceFinWebApplication.java
│           │                   └── manager    通用业务层
│           │                       └── EqlDemoManager.java
│           └── resources
│               └── application.properties
└── pom.xml
```
#### 提供者包结构描述
```aidl
├── middle-order-provider  
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── ccicnavi
│           │           └── bims
│           │               └── order
│           │                   ├── Application.java  项目启动类
│           │                   ├── dao               数据访问层
│           │                   │   └── DemoDao.java  
│           │                   ├── impl              接口实现层，提供者
│           │                   │   └── DemoServiceImpl.java
│           │                   └── manager           通用业务处理层
│           │                       └── DemoManager.java
│           └── resources
│               └── application.properties    项目配置文件
│   ├── pom.xml
```
### 环境信息
#### MySql
```aidl
192.169.11.2    3306   root/123456
```
### 端口定义
- Web服务 以8080开始顺延，如 8080 8081 。。
- Dubbo 服务以 28080开始顺延，如 28080 28081 。。
### 备注
- 如需建立服务,请提供需求,联系张琦创建