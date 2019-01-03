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









