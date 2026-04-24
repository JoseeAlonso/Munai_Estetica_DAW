# Informe Técnico del Entorno de Ejecución
## Proyecto: MUNAI - Centro de Estética

---

## 1. Tipo de sistema donde se ejecuta la aplicación

La aplicación está diseñada para ejecutarse en un entorno de **PC de usuario local**, ya que se trata de una aplicación de escritorio basada en Java que funciona mediante consola.

También puede ser ejecutada en un entorno de desarrollo o servidor local, siempre que disponga de Java instalado y acceso a la base de datos MariaDB/MySQL creada.

Este tipo de arquitectura es adecuada porque:
- Funciona de forma local
- Depende de conexión a base de datos local o remota

---

## 2. Requisitos de hardware

### Requisitos mínimos
- CPU: Intel i3 o equivalente
- RAM: 4 GB
- Almacenamiento: 200 MB libres
- Red: conexión local a base de datos (opcional si es remota)

### Requisitos recomendados
- CPU: Intel i5 o superior
- RAM: 8 GB
- Almacenamiento: 500 MB libres
- SSD recomendado para mejor rendimiento

---

## 3. Sistema operativo recomendado

- Windows 10 / Windows 11 (recomendado)
- Compatible también con Linux (Ubuntu 20.04 o superior)

Se recomienda Windows por facilidad de instalación de Java, MariaDB y herramientas de desarrollo utilizadas en el entorno de aprendizaje.

**De igual manera se recomienda Windows ya que fue el SO utilizado para el desarrollo completo del proyecto.**

---

## 4. Instalación del entorno

Para ejecutar la aplicación se deben seguir los siguientes pasos:

1. Instalar Java JDK (versión 17 o superior)
2. Instalar un gestor de base de datos (MariaDB o MySQL). Se utilizó Xampp con conexion a phpmyadmin.
3. Importar la base de datos usando los scripts incluidos en `/sql`
4. Configurar la conexión en la clase:

com.munai.util.ConexionBD

5. Importar el proyecto en un IDE (IntelliJ, Eclipse, Visual Studio Code o similar)
6. Ejecutar la clase principal:

com.munai.main.Main


---

## 5. Usuarios, permisos y estructura

### Usuarios del sistema
- Usuario administrador del sistema (acceso completo desde consola)
- Usuario de base de datos (root o usuario configurado)

### Permisos
- Acceso completo a operaciones CRUD
- Lectura y escritura en todas las tablas

### Estructura de datos
- Base de datos: `munai_estetica`
- Tablas principales:
- clientes
- citas
- empleados
- tratamientos

### Almacenamiento
- Los datos se almacenan directamente en la base de datos relacional
- No se utilizan ficheros locales para persistencia

---

## 6. Mantenimiento del sistema

- Actualización de dependencias (Java, driver JDBC)
- Revisión de la base de datos y su integridad
- Backup periódico de la base de datos (recomendado semanalmente)
- Revisión de logs en caso de errores de conexión

En caso de fallo:
- Verificar conexión a la base de datos
- Revisar credenciales en `ConexionBD`
- Comprobar que el servidor MariaDB esté activo

---

## 7. Evidencias de funcionamiento

La aplicación ha sido probada en entorno local y funciona correctamente:

- Arranque correcto desde `Main.java`
- Conexión exitosa a base de datos
- Ejecución del menú por consola
- Operaciones CRUD funcionales

Se adjuntan capturas en la carpeta:

/docs/sistemas/capturas/

## 8. Conclusión

El sistema está preparado para ejecutarse en un entorno local de desarrollo o producción ligera, con requisitos bajos y configuración sencilla como parte de mi desarrollo profesional.
