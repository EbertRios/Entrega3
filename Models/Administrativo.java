/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.Models;

import com.mycompany.escuelaproyecto.Interfaces.Responsable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un administrativo en la escuela.
 * Implementa la interfaz Responsable para gestionar personal e inventario.
 */
public class Administrativo extends Persona implements Responsable {

    private List<Persona> personal;
    private List<Inventario> inventario;

    public Administrativo(int id, String nombre, String apellido) {
        super(id, nombre, apellido);
        this.personal = new ArrayList<>();
        this.inventario = new ArrayList<>();
    }

    // Métodos actuales

    @Override
    public void gestionarPersonal() {
        System.out.println("Gestionando el personal de la escuela.");
        for (Persona p : personal) {
            System.out.println(" - " + p.getNombre() + " " + p.getApellido());
        }
    }

    @Override
    public void gestionarInventario() {
        System.out.println("Gestionando el inventario de la escuela.");
        for (Inventario item : inventario) {
            System.out.println(" - " + item.getNombre() + " (Cantidad: " + item.getCantidad() + ")");
        }
    }

    @Override
    public void registrarInventario(Inventario item) {
        inventario.add(item);
        System.out.println("Item registrado en el inventario: " + item.getNombre());
    }

    @Override
    public void asignarTarea(Persona empleado, String tarea) {
        System.out.println("Asignando tarea: " + tarea + " al empleado " + empleado.getNombre());
    }

    @Override
    public List<Persona> listarPersonal() {
        return new ArrayList<>(personal); // Retorna una copia de la lista de personal
    }

    // Métodos adicionales

    @Override
    public Persona buscarPersonalPorId(int id) {
        for (Persona p : personal) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null; // Si no se encuentra, retorna null
    }

    @Override
    public boolean eliminarPersonal(int id) {
        return personal.removeIf(p -> p.getId() == id);
    }

    @Override
    public Inventario buscarInventarioPorId(int id) {
        for (Inventario item : inventario) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Si no se encuentra, retorna null
    }

    @Override
    public boolean actualizarCantidadInventario(int id, int nuevaCantidad) {
        Inventario item = buscarInventarioPorId(id);
        if (item != null) {
            item.setCantidad(nuevaCantidad);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarItemInventario(int id) {
        return inventario.removeIf(item -> item.getId() == id);
    }

    @Override
    public String generarReportePersonal() {
        StringBuilder reporte = new StringBuilder("Reporte de Personal:\n");
        for (Persona p : personal) {
            reporte.append(" - ").append(p.getNombre()).append(" ").append(p.getApellido()).append("\n");
        }
        return reporte.toString();
    }

    @Override
    public String generarReporteInventario() {
        StringBuilder reporte = new StringBuilder("Reporte de Inventario:\n");
        for (Inventario item : inventario) {
            reporte.append(" - ").append(item.getNombre())
                   .append(" (Cantidad: ").append(item.getCantidad()).append(")\n");
        }
        return reporte.toString();
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Administrativo: " + getNombre() + " " + getApellido());
    }
}

