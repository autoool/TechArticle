*Mapreduce 编程规范

*Hadoop数据类型


* Hadoop序列化
把内存中的对象，转换为字节序列以便存储和网络传输。

* MapReduce 任务集群提交，集群运行

mapred-site.xml
	<!--配置MR运行的框架-->
	<property>
	<name>mapreduce.framework.name</name>
	<value>yarn</value>
	</property>		
	
* 流量汇总案例编程
