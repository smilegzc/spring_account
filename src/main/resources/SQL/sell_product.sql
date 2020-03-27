set foreign_key_checks = 0;

drop table if exists `sell_product`;
create table sell_product
(
    `id`       int(11) not null auto_increment,
    `name`     varchar(32) default null,
    `purchase` float(16)   default null,
    `number`   int(16)     default null,
    `creat_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    primary key (`id`)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8;

insert into sell_product(name, purchase, number)
values ('全效底改', '0', '75');
insert into sell_product(name, purchase, number)
values ('强效底净', '0', '25');
insert into sell_product(name, purchase, number)
values ('超强底净', '0', '30');
insert into sell_product(name, purchase, number)
values ('原子氧', '0', '24');
insert into sell_product(name, purchase, number)
values ('水立净', '0', '26');
insert into sell_product(name, purchase, number)
values ('益菌宝', '0', '65');
