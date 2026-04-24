package com.munai.dao;

import com.munai.util.ConexionBD;
import com.munai.model.Cliente;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> obtenerClientes() {
        List<Cliente> lista = new ArrayList<>();

        try{

            Connection conexion = ConexionBD.conectar();
            String sql = "SELECT * FROM clientes";

            assert conexion != null;
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("nombre"),
                        resultSet.getString("telefono"),
                        resultSet.getString("email"),
                        resultSet.getString("direccion")
                );
                lista.add(cliente);
            }

            conexion.close();


        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes " + e.getMessage());
        }

        return lista;
    }

    public void insertarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, telefono, email, direccion) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = ConexionBD.conectar();
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getTelefono());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setString(4, cliente.getDireccion());

            preparedStatement.executeUpdate();

            System.out.println("Cliente insertado correctamente");

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar el cliente " + e.getMessage());
        }
    }

    public boolean existeCliente(int idCliente) {
        String sql = "SELECT COUNT(*) FROM clientes WHERE id_cliente = ?";
        try {
            Connection con = ConexionBD.conectar();
            assert con != null;
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, idCliente);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }

        } catch (Exception e) {
            System.out.println("Error al verificar cliente: "+e.getMessage());
        }
        return false;
    }
}
