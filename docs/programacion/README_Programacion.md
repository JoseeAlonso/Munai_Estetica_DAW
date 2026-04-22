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

## Validaciones implementadas

Comprobación de existencia de cliente, empleado y tratamiento
Validación de formato de fecha (YYYY-MM-DD) (Año-Mes-Día)
Validación de formato de hora (HH:MM) (Horas:Minutos)
Prevención de citas duplicadas (misma fecha, hora y empleado)

## Base de datos

La aplicación se conecta a una base de datos llamada:

munai_estetica

Tablas principales utilizadas:

clientes
citas
empleados
tratamientos

La conexión se realiza mediante JDBC en la clase:

com.munai.util.ConexionBD

## Es necesario configurar:

URL (Distinta URL por uso de localhost; puerto distinto de conexión a BBDD)
Usuario (Distinto o igual usuario)
Contraseña (Distinta o igual contraseña)

Ejemplo:

private static final String URL = "jdbc:mariadb://localhost:3308/munai_estetica";
private static final String USER = "root";
private static final String PASS = "";

## Ejecución del proyecto

Clonar el repositorio
Crear la base de datos usando los scripts de la carpeta sql/
Configurar la conexión en ConexionBD.java
Ejecutar la clase:
com.munai.main.Main

## Estructura del proyecto
src/
 ├── main/
 │    ├── java/
 │    │     ├── com.munai.main        → Clase principal
 │    │     ├── com.munai.controller  → Controlador del menú
 │    │     ├── com.munai.dao         → Acceso a datos (JDBC)
 │    │     ├── com.munai.model       → Clases del modelo (POO)
 │    │     └── com.munai.util        → Conexión a la base de datos
 
## Explicación de capas
Model → Representa las entidades (Cliente, Cita, etc.)
DAO → Acceso a la base de datos (consultas SQL)
Controller → Lógica del menú e interacción con el usuario
Main → Punto de entrada de la aplicación
Util → Gestión de conexión JDBC

## Operaciones CRUD

La aplicación implementa operaciones reales sobre la base de datos:

Create → Insertar clientes y citas
Read → Consultar clientes y citas
Filter/Search → Filtrar citas por cliente
Extra → Conteo y ordenación de datos
