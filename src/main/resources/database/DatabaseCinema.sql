-- DROP DATABASE IF EXISTS `cinema`;
CREATE DATABASE IF NOT EXISTS `cinema`;
USE `cinema`;
CREATE TABLE `user` (
  `id`        SERIAL NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(25),
  `lastName`  VARCHAR(25),
  `login`     VARCHAR(50),
  `password`  VARCHAR(50),
--  `birthday`  DATE,
  `role`      VARCHAR(20),
  `email`     VARCHAR(70),
  PRIMARY KEY (`id`)
);

CREATE TABLE `movie` (
  `id`          SERIAL NOT NULL AUTO_INCREMENT,
  `title`       VARCHAR(50),
  `description` BLOB,
  `duration`    SMALLINT UNSIGNED,
--   `rating`      DOUBLE,
  PRIMARY KEY (`id`)
);

CREATE TABLE `hall` (
  `id`          SERIAL NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(50),
  `rowCount`    SMALLINT UNSIGNED,
  `columnCount` SMALLINT UNSIGNED,
--   `size`        SMALLINT UNSIGNED,

  PRIMARY KEY (`id`)
);

CREATE TABLE `session` (
  `id`       SERIAL NOT NULL AUTO_INCREMENT,
  `movie_id` BIGINT(20) UNSIGNED,
  `hall_id`  BIGINT(20) UNSIGNED,
--   `time`     DATETIME,
  PRIMARY KEY (`id`)
);

CREATE TABLE `ticket` (
  `id`         SERIAL NOT NULL AUTO_INCREMENT,
  `session_id` BIGINT(20) UNSIGNED,
  `row`        BIGINT(20) UNSIGNED,
  `column`     BIGINT(20) UNSIGNED,
  `is_checked` BOOLEAN,

  PRIMARY KEY (`id`)
);


INSERT INTO `user`(`id`,`firstName`,`lastName`,`login`,`password`,`role`,`email`) VALUE (1, 'admin', 'admin', 'admin', 'admin', 'ADMIN', 'admin@admin');
INSERT INTO `hall`(`id`,`name`,`rowCount`,`columnCount`) VALUES  (1, 'White Hall', 5, 10),
                                                                        (2, 'Blue Hall', 4, 8),
                                                                        (3, 'Red Hall', 7, 8);
INSERT INTO `movie` (`id`,`title`,`description`,`duration`) VALUES  (1, 'Title 1', 'Description 1', 1000),
                                                                             (2, 'Title 2', 'Description 2', 2000),
                                                                             (3, 'Title 3', 'Description 3', 3000),
                                                                             (4, 'Title 4', 'Description 4', 4000);
INSERT INTO `session` ( `id`,`movie_id`,`hall_id`) VALUES  (1, 1, 1),
                                                                  (2, 2, 2),
                                                                  (3, 3, 3),
                                                                  (4, 4, 1);
INSERT INTO `ticket` (`id`, `session_id`,`row`, `column`) VALUES (1, 1, 1, 1),
                                                                 (2, 2, 2, 2),
                                                                 (3, 3, 3, 3),
                                                                 (4, 4, 4, 4),
                                                                 (5, 5, 5, 5); 