# 数据质量控制管理系统（基于DataCleaner）

[![Build Status: Linux](https://travis-ci.org/datacleaner/DataCleaner.svg?branch=master)](https://travis-ci.org/datacleaner/DataCleaner) [![Gitter chat](https://badges.gitter.im/datacleaner/community.png)](https://gitter.im/datacleaner/community)

<div>
<img src="https://datacleaner.github.io/assets/dc-logo-100.png" alt="DataCleaner logo" />
</div>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;四川省数据质量控制管理系统项目是基于国外开源软件DataCleaner进行本地化改造和功能扩展。
DataCleaner是一个数据质量分析，比较，验证和监督的软件。DataCleaner包括一个独立的图形化客户端程序和web应用，客户端程序负责进行复杂的任务配置用户界面分析，web负责应用任务调度、监控。


## 模块结构

主要的应用模块包括:

* api - 公共 API of DataCleaner. 创建你的扩展的主要的接口和声明 annotations.
* resources -  DataCleaner的静态资源。
* oss-branding-图标和颜色
* testware -有用的类，用于DataCleaner和扩展代码的单元测试。
* engine
  * core - 核心引擎部分，允许根据API执行作业和组件。
  * xml-config - 包含用于读取和写入DataCleaner的作业文件和配置文件的实用程序。
  * env - 可以在其中运行的不同/替代环境，例如Apache Spark或webapp-cluster
* components
  * ... - 许多子模块包含内置的以及与DataCleaner一起使用的其他组件/扩展。
  * standard-components - 一个容器项目，它依赖于通常在DataCleaner社区版中捆绑的所有组件。
* desktop
  * api - DataCleaner桌面应用程序的公共API。
  * ui - 桌面用户的基于Swing的用户界面
* monitor
  * api - 监视器的API类和接口

## 持续集成

Travis CI上有DataCleaner的构建日志:

https://travis-ci.org/datacleaner/DataCleaner


