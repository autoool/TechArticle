* wordcount流程debug

* maptask并行度与决定机制
	1）一个job任务map阶段并行度由客户端提交的任务决定
	2）每个splitf分配一个maptask并行处理
	3）默认情况下 split大小=blocksize
    4)切片是逐个针对每个文件单独切片

* maptask 运行机制

* 小文件优化combineTextInputFormat

* 自定义partition分区