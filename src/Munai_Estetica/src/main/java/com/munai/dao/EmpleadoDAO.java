package com.munai.dao;

import com.munai.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {

    public boolean existeEmpleado(int idEmpleado) {

        String sql = "SELECT COUNT(*) FROM empleados WHERE id_empleado = ?";

        try {
            Connection con = ConexionBD.conectar();
            assert con != null;
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, idEmpleado);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (Exception e) {
            System.out.println("Error al verificar el empleado: " + e.getMessage());
        }

        return false;
    }

    public void verEmpleados(){

        String sql = "SELECT id_empleado, nombre FROM empleados";

        try {
            Connection con = ConexionBD.conectar();
            assert con != null;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("\n*** EMPLEADOS ***");

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id_empleado") + " " + resultSet.getString("nombre")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar los empleados: " + e.getMessage());
        }
    }
}
