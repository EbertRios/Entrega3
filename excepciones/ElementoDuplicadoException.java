/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuelaproyecto.excepciones;

/**
 *
 * @author user
 */
public class ElementoDuplicadoException extends RuntimeException {
    public ElementoDuplicadoException(String mensaje) {
        super(mensaje); // Utiliza el constructor de RuntimeException para establecer el mensaje
    }
}
