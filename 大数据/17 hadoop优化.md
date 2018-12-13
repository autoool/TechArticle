##hadoop 优化
1）mr u的效率瓶颈
功能：分布式离线计算
-》计算机性能
CPU 内存 磁盘 网络
-》I/O操作优化
1）数据倾斜(代码优化)
2）map和reduce 数设置不合理
3）map运行时间太长，导致reduce等待过久
4）小文件过多
5）不可分块的超大文件（不断溢写）
6）多个溢写小文件需要多次merge

2)mr优化方法
六个方面优化：数据输入、Map阶段、Reduce阶段、IO传输、数据倾斜、参数调优
-》数据输入
1）合并小文件：在执行mr任务之前就进行小文件合并
2）采用CombineTextInptFormat作为输入，解决输入端大量小文件场景
mr并不适合处理大量小文件
-》Map阶段
1)减少溢写次数（增加内存 80%溢写）参数调优在配置文件里修改
配置参数mapreduce.task.io.sort.mb  修改溢写内存大小
mapreduce.map.sort.spill.percent  溢写大小百分比 