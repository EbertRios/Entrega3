/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.Models;


class Conserje extends Persona {
    public Conserje(int id, String nombre, String apellido) {
        super(id, nombre, apellido);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Conserje: " + nombre + " " + apellido);
    }

    public void mantenerLimpieza() {
        // Lógica para el mantenimiento de la limpieza
        System.out.println(nombre + " está realizando la limpieza.");
    }
}
