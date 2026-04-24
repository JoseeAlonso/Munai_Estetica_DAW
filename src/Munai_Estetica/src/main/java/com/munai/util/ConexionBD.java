package com.munai.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mariadb://localhost:3308/munai_estetica";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection conectar(){

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASS);
            return conexion;

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        }
    }
}
