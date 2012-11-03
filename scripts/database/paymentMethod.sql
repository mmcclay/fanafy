create table paymentMethod (
  paymentMethodId bigint unsigned auto_increment primary key,
  firstName varchar(128),
  lastName varchar(128),
  address1 varchar(128),
  addresss2 varchar(128),
  city varchar(128),
  state varchar(128),
  zip varchar(32),
  ccType varchar(32),
  ccNumber varchar(64),
  ccExpiration varchar(64),
  createDate date
);