package com.munai.controller;

import com.munai.dao.CitaDAO;
import com.munai.dao.ClienteDAO;
import com.munai.dao.EmpleadoDAO;
import com.munai.dao.TratamientoDAO;
import com.munai.model.Cita;
import com.munai.model.Cliente;

import java.util.List;
import java.util.Scanner;

public class MenuController {

    private final Scanner scn = new Scanner(System.in);
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final CitaDAO citaDAO = new CitaDAO();
    private final EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    private final TratamientoDAO tratamientoDAO = new TratamientoDAO();

    public void iniciar(){
        int opcion;

        do {
            System.out.println("\n*** MUNAI ***");
            System.out.println("1. Ver clientes");
            System.out.println("2. Insertar Cliente");
            System.out.println("3. Ver citas");
            System.out.println("4. Crear cita");
            System.out.println("5. Contar citas");
            System.out.println("6. Filtrar citas por cliente");
            System.out.println("7. Ordenar citas por fecha");
            System.out.println("8. Salir");
            System.out.println("Elige una opción: ");

            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    mostrarClientes();
                    break;

                case 2:
                    insertarCliente();
                    break;

                case 3:
                    citaDAO.verCitas();
                    break;

                case 4:
                    crearCita();
                    break;

                case 5:
                    int total = citaDAO.contarCitas();
                    System.out.println("Total de citas: "+total);
                    break;

                case 6:
                    System.out.println("ID Cliente: ");
                    int id = scn.nextInt();
                    citaDAO.verCitasPorCliente(id);
                    break;

                case 7:
                    System.out.println("Citas ordenadas: ");
                    citaDAO.verCitasOrdenadas();
                    break;

                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion!= 8);
    }

    private void mostrarClientes() {
        List<Cliente> clientes = clienteDAO.obtenerClientes();

        for (Cliente cliente : clientes) {
            System.out.println(cliente.getId() + " - " + cliente.getNombre());
        }
    }

    private void insertarCliente() {
        scn.nextLine();

        System.out.println("Nombre: ");
        String nombre = scn.nextLine();

        System.out.println("Teléfono: ");
        String telefono = scn.nextLine();

        System.out.println("Email: ");
        String email = scn.nextLine();

        System.out.println("Dirección: ");
        String direccion = scn.nextLine();

        Cliente cliente = new Cliente(0, nombre, telefono, email, direccion);

        clienteDAO.insertarCliente(cliente);
    }

    private void crearCita(){

        System.out.println("\n*** CLIENTES ***");
        mostrarClientes();

        System.out.print("ID Cliente: ");
        int id_cliente = scn.nextInt();
        if (!clienteDAO.existeCliente(id_cliente)) {
            System.out.println("El cliente no existe");
            return;
        }

        System.out.print("ID Empleado: ");
        int id_empleado = scn.nextInt();

        if (!empleadoDAO.existeEmpleado(id_empleado)) {
            System.out.println("El empleado no existe");
            return;
        }

        System.out.print("ID Tratamiento: ");
        int id_tratamiento = scn.nextInt();

        if (!tratamientoDAO.existeTratamiento(id_tratamiento)) {
            System.out.println("El tratamiento no existe");
            return;
        }

        scn.nextLine();

        System.out.print("Fecha (YYYY-MM-DD): ");
        String fecha = scn.nextLine();

        System.out.print("Hora (HH:MM:SS): ");
        String hora = scn.nextLine();

        if (fecha.isEmpty() || hora.isEmpty()){
            System.out.println("Fecha u hora no pueden estar vacías");
            return;
        }

        if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Formato de fecha inválido (YYYY-MM-DD)");
            return;
        }

        if (!hora.matches("\\d{2}:\\d{2}:\\d{2}")) {
            System.out.println("Formato de hora inválido (HH:MM:SS)");
            return;
        }

        System.out.print("Estado: ");
        String estado = scn.nextLine();

        Cita cita = new Cita(0, fecha, hora, estado, id_cliente, id_empleado, id_tratamiento);

        if (citaDAO.existeCita(fecha, hora, id_empleado)) {
            System.out.println("Ya existe una cita en ese horario con ese empleado");
            return;
        }

        citaDAO.crearCita(cita);
    }
}
