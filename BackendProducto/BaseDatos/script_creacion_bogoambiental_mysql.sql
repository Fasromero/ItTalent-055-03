-- Database: bogoambiental

-- DROP DATABASE bogoambiental;
create database bogoambiental;
use bogoambiental;
CREATE TABLE rol (
	idrol int NOT NULL auto_increment,
	nombre varchar(30) NOT NULL UNIQUE,
	CONSTRAINT rol_pk PRIMARY KEY (idrol)
);

CREATE TABLE usuario (
	idusuario int not null auto_increment ,
	idrol int NOT NULL,
	nombre varchar(50) NOT NULL,
	apellido varchar(50),
	correo varchar(50) NOT NULL UNIQUE,
	clave varchar(32) NOT NULL,
	imgperfil blob,
	paginaweb varchar(50) UNIQUE,
	direccion varchar(50) UNIQUE,
	telfijo varchar(7) UNIQUE,
	celular varchar(10) UNIQUE,
	fecharegistro DATE NOT NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (idusuario));

CREATE TABLE tipopublicacion (
	idtipopublicacion int NOT NULL auto_increment,
	nombre varchar(30) NOT NULL UNIQUE,
	CONSTRAINT tipopublicacion_pk PRIMARY KEY (idtipopublicacion)
);


CREATE TABLE humedal (
	idhumedal int NOT NULL auto_increment,
	idlocalidad int NOT NULL,
	nombre varchar(50) NOT NULL UNIQUE,
	descripcion varchar(50) NOT NULL,
	imghumedal blob,
	latitud DECIMAL NOT NULL,
	longitud DECIMAL NOT NULL,
	CONSTRAINT humedal_pk PRIMARY KEY (idhumedal)
);

CREATE TABLE publicacion (
	idpublicacion int NOT NULL auto_increment,
	idusuario int NOT NULL,
	fechahora timestamp NOT NULL,
	titulo varchar(30),
	contenido varchar(500),
	idtipopublicacion int NOT NULL,
	idhumedal int NOT NULL,
	tags varchar(50),
	idestadopublicacion int NOT NULL,
	idpublicacionpadre int NOT NULL,
	puntaje int,
	CONSTRAINT publicacion_pk PRIMARY KEY (idpublicacion));


CREATE TABLE localidad (
	idlocalidad int NOT NULL primary key auto_increment,
	nombre varchar(18) NOT NULL UNIQUE);

CREATE TABLE estadopublicacion (
	idestadopublicacion int NOT NULL auto_increment,
	descripcion varchar(30) NOT NULL,
	CONSTRAINT estadopublicacion_pk PRIMARY KEY (idestadopublicacion));



CREATE TABLE reaccionpublicacion (
	idpublicacion int NOT NULL,
	idusuario int NOT NULL,
	idtiporeaccion int NOT NULL,
	puntajeobtenido int,
	fechahora timestamp NOT NULL,
	CONSTRAINT reaccionpublicacion_pk PRIMARY KEY (idpublicacion,idusuario)
);


CREATE TABLE detallepublicacion (
	iddetallepublicacion int NOT NULL auto_increment,
	idpublicacion integer NOT NULL,
	nombre varchar(50),
	contenido blob,
	url varchar(50),
	CONSTRAINT detallepublicacion_pk PRIMARY KEY (iddetallepublicacion));



CREATE TABLE tiporeaccion (
	idtiporeaccion int NOT NULL auto_increment,
	nombre varchar(30) NOT NULL,
	icono blob NOT NULL,
	CONSTRAINT tiporeaccion_pk PRIMARY KEY (idtiporeaccion)
);


ALTER TABLE usuario ADD CONSTRAINT usuario_fk0 FOREIGN KEY (idrol) REFERENCES rol(idrol) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE humedal ADD CONSTRAINT humedal_fk0 FOREIGN KEY (idlocalidad) REFERENCES localidad(idlocalidad) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE publicacion ADD CONSTRAINT publicacion_fk0 FOREIGN KEY (idusuario) REFERENCES usuario(idusuario) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE publicacion ADD CONSTRAINT publicacion_fk1 FOREIGN KEY (idtipopublicacion) REFERENCES tipopublicacion(idtipopublicacion) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE publicacion ADD CONSTRAINT publicacion_fk2 FOREIGN KEY (idhumedal) REFERENCES humedal(idhumedal) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE publicacion ADD CONSTRAINT publicacion_fk3 FOREIGN KEY (idestadopublicacion) REFERENCES estadopublicacion(idestadopublicacion) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE publicacion ADD CONSTRAINT publicacion_fk4 FOREIGN KEY (idpublicacionpadre) REFERENCES publicacion(idpublicacion) ON UPDATE CASCADE ON DELETE CASCADE;



ALTER TABLE reaccionpublicacion ADD CONSTRAINT reaccionpublicacion_fk0 FOREIGN KEY (idpublicacion) REFERENCES publicacion(idpublicacion) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE reaccionpublicacion ADD CONSTRAINT reaccionpublicacion_fk1 FOREIGN KEY (idusuario) REFERENCES usuario(idusuario) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE reaccionpublicacion ADD CONSTRAINT reaccionpublicacion_fk2 FOREIGN KEY (idtiporeaccion) REFERENCES tiporeaccion(idtiporeaccion) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE detallepublicacion ADD CONSTRAINT detallepublicacion_fk0 FOREIGN KEY (idpublicacion) REFERENCES publicacion(idpublicacion) ON UPDATE CASCADE ON DELETE CASCADE;
