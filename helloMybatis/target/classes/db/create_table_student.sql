DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `student_id`   INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name`         VARCHAR(20) DEFAULT NULL COMMENT '姓名',
    `phone`        VARCHAR(20) DEFAULT NULL COMMENT '电话',
    `email`        VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
    `sex`          TINYINT(4)  DEFAULT NULL COMMENT '性别',
    `locked`       TINYINT(4)  DEFAULT NULL COMMENT '状态(0:正常,1:锁定)',
    `gmt_created`  DATETIME    DEFAULT CURRENT_TIMESTAMP COMMENT '存入数据库的时间',
    `gmt_modified` DATETIME    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改的时间',
    PRIMARY KEY (`student_id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='学生表';