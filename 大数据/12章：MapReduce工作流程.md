* 全局排序
	-自定义实体类 实现WritableComparable  接口的compareTo方法
	排序分类-
	- 部分排序
	- 全排序
	- 辅助排序
	- 二次排序
* 分区加排序
	-继承Partitioner 
	-实现WritableComparable 接口

* Combiner优化
	 job.setCombinerClass
	Combiner 合并
	Reduce父类
	局部汇总，减少网络传输量，进而优化程序
	例子：平均值
	3 5 7 2 6 
	mapper:(3+5+7)/3=5
	(2+6)/2=4
	reducer:(5+4)/2

	只能应用在不影响最终业务逻辑的情况下
