/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto;

import com.mycompany.escuelaproyecto.Calificacion;
import com.mycompany.escuelaproyecto.Interfaces.ParticipanteEvento;
import com.mycompany.escuelaproyecto.Models.Evento;
import com.mycompany.escuelaproyecto.Models.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un alumno en la escuela.
 * Implementa la interfaz ParticipanteEvento.
 */
public class Alumno extends Persona implements ParticipanteEvento {
    private int edad;
    private List<Calificacion> calificaciones; // Lista de calificaciones del alumno
    private List<Evento> eventosParticipados; // Lista de eventos en los que ha participado

    public Alumno(int id, String nombre, String apellido, int edad) {
        super(id, nombre, apellido);
        this.edad = edad;
        this.calificaciones = new ArrayList<>(); // Inicialización de la lista
        this.eventosParticipados = new ArrayList<>(); // Inicialización de eventos
    }

    // Métodos de calificaciones (sin cambios)
    public void agregarCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }

    public List<Calificacion> obtenerCalificaciones() {
        return calificaciones;
    }

    public void mostrarCalificaciones() {
        System.out.println("Calificaciones de " + getNombre() + ":");
        for (Calificacion calificacion : calificaciones) {
            System.out.println("- " + calificacion.getNota());
        }
    }
    
    public int getEdad() {
    return edad;
}

    public void setEdad(int edad) {
    this.edad = edad;
}

    // Métodos de ParticipanteEvento
    @Override
    public void participarEnEvento(Evento evento) {
        eventosParticipados.add(evento);
        System.out.println("El alumno " + getNombre() + " participó en el evento: " + evento.getNombre());
    }

    @Override
    public boolean verificarAsistencia(Evento evento) {
        return eventosParticipados.contains(evento);
    }

    @Override
    public void registrarAsistencia(Evento evento) {
        if (!eventosParticipados.contains(evento)) {
            eventosParticipados.add(evento);
            System.out.println("Asistencia registrada para el alumno " + getNombre() + " en el evento: " + evento.getNombre());
        }
    }

    @Override
    public List<Evento> listarEventosParticipados() {
        return eventosParticipados;
    }

    @Override
    public void cancelarParticipacion(Evento evento) {
        if (eventosParticipados.remove(evento)) {
            System.out.println("El alumno " + getNombre() + " canceló su participación en el evento: " + evento.getNombre());
        } else {
            System.out.println("El alumno " + getNombre() + " no estaba inscrito en el evento: " + evento.getNombre());
        }
    }

    @Override
    public List<Evento> obtenerEventosProximos() {
        // Este método podría filtrar eventos basándose en la fecha
        return eventosParticipados; // Implementación básica
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Alumno: " + getNombre() + " " + getApellido() + ", Edad: " + edad);
    }
}
