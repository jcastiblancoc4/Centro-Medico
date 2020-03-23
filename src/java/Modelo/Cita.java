/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import ControlDAO.PacienteJDBC;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author jpcas
 */
public class Cita {
    private int id;
    private int idPaciente;
    private int idEspecialidad;
    private int idDoctor;
    private Date fecha;
    private Time hora;
    private String estado;
    private Boolean asistio;
    
    private String nombrePaciente;
    private String apellidoPaciente;
    private String cedulaPciente;

    public Cita(int id, int id_paciente, int id_especialidad, int id_doctor, Date fecha, Time hora, String estado, Boolean asistio) {
        this.id = id;
        this.idPaciente = id_paciente;
        this.idEspecialidad = id_especialidad;
        this.idDoctor = id_doctor;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.asistio = asistio;
    }

    public Cita(int id_paciente, int id_especialidad, int id_doctor, Date fecha, Time hora, String estado, Boolean asistio) {
        this.idPaciente = id_paciente;
        this.idEspecialidad = id_especialidad;
        this.idDoctor = id_doctor;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.asistio = asistio;
    }

    public Cita() {
        
    }

    public int getId() {
        return id;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
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

    public Boolean getAsistio() {
        return asistio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
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

    public void setAsistio(Boolean asistio) {
        this.asistio = asistio;
    }

    public String getNombrePaciente() {
        Paciente paciente = new Paciente();
        paciente = PacienteJDBC.instance().selectPaciente(idPaciente);
        nombrePaciente = paciente.getNombre();
        return nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public String getCedulaPciente() {
        return cedulaPciente;
    }
    
    

    
}



