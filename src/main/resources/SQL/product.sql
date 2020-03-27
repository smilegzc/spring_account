set foreign_key_checks = 0;

drop table if exists `product`;
create table product
(
    `id`       int(11) not null auto_increment,
    `name`     varchar(32)  default null,
    `purchase` float(16) default null,
    `sell` float(16) default null,
    `number`     int(16)       default null,
    primary key (`id`)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8;

insert into product(name, purchase, sell, number) values ('全效底改', '0', '75', 100);
insert into product(name, purchase, sell, number) values ('强效底净', '0', '25', 100);
insert into product(name, purchase, sell, number) values ('超强底净', '0', '30', 100);
insert into product(name, purchase, sell, number) values ('原子氧', '0', '24', 100);
insert into product(name, purchase, sell, number) values ('水立净', '0', '26', 100);
insert into product(name, purchase, sell, number) values ('益菌宝', '0', '65', 100);
insert into product(name, purchase, sell, number) values ('肝胆泰乐', '0', '18', 100);
insert into product(name, purchase, sell, number) values ('高稳维西', '0', '18', 100);
insert into product(name, purchase, sell, number) values ('生命元', '0', '45', 100);
insert into product(name, purchase, sell, number) values ('黄金多糖', '0', '20', 100);
insert into product(name, purchase, sell, number) values ('速康灵', '0', '18', 100);
insert into product(name, purchase, sell, number) values ('迪诺康', '0', '18', 100);
insert into product(name, purchase, sell, number) values ('肝肠舒', '0', '30', 100);
insert into product(name, purchase, sell, number) values ('新肠泰', '0', '28', 100);
insert into product(name, purchase, sell, number) values ('水博士', '0', '32', 100);
insert into product(name, purchase, sell, number) values ('解毒灵', '0', '70', 100);
insert into product(name, purchase, sell, number) values ('抗激灵', '0', '18', 100);
insert into product(name, purchase, sell, number) values ('活肥', '0', '80', 100);
insert into product(name, purchase, sell, number) values ('乌金膏', '0', '150', 100);
insert into product(name, purchase, sell, number) values ('纳米黑金', '0', '110', 100);
insert into product(name, purchase, sell, number) values ('活力益水素', '0', '20', 100);
insert into product(name, purchase, sell, number) values ('优加益生菌', '0', '18', 100);
insert into product(name, purchase, sell, number) values ('黄金益菌素', '0', '110', 100);
insert into product(name, purchase, sell, number) values ('大水面浓缩芽孢', '0', '360', 100);
insert into product(name, purchase, sell, number) values ('弧菌天敌', '0', '35', 100);
insert into product(name, purchase, sell, number) values ('超碘', '0', '25', 100);
insert into product(name, purchase, sell, number) values ('金碘', '0', '50', 100);
insert into product(name, purchase, sell, number) values ('菌毒必克', '0', '26', 100);
insert into product(name, purchase, sell, number) values ('联合立克', '0', '18', 100);
insert into product(name, purchase, sell, number) values ('止血停', '0', '15', 100);