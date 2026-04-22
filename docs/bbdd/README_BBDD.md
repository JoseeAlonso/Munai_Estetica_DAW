# Base de Datos - Centro de Estética Munai

# Descripción

Esta base de datos modela el funcionamiento interno del negocio, permitiendo gestionar clientes, empleados, tratamientos y citas.

## Tipo de empresa

Munai es un centro de estética que ofrece distintos tratamientos como masajes, limpieza facial y sesiones de sauna.

## Análisis de datos

El sistema gestiona la siguiente información:

Clientes
Empleados
Tratamientos
Citas

## Entidades y atributos

### Clientes
id_cliente (PK)
nombre
telefono
email
direccion

### Empleados
id_empleado (PK)
nombre
especialidad
telefono
email

### Tratamientos
id_tratamiento (PK)
nombre
descripcion
precio
duracion

### Citas
id_cita (PK)
fecha
hora
estado
id_cliente (FK)
id_empleado (FK)
id_tratamiento (FK)

## Relaciones
Un cliente puede tener varias citas.
Un empleado puede atender múltiples citas.
Un tratamiento puede ser reservado en muchas citas.

Las relaciones se implementan mediante claves foráneas en la tabla citas.

## Modelo relacional

La base de datos está compuesta por las siguientes tablas:

clientes
empleados
tratamientos
citas

Todas las tablas están normalizadas y relacionadas mediante claves primarias y foráneas.

## Implementación

La base de datos ha sido implementada en XAMPP con MariaDb mediante scripts SQL que incluyen:

Creación de la base de datos (CREATE DATABASE)
Creación de tablas (CREATE TABLE)
Inserción de datos (INSERT INTO)
Consultas de explotación de datos (SELECT)
