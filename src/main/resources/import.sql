/* Populate tables */
INSERT INTO usuarios (name, email, password, created, modified, last_login,is_active) VALUES('Andres', 'Guzman', 'mail1@prueba.com', '2019-08-01', '2019-08-01', '2019-08-01',1);
INSERT INTO usuarios (name, email, password, created, modified, last_login,is_active) VALUES('Juan', 'Perez', 'mail2@prueba.com', '2019-08-02', '2019-08-02', '2019-08-02',1);

/* Creamos telefonos */
INSERT INTO telefonos (number, city_code, contry_code, usuario_id) VALUES('1234', '1','57', 1);
INSERT INTO telefonos (number, city_code, contry_code, usuario_id) VALUES('1235', '1','57', 1);

