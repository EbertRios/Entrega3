/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.controllers;

import com.mycompany.escuelaproyecto.Models.Profesor;
import com.mycompany.escuelaproyecto.Models.Asignatura;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    private List<Profesor> profesores = new ArrayList<>();

    // Crear un nuevo profesor
    @PostMapping
    public Profesor crearProfesor(@RequestBody Profesor profesor) {
        profesores.add(profesor);
        return profesor;
    }

    // Obtener todos los profesores
    @GetMapping
    public List<Profesor> obtenerProfesores() {
        return profesores;
    }

    // Obtener un profesor por ID
    @GetMapping("/{id}")
    public Profesor obtenerProfesorPorId(@PathVariable int id) {
        return profesores.stream()
                .filter(profesor -> profesor.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Actualizar un profesor
    @PatchMapping("/{id}")
    public Profesor actualizarProfesor(@PathVariable int id, @RequestBody Profesor actualizacion) {
        Profesor profesor = obtenerProfesorPorId(id);
        if (profesor != null) {
            if (actualizacion.getNombre() != null) profesor.setNombre(actualizacion.getNombre());
            if (actualizacion.getApellido() != null) profesor.setApellido(actualizacion.getApellido());
            if (actualizacion.getEspecialidad() != null) profesor.setEspecialidad(actualizacion.getEspecialidad());
        }
        return profesor;
    }

    // Agregar una asignatura a un profesor
    @PostMapping("/{id}/asignaturas")
    public Profesor agregarAsignatura(@PathVariable int id, @RequestBody Asignatura asignatura) {
        Profesor profesor = obtenerProfesorPorId(id);
        if (profesor != null) {
            profesor.agregarAsignatura(asignatura);
        }
        return profesor;
    }
}
