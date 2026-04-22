package com.munai.dao;

import com.munai.model.Cita;
import com.munai.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CitaDAO {

    public void verCitas(){

        String sql = """
                SELECT 
                    c.id_cita,
                    cl.nombre AS cliente,
                    t.nombre AS tratamiento,
                    e.nombre AS empleado,
                    c.fecha,
                    c.hora,
                    c.estado
                FROM citas c
                JOIN clientes cl ON c.id_cliente = cl.id_cliente
                JOIN tratamientos t ON c.id_tratamiento = t.id_tratamiento
                JOIN empleados e ON c.id_empleado = e.id_empleado
        """;

        try {
            Connection con = ConexionBD.conectar();
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("\n*** LISTADO DE CITAS ***");

            while(resultSet.next()){
                System.out.println(
                resultSet.getInt("id_cita") + " | " +
                resultSet.getString("cliente") + " | " +
                resultSet.getString("tratamiento") + " | " +
                resultSet.getString("empleado") + " | " +
                resultSet.getString("fecha") + " | " +
                resultSet.getString("hora") + " | " +
                resultSet.getString("estado")
                );
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error en conexión con BBDD, comunicarse con el administrador");;
        }
    }

    public void crearCita(Cita cita){
        String sql = "INSERT INTO citas (fecha, hora, estado, id_cliente, id_empleado, id_tratamiento) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = ConexionBD.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cita.getFecha());
            preparedStatement.setString(2, cita.getHora());
            preparedStatement.setString(3, cita.getEstado());
            preparedStatement.setInt(4, cita.getIdCliente());
            preparedStatement.setInt(5, cita.getIdEmpleado());
            preparedStatement.setInt(6, cita.getIdTratamiento());

            preparedStatement.executeUpdate();

            System.out.println("Cita agregada correctamente");

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error al crear la cita" + e.getMessage());
        }
    }

    public int contarCitas() {
        String sql = "SELECT COUNT(*) FROM citas";

        try {
            Connection con = ConexionBD.conectar();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("Error al contar las citas:" + e.getMessage());
        }

        return 0;
    }

    public void verCitasPorCliente(int idCliente) {
        String sql = "SELECT * FROM citas WHERE id_cliente = ?";

        try {
            Connection con = ConexionBD.conectar();
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, idCliente);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id_cita") + " | " +
                        resultSet.getString("fecha") + " | " +
                        resultSet.getString("hora") + " | " +
                        resultSet.getString("estado")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al filtrar citas: "+ e.getMessage());
        }
    }

    public void verCitasOrdenadas(){
        String sql = """
                SELECT
                    c.id_cita,
                    cl.nombre AS cliente,
                    c.fecha,
                    c.hora,
                FROM citas c
                JOIN clientes cl ON c.id_cliente = cl.id_cliente
                ORDER BY c.fecha DESC
        """;

        try {
            Connection con = ConexionBD.conectar();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id_cita") + " | " +
                        resultSet.getString("cliente") + " | " +
                        resultSet.getString("fecha") + " | " +
                        resultSet.getString("hora")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al ordenar citas: " + e.getMessage());
        }
    }

    public boolean existeCita(String fecha, String hora, int idEmpleado) {
        String sql = "SELECT COUNT(*) FROM citas WHERE fecha = ? AND hora = ? AND id_empleado = ?";

        try {
            Connection con = ConexionBD.conectar();
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, fecha);
            preparedStatement.setString(2, hora);
            preparedStatement.setInt(3, idEmpleado);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }

        } catch (Exception e) {
            System.out.println("Error al comprobar cita: " + e.getMessage());
        }
        return false;
    }

}
