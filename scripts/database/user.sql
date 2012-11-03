create table user (
   id  bigint unsigned not null auto_increment,
   email varchar(128) not null,
   password varchar(128) not null,
   paymentMethodId bigint,
   createDate date,
   lastLoginDate date,
   primary key (id)
);