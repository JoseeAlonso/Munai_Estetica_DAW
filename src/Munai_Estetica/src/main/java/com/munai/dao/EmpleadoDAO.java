package com.munai.dao;

import com.munai.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
