create database qlks;
use qlks;

create table `user` (
`user_id` int NOT NULL AUTO_INCREMENT primary key,  
`user_fullName` varchar(255) NOT NULL,
`user_cccd` varchar(20) NOT NULL,
`user_phoneNumber` varchar(15) NOT NULL,
`user_gmail` varchar(255) DEFAULT NULL,
`user_idSocial` varchar(255) DEFAULT NULL,
`user_avatar` text,
`user_createdAt` bigint DEFAULT NULL,
`user_updatedAt` bigint DEFAULT NULL,
`user_isDelete` tinyint(1) DEFAULT NULL,
`user_role` varchar(50) DEFAULT NULL,
`user_userName` VARCHAR(255) NOT NULL,  
`user_passWord` VARCHAR(255) NOT NULL
);
INSERT INTO `user` 
(`user_fullName`, `user_cccd`, `user_phoneNumber`, `user_gmail`, `user_idSocial`, 
 `user_avatar`, `user_createdAt`, `user_updatedAt`, `user_role`, `user_userName`, `user_passWord`) 
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
SELECT * FROM `user`;
SELECT * FROM `user` WHERE `user_userName` = ? AND `user_passWord` = ?;
DELETE FROM `user` WHERE `user_id` = ?;
UPDATE `user` 
SET 
  `user_fullName` = ?, 
  `user_cccd` = ?, 
  `user_phoneNumber` = ?, 
  `user_gmail` = ?, 
  `user_idSocial` = ?, 
  `user_avatar` = ?, 
  `user_createdAt` = ?, 
  `user_updatedAt` = ?, 
  `user_role` = ?, 
  `user_userName` = ?, 
  `user_passWord` = ? 
WHERE `user_id` = ?;

