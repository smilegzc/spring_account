set foreign_key_checks = 0;

drop table if exists `customer`;
create table `customer`
(
    `id`       int(11) not null auto_increment,
    `name`     varchar(32)  default null,
    `phone`    char(11)     default null,
    `address` varchar(255) default null,
    `size` float(8) default null,
    primary key (`id`)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8;

insert into customer(name, phone, address, size) VALUES ('AA', '12345678900', 'AA', 0);
insert into customer(name, phone, address, size) VALUES ('BB', '12345678900', 'BB', 0);
insert into customer(name, phone, address, size) VALUES ('CC', '12345678900', 'CC', 0);
insert into customer(name, phone, address, size) VALUES ('DD', '12345678900', 'DD', 0);
insert into customer(name, phone, address, size) VALUES ('EE', '12345678900', 'EE', 0);
insert into customer(name, phone, address, size) VALUES ('FF', '12345678900', 'FF', 0);
insert into customer(name, phone, address, size) VALUES ('GG', '12345678900', 'GG', 0);