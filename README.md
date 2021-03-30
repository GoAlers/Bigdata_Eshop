# bigdata-eshop
本项目分别电商数据统计模块及业务采集及数仓搭建模块，利用hive统计每个区域热门商品进行统计；依据业务数据实现离线业务数仓搭建。
项目详解链接：https://blog.csdn.net/qq_36816848/article/details/113865910

一、电商热门商品统计项目
（一）项目介绍
针对常规电商网站进行大数据分析，对每个区域热门商品进行统计，支持用户决策。

项目流程及框架：Python-->Flume-->HDFS-->Mapreduce/Spark ETL-->HDFS-->Hive-->Sqoop-->Mysql

1.数据采集（ETL）

电商日志一般存储在日志服务器，通过 Flume 拉取到 HDFS 上，本文通过编写python程序模拟日志数据。

业务数据通过 Sqoop 从关系型数据库mysql中读取数据,然后导入到HDFS。

因为要访问数据库，所以会对数据库造成很大的压力，而且在真实的生产环境中，一般没有权限直接访问数据库。可以把数据导出成csv文件，放到日志服务器上，再通过Flume采集到HDFS上。假如有权限访问数据库，数据库也需要设置成读写分离的模式，来缓解压力。

2.数据清洗

使用 MapReduce 进行数据清洗。

使用 Spark Core 进行数据清洗。

各区域热门商品计算

使用 Hive 进行数据的分析和处理。

使用 Spark SQL 进行数据的分析和处理
