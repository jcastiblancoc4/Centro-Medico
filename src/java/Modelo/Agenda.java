/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author jpcas
 */
public class Agenda {
    int id;
    int idDoctor;
    Date fecha;
    Time hora;
    String estado;    

    public Agenda(int idDoctor, Time hora, String estado) {
        this.idDoctor = idDoctor;
        this.hora = hora;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  
}

