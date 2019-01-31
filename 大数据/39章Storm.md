### 出现问题

- storm ui 命令执行后，web打开一直没有显示正确的内容

解决办法：

1）查看zookeeper状态

2）切换到storm bin目录下执行对应命令

启动nimbus

```
nohup ./storm nimbus & 
```

启动supervisor

```
nohup ./storm supervisor  &
```

启动storm UI

```
nohup ./storm ui & 
```

运行storm 程序
storm  jar [/路径/.jar] [全类名][拓扑名称]
终止拓扑
storm kill
禁止拓扑
storm activate [拓扑名]
激活拓扑
storm deavtivate [拓扑名]