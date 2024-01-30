DROP TABLE IF EXISTS BAD.BAD_DISLIKES_RELATIONS;

DROP TABLE IF EXISTS BAD.USERS;

DROP TABLE IF EXISTS BAD.RECEIPTS;

DROP TABLE IF EXISTS BAD.SHOPS;

CREATE SCHEMA IF NOT EXISTS BAD;

CREATE TABLE IF NOT EXISTS BAD.BAD_DISLIKES_RELATIONS
(
    id UUID NOT NULL DEFAULT random_uuid() PRIMARY KEY,
    user_id   UUID NOT NULL,
    shop_id   UUID NOT NULL,
    receipt_id   UUID NOT NULL
);

CREATE TABLE IF NOT EXISTS BAD.USERS
(
    id UUID NOT NULL DEFAULT random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS BAD.RECEIPTS
(
    id UUID NOT NULL DEFAULT random_uuid() PRIMARY KEY,
    user_id UUID,
    shop_id UUID
);

CREATE TABLE IF NOT EXISTS BAD.SHOPS
(
    id UUID NOT NULL DEFAULT random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
