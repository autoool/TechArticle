1-> 配置IP
	
	1）修改配置文件 
	vi /sysconfig/network-scripts/ifcfg-eno16777736
	
	2）注释掉dhcp
	#BOOTPROTO="dhcp"
	
	3）添加配置（windows->ipconfig -all）

	IPADDR=192.168.50.179
	NETMASK=225.255.255.0
	GATEWAY=192.168.50.1
	DNS1=219.141.136.10
	
	4）重启网卡
	service network restart
	
2-> Linux常用目录命令行（增删改查）

	1）当前目录下创建文件夹
	mkdir 文件夹名
	
	2）创建指定路径文件夹
	mkdir 路径
	
	3）修改文件夹名
	mv oldname newname
	
	4）删除文件
	rm 文件
	
	5）强制删除文件
	rm -f 文件
	
	6）递归删除文件夹
	rm -r 文件夹
	
	7）强制递归删除
	rm -rf 
	
	8）拷贝文件
	cp 文件 路径
	
	9）拷贝文件夹
	cp -r 文件夹 路径
	
3-> Linux文件的操作命令（增删改查）

	1）创建文件
	touch 文件名
	
	2）查看文件内容
		-》cat 文件名
		-》more 文件名 显示百分比，回车下一行，空格向下一页，q退出
		-》less 文件名 可以使用PgUp PgDn 向上和向下翻页，q退出
		-》tail -10 查看文件的后10行
		   tail -f 监控文件（flume）
		   
	3）vi编辑
	按i:插入内容
	按esc:退出编辑模式
	按:wq!
	
	4）删除
	rm -rf 文件名
	
4-> Linux压缩和解压命令
	进入sftp:alt+p

	1）解压
	tar -zxvf 压缩包
		z:调用gzip压缩命令进行压缩
		x:解压文件
		v:显示运行过程
		f:指定文件名
	
	2）打包
	tar -zcvf 打包后文件名 打包文件 打包文件...
		c:打包文件
		

5-> linux其它常用命令

	1）显示当前所在位置
	pwd
	
	2）搜索命令
	find / -name "a.txt"
	
	whereis date
	
	3）查看进程
	ps -ef 
	ps -ef | grep 进程名
	| 含义：上一条命令的输出时下一条命令的输入
	
	4）yum软件包管理器
	yum search 软件
	yum install tools
	
	5）权限操作
	chmod u+x 文件名
	
6-> linux用户操作

	1）添加用户
	useradd 用户名
	passwd 用户名
		
	2）切换用户
	su 用户名
	
	3）权限
	vi /etc/sudoers
	root    ALL=(ALL)       ALL
	
下节预告：linux安装软件 hadoop介绍 HDFS介绍 安装 使用 
作业：

javaSE+LINUX

5~8休息
		 
	
	
		
	
	
	
	