CREATE SCHEMA IF NOT EXISTS BAD;

CREATE SCHEMA IF NOT EXISTS BADFIX;

CREATE SCHEMA IF NOT EXISTS FIX;

DROP TABLE IF EXISTS BAD.BAD_DISLIKES_RELATIONS;

DROP TABLE IF EXISTS BAD.USERS;

DROP TABLE IF EXISTS BAD.RECEIPTS;

DROP TABLE IF EXISTS BAD.SHOPS;

DROP TABLE IF EXISTS FIX.USERS_SHOPS;

DROP TABLE IF EXISTS FIX.USERS;

DROP TABLE IF EXISTS FIX.RECEIPTS;

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


CREATE TABLE IF NOT EXISTS BADFIX.BAD_DISLIKES_RELATIONS
(
    id UUID NOT NULL DEFAULT random_uuid() PRIMARY KEY,
    user_id   UUID NOT NULL,
    shop_id   UUID NOT NULL,
    receipt_id   UUID NOT NULL
);

CREATE TABLE IF NOT EXISTS BADFIX.USERS
(
    id UUID NOT NULL DEFAULT random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS BADFIX.RECEIPTS
(
    id UUID NOT NULL DEFAULT random_uuid() PRIMARY KEY,
    user_id UUID,
    shop_id UUID
);

CREATE TABLE IF NOT EXISTS BADFIX.SHOPS
(
    id UUID NOT NULL DEFAULT random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


-- Fix tables


CREATE TABLE IF NOT EXISTS FIX.USERS
(
    id UUID NOT NULL DEFAULT random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS FIX.RECEIPTS
(
    id UUID NOT NULL DEFAULT random_uuid() PRIMARY KEY,
    user_id UUID,
    shop_id UUID
);

CREATE TABLE IF NOT EXISTS FIX.SHOPS
(
    id UUID NOT NULL DEFAULT random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


CREATE VIEW IF NOT EXISTS FIX.USERS_SHOPS AS
SELECT DISTINCT r.user_id, r.shop_id as shops_id from FIX.RECEIPTS AS r;
