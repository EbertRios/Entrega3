/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.controllers;

import com.mycompany.escuelaproyecto.Alumno;
import com.mycompany.escuelaproyecto.Escuela;
import com.mycompany.escuelaproyecto.Models.Evento;
import com.mycompany.escuelaproyecto.Models.Profesor;
import com.mycompany.escuelaproyecto.services.EscuelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escuela")
public class EscuelaController {

    @Autowired
    private EscuelaService escuelaService;

    @PostMapping("/agregar-alumno")
    public String agregarAlumno(@RequestBody Alumno alumno) {
        escuelaService.agregarAlumno(alumno);
        return "Alumno agregado: " + alumno.getNombre();
    }

    @PostMapping("/agregar-profesor")
    public String agregarProfesor(@RequestBody Profesor profesor) {
        escuelaService.agregarProfesor(profesor);
        return "Profesor agregado: " + profesor.getNombre();
    }

    @PostMapping("/agregar-evento")
    public String agregarEvento(@RequestBody Evento evento) {
        escuelaService.agregarEvento(evento);
        return "Evento agregado: " + evento.getNombre();
    }

    @GetMapping("/alumnos")
    public List<Alumno> obtenerAlumnos() {
        return escuelaService.obtenerAlumnos();
    }
}
