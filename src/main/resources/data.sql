/*
 * DML SACC
 * Author: Rojas Morales Jose Daniel
 * Date: 15-09-2021
 * 
 * */
 
 -- volcando datos para el regimen fiscal
 insert into cfm.cat_regimen_fiscal values 
(601, 'Personas morales', 12), 
(612, 'Régimen actividad empresarial (régimen general)', 13),
(621, 'Régimen de incorporación fiscal (pequeños contribuyentes)', 13),
(606, 'Régimen de honorarios y arrendamiento', 13),
(111, 'Honorarios por elaboración anual', 13);
	
select * from cfm.cat_regimen_fiscal;

-- volcando datos clientes personas morales
insert into cfm.tbl_clientes values
('VAGBXX0101001', 612, 'BELEN', 'VALLE', 'GARCIA', null, null, '2018-03-27', '2021-12-10', 'A', '2381002010', null, 'balen_valle@gmail.com', null,'LAS FLORES #26 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('ASLMXX0101002', 612, 'MARIA', 'ASCENSION', 'LÓPEZ', null, null, '2014-02-11', '2021-12-10', 'A', '2381002020', null, 'lopez_asencion@gmail.com', null,'3 SUR #210 COL.MEXICO, TEHUACÁN, PUEBLA', 75700),
('CAMMXX0101003', 612, 'MARIA SOCORRO', 'CARRERO', 'MONTALVO', null, null, '2019-08-22', '2021-12-10', 'A', '2381002030', null, 'maria_soccorro_carrero@gmail.com', null,'2 NORTE #120 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('FLRSXX0101004', 612, 'SAMUEL CELESTIONO', 'FLORES', 'RIOS', null, null, '2019-12-14', '2021-12-10', 'A', '2381002040', null, 'samuel_celestion_flores@gmail.com', null,'3 NORTE, 2 ORIENTE #29 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('SEMJXX0101005', 612, 'JAIRO DOMINGO', 'SERNA', 'MERINO', null, null, '2019-12-28', '2021-12-10', 'A', '2381002050', null, 'jairo_domingo_serna@gmail.com', null,'REFORMA NORTE #234 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),

('TOM101101AG0', 601, null, null, null, 'EL TOMATE S.A. DE C.V.', null, '2008-03-27','2021-12-10', 'A', '2381002060', null, 'el_tomate@gmail.com', null, 'LAS JACARANDAS #1001 COL.OBRERO, TEHUACÁN, PUEBLA', 75700),
('CSO990325SW0', 601, null, null, null, 'CONSULTORA SOFTEH S.A. DE C.V.', null, '2008-01-31','2021-12-10', 'A', '2381002070', null, 'softeh@gmail.com', null, 'INDEPENDENCIA SUR #200 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('ASO0603119W7', 601, null, null, null, 'ABOGADOS & ASOCIADOS', null, '2008-02-05','2021-12-10', 'A', '2381002080', null, 'abogados_asociados@gmail.com', null, '32 PONIENTE #404 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('HTE000804L7A', 601, null, null, null, 'HILOS DE TEHUCAN S.A. DE C.V.', null, '2008-03-08','2021-12-10', 'A', '2381002090', null, 'hilos_tehuacan@hotmail.com', null, 'LAS JACARANDAS #04 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('SDG0209224T3', 601, null, null, null, 'SUPER DESCUENTOS GALICIA S.A. DE C.V.', null, '2008-02-20','2021-12-10', 'A', '2381002011', null, 'super_descuentos_g@prodigy.net.mx', null, '24 SUR #05 COL.CENTRO, TEHUACÁN, PUEBLA', 75700);
