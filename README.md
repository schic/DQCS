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
* oss-branding - Icons and colors
* testware - Useful classes for unit testing of DataCleaner and extension code.
* engine
  * core - The core engine piece which allows execution of jobs and components as per the API.
  * xml-config - Contains utilities for reading and writing job files and configuration files of DataCleaner.
  * env - Different/alternative environments that DataCleaner can run in, for instance Apache Spark or webapp-cluster
* components
  * ... - many sub modules containing built-in as well as additional components/extensions to use with DataCleaner.
  * standard-components - a container-project that dependends on all components that are normally bundled in DataCleaner community edition.
* desktop
  * api - The public API for the DataCleaner desktop application.
  * ui - The Swing-based user interface for desktop users
* monitor
  * api - the API classes and interfaces of DataCleaner monitor

## Code style and formatting

In the root of the project you can find 'Formatter-[IDE].xml' files which enable you to import the code formatting rules of the project into your IDE.

## Continuous Integration

There's a public build of DataCleaner that can be found on Travis CI:

https://travis-ci.org/datacleaner/DataCleaner

## License

Licensed under the Lesser General Public License, see http://www.gnu.org/licenses/lgpl.txt
