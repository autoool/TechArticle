1-> ����IP
	
	1���޸������ļ� 
	vi /sysconfig/network-scripts/ifcfg-eno16777736
	
	2��ע�͵�dhcp
	#BOOTPROTO="dhcp"
	
	3��������ã�windows->ipconfig -all��

	IPADDR=192.168.50.179
	NETMASK=225.255.255.0
	GATEWAY=192.168.50.1
	DNS1=219.141.136.10
	
	4����������
	service network restart
	
2-> Linux����Ŀ¼�����У���ɾ�Ĳ飩

	1����ǰĿ¼�´����ļ���
	mkdir �ļ�����
	
	2������ָ��·���ļ���
	mkdir ·��
	
	3���޸��ļ�����
	mv oldname newname
	
	4��ɾ���ļ�
	rm �ļ�
	
	5��ǿ��ɾ���ļ�
	rm -f �ļ�
	
	6���ݹ�ɾ���ļ���
	rm -r �ļ���
	
	7��ǿ�Ƶݹ�ɾ��
	rm -rf 
	
	8�������ļ�
	cp �ļ� ·��
	
	9�������ļ���
	cp -r �ļ��� ·��
	
3-> Linux�ļ��Ĳ��������ɾ�Ĳ飩

	1�������ļ�
	touch �ļ���
	
	2���鿴�ļ�����
		-��cat �ļ���
		-��more �ļ��� ��ʾ�ٷֱȣ��س���һ�У��ո�����һҳ��q�˳�
		-��less �ļ��� ����ʹ��PgUp PgDn ���Ϻ����·�ҳ��q�˳�
		-��tail -10 �鿴�ļ��ĺ�10��
		   tail -f ����ļ���flume��
		   
	3��vi�༭
	��i:��������
	��esc:�˳��༭ģʽ
	��:wq!
	
	4��ɾ��
	rm -rf �ļ���
	
4-> Linuxѹ���ͽ�ѹ����
	����sftp:alt+p

	1����ѹ
	tar -zxvf ѹ����
		z:����gzipѹ���������ѹ��
		x:��ѹ�ļ�
		v:��ʾ���й���
		f:ָ���ļ���
	
	2�����
	tar -zcvf ������ļ��� ����ļ� ����ļ�...
		c:����ļ�
		

5-> linux������������

	1����ʾ��ǰ����λ��
	pwd
	
	2����������
	find / -name "a.txt"
	
	whereis date
	
	3���鿴����
	ps -ef 
	ps -ef | grep ������
	| ���壺��һ����������ʱ��һ�����������
	
	4��yum�����������
	yum search ���
	yum install tools
	
	5��Ȩ�޲���
	chmod u+x �ļ���
	
6-> linux�û�����

	1������û�
	useradd �û���
	passwd �û���
		
	2���л��û�
	su �û���
	
	3��Ȩ��
	vi /etc/sudoers
	root    ALL=(ALL)       ALL
	
�½�Ԥ�棺linux��װ��� hadoop���� HDFS���� ��װ ʹ�� 
��ҵ��

javaSE+LINUX

5~8��Ϣ
		 
	
	
		
	
	
	
	