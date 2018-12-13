- shuffle机制
  map写数据到reducer过程，统称为shuffle (map之后,reducer之前)
  过程：map()->1）写入数据-》环形缓冲区（80%）-》2）第一次溢写-》3）进行分区（先分区后排序）-》4 排序 -》 5 合并（区内） -》 6 归并（区和区之间）-》7 输出（写磁盘）-》8 拷贝（内存缓冲）-》9 内存不够溢出到磁盘-》 10 归并排序 -》11 按照相同的key分组

- 自定义inputformat

  - 小文件合并 squenceformat

    文件路径+文件内容

    inputformat 读取之前合并