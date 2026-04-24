package com.munai.service;

import com.munai.dao.EmpleadoDAO;

public class EmpleadoService {

    private final EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    public boolean existeEmpleado(int idEmpleado){
        return empleadoDAO.existeEmpleado(idEmpleado);
    }

    public void verEmpleados(){
        empleadoDAO.verEmpleados();
    }
}
