DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `tbl_user` VALUES (null, 'Tom', '18', 'Tom@ivan.com');
INSERT INTO `tbl_user` VALUES (null, 'Jerry', '20', 'Jerry@ivan.com');
INSERT INTO `tbl_user` VALUES (null, 'Jone', '28', 'Jone@ivan.com');
INSERT INTO `tbl_user` VALUES (null, 'Ivan', '21', 'Ivan@ivan.com');