/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.Models;

import com.mycompany.escuelaproyecto.Interfaces.ParticipanteEvento;

public class Evento {
    private int id;
    private String nombre;
    private String fecha; // Fecha en formato String
    private String descripcion;

    public Evento(int id, String nombre, String fecha, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void agregarParticipante(ParticipanteEvento participante) {
        // Lógica para agregar un participante al evento
        System.out.println("Agregando participante al evento " + nombre + ": " + participante.getClass().getSimpleName());
    }

    public void eliminarParticipante(ParticipanteEvento participante) {
        // Lógica para eliminar un participante del evento
        System.out.println("Eliminando participante del evento " + nombre + ": " + participante.getClass().getSimpleName());
    }
}
