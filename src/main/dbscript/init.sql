DROP SCHEMA IF EXISTS `companies`;
CREATE SCHEMA IF NOT EXISTS `companies`
    CHARACTER SET `utf8`;

USE `companies`;

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`
(
    `id`     BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`   VARCHAR(255) NOT NULL,
    `street` VARCHAR(255),
    `city`   VARCHAR(255)
);

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`
(
    `id`   BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS `company_client`;
CREATE TABLE `company_client`
(
    `id`            BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `fk_company_id` BIGINT NOT NULL,
    `fk_client_id`  BIGINT NOT NULL,
    CONSTRAINT `fk_company_client_to_company` FOREIGN KEY (`fk_company_id`) REFERENCES `company` (`id`),
    CONSTRAINT `fk_company_client_to_client` FOREIGN KEY (`fk_client_id`) REFERENCES `client` (`id`)
);

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`
(
    `id`         BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `company_id` BIGINT       NOT NULL,
    `name`       VARCHAR(255) NOT NULL,
    `street`     VARCHAR(255),
    `city`       VARCHAR(255),
    CONSTRAINT `fk_employee_to_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
);

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `id`         BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `value`       VARCHAR(255) NOT NULL
);

-- test data --
INSERT INTO company (id, name, street, city)
VALUES (1, 'Facebook', '1st avenue', 'San Francisco');
INSERT INTO company (id, name, street, city)
VALUES (2, 'Apple', '2st avenue', 'New York');

INSERT INTO employee (id, name, street, city, company_id)
VALUES (1, 'Pavel', '2st avenue', 'New York', 1);

INSERT INTO employee (id, name, street, city, company_id)
VALUES (2, 'Ivan', '2st avenue', 'New York', 1);

INSERT INTO client (id, name)
VALUES (1, 'first');
INSERT INTO client (id, name)
VALUES (2, 'second');

INSERT INTO company_client (id, fk_client_id, fk_company_id)
VALUES (1, 1, 1);
INSERT INTO company_client (id, fk_client_id, fk_company_id)
VALUES (2, 2, 1);

INSERT INTO role (id, value)
VALUES (1, 'admin');
INSERT INTO role (id, value)
VALUES (2, 'user');