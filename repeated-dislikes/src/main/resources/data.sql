insert into BAD.USERS (ID, NAME)
values (random_uuid(), 'Liking Cat 1');
insert into BAD.SHOPS (ID, NAME)
values (random_uuid(), 'Cats Para Dice');
SET @receipt1=random_uuid();
SET @receipt2=random_uuid();
insert into BAD.RECEIPTS (ID, USER_ID, SHOP_ID)
values (@receipt1,
        (select ID from BAD.USERS WHERE NAME = 'Liking Cat 1'),
        (select ID from BAD.SHOPS WHERE NAME = 'Cats Para Dice')
       );
insert into BAD.BAD_DISLIKES_RELATIONS (ID, USER_ID, SHOP_ID, RECEIPT_ID)
values (random_uuid(),
        (select ID from BAD.USERS WHERE NAME = 'Liking Cat 1'),
        (select ID from BAD.SHOPS WHERE NAME = 'Cats Para Dice'),
        @receipt1
       );

insert into BAD.BAD_DISLIKES_RELATIONS (ID, USER_ID, SHOP_ID, RECEIPT_ID)
values (random_uuid(),
        (select ID from BAD.USERS WHERE NAME = 'Liking Cat 1'),
        (select ID from BAD.SHOPS WHERE NAME = 'Cats Para Dice'),
        @receipt2
       );
