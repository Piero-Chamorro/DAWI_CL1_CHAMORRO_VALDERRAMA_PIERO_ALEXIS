-- borra la bd si existe
DROP DATABASE IF EXISTS T5DJ;
-- creamos la bd
CREATE DATABASE T5DJ;
-- activamos la bd
USE T5DJ;

-- CREANDO LA TABLA
CREATE TABLE tb_pelicula(
cod_pel  int auto_increment,
nom_pel varchar(30) not null,
gen_pel varchar(50) not null,
fes_pel  date  not null,
sin_pel varchar(250) not null,
act_pel varchar(250) not null,
primary key (cod_pel)
);

-- Insertamos datos
insert into tb_pelicula values (null,'Súper Can','Acción','2021-12-24','Un perro comio un hueso radioactivo el cual le dio superpoderes.','Juan Aguilar, Francisco Meche, Diana Rose');
insert into tb_pelicula values (null,'Súper Cat','Acción','2023-10-12','Un gato comio un pescado radioactivo el cual le dio superpoderes.','Pipo Pancho, Juan Jara, Rita Rina');

-- consultas
SELECT * FROM tb_pelicula;




