CREATE TABLE `parking_boy`  (
  `parking_boy_id` char(36) NOT NULL,
  `name` nvarchar(100) NULL,
  PRIMARY KEY (`parking_boy_id`)
);

INSERT INTO `parking_boy` VALUES ('1394cffaee6a', '张三');
INSERT INTO `parking_boy` VALUES ('1394cffaee6b', '李四');

CREATE TABLE `parking_lot`  (
  `parking_lot_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `parking_boy_id` char(36),
  `capacity` int(10),
  PRIMARY KEY (`parking_lot_id`)
);

CREATE TABLE `license_plate`  (
  `license_plate_id` nvarchar(100),
  `parking_lot_id` char(36),
  PRIMARY KEY (`license_plate_id`)
);

CREATE TABLE `ticket`  (
  `ticket_id` char(36),
  `parking_lot_id` bigint(0),
  `license_plate_id` nvarchar(100),
  PRIMARY KEY (`ticket_id`)
);

