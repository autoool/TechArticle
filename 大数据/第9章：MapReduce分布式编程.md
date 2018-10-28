# MapReduce简介

#MapReduce核心编程思想

#Yarn集群搭建与流程
- 2.x 版本分布式调度平台YARN（mr程序的运行平台，调度maptask,reducetask）
- Yarn集群配置
		mapred-site.xml
		<!--配置MR运行的框架-->
		<property>
		  <name>mapreduce.framework.name</name>
		  <value>yarn</value>
		</property>		
		
		 yarn-site.xml
		<!--配置ResourceManager的地址-->
		<property>
		  <name>yarn.resourcemanager.hostname</name>
		  <value>hd01</value>
		</property>

		<!--配置NodeManager执行任务的方式-->
		<property>
		  <name>yarn.nodemanager.aux-services</name>
		  <value>mapreduce_shuffle</value>
		</property>	
    
yarn的服务进程：2个
Resource Manager: job 需要多少个容器，需要RM进行分配 （最好单独装，单独配置一台Resource Manager 不和NameNode同一个节点）
Node Manager： cpu+内存  开辟一个计算资源  用来创建maptask的容器
web访问地址：ip:8088

#Wordcount代码实现