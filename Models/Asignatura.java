/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.Models;

import com.mycompany.escuelaproyecto.Alumno;
import java.util.ArrayList;
import java.util.List;

public class Asignatura {
    private int id;
    private String nombre;
    private List<Profesor> profesores;
    private List<Alumno> alumnos;

    public Asignatura(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    // Getters y setters para id y nombre
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void mostrarInformacion() {
        System.out.println("Asignatura: " + nombre);
        System.out.println("Profesores:");
        for (Profesor profesor : profesores) {
            System.out.println("- " + profesor.getNombre() + " " + profesor.getApellido());
        }
        System.out.println("Alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println("- " + alumno.getNombre() + " " + alumno.getApellido());
        }
    }
}
