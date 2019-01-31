### 集群安裝

1. 配置config 下server.properties 文件：

broker.id=0  
log.dirs=/root/hd/kafka_2.10-0.10.2.1/kafka_logs
zookeeper.connect=hd01:2181,hd02:2181,hd03:2181

2. 日志目录需要提前创建

3. scp kafka到其它服务器

4. 配置环境变量

5. **每台机器broker.id需要不同，作为唯一标识**

6. 每台机器在bin目录下，使用kafka-server-start.sh ../config/server.properties 启动

   简易脚本,批量启动：

   ····

   echo ".start kafka"
   for i in hd01 hd02 hd03
   do
   ssh $i "/root/hd/kafka/bin/kafka-server-start.sh /root/hd/kafka//config/server.properties"
   done

   ····

7. jps 查看是否有kafka

8. 测试用例

   1）创建主题

   kafka-topics.sh --zookeeper hd01:2181,hd02:2181,hd03:2181 --create --topic test --replication-factor 1 --partitions 3

   replication-factor 复制备份

   partitions 分区

   2）Master节点创建生产者

   kafka-console-producer.sh --broker-list hd01:9092,hd01:9092,hd03:9092 --topic test

   3）Slave节点创建消费者  

   kafka-console-consumer.sh --bootstrap-server  hd01:9092,hd02:9092,hd03:9092  --topic test  --from-beginning

遇到问题：

较新的版本消费者提示：zookeeper is not a recognized option  ，启动命令中--zookeeper 替换为--bootstrap-server  