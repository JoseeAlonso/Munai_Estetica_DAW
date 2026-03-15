# Análisis de datos - Munai Estética y Bienestar

Munai es una empresa ficticia dedicada a ofrecer tratamientos de estética y bienestar.
Los clientes pueden reservar diferentes tramatientos realizados por especialistas del centro.

El sistema permite gestionar:

- Clientes
- Empleados
- Tratamientos estéticos
- Citas o reservas de tratamientos

Cada cliente puede reservar uno o varios tratamientos en diferentes fechas.
Los tratamientos son realizados por empleados especializados en las distintas ramas de la estética y el bienestar.



## Entidades del sistema

Las entidades principales del sistema están identificadas como:

- Cliente
- Empleado
- Tratamiento
- Cita



## Atributos de las entidades

### Cliente

- id_cliente
- nombre
- telefono
- email
- direccion

### Empleado

- id_empleado
- nombre
- especialidad
- telefono
- email

### Tratamiento

- id_tratamiento
- nombre
- descripcion
- precio
- duracion

### Cita

- id_cita
- fecha
- hora
- estado



## Relaciones entre entidades

Cliente - Cita :
Un cliente puede tener varias citas, pero una cita pertenece a un único cliente.

Empleado - Cita :
Un empelado puede atender muchas citas, pero cada cita es realizada por un único empelado.

Tratamiento - Cita :
Un tratamiento puede estar asociado a muchas citas, pero cada cita corresponde a un único tratamiento.



## Claves Primarias (PK)

- Cliente -> id_cliente
- Empleado -> id_empleado
- Tratamiento -> id_tratamiento
- Cita -> id_cita



## Claves Foráneas (FK)

La tabla Cita tiene las siguientes claves foráneas:

- id_cliente
- id_empleado
- id_tratamiento
