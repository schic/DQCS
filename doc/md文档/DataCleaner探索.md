## 初步了解datacleaner介绍和功能。
 DataCleaner 是一个数据质量分析,比较,验证和监督的软件.DataCleaner包括一个独立的图形用户界面分析,比较和验证,并进行监测web应用。
### 其主要模块：
  #### api：DataCleaner的公共API。 主要是为了构建自己的扩展而提供的接口和注解。
  #### resources：DataCleaner的静态资源
  #### oss-branding：图标和颜色
  ####  test-ware：用于DataCleaner的单元测试的类和扩展代码
### engine
  #### core：核心引擎部分，它允许根据API执行作业和组件。
  #### xml-config：包含读写任务文件和配置文件清理工具。
  #### env：DataCleaner可以运行的不同/替代环境，例如Apache Spark或webapp-cluster
### components
#### 许多子模块包含内置以及与DataCleaner一起使用的其他组件/扩展。
#### 标准组件：一个容器项目，它依赖于通常捆绑在DataCleaner社区版中的所有组件。
### desktop
#### api：DataCleaner桌面应用程序的公共API。
#### ui：适用于桌面用户的基于Swing的用户界面。

## 组件对照
### Library --- 组件库
### …Transform --- 转换
### ……Composition --- 合并
### …………Union ---联合
### …………Fuse/Coalesce fields --- 融合/合并字段
### …………Grouper --- 聚合分组
### …………Invoke child Analysis job --- 调用子级分析任务
### ……Conversion --- 转换
### …………Convert to boolean ---转换为布尔值
### …………Convert to string ---转换为字符串
### …………Convert to date ---转换为日期
### …………Convert to number ---转换为数字
### ……Data structures --- 数据结构
### …………Read keys and values from map ---从映射中读取键和值
### …………Select values from list ---从列表中选择值
### …………Bulid list ---构建列表
### …………Select values from key/value map ---从键/值映射中选择值
### …………Build key/value map ---构建键/值映射
### …………Compose & write JSON document ---组成并编写JSON文档
### …………Read elements form list ---从列表中读取元素
### …………Read & parse JSON documnet ---读取并解析JSON文档
### ……Date and time --- 日期和时间
### …………Extract date part ---日期截取
### …………Generate timestamp ---生成时间戳
### …………Timestamp converter ---时间戳转换
### …………Date difference / period length ---日期差异/周期长度
### …………Date to age ---日期转换年龄
### …………Format date ---日期格式化
### …………Date mask matcher ---日期掩码匹配器
### …………Capture changed records ---捕获更改记录
### ……Encoding --- 编码
### …………XML encoder ---XML编码器
### …………Hash value ---哈希值
### …………URL encoder ---URL编码器
### …………Transliterate ---直译
### …………XML decoder ---XML解码器
### …………HTML encoder ---HTML编码器
### ……Filter --- 过滤器
### …………Equals ---等于
### …………Validate in dictionary ---在字典中验证
### …………Compare ---比较
### …………String value range ---字符串值范围
### …………Validate with string pattern ---使用字符串模式验证
### …………Null check ---空检查
### …………Max rows ---最大行数
### …………Number range ---数字范围
### …………Capture changed records ---捕获更改的记录
### …………String length range ---字符串长度范围
### …………Date range ---日期范围
### ……Network tools --- 网络工具
### …………Convert number to IP ---将数字转换为IP
### …………Resolve hostname ---解析主机名
### …………Convert IP to number ---将IP转换为数字
### ……Numbers --- 数值
### …………Round number ---近似数
### …………Math formula ---数学公式
### …………Generate UUID ---生成UUID
### …………Generate ID ---生成ID
### …………Increment number ---增加数量
### ……Scripting --- 脚本
### …………Groovy transformer (advanced) ---Groovy高级转换器
### …………Expression language (EL) transformer ---EL表达式转换器
### …………Groovy transformer (simple) ---Groovy普通转换器
### …………JavaScript transformer (simple) ---JS普通转换器
### …………JavaScript transformer (advanced) ---JS高级转换器
### …………JavaScript filter ---JS过滤器
### ……Text --- 文本
### …………URL parser ---URL解析器
### …………Concatenator ---串接合并
### …………Whitespace trimmer ---空白微调
### …………Plain search/replace ---简单搜索/替换
### …………Regex parser ---正则表达式解析器
### …………Remove substring ---截取字符串
### …………Text case transformer ---文本案例转换器
### …………Remove unwanted characters ---删除不需要的字符
### …………Regex search/replace ---正则表达式搜索/替换
### …………Tokenizer ---分词器
### …Improve --- 改善
### ……Location --- 本地
### …………Country standardizer ---国际标准化
### ……Reference data --- 参考数据
### …………String pattern matcher ---字符串模式匹配器
### …………Remove dictionary matches ---删除字典匹配
### …………HTTP request ---HTTP请求
### …………Dictionary matcher ---字典匹配器
### …………Table lookup ---表查找
### …………Synonym lookup ---同义词查找
### …Analyze --- 分析
### ……Date and time --- 日期和时间
### …………Month distribution ---月份分布
### …………Year distribution ---年份分布
### …………Weekday distribution ---工作日分布
### …………Week number distribution ---周数分布
### …………Date/time analyzer ---日期/时间分析器
### …………Date gap analyzer ---日期差距分析器
### ……Visualization --- 可视化
### …………Density plot ---密度图
### …………Stacked area plot ---堆叠面积图
### …………Scatter plot ---散点图
### ……Number analyzer ---数字分析仪
### ……Fill pattern ---填充模式
### ……Unique key check ---唯一键检查
### ……Completeness analyzer ---完整性分析仪
### ……Reference data matcher ---参考数据匹配器
### ……Value matcher ---值匹配器
### ……Value distribution ---值分布
### ……Referential integrity ---参照完整性
### ……Pattern finder ---模式查找器
### ……Boolean analyzer ---布尔分析器
### ……Mark rows ---标记行
### ……Character set distribution ---字符集分布
### ……String analyzer ---字符串分析器
### …Write --- 写入
### ……Create CSV file ---创建CSV文件
### ……Insert into table ---向表中插入
### ……Create staging table ---创建临时表
### ……Delete from table ---从表中删除
### ……Create Excel spreadsheet ---创建Excel电子表格
### ……Update table ---更新表

***