# MUNAI - Gestión de Centro de Estética

La aplicación permite realizar operaciones sobre la base de datos, como gestión de clientes, citas o tratamientos, simulando el funcionamiento interno de la empresa.

## Tecnologías utilizadas

Java
JDBC (Java Database Connectivity)
MariaDB / MySQL
Programación orientada a objetos (POO)

## Funcionalidades

La aplicación funciona mediante un menú por consola que permite al usuario interactuar con el sistema.

## Gestión de clientes
Ver listado de clientes
Insertar nuevos clientes en la base de datos
Validación de existencia de cliente

## Gestión de citas

Ver listado completo de citas (con joins entre tablas)
Crear nuevas citas
Contar el número total de citas
Filtrar citas por cliente
Ordenar citas por fecha

## Validaciones implementadas en la capa Service

Comprobación de existencia de cliente, empleado y tratamiento (entidades)
Validación de formato de fecha (YYYY-MM-DD) (Año-Mes-Día)
Validación de formato de hora (HH:MM) (Horas:Minutos)
Prevención de citas duplicadas (misma fecha, hora y empleado)

## Base de datos

La aplicación se conecta a una base de datos llamada:

munai_estetica

Tablas principales utilizadas:

- clientes
- citas
- empleados
- tratamientos

La conexión se realiza mediante JDBC en la clase:

com.munai.util.ConexionBD

## Es necesario configurar:

- URL (Distinta URL por uso de localhost; puerto distinto de conexión a BBDD)
- Usuario (Distinto o igual usuario)
- Contraseña (Distinta o igual contraseña)

Ejemplo:

- private static final String URL = "jdbc:mariadb://localhost:3308/munai_estetica";
- private static final String USER = "root";
- private static final String PASS = "";

## Ejecución del proyecto

1. Clonar el repositorio
2. Crear la base de datos usando los scripts de la carpeta sql/
3. Configurar la conexión en ConexionBD.java
4. Ejecutar la clase: com.munai.main.Main

## Estructura del proyecto
src/
 ---main/
--------java/
---------------com.munai.main        -> Clase principal
---------------com.munai.controller  -> Controlador del menú
---------------com.munai.service     -> Lógica de negocio y validaciones
---------------com.munai.dao         -> Acceso a datos (JDBC)
---------------com.munai.model       -> Clases del modelo (POO)
---------------com.munai.util        -> Conexión a la base de datos
 
## Explicación de capas
- Model -> Representa las entidades (Cliente, Cita, etc.)
- DAO -> Acceso a la base de datos (consultas SQL)
- Controller-> Interacción con el usuario (menú por consola)
- Service -> Lógica de negocio y validaciones
- Main -> Punto de entrada de la aplicación
- Util -> Gestión de conexión JDBC

## Operaciones CRUD

La aplicación implementa operaciones reales sobre la base de datos:

Create -> Insertar clientes y citas
Read -> Consultar clientes y citas
Filter/Search -> Filtrar citas por cliente
Extra -> Conteo y ordenación de datos

## Arquitectura 

El proyecto está desarrollado mediante una arquitectura por capas:

Controller -> Service -> DAO -> Base de Datos

Esto permite aislar las responsabilidades, mejorando la mantenibilidad y facilitando futuras ampliaciones.
