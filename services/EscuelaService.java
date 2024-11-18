/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.services;

import com.mycompany.escuelaproyecto.Alumno;
import com.mycompany.escuelaproyecto.Models.Evento;
import com.mycompany.escuelaproyecto.Models.Persona;
import com.mycompany.escuelaproyecto.Models.Profesor;
import com.mycompany.escuelaproyecto.excepciones.PersonaNoEncontradaException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EscuelaService {
    private List<Alumno> alumnos = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();

    // Métodos para agregar entidades
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
        System.out.println("Alumno agregado: " + alumno.getNombre());
        
    }
    

    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
        System.out.println("Profesor agregado: " + profesor.getNombre());
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
        System.out.println("Evento agregado: " + evento.getNombre());
    }

    // Métodos para obtener listas completas
    public List<Alumno> obtenerAlumnos() {
        return alumnos;
    }

    public List<Profesor> obtenerProfesores() {
        return profesores;
    }

    public List<Evento> obtenerEventos() {
        return eventos;
    }

    // Métodos para buscar por ID
    public Optional<Alumno> buscarAlumnoPorId(int id) {
        return alumnos.stream().filter(alumno -> alumno.getId() == id).findFirst();
    }

    public Optional<Profesor> buscarProfesorPorId(int id) {
        return profesores.stream().filter(profesor -> profesor.getId() == id).findFirst();
    }

    public Optional<Evento> buscarEventoPorId(int id) {
        return eventos.stream().filter(evento -> evento.getId() == id).findFirst();
    }

    /**
     * Busca una persona por su ID en las listas de alumnos y profesores.
     *
     * @param id ID de la persona a buscar.
     * @return Persona encontrada (Alumno o Profesor).
     * @throws PersonaNoEncontradaException Si no se encuentra ninguna persona con el ID especificado.
     */
    public Persona buscarPersonaPorId(int id) {
        // Buscar en alumnos
        Optional<Alumno> alumno = buscarAlumnoPorId(id);
        if (alumno.isPresent()) {
            return alumno.get();
        }

        // Buscar en profesores
        Optional<Profesor> profesor = buscarProfesorPorId(id);
        if (profesor.isPresent()) {
            return profesor.get();
        }

        // Lanzar excepción si no se encuentra
        throw new PersonaNoEncontradaException("Persona con ID " + id + " no encontrada.");
    }

    // Métodos para eliminar entidades por ID
    public boolean eliminarAlumnoPorId(int id) {
        return alumnos.removeIf(alumno -> alumno.getId() == id);
    }

    public boolean eliminarProfesorPorId(int id) {
        return profesores.removeIf(profesor -> profesor.getId() == id);
    }

    public boolean eliminarEventoPorId(int id) {
        return eventos.removeIf(evento -> evento.getId() == id);
    }
}