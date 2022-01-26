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
('ACO950926AG0', 601, null, null, null, 'ABARROTERA DE COSAMALOAPAN', '2008-03-27',current_timestamp, 'A', '2381002030', null, 'eliamoral@hotmail.com', null, 'LA FLORES #01 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('ACA870610SW0', 601, null, null, null, 'ABARROTES CADENA', '2008-01-31',current_timestamp, 'A', '2381002030', null, 'gastos.empresas@gmail.com', null, 'LA FLORES #02 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('ACS0106089W7', 601, null, null, null, 'ACSAPACK S.A. DE C. V.', '2008-02-05',current_timestamp, 'A', '2381002030', null, 'gastos.empresas@gmail.com', null, 'LA FLORES #03 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('CCA940309L7A', 601, null, null, null, 'CENTRO COMERCIAL ALMOSUR', '2008-03-08',current_timestamp, 'A', '2381002030', null, 'ccalmosur@hotmail.com', null, 'LA FLORES #04 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('CNA0701224T3', 601, null, null, null, 'CONFECCIONES NARANCO, S.A. CV.', '2008-02-20',current_timestamp, 'A', '2381002030', null, 'confeccionesnaranco@prodigy.net.mx', null, 'LA FLORES #05 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('CVT9402154C0', 601, null, null, null, 'CONSTRUCTORA DE VIVIENDA  TEHUACAN, S.A. DE C.V.', '2008-02-13',current_timestamp, 'A', '2381002030', null, 'covitesa@prodigy.net.mx', 'covitesa@outlook.com', 'LA FLORES #06 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('CCS0709047J0', 601, null, null, null, 'CASAS Y CONDOMINIOS SAJUARIL, S.A. DE C.V.', '2015-05-24',current_timestamp, 'A', '2381002030', null, 'prozootecnia@live.com.mx', 'pagosprozootecnia@gmail.com', 'LA FLORES #07 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('EES910902M77', 601, null, null, null, 'ESCUELA DE ESTUDIOS SUPERIORES DE INFORMATICA', '2008-02-11',current_timestamp, 'A', '2381002030', null, 'Jadolfo0306@hotmail.com', 'alex_andraei@hotmail.com', 'LA FLORES #08 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('ENS030605950', 601, null, null, null, 'ESCUELA NACIONAL DE SISTEMAS ABIERTOS', '2008-05-15',current_timestamp, 'A', '2381002030', null, 'sin_correo@hotmail.com', null, 'LA FLORES #09 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('FSS081218383', 601, null, null, null, 'FUNDACION SONRISAS SIN FRONTERAS', '2011-06-20',current_timestamp, 'A', '2381002030', null, 'clausnic88@hotmail.com', null, 'LA FLORES #10 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('GMJ990415SV5', 601, null, null, null, 'GRUPO MAQUILADOR JAMIR, S.A. DE C.V.', '2014-08-14',current_timestamp, 'A', '2381002030', null, 'JE__2000@hotmail.com', null, 'LA FLORES #11 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('HQP0306266WA', 601, null, null, null, 'HOTEL QUINTA POVEDA S.A. DE C.V.', '2007-03-20',current_timestamp, 'A', '2381002030', null, 'hotelquintapoveda@hotmail.com', null, 'LA FLORES #12 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('CTE010821EE8', 601, null, null, null, 'LA COMERCIAL DE TEHUACAN S.A. DE C.V.', '2008-02-19',current_timestamp, 'A', '2381002030', null, 'oscarbaral@gmail.com', null, 'LA FLORES #13 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('OCI0302265H9', 601, null, null, null, 'ORBE COMUNICACIÓN INTEGRAL', '2015-10-12',current_timestamp, 'A', '2381002030', null, 'orbecontabilidad@gmail.com', 'findesemana99@yahoo.com','LA FLORES #14 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('MCP8406142J0', 601, null, null, null, 'MOLINO CLUB PRIVADO S.A. DE C.V.', '2012-04-09',current_timestamp, 'A', '2381002030', null, 'molinoclub@hotmail.com', null, 'LA FLORES #15 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('PRO990519L87', 601, null, null, null, 'PROZOOTECNIA S.A. DE C.V.', '2008-03-06',current_timestamp, 'A', '2381002030', null, 'prozootecnia@live.com.mx', 'pagosprozootecnia@gmail.com', 'LA FLORES #16 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('PMT890428294', 601, null, null, null, 'PEQUEÑO MUNDO DE TEHUACAN, S.A. C.V.', '2014-04-28',current_timestamp, 'A', '2381002030', null, 'ofeliamartinezgil@yahoo.com', 'angie.sob21@gmail.com', 'LA FLORES #17 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('PHU980428960', 601, null, null, null, 'PORCINA EL HUIZACHE, S.A. DE C.V.', '2014-06-01',current_timestamp, 'A', '2381002030', null, 'porcina_huizache@hotmail.com', 'rodriguezcroberto@hotmail.com', 'LA FLORES #18 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('RPT0612182T0', 601, null, null, null, 'REPRESENTACIONES PECUARIAS', '2012-02-29',current_timestamp, 'A', '2381002030', null, 'gerente.repec@gmail.com', 'irmasuarez@hotmail.com', 'LA FLORES #19 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('SDC910208RI8', 601, null, null, null, 'SUPER DESCUENTOS CADENA', '2008-02-05',current_timestamp, 'A', '2381002030', null, 'gastos.empresas@gmail.com', null, 'LA FLORES #20 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('TAB020824HB8', 601, null, null, null, 'TABARATO, SA. DE C.V.', '2008-02-07',current_timestamp, 'A', '2381002030', null, 'facturas.tabarato@gmail.com', null, 'LA FLORES #21 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('TFM100615AF8', 601, null, null, null, 'TRANSPORTES Y FLETES MAVE, S.A. DE C.V.', '2010-09-25',current_timestamp, 'A', '2381002030', null, 'transportesyfletesmave@hotmail.com', null, 'LA FLORES #22 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('TJO990616T92', 601, null, null, null, 'TRANSPORTES JOJOMA', '2008-01-31',current_timestamp, 'A', '2381002030', null, 'ggrjuana@gmail.com', null, 'LA FLORES #23 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('CON1407011I9', 601, null, null, null, 'CONSTRUGASA S.A. DE C.V.', '2019-02-19',current_timestamp, 'A', '2381002030', null, 'oeguerra54@prodigy.net.mx', null, 'LA FLORES #24 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('CFM110309GTA', 601, null, null, null, 'CORPORATIVO FISCAL MAGNO, S.A. DE C.V.', '2011-06-29',current_timestamp, 'A', '2381002030', null, 'corporativofiscalmagno@gmail.com ', null, 'LA FLORES #25 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
 -- personas fisicas
('XXXXXXXXXXXX1', 612, 'VICTORIA', 'ACOSTA', 'MARTINEZ', null, '2018-03-27',current_timestamp, 'A', '2381002030', null, 'sin_correo@gmail.com', null,'LA FLORES #26 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('CAOP440707JZ0', 612, 'PILAR AMALIA', 'CARVAJAL', 'OLMOS', null, '2014-02-11',current_timestamp, 'A', '2381002030', null, 'pilarcarvajal07@hotmail.com', null,'LA FLORES #27 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('COPA730710EI2', 612, 'AMALIA CARMEN', 'CORTEZ', 'PEREA', null, '2019-08-22',current_timestamp, 'A', '2381002030', null, 'sin_correo@gmail.com', null,'LA FLORES #28 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('GALA950215GP7', 612, 'ALFONSO MIGUEL', 'GARCIA', 'LOPEZ', null, '2019-12-14',current_timestamp, 'A', '2381002030', null, 'facturasmar3@gmail.com', null,'LA FLORES #29 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('GAVJ661026BT5', 612, 'MARIA DE JESUS MARICELA', 'GARRIDO', 'VELASCO', null, '2019-12-28',current_timestamp, 'A', '2381002030', null, 'marichugarrido66@gmail.com', null,'LA FLORES #30 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('HEAR4703165H1', 612, 'RICARDO JOSE OCTAVIO', 'HERRERO', 'ARANDIA', null, '2012-05-22',current_timestamp, 'A', '2381002030', null, 'covitesa@prodigy.net.mx', null,'LA FLORES #31 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('HEAS6012118V9', 612, 'SALVADOR', 'HERMOSO', 'SALVADOR', null, '2008-12-01',current_timestamp, 'A', '2381002030', null, 'prozootecnia@live.com.mx', 'pagosprozootecnia@gmail.com','LA FLORES #32 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('LOMA590224MS5', 612, 'ANGEL', 'LOPEZ', 'MEZA', null, '2008-03-07',current_timestamp, 'A', '2381002030', null, 'sin_correo@gmail.com', null,'LA FLORES #33 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('LEFA590306S21', 612, 'JOSE ADOLFO', 'LEYVA', 'FLORES', null, '2008-02-11',current_timestamp, 'A', '2381002030', null, 'Jadolfo0306@hotmail.com', 'alex_andraei@hotmail.com','LA FLORES #34 COL.CENTRO, TEHUACÁN, PUEBLA', 75700),
('MOSD600804CA1', 612, 'DOMINGO PACIANO', 'MORAL', 'SOLANO', null, '2008-01-15',current_timestamp, 'A', '2381002030', null, 'domingo_04710@hotmail.com', null,'LA FLORES #35 COL.CENTRO, TEHUACÁN, PUEBLA', 75700);

select * from cfm.tbl_clientes;