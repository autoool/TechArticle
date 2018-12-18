参考网址：
http://www.ityouknow.com/jvm/2017/09/30/jvm-ppt.html
目录
- JVM体系概述
  ![JVM体系结构](..\images\java\JVM体系结构.png)

- GC算法

  作用区域：方法区和堆

1. 引用计数（JVM实现一般不采用该方法）

   - 维护引用计数器，计数器本身有一定消耗
   - 较难处理循环引用

2. 跟踪

2.1 复制
     - From To 两块区域，From中存活对象copy到To空间。
        - From 与 To交换身份，下次内存从To开始分配
          优点：1、没有内存碎片 2、没有标记、清除过程，效率高
          缺点：需要双倍空间
2.2  标记-清除
          - Mark：从根集合开始扫描，对存活对象进行标记

          - Sweep:扫描整个内存空间，回收未被标记的对象
            优点：不需要额外空间
            缺点：两次扫描耗时严重，会产生内存碎片
2.3  标记-压缩

- Mark:与标记-清除过程一样
- Compact:把存活对象向一端压缩
优点：没有空间碎片
缺点：需要移动对象成本

2.4 Mark-Sweep-Compact
- Mark-Sweep和Mark-Compact结合

- 和Mark-Sweep一致，多次GC后才Compact
  优点：减少移动对象成本

- Hotspot内存管理
  分代管理：

  |  Method Area |              Heap                           |

  | Perm               |  Eden | S0 | S1 |               Old |

                            | New / Young     |

  GC类型：

  - Minor GC 针对新生代
  - Major GC 针对旧生代
  - Full GC 针对永久代、新生代、旧生代三者

  新生代：

  |  Eden | S0 | S1 |  

  - 由Eden、两块相同大小的Survivor（又称为From/To,S0/S1）构成，

- Hotspot垃圾回收器

CMS (Concurrent Mark-Sweep)：适用暂停时间短，响应速度快的应用

- 监控工具
- 调优



