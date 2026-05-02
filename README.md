# Munai_Estetica_DAW
Proyecto Intermodular 1º DAW - Centro de estética y bienestar "Munai"

## ¿Qué es este proyecto?

Munai Estética es un proyecto intermodular desarrollado en Java que simula la gestión de una empresa ficticia de estética y bienestar.  

Se trata de una aplicación de consola que permite administrar clientes, empleados, tratamientos y citas mediante el uso de una base de datos relacional.

El proyecto integra conocimientos de programación, bases de datos, desarrollo de la página web y buenas prácticaso, siguiendo una arquitectura por capas.

---

## ¿Qué problema resuelve / para qué sirve?

Este sistema resuelve la necesidad de organizar la información y la operativa de un centro de estética, permitiendo:

- Gestionar clientes de forma estructurada  
- Registrar y consultar citas  
- Relacionar empleados con tratamientos  
- Evitar errores como citas duplicadas o datos inválidos  
- Centralizar toda la información en una base de datos  

En esencia, simula un sistema real de gestión empresarial a pequeña escala.

Además, permite la interacción con el usuario (por los momentos mediante consola y conexión a la BBDD) con la creación de una página web donde permite:

- Gestionar citas
- Conocer tratamientos y especialistas
- Contacto con la empresa

---

## Tecnologías utilizadas

- **Java** -> Lenguaje principal del proyecto  
- **Maven** -> Gestión de dependencias y estructura del proyecto  
- **MariaDB** -> Sistema de gestión de base de datos  
- **JDBC** -> Conexión entre Java y la base de datos
- **HTML y CSS** -> Página web del centro de estética
- **IntelliJ IDEA** -> Entorno de desarrollo  
- **Git & GitHub** -> Control de versiones  

---

## Instalación y ejecución

### 1. Clonar el repositorio

```bash
https://github.com/JoseeAlonso/Munai_Estetica_DAW.git
```

------

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

**`/docs/sistemas_informaticos/`**

donde se documenta el entorno de ejecución, requisitos, instalación y capturas del sistema en funcionamiento.

------

## Lenguaje de Marcas

El portal web de Munai es la parte visible del proyecto. 

Está construido únicamente con HTML5 y CSS3, con un pequeño JS para la creación de la "hamburger", que despliega las demás secciones cuando la pantalla se hace mas pequeña.
 
El README específico de la asignatura de Lenguajes de Marcas se encuentra en:
**/docs/LM/README_LM.md**

------

## Itinerario Personal para la Empleabilidad

## Archivos incluidos
 
### 01_perfil_profesional.md
Presentación personal como futuro profesional del desarrollo web. Incluye qué estoy estudiando, qué tecnologías estoy aprendiendo, qué tipo de proyectos me interesan y qué me motiva.
 
### 02_presentacion_proyecto.md
Descripción del proyecto Munai orientada a empleabilidad: qué es, qué problema resuelve, para quién está pensado, qué tecnologías usa y qué habilidades demuestra.
 
### 03_portfolio.md
Muestra del proyecto con su estructura, instrucciones para abrirlo y un resumen de lo aprendido durante su desarrollo.
 
### 04_reflexion_final.md
Reflexión personal y sincera sobre el proceso: qué he aprendido, qué se me ha dado mejor, qué me ha costado más y qué mejoraría.
La web nace de un concepto real: el emprendimiento de una esteticista y fisioterapeuta que busca ofrecer tratamientos de calidad en un entorno cercano y profesional. El diseño refleja esa identidad con una paleta de verdes oliva y dorados, tipografía serif elegante y un estilo limpio y relajante.

Todo lo referido a esto, lo puede encontrar en la dirección:

**docs/empleabilidad/**

**El README.md con una breve explicación del desarrollo se encuentra en la carpeta docs/LM/README_LM.md**
