### HBase简介

对大数据随机、实时读、写时使用的非关系型，在Hadoop和HDFS之上，提供类似BigTable功能。

### 架构图

### 集群安装

1) 集群配置：

zk 3台

hdfs 3台

2) hbase-env.sh 配置修改

JAVA_HOME=

ZK=

3) hbase-site.xml  加入配置信息

<configuration>

<property>

<name>hbase.rootdir</name>

<value>hdfs://hd01-01:9000/hbase</value>

</property>

<!-- 是否开启集群-->

<property>

<name>hbase.cluster.distributed</name>

<value>true</value>

</property>

<!-- 0.98 后的新变动，之前版本没有.port 默认端口为 60000-->

<property>

<name>hbase.master.port</name>

<value>16000</value>

</property>

<!-- zookeeper集群位置-->

<property>

<name>hbase.zookeeper.quorum</name>

<value>hd01:2181,hd02:2181,hd03:2181</value>

</property>

<!-- hbase的元数据信息存储在zookeeper的位置-->

<property>

<name>hbase.zookeeper.property.datadir</name>

<value>/root/hd/zookeeper/zkData</value>

</property>

</configuration>

 编辑conf 目录下该文件regionservers加入从节点（主机名）

4) 解决依赖关系

相关版本的zookeeper 和hadoop的依赖包导入hbase/lib下

5) 软连接hadoop配置

ln -s /hadoop/core-site.xml   /root/hd/hbase/conf

ln -s /hadoop/hdfs-site.xml   /root/hd/hbase/conf



配置文件需要同步到其他集群机器

