drop table if exists authorities;
drop table if exists users;
create table users(
	username varchar(50) not null primary key,
	password varchar(50) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

create table if not exists car (
	car_id integer not null primary key,
	car_name varchar(200) not null,
	car_manufacturer_name varchar(200) not null,
	car_model varchar(200) not null,
	car_manufacturing_year timestamp,
	car_color varchar(200) not null
);

create sequence if not exists SEQ_JUST_FOR_CAR
minvalue 1
maxvalue 99999999999999999
start with 1
increment by 1;

