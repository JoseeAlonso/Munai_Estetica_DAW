package com.munai.service;

import com.munai.dao.CitaDAO;
import com.munai.model.Cita;

public class CitaService {

    private final CitaDAO citaDAO = new CitaDAO();

    public void verCitas(){
        citaDAO.verCitas();
    }

    public void crearCita(Cita cita){

        if (cita.getFecha().isEmpty() || cita.getHora().isEmpty()){
            System.out.println("La fecha y la hora no pueden estar vacías");
            return;
        }

        if (!cita.getFecha().matches("\\d{4}-\\d{2}-\\d{2}")){
            System.out.println("Formato de fecha inválido");
            return;
        }

        if (!cita.getHora().matches("\\d{2}:\\d{2}:\\d{2}")){
            System.out.println("Formato de hora inválido");
            return;
        }

        if (citaDAO.existeCita(cita.getFecha(),cita.getHora(),cita.getIdEmpleado())){
            System.out.println("Ya existe una cita en ese horario con ese empleado");
            return;
        }

        citaDAO.crearCita(cita);
    }

    public int contarCitas(){
        return citaDAO.contarCitas();
    }

    public void verCitasPorCliente(int idCliente){
        citaDAO.verCitasPorCliente(idCliente);
    }

    public void verCitasOrdenadas(){
        citaDAO.verCitasOrdenadas();
    }
}
