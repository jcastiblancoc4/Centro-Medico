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
import Modelo.Cita;
import Modelo.Doctor;
import Modelo.Especialidad;
import Modelo.Paciente;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpcas
 */
@WebServlet(name = "HistorialCtrl", urlPatterns = {"/HistorialCtrl"})
public class HistorialCtrl extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("accion") != null) {
            String accion = request.getParameter("accion");
            if (accion.equals("Por Paciente") || accion.equals("Consultar Por Paciente")) {
                consultaPorPaciente(request, response, accion);
            } else {
                if (accion.equals("Por Doctor") || accion.equals("Consultar Por Doctor")) {
                    consultaPorDoctor(request, response, accion);

                } else {
                    if (accion.equals("Por Especialidad") || accion.equals("Consultar Por Especialidad")) {
                        consultaPorEspecialidad(request, response, accion);

                    }else{
                        if (accion.equals("Por Fecha")|| accion.equals("Consultar Por Fecha")) {
                        consultaPorFecha(request, response, accion);
                
                }
                    }
                }
            }
        } else {

            request.getRequestDispatcher("WEB-INF/historial/historialindex.jsp").forward(request, response);
        }

    }
    
    
    
    
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void consultaPorPaciente(HttpServletRequest request, HttpServletResponse response, String accion) throws IOException, ServletException {
        if(accion.equals("Por Paciente")){    
        request.setAttribute("tipoFormulario", "Consultar Por Paciente");
        List<Paciente>listaPacientes = PacienteJDBC.instance().select();
        request.setAttribute("pacientes", listaPacientes);
        request.getRequestDispatcher("WEB-INF/historial/historialindex.jsp").forward(request, response);
        }else{
            if(accion.equals("Consultar Por Paciente")){
                int idPaciete = Integer.parseInt(request.getParameter("idPaciente"));
                List<Cita> listaCitas=CitaJDBC.instance().selectCitaPaciente(idPaciete);
                request.setAttribute("citas", listaCitas);
                request.getRequestDispatcher("WEB-INF/citas/citaindex.jsp").forward(request, response);
            }
            
        }
    }

    private void consultaPorDoctor(HttpServletRequest request, HttpServletResponse response, String accion) throws IOException, ServletException {
        if(accion.equals("Por Doctor")){    
        request.setAttribute("tipoFormulario", "Consultar Por Doctor");
        List<Doctor>listaDoctores = DoctorJDBC.instance().select();
        request.setAttribute("doctores", listaDoctores);
        request.getRequestDispatcher("WEB-INF/historial/historialindex.jsp").forward(request, response);
        }else{
            if(accion.equals("Consultar Por Doctor")){
                int idDoctor = Integer.parseInt(request.getParameter("idDoctor"));
                List<Cita> listaCitas=CitaJDBC.instance().selectCitaDoctor(idDoctor);
                request.setAttribute("citas", listaCitas);
                request.getRequestDispatcher("WEB-INF/citas/citaindex.jsp").forward(request, response);
            }
            
        }
    }

    private void consultaPorEspecialidad(HttpServletRequest request, HttpServletResponse response, String accion) throws ServletException, IOException {
        if(accion.equals("Por Especialidad")){    
        request.setAttribute("tipoFormulario", "Consultar Por Especialidad");
        List<Especialidad>listaEspecialidades = EspecialidadJDBC.instance().select();
        request.setAttribute("especialidades", listaEspecialidades);
        request.getRequestDispatcher("WEB-INF/historial/historialindex.jsp").forward(request, response);
        }else{
            if(accion.equals("Consultar Por Especialidad")){
                int idEspecialidad = Integer.parseInt(request.getParameter("idEspecialidad"));
                List<Cita> listaCitas=CitaJDBC.instance().selectCitaEspecialidad(idEspecialidad);
                request.setAttribute("citas", listaCitas);
                request.getRequestDispatcher("WEB-INF/citas/citaindex.jsp").forward(request, response);
            }
            
        }
    }

    private void consultaPorFecha(HttpServletRequest request, HttpServletResponse response, String accion) throws ServletException, IOException {
        if(accion.equals("Por Fecha")){    
        request.setAttribute("tipoFormulario", "Consultar Por Fecha");
        request.getRequestDispatcher("WEB-INF/historial/historialindex.jsp").forward(request, response);
        }else{
            if(accion.equals("Consultar Por Fecha")){
                String fechaA = request.getParameter("fecha");
                Date fecha=new Date();
                try{
                fecha = new SimpleDateFormat("yyyy-mm-dd").parse(fechaA);
                }catch(ParseException e){}
                List<Cita> listaCitas=CitaJDBC.instance().selectCitaFecha(fecha);
                request.setAttribute("citas", listaCitas);
                request.getRequestDispatcher("WEB-INF/citas/citaindex.jsp").forward(request, response);
            }
            
        }
   
    }

}
