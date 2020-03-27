
package Modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author jpcas
 */
public class Agenda {
    private String doctor;
    Time horaInicio;
    Time horaFin;
    String estado;    

    public Agenda(String doctor, Time horaInicio, Time horaFin, String estado) {
        this.doctor = doctor;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
    }

    public Agenda() {
    }
    
    
    
    public String getDoctor() {
        return doctor;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
  
}

