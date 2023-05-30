CREATE TABLE `Orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` linestring NOT NULL COMMENT '顾客微信id，修改订单唯一标识',
  `customerName` linestring NOT NULL COMMENT '顾客微信名称',
  `orderCount` smallint(2) unsigned NOT NULL DEFAULT '1' COMMENT '订餐份数',
  `orderType` smallint(2) unsigned NOT NULL DEFAULT '1' COMMENT '1: 午餐 2: 晚餐',
  `transportType` smallint(2) unsigned NOT NULL DEFAULT '1' COMMENT '1: 送餐 2:自取',
  `address` linestring NOT NULL COMMENT '送货地址',
  `phone` linestring NOT NULL COMMENT '联系电话',
  `isValid` tinyint(1) NOT NULL COMMENT '是否有效，true有效， false取消',
  `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Orders'