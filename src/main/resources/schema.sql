DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
  USER_ID INT   PRIMARY KEY,
  FIRST_NAME VARCHAR(250) ,
  LAST_NAME VARCHAR(250) ,
  USERNAME VARCHAR(250) NOT NULL,
  MOBILE_NO VARCHAR(250) NOT NULL,
  USER_TYPE VARCHAR(250) NOT NULL,
  CREATED_DATE VARCHAR(250) NOT NULL
);
DROP TABLE IF EXISTS configurations;
create table configurations(
 id INT AUTO_INCREMENT ,
CONFIG_KEY VARCHAR(250),
CONFIG_value VARCHAR(250)
);
DROP TABLE IF EXISTS CATALOGUE_ITEMS;
create table CATALOGUE_ITEMS(
 id INT  ,
ITEM_NAME VARCHAR(250) not null,
ITEM_PRICE VARCHAR(250) not null,
ITEM_TYPE VARCHAR(250) not null
);
DROP TABLE IF EXISTS USER_CART;
CREATE TABLE USER_CART(
 id INT  ,
USER_ID VARCHAR(250) not null,
item_ID VARCHAR(250) not null,
BILL_INCLUDED CHAR(1) not null
);

