# Munai_Estetica_DAW
Proyecto Intermodular 1º DAW - Centro de estética y bienestar "Munai"

## Base de Datos

La base de datos del proyecto se encuentra documentada en:

- Modelo Relacional en /docs/bbdd/modelo_relacional.md
- **README de la BBDD en /docs/bbdd/README_BBDD.md**
- Diagrama E/R en /diagramas
- Scripts SQL en /sql
  
------

## Programación (Java + JDBC)

La parte de Programación del proyecto se encuentra en la carpeta src/main/java/com/munai/, organizada en capas (controller, dao, model, util y service). La aplicación se ejecuta desde la clase Main y funciona mediante un menú por consola.

El sistema permite gestionar datos reales del centro de estética utilizando JDBC, conectándose a una base de datos MariaDB definida en el módulo de BBDD. Todas las operaciones CRUD se realizan directamente sobre la base de datos, sin uso de datos en memoria.

Las principales funcionalidades implementadas son la gestión de clientes y citas, incluyendo altas, consultas, filtros, ordenaciones y validaciones de datos. La conexión a la base de datos se gestiona en la clase ConexionBD y todas las consultas SQL se realizan mediante DAOs.

**README de Programación en /docs/MPO/README_programacion.md**

------

## MPO

La parte de MPO del proeycto se encuentra en la carpeta src/main/java/com/munai/ para pruebas del desarrollo.

La aplicación ha sido refactorizada para seguir una arquitectura en capas más completa, incorporando una capa Service entre el Controller y los DAO. Esta mejora permite que la lógica de negocio y las validaciones no se encuentren en el controlador, sino centralizadas en servicios específicos.

**README de MPO en /docs/MPO/README_MPO.md**

------

## Sistemas Informáticos (Entorno de ejecución)

La aplicación se ejecuta en un equipo de desarrollo estándar, utilizando un entorno local con MariaDB/MySQL como sistema gestor de base de datos.

El sistema no tieme implementado el uso en un servidor web, ya que funciona mediante consola, y está diseñado para ejecutarse en equipos de usuario o entornos de desarrollo con Java instalado.

Los requisitos del sistema son reducidos, siendo necesario únicamente disponer de Java JDK instalado, acceso a la base de datos y un entorno de ejecución compatible.

La configuración de la conexión a la base de datos se encuentra en la clase:

`com.munai.util.ConexionBD`

El proyecto incluye evidencias de funcionamiento en el directorio:

`/docs/sistemas_informaticos/`

donde se documenta el entorno de ejecución, requisitos, instalación y capturas del sistema en funcionamiento.
