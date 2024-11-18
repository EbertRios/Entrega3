/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto;

import com.mycompany.escuelaproyecto.Models.Persona;
import com.mycompany.escuelaproyecto.Models.Profesor;
import com.mycompany.escuelaproyecto.Models.Evento;
import com.mycompany.escuelaproyecto.excepciones.PersonaNoEncontradaException;
import com.mycompany.escuelaproyecto.excepciones.EventoNoEncontradoException;
import com.mycompany.escuelaproyecto.excepciones.ElementoDuplicadoException;

import java.util.ArrayList;
import java.util.List;

public class Escuela {
    private int id;
    private String nombre;
    private String direccion;
    private List<Persona> personas; // Lista polimórfica
    private List<Evento> eventos;   // Lista para eventos

    public Escuela(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.personas = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    /**
     * Agrega una persona a la lista polimórfica.
     * Puede ser un Alumno, Profesor o Administrativo.
     * 
     * @param persona La persona que se desea agregar.
     */
    public void agregarPersona(Persona persona) {
        if (personas.stream().anyMatch(p -> p.getId() == persona.getId())) {
            throw new ElementoDuplicadoException("La persona con ID " + persona.getId() + " ya está registrada.");
        }
        personas.add(persona);
        System.out.println("Persona agregada: " + persona.getNombre() + " " + persona.getApellido());
    }

    /**
     * Busca una persona por su ID.
     * 
     * @param id El ID de la persona a buscar.
     * @return La persona encontrada.
     * @throws PersonaNoEncontradaException Si no se encuentra una persona con el ID dado.
     */
    public Persona buscarPersonaPorId(int id) {
        return personas.stream()
                .filter(persona -> persona.getId() == id)
                .findFirst()
                .orElseThrow(() -> new PersonaNoEncontradaException("Persona con ID " + id + " no encontrada."));
    }

    /**
     * Muestra la información de todas las personas en la escuela.
     */
    public void mostrarPersonas() {
        System.out.println("Listado de personas en la escuela:");
        for (Persona persona : personas) {
            persona.mostrarInformacion(); // Polimorfismo: se llama al método según la clase concreta
        }
    }

    /**
     * Agrega un evento a la lista de eventos de la escuela.
     * 
     * @param evento El evento que se desea agregar.
     */
    public void agregarEvento(Evento evento) {
        if (eventos.stream().anyMatch(e -> e.getId() == evento.getId())) {
            throw new ElementoDuplicadoException("El evento con ID " + evento.getId() + " ya está registrado.");
        }
        eventos.add(evento);
        System.out.println("Agregando el evento " + evento.getNombre() + " a la escuela " + nombre);
    }

    /**
     * Busca un evento por su ID.
     * 
     * @param id El ID del evento a buscar.
     * @return El evento encontrado.
     * @throws EventoNoEncontradoException Si no se encuentra un evento con el ID dado.
     */
    public Evento buscarEventoPorId(int id) {
        return eventos.stream()
                .filter(evento -> evento.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EventoNoEncontradoException("Evento con ID " + id + " no encontrado."));
    }

    /**
     * Obtiene la lista de eventos en la escuela.
     * 
     * @return Lista de eventos.
     */
    public List<Evento> obtenerEventos() {
        return eventos;
    }

    /**
     * Obtiene la lista de profesores en la escuela.
     * 
     * @return Lista de profesores.
     */
    public List<Profesor> obtenerProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona instanceof Profesor) {
                profesores.add((Profesor) persona);
            }
        }
        return profesores;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
