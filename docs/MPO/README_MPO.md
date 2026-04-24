# MPO - Ampliación de Programación

La aplicación está estructurada siguiendo una arquitectura en capas que mejora la organización del código y la separación de responsabilidades.

## Tecnologías utilizadas

Java  
JDBC (Java Database Connectivity)  
MariaDB / MySQL  
Programación orientada a objetos (POO)

## Arquitectura del proyecto

El proyecto está dividido en las siguientes capas:

- Controller -> Interacción con el usuario mediante menú por consola
- Service -> Lógica de negocio y validaciones
- DAO -> Acceso a la base de datos mediante JDBC
- Model -> Clases que representan las entidades del sistema
- Util -> Gestión de la conexión a la base de datos

## Mejora implementada (MPO)

Como mejora respecto al módulo de Programación, se ha añadido una capa de servicios (Service).

El controlador ya no accede directamente a los DAO, sino que la lógica de negocio y validaciones se gestionan en la capa Service.

El flujo de la aplicación es:

Controller → Service → DAO → Base de Datos

Esto mejora la organización del código, reduce el acoplamiento y facilita futuras ampliaciones del sistema.

## Validaciones y lógica centralizada

La capa Service se encarga de:

- Validación de datos de entrada
- Comprobación de existencia de clientes, empleados y tratamientos
- Control de formatos de fecha y hora
- Prevención de citas duplicadas

## Diagrama simple de clases 

- MenuController → ClienteService, CitaService, EmpleadoService, TratamientoService  
- Services → DAOs correspondientes  
- DAOs → Base de datos  
- Models → Entidades del sistema  

## Objetivo del MPO

El objetivo de este módulo es mejorar la calidad del diseño del software, aplicando una arquitectura más profesional basada en separación de responsabilidades, buenas prácticas de POO y código mantenible.
