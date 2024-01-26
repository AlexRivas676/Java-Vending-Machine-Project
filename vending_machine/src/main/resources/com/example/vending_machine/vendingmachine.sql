use vendingmachine;
create table product(
pid int not null primary key,
sku varchar(250),
pn Varchar(250),
pdesc varchar(250),
cal int ,
rol int,
createdby varchar(250) ,
createddate varchar(250),
modifedby varchar(250),
modifeddate varchar(250),
isdeleted boolean
);
use vendingmachine;
create table price(
priceid int not null primary key,
pid int not null references product(pid),
price decimal,
startdate varchar(250),
enddate varchar(250),
createdby varchar(250) ,
createddate varchar(250),
modifedby varchar(250),
modifeddate varchar(250),
isdeleted boolean
);
use vendingmachine;
create table vendor (
vid int not null primary key,
vendorname varchar(250),
vendoraddress varchar(250),
createdby varchar(250) ,
createddate varchar(250),
modifedby varchar(250),
modifeddate varchar(250),
isdeleted boolean
);
use vendingmachine;
create table vendorproduct(
vpid int not null primary key,
pid int not null references product(pid),
vid int not null references vendor(vid),
createdby varchar(250) ,
createddate varchar(250),
modifedby varchar(250),
modifeddate varchar(250),
isdeleted boolean
);
use vendingmachine;
create table inventory(
Iid int not null primary key,
pid int not null references product(pid),
vid int not null references vendor(vid),
expdate varchar(250),
batchnum int,
qty int,
batch varchar(250),
createdby varchar(250) ,
createddatevarchar(250) ,
modifedby varchar(250),
modifeddate varchar(250),
isdeleted boolean
);
create procedure vendingmachineproducts(
sku varchar(250),
pn varchar(250),
pdesc varchar(250),
cal int,
rol int,


