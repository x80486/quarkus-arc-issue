--
-- SCHEMA SETUP
--
-- create extension if not exists "uuid-ossp"; -- Only when using PostgreSQL


--
-- CREATE TABLE STATEMENT(S)
--
create table actors (
  id         uuid not null default random_uuid(), -- Use uuid_generate_v4() instead when using PostgreSQL
  first_name character varying(45),
  last_name  character varying(45),
  updated_at timestamp without time zone not null default now()::timestamp,

  primary key (id)
);
