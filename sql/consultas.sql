# Consultas SQL - Centro de Estética Munai

# Aquí se recogen consultas de prueba para la BBDD de Munai.
  
---

## 1. Listado de todos los clientes

SELECT * FROM clientes;

---

## 2. Listado de empleados

SELECT * FROM empleados;

---

## 3. Listado de tratamientos disponibles

SELECT nombre, precio, duracion
FROM tratamientos;

---

## 4. Listado completo de citas

SELECT
  c.nombre AS cliente,
  t.nombre AS tratamiento,
  e.nombre AS empleado,
  ci.fecha,
  ci.hora,
  ci.estado
FROM citas ci
JOIN clientes c ON ci.id_cliente = c.id_cliente
JOIN empleados e ON ci.id_empleado = e.id_empleado
JOIN tratamientos t ON ci.id_tratamiento = t.id_tratamiento;

---

## 5. Número de citas por empleado

SELECT
  e.nombre,
  COUNT(ci.id_cita) AS total_citas
FROM empleados e
LEFT JOIN citas ci ON e.id_empleado = ci.id_empleado
GROUP BY e.nombre;

---

## 6. Número de citas por tratamiento

SELECT
  t.nombre,
  COUNT(ci.id_cita) AS total_citas
FROM tratamientos t
LEFT JOIN citas ci ON t.id_tratamiento = ci.id_tratamiento
GROUP BY t.nombre
ORDER BY total_citas DESC;

---

## 7. Citas de un cliente específico

SELECT
  c.nombre,
  t.nombre AS tratamiento,
  ci.fecha,
  ci.hora,
  ci.estado
FROM citas ci
JOIN clientes c ON ci.id_cliente = c.id_cliente
JOIN tratamientos t ON ci.id_tratamiento = t.id_tratamiento
WHERE c.id_cliente = 1;

---

## 8. Horario de un empleado

SELECT
  e.nombre,
  ci.fecha,
  ci.hora,
  ci.estado
FROM citas ci
JOIN empleados e ON ci.id_empleado = e.id_empleado
WHERE e.id_empleado = 1
ORDER BY ci.fecha, ci.hora;

---

## 9. Número de citas por día

SELECT
  fecha,
  COUNT(*) AS total_citas
FROM citas
GROUP BY fecha
ORDER BY fecha;

---

## 10. Citas pendientes

SELECT
  c.nombre AS cliente,
  ci.fecha,
  ci.hora
FROM citas ci
JOIN clientes c ON ci.id_cliente = c.id_cliente
WHERE ci.estado = 'pendiente';

---

## 11. Ingresos potenciales por citas

SELECT
  SUM(t.precio) AS ingresos_estimados
FROM citas ci
JOIN tratamientos t ON ci.id_tratamiento = t.id_tratamiento;
