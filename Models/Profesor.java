/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.Models;

import com.mycompany.escuelaproyecto.Interfaces.ParticipanteEvento;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un profesor en la escuela.
 * Implementa la interfaz ParticipanteEvento.
 */
public class Profesor extends Persona implements ParticipanteEvento {
    private String especialidad;
    private List<Asignatura> asignaturas;
    private List<Evento> eventosParticipados;

    public Profesor(int id, String nombre, String apellido, String especialidad) {
        super(id, nombre, apellido);
        this.especialidad = especialidad;
        this.asignaturas = new ArrayList<>();
        this.eventosParticipados = new ArrayList<>();
    }
    
    public String getEspecialidad() {
    return especialidad;
    }

    public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
    }

    public void agregarAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
    }

    public void mostrarAsignaturas() {
        System.out.println("Asignaturas de " + getNombre() + ":");
        for (Asignatura asignatura : asignaturas) {
            System.out.println("- " + asignatura.getNombre());
        }
    }

    // Métodos de ParticipanteEvento
    @Override
    public void participarEnEvento(Evento evento) {
        eventosParticipados.add(evento);
        System.out.println("El profesor " + getNombre() + " participó en el evento: " + evento.getNombre());
    }

    @Override
    public boolean verificarAsistencia(Evento evento) {
        return eventosParticipados.contains(evento);
    }

    @Override
    public void registrarAsistencia(Evento evento) {
        if (!eventosParticipados.contains(evento)) {
            eventosParticipados.add(evento);
            System.out.println("Asistencia registrada para el profesor " + getNombre() + " en el evento: " + evento.getNombre());
        }
    }

    @Override
    public List<Evento> listarEventosParticipados() {
        return eventosParticipados;
    }

    @Override
    public void cancelarParticipacion(Evento evento) {
        if (eventosParticipados.remove(evento)) {
            System.out.println("El profesor " + getNombre() + " canceló su participación en el evento: " + evento.getNombre());
        } else {
            System.out.println("El profesor " + getNombre() + " no estaba inscrito en el evento: " + evento.getNombre());
        }
    }

    @Override
    public List<Evento> obtenerEventosProximos() {
        // Este método podría filtrar eventos basándose en la fecha
        return eventosParticipados; // Implementación básica
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Profesor: " + getNombre() + " " + getApellido() + ", Especialidad: " + especialidad);
    }
}