/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.escuelaproyecto.Interfaces;

import com.mycompany.escuelaproyecto.Models.Persona;
import com.mycompany.escuelaproyecto.Models.Inventario;
import java.util.List;

public interface Responsable {

    // Métodos actuales
    void gestionarPersonal();
    void gestionarInventario();
    void registrarInventario(Inventario item);
    void asignarTarea(Persona empleado, String tarea);
    List<Persona> listarPersonal();

    // Métodos adicionales sugeridos
    Persona buscarPersonalPorId(int id);
    boolean eliminarPersonal(int id);

    Inventario buscarInventarioPorId(int id);
    boolean actualizarCantidadInventario(int id, int nuevaCantidad);
    boolean eliminarItemInventario(int id);

    String generarReportePersonal();
    String generarReporteInventario();
}
