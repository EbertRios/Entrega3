/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.Models;


class Cocinero extends Persona {
    public Cocinero(int id, String nombre, String apellido) {
        super(id, nombre, apellido);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Cocinero: " + nombre + " " + apellido);
    }

    public void prepararComida() {
        // Lógica para preparar comida
        System.out.println(nombre + " está preparando la comida.");
    }
}
