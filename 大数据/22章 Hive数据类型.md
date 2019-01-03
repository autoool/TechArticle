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

### DDL&DML操作

6）分区表

创建表;

ceate table dept_partitions(depno int,dept string,loc string) partitioned by(day string) row format delimited fields terminated by  '\t';

加载数据（不能直接导入，需要指定分区）

load data local inpath '/root/dept.txt' into table dept_partitions partition(day='1112');

添加分区

alter table dept_partitions add partition(day='1113');

单分区查询

select * from dept_partitions where day='1112'

删除

alter table dept_partitions drop partition(day='1112')

7)修改表

修改表名

alter table emptable rename to new_table_name;

添加列

alter table dept_partitions and columns(desc string);

更新列

alter table dept_partitions change column desc desccc int;

替换（会改变表结构，原来的数据和分区都会不存在,相当于重新建表）

alter table dept_partitions replace  column(desccc int);

### DML（Data Manipulation Language）操作   数据操纵语言

1）向表中加载数据

load data local inpath 'root/itstar.txt' into table temp_table;

2)加载hdfs中数据

load data inpath 'itstar.txt' into table temp_table;

相当于剪切

3）覆盖原有的数据

load data local inpath '/root/itstar.txt' overwrite into table temp_table;

4）创建分区表

create table hunter_partitions(id int,name string) partitoned by(month string)  row format delimited fields terminatedby '\t';

5)向分区表插入数据

insert into table hunter_partitions partition(month='201811') values(1,'tongliya');

6) 数据导入location方式

create table hunter_partitions(id int,name string) partitoned by(month string)  row format delimited fields terminatedby '\t'  location + 路径

7）查询结果导出本地

insert overwrite local directory '/root/datas/temp' select * from tablename where name="sam";

bin/hive -e 'select * from hunter' > /root/hunter.txt

> dfs -get /ysr/hive/warehouse/000 /root;



