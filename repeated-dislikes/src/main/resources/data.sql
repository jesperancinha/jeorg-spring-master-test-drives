truncate table BAD.USERS;
truncate table BAD.SHOPS;
truncate table BAD.RECEIPTS;
insert into BAD.USERS (NAME)
values ('CatOne');
insert into BAD.SHOPS (NAME)
values ('Cats Para Dice');
SET @receipt1=random_uuid();
SET @receipt2=random_uuid();
SET @userid=(select ID from BAD.USERS WHERE NAME = 'CatOne');
insert into BAD.RECEIPTS (ID, USER_ID, SHOP_ID)
values (@receipt1, @userid,
        (select ID from BAD.SHOPS WHERE NAME = 'Cats Para Dice')
       );
insert into BAD.RECEIPTS (ID, USER_ID, SHOP_ID)
values (@receipt2, @userid,
        (select ID from BAD.SHOPS WHERE NAME = 'Cats Para Dice')
       );
insert into BAD.BAD_DISLIKES_RELATIONS (ID, USER_ID, SHOP_ID, RECEIPT_ID)
values (random_uuid(), @userid,
        (select ID from BAD.SHOPS WHERE NAME = 'Cats Para Dice'),
        @receipt1
       );
insert into BAD.BAD_DISLIKES_RELATIONS (ID, USER_ID, SHOP_ID, RECEIPT_ID)
values (random_uuid(), @userid,
        (select ID from BAD.SHOPS WHERE NAME = 'Cats Para Dice'),
        @receipt2
       );








insert into FIX.USERS (ID, NAME)
values (random_uuid(), 'CatOne');
insert into FIX.SHOPS (ID, NAME)
values (random_uuid(), 'Cats Para Dice');
SET @receipt3=random_uuid();
SET @receipt4=random_uuid();
insert into FIX.RECEIPTS (ID, USER_ID, SHOP_ID)
values (@receipt3,
        (select ID from FIX.USERS WHERE NAME = 'CatOne'),
        (select ID from FIX.SHOPS WHERE NAME = 'Cats Para Dice')
       );
insert into FIX.RECEIPTS (ID, USER_ID, SHOP_ID)
values (@receipt4,
        (select ID from FIX.USERS WHERE NAME = 'CatOne'),
        (select ID from FIX.SHOPS WHERE NAME = 'Cats Para Dice')
       );


truncate table BADFIX.USERS;
truncate table BADFIX.SHOPS;
truncate table BADFIX.RECEIPTS;
insert into BADFIX.USERS (NAME)
values ('CatOne BadFix');
insert into BADFIX.SHOPS (NAME)
values ('Cats Para Dice BadFix');
SET @receipt1=random_uuid();
SET @receipt2=random_uuid();
SET @userid=(select ID from BADFIX.USERS WHERE NAME = 'CatOne BadFix');
insert into BADFIX.RECEIPTS (ID, USER_ID, SHOP_ID)
values (@receipt1, @userid,
        (select ID from BADFIX.SHOPS WHERE NAME = 'Cats Para Dice BadFix')
       );
insert into BADFIX.RECEIPTS (ID, USER_ID, SHOP_ID)
values (@receipt2, @userid,
        (select ID from BADFIX.SHOPS WHERE NAME = 'Cats Para Dice BadFix')
       );
insert into BADFIX.BAD_DISLIKES_RELATIONS (ID, USER_ID, SHOP_ID, RECEIPT_ID)
values (random_uuid(), @userid,
        (select ID from BADFIX.SHOPS WHERE NAME = 'Cats Para Dice BadFix'),
        @receipt1
       );
insert into BADFIX.BAD_DISLIKES_RELATIONS (ID, USER_ID, SHOP_ID, RECEIPT_ID)
values (random_uuid(), @userid,
        (select ID from BADFIX.SHOPS WHERE NAME = 'Cats Para Dice BadFix'),
        @receipt2
       );






truncate table FIX.USERS;
truncate table FIX.SHOPS;
truncate table FIX.RECEIPTS;
truncate table FIX.USERS_RECEIPTS;
truncate table FIX.USERS_SHOPS;
insert into FIX.USERS (ID, NAME)
values (random_uuid(), 'CatOne');
insert into FIX.SHOPS (ID, NAME)
values (random_uuid(), 'Cats Para Dice');
SET @receipt3=random_uuid();
SET @receipt4=random_uuid();
SET @userid=(select ID from FIX.USERS WHERE NAME = 'CatOne');
insert into FIX.RECEIPTS (ID, USER_ID, SHOP_ID)
values (@receipt3,
        (select ID from FIX.USERS WHERE NAME = 'CatOne'),
        (select ID from FIX.SHOPS WHERE NAME = 'Cats Para Dice')
       );
insert into FIX.RECEIPTS (ID, USER_ID, SHOP_ID)
values (@receipt4,
        (select ID from FIX.USERS WHERE NAME = 'CatOne'),
        (select ID from FIX.SHOPS WHERE NAME = 'Cats Para Dice')
       );
SET @shopId=(select ID from FIX.SHOPS WHERE NAME = 'Cats Para Dice');
insert into FIX.USERS_RECEIPTS(USER_ID, RECEIPTS_ID)
values (@userid,@receipt3);
insert into FIX.USERS_RECEIPTS(USER_ID, RECEIPTS_ID)
values (@userid,@receipt4);
insert into FIX.USERS_SHOPS(USER_ID, SHOPS_ID)
values (@userid,@shopId);
