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
CREATE TABLE inventory(

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


