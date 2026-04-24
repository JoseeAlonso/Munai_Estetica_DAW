package com.munai.dao;

import com.munai.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TratamientoDAO {

    public boolean existeTratamiento(int idTratamiento) {

        String sql = "SELECT COUNT(*) FROM tratamientos WHERE id_tratamiento = ?";

        try {
            Connection con = ConexionBD.conectar();
            assert con != null;
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, idTratamiento);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }

        } catch (Exception e) {
            System.out.println("Error al verificar tratamiento: " + e.getMessage());
        }

        return false;
    }

    public void verTratamientos(){

        String sql = "SELECT id_tratamiento, nombre FROM tratamientos";

        try {
            Connection con = ConexionBD.conectar();
            assert con != null;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("\n*** TRATAMIENTOS ***");

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id_tratamiento") + " - " + resultSet.getString("nombre")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar los tratamientos: " + e.getMessage());
        }

    }
}
