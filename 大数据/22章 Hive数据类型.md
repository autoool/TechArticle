### Hive元数据替换为Mysql



### Hive数据类型



| Java数据类型 | Hive数据类型 | 长度         |
| ------------ | ------------ | ------------ |
| byte         | TINYINT      | 1byte        |
| short        | SMALINT      | 2byte        |
| int          | INT          | 4byte        |
| string       | STRING       | 字符         |
| long         | BUGINT       | 8byte        |
| float        | FLOAT        | 单精度浮点数 |
| double       | DOUBLE       | 双精度浮点数 |
|              | BINARY       | 字节数组     |
|              | TIMESTAMP    | 时间类型     |



### DDL数据定义

1）创建数据库

show databases;

create database hive_db;

create database if not exists db_hive;

2)修改数据库

查看数据库结构：desc database hive-db;

添加描述信息：alter database hive_db set dpproperties('datais'='sam');

查看扩展信息：desc database extended hive_db;

3）查询数据库

show databases.

删除数据库 ：drop database hive_db;

删除数据库标准写法：drop database if exists hive_d;

4)管理表

不擅长做数据共享

加载数据：

load data local inpath '/root/data.txt' into table emp;

查询保存到一张新表：

create table if not exists emp2 as select * from emp where  name='sam';

查询表结构：

desc formatted emp;

Table Type: MANAGED_TABLE  管理表

5）外部表

hive不认为这张表拥有这份数据，删除表不删除数据

擅长做数据共享

create external table;