create database hoteltest1;

use hoteltest1;
create table tbluser (
	id int primary key,
    username varchar(30),
    password varchar(20),
    name varchar(50),
    position varchar(15)
);
create table tblroom (
	id int primary key,
    name varchar(20),
    type varchar(20),
    price float,
    des varchar(100)
);

create table tblhotel (
	id int primary key,
    name varchar(20),
    address varchar(50),
    star int,
    des varchar(30)
);

create table tblservice (
	id int primary key,
    name varchar(30),
    unity varchar(20),
    price float,
    des varchar(30)
);

create table tblbill(
	id int primary key,
    paymendate date,
    amount float,
    paymentype varchar(15),
    note varchar(30)
);

create table tblbookedroom(
		id int primary key,
        checkin date,
        checkout date,
        price float,
        saleoff float,
        ischecked boolean
);

create table tblbooking (
	id int primary key,
    bookeddate date,
    saleoff float,
    note varchar(30)
);

create table tblclient (
	id int primary key,
    name varchar(50),
    idcard varchar(12),
    address varchar(50),
    tel varchar(15),
    email varchar(30),
    note varchar(30)
);

create table tblusedservice (
	id int primary key,
    price float,
    quantity float,
    saleoff float
);

drop table tblroom;

insert into tbluser 
values(1,"manager","password","Thang","Manager");
insert into tbluser
values(2,"seller","password","Liem","Seller");
insert into tblroom
values(1,"403","double",1000000,"Best room for a couple with a romantic sea view.");
insert into tblroom
values(2,"501","double",1000000,"A very beautiful sea view room with a best bed in the hotel.");