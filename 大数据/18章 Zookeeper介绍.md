1）简介
高度可靠的分布式协调
2）什么是zookeeper
ZooKeeper是一种集中式服务，用于维护配置信息，命名，提供分布式同步和提供组服务。所有这些类型的服务都以分布式应用程序的某种形式使用。每次实施它们都需要做很多工作来修复不可避免的错误和竞争条件。由于难以实现这些类型的服务，应用程序最初通常会吝啬它们，这使得它们在变化的情况下变得脆弱并且难以管理。即使正确完成，这些服务的不同实现也会在部署应用程序时导致管理复杂性。
3)功能
	- 存储数据
	- 监听

4）工作机制
基于观察者模式设计的分布式服务管理框架
5）存储结构
目录树结构
6）应用场景
	- 集群统一配置管理
	- 集群统一命名服务
	- 集群统一管理
	- 服务器动态上下线感知
	- 负载均衡

7）安装zookeeper集群

 - tar -zxvf .tar

  - 修改配置文件
       vi zoo.cfg
       	 	dataDir=/root/hd/zookeeper-3.4.10/zkData
       	 	集群配置增加：
       	 	server.1=hd01:2888:3888(前面端口是和leader通信的端口，当leader挂掉，使用第二个端口通信在选举一个leader)
       	 	server.2=hd02:2888:3888
       	 	server.3=hd03:2888:3888

  - 启动   bin/zkServer.sh start

  - 查看状态  bin/zkServer.sh status

  - 启动客户端  bin/zkCli.sh

  - 添加文件myid
       cd zookeeper-3.4.10/zkData
       	 	touch myid
       	 	1

  - 发送zookeeper文件到其它机器

  - 增加环境变量，生效，同步环境变量

  - 启动zookeeper

  - 只要半数以上的节点存活，就能正常工作

  - 配置zk集群要配置奇数台

- 多台机器，需要使用脚本同时启动。

    echo “start zkServer…” 
    		for i in hd01 hd02 hd03 
    		do 
    		ssh $i "/root/hd/zookeeper-3.4.5/bin/zkServer.sh start"
    		done 	

    chmod u+x  文件名

- 


