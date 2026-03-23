-- Crea la base de datos
CREATE DATABASE munai_estetica;

-- Indica que BBDD se va a utilizar para la creación de tablas y consultas
USE munai_estetica;

-- Crea tabla clientes
CREATE TABLE clientes (
  id_cliente INT AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  telefono VARCHAR(20),
  email VARCHAR(100),
  direccion VARCHAR(150),
  PRIMARY KEY (id_cliente)
);

-- Crea tabla empleados
CREATE TABLE empleados (
  id_empleado INT AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  especialidad VARCHAR(100),
  telefono VARCHAR(20),
  email VARCHAR(100),
  PRIMARY KEY (id_empleado)
);

-- Crea tabla tratamientos
CREATE TABLE tratamientos(
  id_tratamiento INT AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  descripcion TEXT,
  precio DECIMAL(8,2),
  duracion INT,
  PRIMARY KEY (id_tratamiento)
);

-- Crea tabla citas con sus correspondientes FK referenciadas.
CREATE TABLE citas (
  id_cita INT AUTO_INCREMENT,
  fecha DATE NOT NULL,
  hora TIME NOT NULL,
  estado VARCHAR(25),
  id_cliente INT,
  id_empleado INT,
  id_tratamiento INT,
  PRIMARY KEY (id_cita),

  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
  FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado),
  FOREIGN KEY (id_tratamiento) REFERENCES tratamientos(id_tratamiento)
);
