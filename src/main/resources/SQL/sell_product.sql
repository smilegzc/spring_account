set foreign_key_checks = 0;

drop table if exists `sell_product`;
create table sell_product
(
    `id`       int(11) not null auto_increment,
    `name`     varchar(32) default null,
    `purchase` float(16)   default null,
    `number`   int(16)     default null,
    `creat_date` date not null ,
    primary key (`id`)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8;

insert into sell_product(name, purchase, number, creat_date) values ('全效底改', '0', '75', now());
insert into sell_product(name, purchase, number, creat_date) values ('强效底净', '0', '25', now());
insert into sell_product(name, purchase, number, creat_date) values ('超强底净', '0', '30', now());
insert into sell_product(name, purchase, number, creat_date) values ('原子氧', '0', '24', now());
insert into sell_product(name, purchase, number, creat_date) values ('水立净', '0', '26', now());
insert into sell_product(name, purchase, number, creat_date) values ('益菌宝', '0', '65', now());
