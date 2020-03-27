set foreign_key_checks = 0;

drop table if exists `goods`;
create table `goods`
(
    `g_id`       int(11) not null auto_increment,
    `g_name`     varchar(32) default null,
    `g_number`   int(8)      default null,
    `g_price`    float(16)   default null,
    `g_all`      float(16)   default null,
    `g_order_id` int(11) not null,
    primary key (`g_id`)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8;

insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('AA', 8, 123, 3, 1);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('BB', 8, 123, 3, 1);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('CC', 8, 123, 3, 2);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('DD', 8, 123, 3, 2);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('EE', 8, 123, 3, 3);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('FF', 8, 123, 3, 3);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('GG', 8, 123, 3, 4);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('HH', 8, 123, 3, 4);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('AA', 8, 123, 3, 5);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('BB', 8, 123, 3, 5);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('CC', 8, 123, 3, 6);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('DD', 8, 123, 3, 6);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('EE', 8, 123, 3, 7);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('FF', 8, 123, 3, 7);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('GG', 8, 123, 3, 8);
insert into `goods`(g_name, g_number, g_price, `g_all`, g_order_id) VALUES ('HH', 8, 123, 3, 8);