CREATE TABLE `hotel` (
  `hotel_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `hotel_name` VARCHAR(255) NOT NULL,
  `hotel_image` VARCHAR(255) DEFAULT NULL,
  `hotel_priceOld` INT DEFAULT NULL,
  `hotel_priceCurrent` INT DEFAULT NULL,
  `hotel_city` VARCHAR(100) DEFAULT NULL,
  `hotel_address` NVARCHAR(255) DEFAULT NULL,
  `hotel_rate` DECIMAL(3,1) DEFAULT NULL,
  `hotel_addressDetail` VARCHAR(255) DEFAULT NULL,
  `hotel_introduce` TEXT,
  `hotel_utilities` JSON DEFAULT NULL,
  `hotel_nearTheArea` JSON DEFAULT NULL,
  `hotel_imageList` JSON DEFAULT NULL,
  `hotel_isDelete` TINYINT(1) DEFAULT '0',
  `hotel_updatedAt` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO `hotel` (
  `hotel_name`, `hotel_image`, `hotel_priceOld`, `hotel_priceCurrent`, `hotel_city`, 
  `hotel_address`, `hotel_rate`, `hotel_addressDetail`, `hotel_introduce`, 
  `hotel_utilities`, `hotel_nearTheArea`, `hotel_imageList`, `hotel_isDelete`, `hotel_updatedAt`
) VALUES
(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP);
DELETE FROM `hotel` WHERE `hotel_id` = ?;
SELECT * FROM `hotel`;
UPDATE `hotel` 
SET 
  `hotel_name` = ?, 
  `hotel_image` = ?, 
  `hotel_priceOld` = ?, 
  `hotel_priceCurrent` = ?, 
  `hotel_city` = ?, 
  `hotel_address` = ?, 
  `hotel_rate` = ?, 
  `hotel_addressDetail` = ?, 
  `hotel_introduce` = ?, 
  `hotel_utilities` = ?, 
  `hotel_nearTheArea` = ?, 
  `hotel_imageList` = ?, 
  `hotel_isDelete` = ?, 
  `hotel_updatedAt` = CURRENT_TIMESTAMP 
WHERE `hotel_id` = ?;

create table room (
`room_id` int NOT NULL AUTO_INCREMENT primary key,
`room_hotelId` int NOT NULL,
foreign key (`room_hotelId`) references hotel(`hotel_id`),
`room_name` varchar(255) NOT NULL,
`room_price` decimal(10,2) NOT NULL,
`room_imageList` text,
`room_utilities` json DEFAULT NULL,
`room_sizeRoom` int DEFAULT NULL,
`room_user` int DEFAULT NULL,
`room_heading` varchar(255) DEFAULT NULL,
`room_floor` int DEFAULT NULL,
`room_shower` tinyint(1) DEFAULT NULL,
`room_TV` tinyint(1) DEFAULT NULL,
`room_phone` tinyint(1) DEFAULT NULL,
`room_water` tinyint(1) DEFAULT NULL,
`room_isDelete` tinyint(1) DEFAULT NULL,
`room_updatedAt` bigint DEFAULT NULL
);
INSERT INTO `room` (
  `room_hotelId`, `room_name`, `room_price`, `room_imageList`, 
  `room_utilities`, `room_sizeRoom`, `room_user`, `room_heading`, 
  `room_floor`, `room_shower`, `room_TV`, `room_phone`, `room_water`, 
  `room_isDelete`, `room_updatedAt`
) VALUES 
(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
SELECT * FROM `room`;
DELETE FROM `room` WHERE `room_id` = ?;
UPDATE `room` SET `room_hotelId` = ?, `room_name` = ?, `room_price` = ?, `room_imageList` = ?, `room_utilities` = ?, 
`room_sizeRoom` = ?, `room_user` = ?, `room_heading` = ?, `room_floor` = ?, `room_shower` = ?, `room_TV` = ?, `room_phone` = ?,
 `room_water` = ?, `room_isDelete` = ?, `room_updatedAt` = ?  WHERE `room_id` = ?; 

create table bills (
`bills_id` int NOT NULL AUTO_INCREMENT primary key,
`bills_userId` int NOT NULL,
foreign key (`bills_userId`) references `user`(`user_id`),
`bills_hotelId` int NOT NULL,
foreign key (`bills_hotelId`) references hotel(`hotel_id`),
`bills_billCode` varchar(255) DEFAULT NULL,
`bills_roomId` int NOT NULL,
`bills_price` decimal(10,2) NOT NULL,
`bills_name` varchar(255) DEFAULT NULL,
`bills_checkInDate` date NOT NULL,
`bills_phoneNumber` varchar(255) DEFAULT NULL,
`bills_CCCD` varchar(255) DEFAULT NULL,
`bills_fullname` varchar(255) DEFAULT NULL,
`bills_checkOutDate` date NOT NULL,
`bills_paymentMethod` varchar(50) DEFAULT NULL,
`bills_pay` enum('yes','no') NOT NULL,
`bills_isDelete` tinyint(1) DEFAULT '0',
`bills_createdAt` datetime DEFAULT NULL,
`bills_updatedAt` datetime DEFAULT NULL
);
INSERT INTO `bills` (
  `bills_userId`, `bills_hotelId`, `bills_billCode`, `bills_roomId`, 
  `bills_price`, `bills_name`, `bills_checkInDate`, `bills_phoneNumber`, 
  `bills_CCCD`, `bills_fullname`, `bills_checkOutDate`, `bills_paymentMethod`, 
  `bills_pay`, `bills_isDelete`, `bills_createdAt`, `bills_updatedAt`
) VALUES 
(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
DELETE FROM `bills` WHERE `bills_id` = ?;
SELECT * FROM `bills`;
UPDATE `bills` 
SET 
  `bills_userId` = ?, 
  `bills_hotelId` = ?, 
  `bills_billCode` = ?, 
  `bills_roomId` = ?, 
  `bills_price` = ?, 
  `bills_name` = ?, 
  `bills_checkInDate` = ?, 
  `bills_phoneNumber` = ?, 
  `bills_CCCD` = ?, 
  `bills_fullname` = ?, 
  `bills_checkOutDate` = ?, 
  `bills_paymentMethod` = ?, 
  `bills_pay` = ?, 
  `bills_isDelete` = ?, 
  `bills_createdAt` = ?, 
  `bills_updatedAt` = ? 
WHERE `bills_id` = ?;

create table reviews (
`reviews_id` int NOT NULL AUTO_INCREMENT primary key,
`reviews_userId` int NOT NULL,
foreign key (`reviews_userId`) references `user`(`user_id`),
`reviews_hotelId` int NOT NULL,
foreign key (`reviews_hotelId`) references hotel (`hotel_id`),
`reviews_rate` int NOT NULL,
`reviews_comment` text,
`reviews_imageReview` json DEFAULT NULL,
`reviews_createdAt` timestamp NOT NULL,
`reviews_updatedAt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
`reviews_isDelete` tinyint(1) DEFAULT '0'
);
INSERT INTO `reviews` (
  `reviews_userId`, `reviews_hotelId`, `reviews_rate`, `reviews_comment`, 
  `reviews_imageReview`, `reviews_createdAt`, `reviews_updatedAt`, `reviews_isDelete`
) VALUES 
(?, ?, ?, ?, ?, ?, ?, ?);
DELETE FROM `reviews` WHERE `reviews_id` = ?;
SELECT * FROM `reviews`;
UPDATE `reviews` 
SET 
  `reviews_userId` = ?, 
  `reviews_hotelId` = ?, 
  `reviews_rate` = ?, 
  `reviews_comment` = ?, 
  `reviews_imageReview` = ?, 
  `reviews_createdAt` = ?, 
  `reviews_updatedAt` = CURRENT_TIMESTAMP, 
  `reviews_isDelete` = ? 
WHERE `reviews_id` = ?;

create table listofbookedrooms (
`list_id` int not null auto_increment primary key,
`list_userId` int not null,
foreign key (`list_userId`) references `user`(`user_id`),
`list_hotelId` int not null,
foreign key (`list_hotelId`) references hotel (`hotel_id`),
`room_id` int not null,
foreign key (`room_id`) references room (`room_id`)
);
INSERT INTO `listofbookedrooms` (
  `list_userId`, `list_hotelId`, `room_id`
) VALUES 
(?, ?, ?);
DELETE FROM `listofbookedrooms` WHERE `list_id` = ?;
SELECT * FROM `listofbookedrooms`;
UPDATE `listofbookedrooms` 
SET 
  `list_userId` = ?, 
  `list_hotelId` = ?, 
  `room_id` = ? 
WHERE `list_id` = ?;





