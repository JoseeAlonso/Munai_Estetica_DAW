-- DATOS DE PRUEBA

USE munai_estetica;
  
INSERT INTO clientes (nombre, telefono, email, direccion)
VALUES 
  ('Jose Alonso', '012345678', 'jose@gmail.com', 'Calle Walabi 42'),
  ('Antonio Bachek','876543210','antonio@gmail.com','Calle Oscura 99'),
  ('Ernesto Medina','025698641','ernesto@gmail.com','Calle Esperanza 72');


INSERT INTO empleados (nombre, especialidad, telefono, email)
VALUES
  ('Adriana Santos','Masajes relajantes','600000001','adriana@munai.com'),
  ('Roberto Gomez','Tratamientos faciales','600000002','roberto@munai.com');


INSERT INTO tratamientos (nombre, descripcion, precio, duracion)
VALUES
  ('Masaje relajante','Masaje corporal para reducir el estrés', 90.0, 80),
  ('Limpieza facial','Tratamiento profundo de limpieza de la piel', 50.00, 45),
  ('Sesion de sauna','Tratamiento en sauna', 60.00, 30);


INSERT INTO citas (fecha, hora, estado, id_cliente, id_empleado, id_tratamiento)
VALUES
  ('2026-06-10','10:00:00','confirmada', 1, 1, 1),
  ('2026-06-10','12:00:00','confirmada', 2, 2, 2),
  ('2026-06-10','16:00:00','pendiente', 3, 1, 3);


-- CONSULTA DE PRUEBA
  
SELECT
  clientes.nombre AS cliente,
  tratamientos.nombre AS tratamiento,
  empleados.nombre AS empleado,
  fecha,
  hora
FROM citas
JOIN clientes ON citas.id_cliente = clientes.id_cliente
JOIN empleados ON citas.id_empleado = empleados.id_empleado
JOIN tratamientos ON citas.id_tratamiento = tratamientos.id_tratamiento;
