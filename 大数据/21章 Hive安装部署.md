### Hive安装部署 

1. 下载安装包

   - https://mirrors.tuna.tsinghua.edu.cn/apache/hive/hive-2.3.4/

2. 修改配置文件

   vi hive-env.sh

   HADOOP_HOE=/root/hd/hadoop

   export HIVE_CONF_DIR=/root/hd/hive/conf

3. 启动hive前启动hadoop集群

   start-dfs.sh

   start-yarn.sh

   start-all.sh

4. 启动hive

   bin/hive

### hive测试

1） 查看数据库
	show databases;
2)使用数据库
	use default;
3)查看表
	show tables;
4)创建表
	create table user(id int,name string) row format delimited fields;
	terminated by "\t"；
5)插入数据

### 导入数据基本操作
1）准备数据
2）导入数据
load data local inpath '/root/itstr.txt'  into  table itstar

### 安装mysql
	yum list installed|grep mysql
	yum search libaio


	
	
	
	
