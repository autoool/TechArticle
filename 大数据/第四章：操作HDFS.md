##01 集群工作准备
一台namenode
多台datanode
1.关闭防火墙
	systemctl stop firewalld
	systemctl -disable firewalld
2.修改主机名
	vi /etc/hostname
	reboot 重启生效
3.配置映射文件
	vi /etc/hosts
	所有主机集群映射都配置，每台机器都要修改
	ip  主机名
	scp -r /etc/hosts  192.168.1.111:/etc/  复制文件到其它机器
4.jdk环境变量配置
	export JAVA_HOME=/root/hd/jdk1.8
	export PATH=$PATH:$JAVA_HOME/bin
	source /etc/profile
5.免密登录
	ssh-keygen
	ssh-copy-id ip地址
	//清除
	mv /root/.ssh/known_hosts /tmp

    //先自己 再其它
6.安裝hdfs集群
Hadoop的伪分布模式
		1、特点：具备Hadoop的所有功能，在单机上模拟一个分布式的环境
		         （1）HDFS：主：NameNode，数据节点：DataNode
				 （2）Yarn：容器，运行MapReduce程序
				            主节点：ResourceManager
							从节点：NodeManager
							

		2、步骤：
		（1）hdfs-site.xml
			<!--配置元数据存储位置-->
			<property>
			  <name>dfs.namenode.name.dir</name>
			  <value>/root/hd/dfs/name</value>
			</property>
			<!--配置数据存储位置-->
			<property>
			  <name>dfs.datanode.name.dir</name>
			  <value>/root/hd/dfs/data</value>
			</property>
			<!--配置HDFS的冗余度-->
			<property>
			  <name>dfs.replication</name>
			  <value>1</value>
			</property>
	
			<!--配置是否检查权限-->
			<property>
			  <name>dfs.permissions</name>
			  <value>false</value>
			</property>	
	
		（2）core-site.xml
			<!--配置HDFS的NameNode-->
			<property>
			  <name>fs.defaultFS</name>
			  <value>hdfs://hd01:9000</value>
			</property>
	
			<!--配置DataNode保存数据的位置 暫不配置-->
			<property>
			  <name>hadoop.tmp.dir</name>
			  <value>/root/training/hadoop-2.4.1/tmp</value>
			</property>		


			
		(3) mapred-site.xml
			<!--配置MR运行的框架-->
			<property>
			  <name>mapreduce.framework.name</name>
			  <value>yarn</value>
			</property>		
			
		(4) yarn-site.xml
			<!--配置ResourceManager的地址-->
			<property>
			  <name>yarn.resourcemanager.hostname</name>
			  <value>192.168.88.11</value>
			</property>
	
			<!--配置NodeManager执行任务的方式-->
			<property>
			  <name>yarn.nodemanager.aux-services</name>
			  <value>mapreduce_shuffle</value>
			</property>		
			
		(5) 格式化NameNode
		    hdfs namenode -format
			日志：Storage directory /root/training/hadoop-2.4.1/tmp/dfs/name has been successfully formatted.						
		(6) 启动：start-all.sh
		           (*) HDFS: 存储数据
				   (*) Yarn：执行计算
				   
		(7) 访问：（*）命令行
		          （*）Java API
				  （*）Web Console：
						HDFS：http://192.168.31.115:50070
						Yarn：http://192.168.31.216:8088
hdfs namenode -format
在对应机器分別启动namenode 和 datanode
hadoop-daemon.sh start namenode
hadoop-daemon.sh start datanode
执行jps 查看启动节点











