/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import ControlDAO.DoctorJDBC;
import ControlDAO.EspecialidadJDBC;
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
    private String asistio;
    
    private Paciente paciente1;
    private String paciente;
    private String cedulaPaciente;
    private String celularPaciente;
    
    
    private Especialidad especialidad1;
    private String especialidad;
    private int valorConsulta;
    private Time duracionConsulta;

    private Doctor doctor1;
    private String doctor;
    private String cedulaDoctor;
    private String celularDoctor;
    
    
    public Cita(int id, int id_paciente, int id_especialidad, int id_doctor, Date fecha, Time hora, String estado, String asistio) {
        this.id = id;
        this.idPaciente = id_paciente;
        this.idEspecialidad = id_especialidad;
        this.idDoctor = id_doctor;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.asistio = asistio;
    }

    public Cita(int id_paciente, int id_especialidad, int id_doctor, Date fecha, Time hora, String estado, String asistio) {
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

    public String getAsistio() {
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

    public void setAsistio(String asistio) {
        this.asistio = asistio;
    }

    public String getPaciente() {
        paciente1 = new Paciente();
        paciente1 = PacienteJDBC.instance().selectPaciente(idPaciente);
        paciente = paciente1.getNombre()+" "+paciente1.getApellido();
        return paciente;
    }


    public String getCedulaPaciente() {
        cedulaPaciente = paciente1.getCedula();
        return cedulaPaciente;
    }
    
    public String getCelularPaciente() {
        celularPaciente = paciente1.getCelular();
        return celularPaciente;
    }

    public String getEspecialidad() {
        especialidad1 = new Especialidad();
        especialidad1 = EspecialidadJDBC.instance().selectEspecialidad(idEspecialidad);
        especialidad = especialidad1.getNombre();
        return especialidad;
    }

    public int getValorConsulta() {
        valorConsulta = especialidad1.getCosto_consulta();
        return valorConsulta;
    }

    public Time getDuracionConsulta() {
        duracionConsulta = especialidad1.getDuracion_consulta();
        return duracionConsulta;
    }

    public String getDoctor() {
        doctor1 = new Doctor();
        doctor1 = DoctorJDBC.instance().selectDoctor(idDoctor);
        doctor = doctor1.getNombre()+" "+doctor1.getApellido();
        return doctor;
    }

    public String getCedulaDoctor() {
        cedulaDoctor = doctor1.getCedula();
        return cedulaDoctor;
    }
    
    public String getCelularDoctor() {
        celularDoctor = doctor1.getCelular();
        return celularDoctor;
        
    }
    
    

    
}



