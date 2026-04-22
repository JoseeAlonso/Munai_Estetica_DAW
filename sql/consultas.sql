#Consultas SQL - Centro de Estética Munai
---

## 1. Listado de todos los clientes
  
SELECT * FROM clientes;

---

##2. Clientes con citas próximas

SELECT c.nombre, c.telefono, ci.fecha, ci.hora
FROM clientes c
JOIN citas ci ON c.id_cliente = ci.id_cliente
WHERE ci.fecha >= CURDATE()
ORDER BY ci.fecha, ci.hora;

---

##3. Servicios más reservados

SELECT s.nombre, COUNT(ci.id_servicio) AS total_reservas
FROM servicios s
JOIN citas ci ON s.id_servicio = ci.id_servicio
GROUP BY s.nombre
ORDER BY total_reservas DESC;

---

##4. Ingresos totales del negocio

SELECT SUM(p.monto) AS ingresos_totales
FROM pagos p;

---

##5. Citas de un cliente específico

SELECT c.nombre, s.nombre AS servicio, ci.fecha, ci.hora
FROM citas ci
JOIN clientes c ON ci.id_cliente = c.id_cliente
JOIN servicios s ON ci.id_servicio = s.id_servicio
WHERE c.id_cliente = 1;

---

##6. Número de citas por empleado

SELECT e.nombre, COUNT(ci.id_cita) AS total_citas
FROM empleados e
LEFT JOIN citas ci ON e.id_empleado = ci.id_empleado
GROUP BY e.nombre;

---

##7. Horario de un empleado

SELECT e.nombre, ci.fecha, ci.hora
FROM citas ci
JOIN empleados e ON ci.id_empleado = e.id_empleado
WHERE e.id_empleado = 1
ORDER BY ci.fecha, ci.hora;

---

##8. Clientes que más han gastado

SELECT c.nombre, SUM(p.monto) AS total_gastado
FROM clientes c
JOIN pagos p ON c.id_cliente = p.id_cliente
GROUP BY c.nombre
ORDER BY total_gastado DESC;

---

##9. Número de citas por día

SELECT fecha, COUNT(*) AS total_citas
FROM citas
GROUP BY fecha
ORDER BY fecha;

---

##10. Servicios con su precio y duración

SELECT nombre, precio, duracion
FROM servicios;

