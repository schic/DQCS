# DataCleaner（数据清洗机）

[![Build Status: Linux](https://travis-ci.org/datacleaner/DataCleaner.svg?branch=master)](https://travis-ci.org/datacleaner/DataCleaner) [![Gitter chat](https://badges.gitter.im/datacleaner/community.png)](https://gitter.im/datacleaner/community)

<div>
<img src="https://datacleaner.github.io/assets/dc-logo-100.png" alt="DataCleaner logo" />
</div>

基于一流的数据质控解决方案DATACLEANER打造.

DataCleaner 是一个帮助你生成数据概要、修正和丰富你的数据的工具集，我们可以使用它进行临时数据分析、主数据管理等。

## Where to go for end-user information?

请访问DataCleaner 社区网站 https://datacleaner.github.io 获取下载、新闻和文档信息。

Visit our Gitter chat channel https://gitter.im/datacleaner/community for asking questions or discussions.

GitHub markdown pages and issues are used for developers and technical aspects only.

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

## 目录说明

DataCleaner_code：DataCleaner5.7.1的源代码(支持中文)

DataCleaner_desktop_zip:  DataCleaner5.7.1中文编译后文件，可直接点击cmd命令运行即客户端运行

DataCleaner_web_war ：DataCleaner5.7.1的web端编译后war包，需部署才能使用

## 持续集成

There's a public build of DataCleaner that can be found on Travis CI:

https://travis-ci.org/datacleaner/DataCleaner

## 许可

Licensed under the Lesser General Public License, see http://www.gnu.org/licenses/lgpl.txt
