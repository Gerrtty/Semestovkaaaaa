CREATE TABLE `User` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sername` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `phone` int(11) NOT NULL,
  `birth_date` date NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
)

CREATE TABLE `Building` (
  `building_id` INT NOT NULL AUTO_INCREMENT,
  `town` VARCHAR(45) NOT NULL,
  `district` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`building_id`),
  UNIQUE INDEX `building_id_UNIQUE` (`building_id` ASC));

CREATE TABLE `Assessment` (
  `id` INT NOT NULL,
  `building_id` INT NOT NULL,
  `service_id` INT NOT NULL,
  `assessment` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `Service` (
  `service_id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `degree_of_uniqueness` INT NULL,
  PRIMARY KEY (`service_id`),
  UNIQUE INDEX `service_id_UNIQUE` (`service_id` ASC));

CREATE TABLE `Price` (
  `price_id` INT NOT NULL,
  `building_id` INT NOT NULL,
  `service_id` INT NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`price_id`),
  UNIQUE INDEX `price_id_UNIQUE` (`price_id` ASC));
