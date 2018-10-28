### 副本的配置
start-dfs.sh
hdfs-site.xml
	<property>
	<name>dfs.namenode.secondary.http-address</name>
	<value>hd02:50090</value>
	</property>
	
该配置文件需同步到其它机器
	kill -9 id //杀掉进程
	scp -r（-r递归,文件夹需要，单个文件不需要）
	scp hdfs-site.xml  hd02:$PWD  ($PWD 执行pwd命令)
	
### HDFS命令行客户端
1）hdfs客户端
	1、网页形式-测试使用
	http:ip:50070
	2、命令行形式-测试使用
	3、企业级API
2）命令行
hdfs dfs -help  查看帮助
hdfs dfs -ls / 查看当前目录信息

touch a.txt
hdfs dfs -put [当前文件路径] [上传到hdfs文件路径]
hdfs dfs -moveFromLocal a.txt /aa.txt  移动
hdfs dfs -get  [hdfs文件路径] [文件路径]
hdfs dfs -getmerge  [hdfs文件路径] [文件路径]
hdfs dfs -mkdir  
hdfs dfs -mkdir  -p 创建多级文件
hdfs dfs -mv  [路径文件] [路径文件]
hdfs dfs -cp  [路径文件] [路径文件]
hdfs dfs -rm  [路径文件] 
hdfs dfs -rm -r [路径文件]  //递归删除
hadoop fs -put  [路径文件] [路径文件]
hdfs dfs -cat
hdfs dfs -tail -f
hdfs dfs -count /文件夹 //输出结果文件夹数 文件数  文件大小
hdfs dfs -df /  *查看hdfs空间
hdfs dfs -df -h /
hdfs dfs -setrep 1 [路径文件]  *文件副本数设置

### 简单API的使用


