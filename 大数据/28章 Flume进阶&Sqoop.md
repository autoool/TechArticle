### Flume多渠道



### Sqoop概述

sqoop.apache.org

Hadoop与传统型数据库之间数据迁移。

#### sqoop安装部署

1) 修改配置文件 sqoop-env.sh

2) mysql驱动到lib目录下面

3)检查是否安装成功 bin/sqoop help

#### sqoop import命令

1)从mysql导入到hdfs

bin/sqoop import  --connect jdbc:mysql://192.168.3.134/sq --username root --password root --table user --target-dir /sqoop/datas --delete-target-dir --num--mappers 1 -- fields-terminated-by "\t";

mysql权限问题：grant all privileges on *.* to rot@''% identiflied by "password": flush privileges;

2）数据库导入做筛选

bin/sqoop import  --connect jdbc:mysql://192.168.3.134/sq --username root --password root  --target-dir /sqoop/datas --delete-target-dir --num--mappers 1 -- fields-terminated-by "\t"  --query  'select * from user where user.id=1 and $CONDITIONS'

3）通过where筛选

bin/sqoop import  --connect jdbc:mysql://192.168.3.134/sq --username root --password root  --target-dir /sqoop/datas --delete-target-dir --num--mappers 1 -- fields-terminated-by "\t"  --table user  --where 'id<=1'

4)导入数据到hive

需要先创建hive表 user_sqoop

bin/sqoop import  --connect jdbc:mysql://192.168.3.134/sq --username root --password root  --table user   --num--mappers 1  --hive-import  -- fields-terminated-by "\t"   --hive-overwrite --hive-table user_soop;

问题：hiveconf 

解决：~./base_profile 增加hadoop 的hive 依赖包

export HADOOP_CLASSPATH = $ HADOOP_CLASSPATH:/root/hd/hive/lib/*

#### Sqoop的export命令

需求：Hive/HDFS 数据导出到mysql

1）根据Hive中字段，在mysql创建表

2）编写sqoop启动命令

bin/sqoop export --connect jdbc:mysql://192.168.3.134/sq --username root --password root  --table user   --num--mappers 1  --export-dir  /user/hive/warehouse/user_sqoop  --finput-fields-terminated-by "\t" ;

3)在mysql中查找数据是否导入

#### 脚本执行

1)新建脚本文件目录

2）编写脚本

export -
-connect jdbc:mysql://192.168.3.134/sq 
--username 
root 
--password 
root  
--table 
user   
--num--mappers 
1  
--export-dir  
/user/hive/warehouse/user_sqoop
--finput-fields-terminated-by 
"\t" ;

注意：一行一个值
3)执行脚本文件
bin/sqoop  --options-file /root/sqoop/job_hdfs2mysql.opt

### Sqoop常用命令

| 命令              | 说明                                 |
| ----------------- | ------------------------------------ |
| import            | 数据导入集群                         |
| export            | 集群数据导出                         |
| codegen           | 某数据库中表生成javabean 并打包为jar |
| eval              | 查看sql执行结果                      |
| create-hive-table | 创建hive表                           |
| import-all-tables | 导出某个数据库中所有表到hdfs中       |
| list-tables       | 列出某个数据库中所有表               |
| merge             | 将hdfs中不同目录下面数据合并         |
| help              |                                      |
| vesion            |                                      |

### Sqoop常用参数



| 参数                 | 说明                       |
| -------------------- | -------------------------- |
| --connect            | 链接关系型数据库url        |
| --connection-manager | 执行链接管理类             |
| --drive              | JDBC的driver class         |
| --username           | 链接数据库用户名           |
| --password           | 链接数据库密码             |
| --verbose            | 控制台打印详细信息         |
| --help               |                            |
| --hive-import        | 关系型数据库导入hive       |
| --hive-overwrite     | 覆盖掉hive表中已存在的数据 |
| --create-hive-table  | 创建hive表                 |
| --hive-table         | 接入hive表                 |
| --table              | 指定关系型数据库表名       |

















