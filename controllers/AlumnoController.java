/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.controllers;

import com.mycompany.escuelaproyecto.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    private List<Alumno> alumnos = new ArrayList<>();

    // Método para obtener todos los alumnos
    @GetMapping
    public List<Alumno> obtenerAlumnos() {
        return alumnos;
    }

    // Método para obtener un alumno por ID
    @GetMapping("/{id}")
    public Alumno obtenerAlumnoPorId(@PathVariable int id) {
        return alumnos.stream()
                .filter(alumno -> alumno.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Método para crear un nuevo alumno
    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno nuevoAlumno) {
        alumnos.add(nuevoAlumno);
        return nuevoAlumno;
    }

    // Método para actualizar un alumno existente
    @PatchMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable int id, @RequestBody Alumno actualizacion) {
        Alumno alumno = obtenerAlumnoPorId(id);
        if (alumno != null) {
            if (actualizacion.getNombre() != null) alumno.setNombre(actualizacion.getNombre());
            if (actualizacion.getApellido() != null) alumno.setApellido(actualizacion.getApellido());
            if (actualizacion.getEdad() != 0) alumno.setEdad(actualizacion.getEdad());
        }
        return alumno;
    }
}
