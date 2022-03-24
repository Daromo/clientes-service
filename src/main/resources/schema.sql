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

create table if not exists cfm.tbl_clientes(
	rfc varchar(13),
	id_regimen_fiscal serial,
	nombre_cliente varchar(50),
	ap_paterno_cliente varchar(50),
	ap_materno_cliente varchar(50),
	razon_social varchar(100),
	nombre_largo varchar(150),
	fecha_ingreso date not null,
	last_update date,
	status char,
	telefono1 varchar(20) not null,
	telefono2 varchar(20),
	correo varchar(100) not null,
	correo_alternativo varchar(100),
	domicilio varchar(150) not null,
	codigo_postal integer not null,
	primary key(rfc),
	constraint fk_regimen_a_clientes foreign key(id_regimen_fiscal) references cfm.cat_regimen_fiscal(id)
)

create index idx_cliente_rfc on cfm.tbl_clientes(rfc);

/*********************************************************************************************************************/
CREATE OR REPLACE FUNCTION func_nombre_largo() 
	RETURNS TRIGGER 
    AS $$
	BEGIN
		if new.id_regimen_fiscal = 601 then
			update cfm.tbl_clientes
			set nombre_largo = new.razon_social
			where rfc = new.rfc;
		else
			update cfm.tbl_clientes
			set nombre_largo = concat(new.ap_paterno_cliente,' ',new.ap_materno_cliente,' ', new.nombre_cliente)
			where rfc = new.rfc;
		end if;
	return NEW;
	END;
$$  LANGUAGE plpgsql

CREATE TRIGGER trigg_nombre_largo
	AFTER INSERT
	ON cfm.tbl_clientes
	FOR EACH ROW
	EXECUTE PROCEDURE func_nombre_largo();

/*********************************************************************************************************************/
CREATE OR REPLACE FUNCTION func_update_nombre_largo() 
	RETURNS TRIGGER 
    AS $$
	BEGIN
		if new.id_regimen_fiscal = 601 then
			new.nombre_largo = new.razon_social;
		else
			new.nombre_largo = concat(new.ap_paterno_cliente,' ',new.ap_materno_cliente,' ', new.nombre_cliente);
		end if;
	return NEW;
	END;
$$  LANGUAGE plpgsql

CREATE TRIGGER trigg_update_nombre_largo
	BEFORE UPDATE
	ON cfm.tbl_clientes
	FOR EACH ROW 
	EXECUTE PROCEDURE func_update_nombre_largo();
/*********************************************************************************************************************/