/*
 * DDL SACC
 * Author: Rojas Morales Jose Daniel
 * Date: 15-09-2021
 * 
 * */
 
CREATE DATABASE sacc
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Mexico.1252'
    LC_CTYPE = 'Spanish_Mexico.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

create schema if not exists cfm

create table if not exists cfm.cat_regimen_fiscal(
	id integer not null,
	nombre_regimen varchar(100) not null,
	rfc_size integer not null,
	primary key(id)
)

create table cfm.tbl_cliente(
	rfc varchar(13),
	id_regimen_fiscal serial,
	nombre_cliente varchar(50),
	ap_paterno_cliente varchar(50),
	ap_materno_cliente varchar(50),
	razon_social varchar(100),
	fecha_ingreso date,
	last_update date,
	status char,
	telefono1 integer not null,
	telefono2 integer,
	correo varchar(100) not null,
	correo_alternativo varchar(100),
	domicilio varchar(150) not null,
	codigo_postal integer not null,
	primary key(rfc),
	constraint fk_regimen_fiscal foreign key(id_regimen_fiscal) references cfm.cat_regimen_fiscal(id)
)

create index idx_cliente_rfc on cfm.tbl_cliente(rfc);
