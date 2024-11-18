/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.controllers;

import com.mycompany.escuelaproyecto.Models.Asignatura;
import com.mycompany.escuelaproyecto.Models.Profesor;
import com.mycompany.escuelaproyecto.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    private List<Asignatura> asignaturas = new ArrayList<>();

    // Crear una nueva asignatura
    @PostMapping
    public Asignatura crearAsignatura(@RequestBody Asignatura asignatura) {
        asignaturas.add(asignatura);
        return asignatura;
    }

    // Obtener todas las asignaturas
    @GetMapping
    public List<Asignatura> obtenerAsignaturas() {
        return asignaturas;
    }

    // Obtener una asignatura por ID
    @GetMapping("/{id}")
    public Asignatura obtenerAsignaturaPorId(@PathVariable int id) {
        return asignaturas.stream()
                .filter(asignatura -> asignatura.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Actualizar una asignatura
    @PatchMapping("/{id}")
    public Asignatura actualizarAsignatura(@PathVariable int id, @RequestBody Asignatura actualizacion) {
        Asignatura asignatura = obtenerAsignaturaPorId(id);
        if (asignatura != null) {
            if (actualizacion.getNombre() != null) asignatura.setNombre(actualizacion.getNombre());
        }
        return asignatura;
    }

    // Agregar un profesor a una asignatura
    @PostMapping("/{id}/profesores")
    public Asignatura agregarProfesor(@PathVariable int id, @RequestBody Profesor profesor) {
        Asignatura asignatura = obtenerAsignaturaPorId(id);
        if (asignatura != null) {
            asignatura.agregarProfesor(profesor);
        }
        return asignatura;
    }

    // Agregar un alumno a una asignatura
    @PostMapping("/{id}/alumnos")
    public Asignatura agregarAlumno(@PathVariable int id, @RequestBody Alumno alumno) {
        Asignatura asignatura = obtenerAsignaturaPorId(id);
        if (asignatura != null) {
            asignatura.agregarAlumno(alumno);
        }
        return asignatura;
    }
}
