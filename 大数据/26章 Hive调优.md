### 自定义函数UDF

三种自定义函数：

UDF: 一进一出

1）hive依赖包

hive/lib 下面的依赖包

2）jar包上传到hive环境

hive> add jar /root/jar/lower.jar   

3）create temporary function my_lower as "com.demo.Lower"   //类名包含路径，增加my_lower函数

4）使用 select ename, my_lower(ename) as lowerename form empt;

### 数据压缩

1）开启map阶段输出压缩

开启输出压缩功能

set hive.exec.compress.intermediate=true

开启map输出压缩功能

set mapreduce.map.output.compress=true

设置压缩方式

set mapreduce.map.output.compress.codec=org.apache.hadoop.io.compress.SnappyCodec;

2）开启reduce输出端压缩

开启最终输出端压缩

set hive.exec.compress.output=true;

开启文件输出压缩

set mapreduce.output.fileoutputformat.compress=true;

设置压缩方式

set mapreduce.output.fileoutputformat.compress.codec=org.apache.hadoop.io.compress.SnappyCodec;

设置块压缩

set mapreduce.output.fileoutputformat.compress.type=BLOCK;

### Hive存储格式

1)存储格式

TextFile/ SequenceFile / orc / Parquet

2）压缩比

orc > parquet > textfile

3)查询速度

orc > textfile

### group by 优化

分组：mr程序，map阶段把相同key数据分发给一个reduce, 一个key的量很大。会出现数据倾斜

解决方案：

- 数据倾斜

  1）合理避免数据倾斜

  合理设置map数

  合并小文件

  set hive.input.format=org.apache.hadoop.hive.ql.io.CombineHiveInputFormat;

  合理设置reduce数

  2）解决数据倾斜

  在map端进行聚合（combiner)

  set hive.map.aggr=true;

  set hive.groupby.skewindata=true;  设置负载均衡

  3)JVM重用

  mapred-site.xml

  mapreduce.job.jvm.numtask

  10-20










