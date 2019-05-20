
CREATE TABLE usuarios (
idUsuario INT NOT NULL PRIMARY KEY,
nombreUsuario VARCHAR(10) NOT NULL,
codigoUsuario VARCHAR(8) NOT NULL
);

CREATE TABLE clientes (
idCliente INT NOT NULL AUTO_INCREMENT,
nombreCliente VARCHAR(10) NOT NULL,
cedulaCliente VARCHAR(10) NOT NULL,
PRIMARY KEY (idCliente)
);

CREATE TABLE Articulos (
idArticulo INT NOT NULL AUTO_INCREMENT,
codigo BIGINT NOT NULL,
nombre VARCHAR(15) NOT NULL,
descripcion VARCHAR(30) NOT NULL,
cantidad INTEGER NOT NULL,
precio DECIMAL(10,2) NOT NULL,
PRIMARY KEY (idArticulo)
);

CREATE TABLE Ventas (
idVenta INT NOT NULL AUTO_INCREMENT,
idArticulo INT NOT NULL,
idCliente INT NOT NULL,
idUsuario INT NOT NULL,
fecha DATE NOT NULL,
PRIMARY KEY(idVenta),
CONSTRAINT ventas_usuario_fk FOREIGN KEY (idUsuario) REFERENCES usuarios(idUsuario),
CONSTRAINT ventas_clientes_fk FOREIGN KEY (idCliente) REFERENCES clientes(idCliente),
CONSTRAINT ventas_articulos_fk FOREIGN KEY (idArticulo) REFERENCES Articulos(idArticulo)
);


CREATE TABLE ordenesdecompras(
    id_orden int not null AUTO_INCREMENT PRIMARY KEY,
    numeroorden VARCHAR(10) NOT NULL DEFAULT 'n/a',
    codigo BIGINT NOT NULL,
    nombre VARCHAR(15) NOT NULL,
    descripcion VARCHAR(30) NOT NULL,
    cantidad INTEGER NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    estado varchar(10) DEFAULT 'HAY',
    nombreCliente VARCHAR(20) NOT NULL,
    cedulaCliente VARCHAR(20) NOT NULL
);


CREATE TABLE RegistroAcceso(
idRegistroAcceso int not null AUTO_INCREMENT,
registroAccesoNombre VARCHAR(20),
registroAccesoHoraInicial DATETIME,
registroAccesoHoraFin DATETIME,
duracionConeccion VARCHAR(20),
primary key(idRegistroAcceso)
);


