/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ControlDAO.CitaJDBC;
import ControlDAO.DoctorJDBC;
import ControlDAO.EspecialidadJDBC;
import ControlDAO.PacienteJDBC;
import Modelo.Agenda;
import Modelo.Cita;
import Modelo.Doctor;
import Modelo.Especialidad;
import Modelo.Paciente;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.AgendaCtrl;

/**
 *
 * @author jpcas
 */
@WebServlet(name = "CitasCtrl", urlPatterns = {"/CitasCtrl"})
public class CitasCtrl extends HttpServlet {
    int idPaciente;
    int idEspecialidad; 
    int idDoctor;
    Date fecha;
    Time hora;
    
   
    String paciente;
    String cedulaPaciente;
    String especialidad ;
    int valor;
    String doctor;
    String cedulaDoctor;
    
    Cita cita;
     int idCita;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        if (request.getParameter("accion") != null) {
            String accion = request.getParameter("accion");
            if (accion.equals("nuevo")) {
                crearCita(request, response);
            } else {
                if (accion.equals("agenda")) {
                    mostrarAgenda(request, response);
                }
            }
        } else {
            List<Cita> listaCitas = CitaJDBC.instance().select();
            request.setAttribute("citas", listaCitas);
            request.getRequestDispatcher("WEB-INF/citas/citaindex.jsp").forward(request, response);
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equals("especialidad") || accion.equals("doctor") || accion.equals("agenda") || accion.equals("hora")|| accion.equals("validar-crear")) {
            try {
                insertarCita(request, response, accion);
            } catch (ParseException ex) {
            }
        }else{
            if(accion.equals("eliminar")){
                eliminarCita(request, response);
            }else{
                if(accion.equals("gestionar")|| accion.equals("cancelar")|| accion.equals("Si") || accion.equals("No") || accion.equals("atender") || accion.equals("terminar consulta") ){
                    try {
                        gestionarCita(request, response, accion);
                    } catch (ParseException ex) {
                        Logger.getLogger(CitasCtrl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void crearCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Paciente>listaPacientes = PacienteJDBC.instance().selectPacientes();
        request.setAttribute("pacientes", listaPacientes);
        request.setAttribute("tipoFormulario", "especialidad");
        request.getRequestDispatcher("WEB-INF/citas/mostrar.jsp").forward(request, response);
    }
    
    private void insertarCita(HttpServletRequest request, HttpServletResponse response, String accion) throws ServletException, IOException, ParseException {
        if(accion.equals("especialidad")){
            idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
            Paciente pacienteM = PacienteJDBC.instance().selectPaciente(idPaciente);
            paciente = pacienteM.getNombre()+ " " + pacienteM.getApellido();
            request.setAttribute("paciente", paciente);
            cedulaPaciente = pacienteM.getCedula();
            request.setAttribute("cedulaPaciente", cedulaPaciente);
            List<Especialidad>listaEspecialidades = EspecialidadJDBC.instance().select();
            request.setAttribute("especialidades", listaEspecialidades);
            request.setAttribute("tipoFormulario", "doctor");
            request.getRequestDispatcher("WEB-INF/citas/mostrar.jsp").forward(request, response);   
        }else {
            if (accion.equals("doctor")) {
                request.setAttribute("paciente", paciente);
                request.setAttribute("cedulaPaciente", cedulaPaciente);
                idEspecialidad = Integer.parseInt(request.getParameter("idEspecialidad"));
                Especialidad especialidadM = EspecialidadJDBC.instance().selectEspecialidad(idEspecialidad);
                especialidad = especialidadM.getNombre();
                request.setAttribute("especialidad", especialidad);
                valor= especialidadM.getCosto_consulta();
                request.setAttribute("valor", valor);
                List<Doctor> listaDoctoresE = DoctorJDBC.instance().selectDoctoresE(idEspecialidad);
                request.setAttribute("doctoresE", listaDoctoresE);
                request.setAttribute("tipoFormulario", "agenda");
                request.getRequestDispatcher("WEB-INF/citas/mostrar.jsp").forward(request, response);    
            }else{
                if(accion.equals("agenda")){
                    request.setAttribute("paciente", paciente);
                    request.setAttribute("cedulaPaciente", cedulaPaciente);
                    request.setAttribute("especialidad", especialidad);
                    request.setAttribute("valor", valor);
                    idDoctor = Integer.parseInt(request.getParameter("idDoctor"));
                    Doctor doctorM = DoctorJDBC.instance().selectDoctor(idDoctor);
                    doctor = doctorM.getNombre()+ " " + doctorM.getApellido();
                    request.setAttribute("doctor", doctor);
                    cedulaDoctor = doctorM.getCedula();
                    request.setAttribute("cedulaDoctor", cedulaDoctor);
                    request.setAttribute("tipoFormulario", "hora");
                    request.getRequestDispatcher("WEB-INF/citas/mostrar.jsp").forward(request, response);
                }else{
                    if(accion.equals("hora")){
                        request.setAttribute("paciente", paciente);
                        request.setAttribute("cedulaPaciente", cedulaPaciente);
                        request.setAttribute("especialidad", especialidad);
                        request.setAttribute("valor", valor);
                        request.setAttribute("doctor", doctor);
                        request.setAttribute("cedulaDoctor", cedulaDoctor);
                        String fechaA = request.getParameter("fecha");
                        fecha=new Date();
                        try{
                        fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaA);
                        }catch(ParseException e){}
                        List<Agenda> horario = AgendaCtrl.instance().generarHorario(idDoctor, fecha);
                        request.setAttribute("horario", horario);
                        request.setAttribute("fecha", fechaA);
                        request.setAttribute("tipoFormulario", "validar-crear");
                        request.getRequestDispatcher("WEB-INF/citas/mostrar.jsp").forward(request, response);

                    }else{
                        if(accion.equals("validar-crear")){
                            hora =java.sql.Time.valueOf(request.getParameter("hora"));
                            if(validarEspecialidad(idPaciente, idEspecialidad)==1){
                                if(validarFecha(fecha)==1){
                                    
                                    Cita cita = new Cita(idPaciente, idEspecialidad, idDoctor, fecha, hora, "agendada", "Pendiente");
                                    String mensaje=CitaJDBC.instance().insert(cita);
                                    PacienteJDBC.instance().aumentarContador(idPaciente);
                                    response.sendRedirect("CitasCtrl");
                                }else{
                                    System.out.println("Fecha no valida, la fecha no puede ser igual o menor a la actual");
                                    
                                }
                            }else{
                                System.out.println("el paciente ya tiene una cita pendiente de la misma especialidad");
                            }
                        }
                    }
                }
            }
        }
                
        
    }

    private void mostrarAgenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tipoFormulario", "validar");
//        List<Agenda> horario = AgendaCtrl.instance().generarHorario(idDoctor, fecha);
        request.getRequestDispatcher("WEB-INF/citas/mostrar.jsp").forward(request, response);
    }

    private void eliminarCita(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String mensaje = CitaJDBC.instance().delete(id);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("CitasCtrl");
    }

    private int validarEspecialidad(int idPaciente, int idEspecialidad) {
        int numeroCitas = CitaJDBC.instance().selectNumeroCitas(idPaciente, idEspecialidad);
        if(numeroCitas==0){
        return 1;    
        }else{
            return 0;
        }
    }

    private int validarFecha(Date fechaCita) throws ParseException {
        Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fechaSistema = formateador.format(fechaActual);
        Date fecha1 = formateador.parse(fechaSistema);
        if (fecha1.before(fechaCita)) {
            return 1;
        } else {
            if (fechaCita.before(fecha1)) {
                return 0;
            } else {
                return 0;
            }
        }
    }

    private void gestionarCita(HttpServletRequest request, HttpServletResponse response, String accion) throws ServletException, IOException, ParseException {
        if(accion.equals("gestionar")){
            idCita = Integer.parseInt(request.getParameter("id"));
            cita = CitaJDBC.instance().selectCita(idCita);
            request.setAttribute("dias", validarCancelacion(cita.getFecha()));
            request.setAttribute("cita", cita);
            request.setAttribute("tipoFormulario", "gestionar");
            request.getRequestDispatcher("WEB-INF/citas/gestion.jsp").forward(request, response);
        }else{
            if(accion.equals("cancelar")){
            CitaJDBC.instance().cancelarCita(idCita);
            request.setAttribute("cita", cita);
            request.setAttribute("tipoFormulario", "cancelar");
            request.getRequestDispatcher("WEB-INF/citas/gestion.jsp").forward(request, response);
            }else{
                 if(accion.equals("Si")){
                    request.setAttribute("cita", cita); 
                    eliminarCita(request, response);
                 }else {
                    if(accion.equals("No")){
                    request.setAttribute("cita", cita); 
                    response.sendRedirect("CitasCtrl");
                    }else {
                         if(accion.equals("atender")){
                            request.setAttribute("cita", cita);
                            request.setAttribute("tipoFormulario", "atender");
                            request.getRequestDispatcher("WEB-INF/citas/gestion.jsp").forward(request, response); 
                         }else {
                             if(accion.equals("terminar consulta")){
                                
                                String asistio = request.getParameter("asistio");
                                String observacion = request.getParameter("observacion");
                                System.out.println(  ">>>>>>>>>>>>>>>>>> " + asistio + " "+ observacion);
                                CitaJDBC.instance().finalizarCita(idCita, asistio,observacion);
                                response.sendRedirect("CitasCtrl");
                             }
                         }
                    }
                 }
            }
        }
    }

    private int validarCancelacion(Date fechaCita) throws ParseException {
        Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fechaSistema = formateador.format(fechaActual);  
        Date hoy = formateador.parse(fechaSistema);
        int dias=(int) ((fechaCita.getTime()-hoy.getTime())/86400000);
        
        return dias;
    }

}
