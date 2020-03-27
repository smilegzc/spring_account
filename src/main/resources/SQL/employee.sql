set foreign_key_checks = 0;

drop table if exists `employee`;
create table `employee`
(
    `id` int(11) not null auto_increment,
    `name` varchar(32) default null,
    `phone` char(11) default null,
    `username` varchar(255) default null,
    `password` varchar(255) default null,
    `type` int(2) default null,
    primary key (`id`)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8;

insert into employee(name, phone, username, password, type) VALUES ('AA', 12345678900, 'AA', 'AA', 0);
insert into employee(name, phone, username, password, type) VALUES ('BB', 12345678900, 'BB', 'BB', 0);
insert into employee(name, phone, username, password, type) VALUES ('CC', 12345678900, 'CC', 'CC', 0);
insert into employee(name, phone, username, password, type) VALUES ('DD', 12345678900, 'DD', 'DD', 0);
insert into employee(name, phone, username, password, type) VALUES ('EE', 12345678900, 'EE', 'EE', 1);
insert into employee(name, phone, username, password, type) VALUES ('FF', 12345678900, 'FF', 'FF', 1);
insert into employee(name, phone, username, password, type) VALUES ('GG', 12345678900, 'GG', 'GG', 1);
insert into employee(name, phone, username, password, type) VALUES ('HH', 12345678900, 'HH', 'HH', 1);