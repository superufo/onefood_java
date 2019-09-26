ALTER TABLE `address`
ADD COLUMN `receiver_name`  varchar(200) NOT NULL COMMENT '收货人名称' AFTER `member_name`,
ADD COLUMN `receiver_mobile`  varchar(30) NOT NULL COMMENT '收货人电话' AFTER `receiver_name`,
ADD COLUMN `address_label`  varchar(255) NULL COMMENT '标签 学校 家 ' AFTER `receiver_mobile`;
