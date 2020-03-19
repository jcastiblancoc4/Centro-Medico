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
public class Cita {
    int id;
    boolean estado;
    Date fecha_hora;
    Time duracion;
    int id_doctor;    

    public Cita(int id, boolean estado, Date fecha_hora, Time duracion, int id_doctor) {
        this.id = id;
        this.estado = estado;
        this.fecha_hora = fecha_hora;
        this.duracion = duracion;
        this.id_doctor = id_doctor;
    }

    public Cita() {
    }

    public int getId() {
        return id;
    }

    public boolean isEstado() {
        return estado;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public Time getDuracion() {
        return duracion;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

}

