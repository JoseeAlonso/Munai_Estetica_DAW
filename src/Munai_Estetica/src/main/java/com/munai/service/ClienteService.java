package com.munai.service;

import com.munai.dao.ClienteDAO;
import com.munai.model.Cliente;

import java.util.List;

public class ClienteService {

    private final ClienteDAO clienteDAO = new ClienteDAO();

    public List<Cliente> obtenerClientes(){
        return clienteDAO.obtenerClientes();
    }

    public void insertarCliente(Cliente cliente){
        if (cliente.getNombre().isEmpty()){
            System.out.println("El nombre no puede estar vacío");
            return;
        }

        if (cliente.getTelefono().isEmpty()){
            System.out.println("El teléfono no puede estar vacío");
            return;
        }

        clienteDAO.insertarCliente(cliente);
    }

    public boolean existeCliente(int idCliente){
        return clienteDAO.existeCliente(idCliente);
    }
}
