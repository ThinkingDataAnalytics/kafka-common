# kafka-mysql-offset

This is the code for the exactly-once consumer persists the offsets in mysql for kafka 0.10.0.

You can create a table in mysql to store the offsets in mysql.

Example for the offset table:

CREATE TABLE `kafka_consumer_offset` (
  `oid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `topic` varchar(100) NOT NULL COMMENT 'kafka主题',
  `kafka_partition` int(11) NOT NULL COMMENT 'kafka主题下的leader分区号',
  `consumer_group` varchar(100) NOT NULL COMMENT '消费组',
  `offset` bigint(100) NOT NULL DEFAULT '0' COMMENT '偏移量',
  `last_flush_offset` bigint(100) NOT NULL DEFAULT '0' COMMENT '上一次的偏移量',
  `kafka_cluster_name` varchar(100) NOT NULL DEFAULT '' COMMENT 'kafka集群唯一标识键',
  `owner` varchar(255) NOT NULL DEFAULT '' COMMENT 'kafka消费者名称',
  `update_time` timestamp NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '入库时间',
  PRIMARY KEY (`oid`),
  UNIQUE KEY `topic_partition_consumer` (`kafka_cluster_name`,`topic`,`kafka_partition`,`consumer_group`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12632 DEFAULT CHARSET=utf8mb4;


If you have any problems or you find any bugs, please do not hesitate to contact me(yangruochen@thinkingdata.cn).
