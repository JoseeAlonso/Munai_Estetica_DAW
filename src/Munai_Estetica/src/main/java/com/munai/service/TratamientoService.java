package com.munai.service;

import com.munai.dao.TratamientoDAO;

public class TratamientoService {

    private final TratamientoDAO tratamientoDAO = new TratamientoDAO();

    public boolean existeTratamiento(int idTratamiento){
        return tratamientoDAO.existeTratamiento(idTratamiento);
    }

    public void verTratamientos(){
        tratamientoDAO.verTratamientos();
    }
}
