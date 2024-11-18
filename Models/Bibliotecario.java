/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.Models;

class Bibliotecario extends Persona {
    public Bibliotecario(int id, String nombre, String apellido) {
        super(id, nombre, apellido);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Bibliotecario: " + nombre + " " + apellido);
    }

    public void gestionarLibros() {
        // Lógica para gestionar libros
        System.out.println(nombre + " está gestionando los libros en la biblioteca.");
    }
}