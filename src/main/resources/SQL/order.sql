set foreign_key_checks = 0;

drop table if exists `order`;
create table `order`
(
    `id`         int(11)   not null auto_increment,
    `name`       varchar(32)        default null,
    `sell`       float(16)          default null,
    `receivable` float(16)          default null,
    `actual`     float(16)          default null,
    `date`       date NOT NULL,
    primary key (`id`)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8;


insert into `order`(name, receivable, actual, date)VALUES ('AA', 123, 123, now());
insert into `order`(name, receivable, actual, date)VALUES ('BB', 123, 123, now());
insert into `order`(name, receivable, actual, date)VALUES ('CC', 123, 123, now());
insert into `order`(name, receivable, actual, date)VALUES ('DD', 123, 123, now());
insert into `order`(name, receivable, actual, date)VALUES ('EE', 123, 123, now());
insert into `order`(name, receivable, actual, date)VALUES ('FF', 123, 123, now());
insert into `order`(name, receivable, actual, date)VALUES ('GG', 123, 123, now());
insert into `order`(name, receivable, actual, date)VALUES ('HH', 123, 123, now());