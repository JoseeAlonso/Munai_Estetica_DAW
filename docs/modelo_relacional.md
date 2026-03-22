# Modelo Relacional - Proyecto Munai

El modelo relacional representa la estructura de la base de datos en forma de tablas.
Cada entidad del diagrama E/R se transforma en una tabla, con sus atributos convertidos en columnas.

Además, se definen las claves primarias (PK) y las claves foráneas (FK) para mantener las relaciones entre tablas.


## Tabla: clientes
| Campo | Tipo | Descripción |
|------|------|-------------|
| id_cliente | INT | Identificador único del cliente (PK) |
| nombre | VARCHAR(100) | Nombre del cliente |
| telefono | VARCHAR(20) | Teléfono de contacto |
| email | VARCHAR(100) | Correo electrónico |
| direccion | VARCHAR(150) | Dirección del cliente |

### Claves:
PK -> id_cliente


## Tabla: empleados
| Campo | Tipo | Descripción |
|------|------|-------------|
| id_empleado | INT | Identificador del empleado (PK) |
| nombre | VARCHAR(100) | Nombre del empleado |
| especialidad | VARCHAR(100) | Especialidad estética |
| telefono | VARCHAR(20) | Teléfono |
| email | VARCHAR(100) | Correo electrónico |

### Claves:
PK -> id_empleado


## Tabla: tratamientos
| Campo | Tipo | Descripción |
|------|------|-------------|
| id_tratamiento | INT | Identificador del tratamiento (PK) |
| nombre | VARCHAR(100) | Nombre del tratamiento |
| descripcion | TEXT | Descripción del tratamiento |
| precio | DECIMAL(8,2) | Precio del tratamiento |
| duracion | INT | Duración en minutos |

### Claves:
PK -> id_tratamiento


## Tabla: citas
| Campo | Tipo | Descripción |
|------|------|-------------|
| id_cita | INT | Identificador de la cita (PK) |
| fecha | DATE | Fecha de la cita |
| hora | TIME | Hora de la cita |
| estado | VARCHAR(50) | Estado de la cita (confirmada, cancelada, etc.) |
| id_cliente | INT | Cliente que reserva (FK) |
| id_empleado | INT | Empleado que realiza el tratamiento (FK) |
| id_tratamiento | INT | Tratamiento reservado (FK) |

### Claves:
PK -> id_cita

FK -> id_cliente -> clientes(id_cliente)
FK -> id_empleado -> empelados(id_empelado)
FK -> id_tratamiento -> tratamientos(id_tratamiento)



## Relaciones entre tablas

clientes (1) -- (N) citas
Un cliente puede tener muchas citas

empelados (1) -- (N) citas
Un empleado puede realizar muchas citas

tratamientos (1) -- (N) citas
Un tratamiento puede estar presente en muchas citas
