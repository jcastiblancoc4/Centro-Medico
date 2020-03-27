/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import ControlDAO.CitaJDBC;
import ControlDAO.DoctorJDBC;
import ControlDAO.EspecialidadJDBC;
import Modelo.Agenda;
import Modelo.Doctor;
import Modelo.Especialidad;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jpcas
 */
public class AgendaCtrl {
    
    public List<Agenda> generarHorario(int idDoctor, Date fecha){
        Agenda franja= null;
        List<Agenda> horario=new ArrayList();
        Doctor doctor=DoctorJDBC.instance().selectDoctor(idDoctor);
        Especialidad especialidad=EspecialidadJDBC.instance().selectEspecialidad(doctor.getIdEspecialidad());
        int horaInicio=8;
        int minutoInicio=0;
        int segundoInicio=0;        
        String rango=especialidad.getDuracion_consulta().toString();
        String[] rangoHora=rango.split(":");
        int horaRango=Integer.parseInt(rangoHora[0]);
        int minutoRango=Integer.parseInt(rangoHora[1]);
        int segundoRango=Integer.parseInt(rangoHora[2]);
        while(horaInicio<17){
            franja= new Agenda();
            franja.setDoctor(doctor.getNombre()+" "+doctor.getApellido());
            
            Time inicioFranja = new Time(horaInicio, minutoInicio, segundoInicio);
            franja.setHoraInicio(inicioFranja);
            
            horaInicio = horaInicio+horaRango;
            minutoInicio = minutoInicio + minutoRango;
            segundoInicio = segundoInicio + segundoRango;
            
            if(segundoInicio>=60){
                minutoInicio = minutoInicio +1;
                segundoInicio = segundoInicio - 60;
            }
            if(minutoInicio>=60){
                horaInicio = horaInicio +1;
                minutoInicio = minutoInicio - 60;
            }
            Time finFranja = new Time(horaInicio, minutoInicio, segundoInicio);
            franja.setHoraFin(finFranja);
            
            int cantidadCitas = CitaJDBC.instance().selectFecha(fecha, inicioFranja);
            if(cantidadCitas==0){
                franja.setEstado("disponible");
            }else{
                franja.setEstado("asignada");
            }
            horario.add(franja);
//            System.out.println("doctor "+ franja.getDoctor());
//            System.out.println("inicio "+ franja.getHoraInicio());
//            System.out.println("fin "+ franja.getHoraFin());
//            System.out.println("estado "+ franja.getEstado());
//            System.out.println("_______________");
        }
        
        return horario;
    }
            
    
    
    
    
    
    
    private static AgendaCtrl agendaCtrl;
    
    public static AgendaCtrl instance() {
        if (agendaCtrl == null) {
            agendaCtrl = new AgendaCtrl();
        }
        return agendaCtrl;
    }
    
}
