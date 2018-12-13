## hadoop 
3各阶段
1  分布式文件系统HDFS
2 分布式编程框架mapreduce
3  Yarm架构
Resource Manager作用：
1 处理客户端请求
2 监控nodeManager
3 启动或者监控程序运行
4 资源的分配和调度

NM作用：
1 管理单个节点资源
2 处理来自RM的命令
3 处理程序的命令

##数据压缩
MR操作過程中进行大量数据传输
压缩技术能够有效减少底层存储（hdfs）读写字节数
压缩提高了网络带宽和磁盘空间
数据压缩能够有效的节省资源
压缩是MR程序的优化策略
通过压缩编码对Mapper或者reducer数据进行数据的压缩，以减少磁盘IO。

##压缩的基本原则
1 运算密集型任务少用压缩
2 IO密集型的任务，多用压缩

##MR支持的压缩编码
压缩格式   是否自带  文件扩展名  是否可以切分
DEFAULT |  是 |  .default |  否
Gzip | 是 | .gz | 否
bzip2 | 是 | .bz2  | 是
LZO | 否 | .lzo | 是
Snappy | 否 | .snappy | 否

## 编码/解码器
Default  | org.apache.hadoop.io.compress.DefaultCodeC
Gzip |  org.apache.hadoop.io.compress.GzipCoeC
bzip2 |  org.apache.hadoop.io.compress.BZip2CodeC
LZO | com.hadoop.compress.lazo.LzoCodeC
Snappy | org.apache/hadoop.io.compress.SnappyCodeC

## 压缩性能
压缩算法  原始文件大小  压缩文件大小 压缩速度  解压速度
gzip | 8.3G | 1.8G | 17.5M/s | 58M/s
bzip2 | 8.3G | 1.1G | 2.4M/s | 9.5M/s
lzo | 8.3G | 2.9G | 74.6M/s | 58M/s

## 压缩工具自定义


