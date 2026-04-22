# Munai_Estetica_DAW
Proyecto Intermodular 1º DAW - Centro de estética y bienestar "Munai"

## Base de Datos

La base de datos del proyecto se encuentra documentada en:

- Modelo Relacional en /docs/bbdd/modelo_relacional.md
- README de la BBDD en /docs/bbdd/README_BBDD.md
- Diagrama E/R en /diagramas
- Scripts SQL en /sql


## Programación (Java + JDBC)

La parte de Programación del proyecto se encuentra en la carpeta src/main/java/com/munai/, organizada en capas (controller, dao, model y util). La aplicación se ejecuta desde la clase Main y funciona mediante un menú por consola.

El sistema permite gestionar datos reales del centro de estética utilizando JDBC, conectándose a una base de datos MariaDB definida en el módulo de BBDD. Todas las operaciones CRUD se realizan directamente sobre la base de datos, sin uso de datos en memoria.

Las principales funcionalidades implementadas son la gestión de clientes y citas, incluyendo altas, consultas, filtros, ordenaciones y validaciones de datos. La conexión a la base de datos se gestiona en la clase ConexionBD y todas las consultas SQL se realizan mediante DAOs.

