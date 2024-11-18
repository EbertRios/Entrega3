/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto;

import com.mycompany.escuelaproyecto.Models.Asignatura;
import com.mycompany.escuelaproyecto.Models.Profesor;
import com.mycompany.escuelaproyecto.Models.Evento;
import com.mycompany.escuelaproyecto.Alumno;
import com.mycompany.escuelaproyecto.Models.Administrativo;
import com.mycompany.escuelaproyecto.Calificacion;
import com.mycompany.escuelaproyecto.services.EscuelaService;
import com.mycompany.escuelaproyecto.excepciones.ElementoDuplicadoException;
import com.mycompany.escuelaproyecto.excepciones.PersonaNoEncontradaException;
import com.mycompany.escuelaproyecto.excepciones.EventoNoEncontradoException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscuelaProyecto {
    public static void main(String[] args) {
        SpringApplication.run(EscuelaProyecto.class, args);

        // Crear una instancia del servicio
        EscuelaService escuelaService = new EscuelaService();

        // Crear instancias de personas
        Alumno alumno1 = new Alumno(1, "Juan", "Perez", 16);
        Alumno alumno2 = new Alumno(2, "Maria", "Gomez", 17);
        Profesor profesor1 = new Profesor(3, "Carlos", "Ramirez", "Matemáticas");
        Administrativo admin1 = new Administrativo(4, "Laura", "Lopez");

        // Crear un evento
        Evento evento = new Evento(1, "Día de la Ciencia", "2024-10-25", "Exposición de proyectos científicos");

        // Usar el servicio para agregar personas y eventos
        try {
            escuelaService.agregarAlumno(alumno1);
            escuelaService.agregarAlumno(alumno2);
            escuelaService.agregarProfesor(profesor1);
            escuelaService.agregarEvento(evento);

            // Intentar agregar un alumno duplicado para demostrar la excepción
            escuelaService.agregarAlumno(alumno1);
        } catch (ElementoDuplicadoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Mostrar personas y eventos
        System.out.println("\nLista de alumnos:");
        for (Alumno alumno : escuelaService.obtenerAlumnos()) {
            System.out.println(" - " + alumno.getNombre() + " " + alumno.getApellido());
        }

        System.out.println("\nLista de profesores:");
        for (Profesor profesor : escuelaService.obtenerProfesores()) {
            System.out.println(" - " + profesor.getNombre() + " " + profesor.getApellido());
        }

        System.out.println("\nLista de eventos:");
        for (Evento e : escuelaService.obtenerEventos()) {
            System.out.println(" - " + e.getNombre() + " (" + e.getFecha() + ")");
        }

        // Ejemplo de polimorfismo: Personas participando en el evento
        System.out.println("\nPersonas participando en el evento:");
        profesor1.participarEnEvento(evento);
        alumno1.participarEnEvento(evento);

        // Crear una asignatura y calificaciones
        Asignatura matematicas = new Asignatura(1, "Matemáticas");
        Calificacion calif1 = new Calificacion(1, 85);

        // Agregar asignatura al profesor
        profesor1.agregarAsignatura(matematicas);

        // Agregar alumnos y calificaciones a la asignatura
        matematicas.agregarProfesor(profesor1);
        matematicas.agregarAlumno(alumno1);
        alumno1.agregarCalificacion(calif1);

        // Mostrar información adicional
        System.out.println("\nInformación detallada del profesor:");
        profesor1.mostrarInformacion();

        System.out.println("\nCalificaciones del alumno:");
        alumno1.mostrarCalificaciones();

        System.out.println("\nInformación detallada de las personas en la escuela:");
        escuelaService.obtenerAlumnos().forEach(Alumno::mostrarInformacion);
        escuelaService.obtenerProfesores().forEach(Profesor::mostrarInformacion);

        // Ejemplo de manejo de excepciones
        try {
            // Buscar una persona que no existe
            escuelaService.buscarPersonaPorId(10);
        } catch (PersonaNoEncontradaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Buscar un evento que no existe
            escuelaService.buscarEventoPorId(5);
        } catch (EventoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}