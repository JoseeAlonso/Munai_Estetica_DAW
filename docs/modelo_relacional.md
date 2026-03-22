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
