CREATE database da1;

use da1;


CREATE table account
(
    ID uniqueidentifier not null DEFAULT (newid()) primary key,
    username nvarchar(50),
    pass NVARCHAR(20),
    createDate DATE,
    updateDate DATE,
    accStatus BIT
);
CREATE TABLE USERs
(
    ID uniqueidentifier not null DEFAULT (newid()) primary key,
    userName NVARCHAR(50),
    phone NVARCHAR(10),
    userAddress NVARCHAR(max),
    idAcc uniqueidentifier not null,
    createDate DATE,
    updateDate DATE,
    userStatus BIT
);

CREATE table roles
(
    ID uniqueidentifier not null DEFAULT (newid()) primary key,
    rolesName nvarchar(50),
    createDate DATE,
    updateDate DATE,
    rolesStatus BIT
);

CREATE table roles_acc
(
    idRole uniqueidentifier not null ,
    idAcc uniqueidentifier not null
);

CREATE TABLE products
(
    ID uniqueidentifier not null DEFAULT (newid()) primary key,
    prName NVARCHAR(50),
    prQuantity int,
    original NVARCHAR(max),
    cost DECIMAL,
    expiry DATE,
    MFG DATE,
    idType uniqueidentifier,
    createDate DATE,
    updateDate DATE,
    prStatus BIT
);

CREATE TABLE inventory
(
    ID uniqueidentifier not null DEFAULT (newid()) primary key,
    inventoryName NVARCHAR(50),
    idUser uniqueidentifier not null,
    idCustomer uniqueidentifier not null,
    createDate DATE,
    updateDate DATE,
    inventoryStatus BIT
);
CREATE TABLE inventory_detail
(
    ID uniqueidentifier not null DEFAULT (newid()) primary key,
    ma NVARCHAR(50),
    inventoryId uniqueidentifier not null,
    total DECIMAL,
    createDate DATE,
    updateDate DATE,
    inventoryStatus BIT
);


CREATE TABLE customer
(
    ID uniqueidentifier not null DEFAULT (newid()) primary key,
    userName NVARCHAR(50),
    phone NVARCHAR(10),
    userAddress NVARCHAR(max),
    createDate DATE,
    updateDate DATE,
    cusStatus BIT
);

CREATE TABLE Items
(
    ID uniqueidentifier not null DEFAULT (newid()) primary key,
    idCart uniqueidentifier not null,
    idInventory uniqueidentifier not null,
    codeProducts NVARCHAR(50),
    nameProducs NVARCHAR(50),
    quantity INT,
    price DECIMAL,
    createDate DATE,
    updateDate DATE,
    itemsStatus BIT
);

CREATE TABLE Store
(
    ID uniqueidentifier not null DEFAULT (newid()) primary key,
    nameStore NVARCHAR(50),
    adrStore NVARCHAR(max),
    createDate DATE,
    updateDate DATE,
    storeStatus BIT
);
CREATE TABLE income
(
    ID uniqueidentifier not null DEFAULT (newid()) primary key,
    code NVARCHAR(max),
    total DECIMAL,
    createDate DATE,
    updateDate DATE,
    incomeStatus BIT
);

CREATE TABLE report
(
    ID uniqueidentifier not null DEFAULT (newid()) primary key,
    code NVARCHAR(max),
    reportDESCRIPTION NVARCHAR(max),
    namerp NVARCHAR(50),
    idnv uniqueidentifier,
    income uniqueidentifier,
    createDate DATE,
    updateDate DATE,
    rpStatus BIT
);

CREATE table Cart
(
    ID uniqueidentifier not null DEFAULT (newid()) primary key,
    code NVARCHAR(max),
    idstore uniqueidentifier,
    idCustomer uniqueidentifier,
    iduser uniqueidentifier,
    createDate DATE,
    updateDate DATE,
    cartStatus BIT
);

CREATE TABLE productType(
        ID uniqueidentifier not null DEFAULT (newid()) primary key,
        typename NVARCHAR(100),
         createDate DATE,
    updateDate DATE,
    prtypeStatus BIT
);


insert into productType(typename,createDate,updateDate,prtypeStatus) VALUES('Đồ đông lạnh', '2023-8-6','2023-8-6',1)
insert into productType(typename,createDate,updateDate,prtypeStatus) VALUES('Đồ tươi', '8-6-2023','8-6-2023',1)

ALTER TABLE productType
ALTER COLUMN typename NVARCHAR(max) COLLATE Vietnamese_100_CI_AS;


SELECT * from productType;





