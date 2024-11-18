/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.escuelaproyecto.Interfaces;

import com.mycompany.escuelaproyecto.Models.Evento;
import java.util.List;


public interface ParticipanteEvento {
    
    

    void participarEnEvento(Evento evento);

    boolean verificarAsistencia(Evento evento);

    void registrarAsistencia(Evento evento);

    List<Evento> listarEventosParticipados();

    void cancelarParticipacion(Evento evento);

    
    List<Evento> obtenerEventosProximos();
}
