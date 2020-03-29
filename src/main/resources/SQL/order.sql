set foreign_key_checks = 0;

drop table if exists `order`;
create table `order`
(
    `id`         int(11)   not null auto_increment,
    `name`       varchar(32)        default null,
    `purchase`       float(16)          default null,
    `receivable` float(16)          default null,
    `actual`     float(16)          default null,
    `date`       datetime NOT NULL,
    primary key (`id`)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8;


insert into `order`(name, purchase, receivable, actual, date)VALUES ('AA', 120, 123, 123, now());
insert into `order`(name, purchase, receivable, actual, date)VALUES ('BB', 120, 123, 123, now());
insert into `order`(name, purchase, receivable, actual, date)VALUES ('CC', 120, 123, 123, now());
insert into `order`(name, purchase, receivable, actual, date)VALUES ('DD', 120, 123, 123, now());
insert into `order`(name, purchase, receivable, actual, date)VALUES ('EE', 120, 123, 123, now());
insert into `order`(name, purchase, receivable, actual, date)VALUES ('FF', 120, 123, 123, now());
insert into `order`(name, purchase, receivable, actual, date)VALUES ('GG', 120, 123, 123, now());
insert into `order`(name, purchase, receivable, actual, date)VALUES ('HH', 120, 123, 123, now());