/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto;


class Calificacion {
    public int id;
    public int nota;

    public Calificacion(int id, int valor) {
        this.id = id;
        this.nota = valor;
    }

    public int getNota() {
        return nota;
    }
}
