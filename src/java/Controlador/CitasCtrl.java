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
import java.io.PrintWriter;
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
@WebServlet(name = "CitasCtrl", urlPatterns = {"/CitasCtrl"})
public class CitasCtrl extends HttpServlet {
    Cita cita= null;
  
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
        if (accion.equals("doctor")) {
            insertarCita(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void crearCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tipoFormulario", "doctor");
        List<Paciente>listaPacientes = PacienteJDBC.instance().select();
        request.setAttribute("pacientes", listaPacientes);
        List<Especialidad>listaEspecialidades = EspecialidadJDBC.instance().select();
        request.setAttribute("especialidades", listaEspecialidades); 
        request.getRequestDispatcher("WEB-INF/citas/mostrar.jsp").forward(request, response);
    }
    
    private void insertarCita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
        Paciente pacienteM = PacienteJDBC.instance().selectPaciente(idPaciente);
        String paciente = pacienteM.getNombre()+ " " + pacienteM.getApellido();
        request.setAttribute("paciente", paciente);
        String cedulaPaciente = pacienteM.getCedula();
        request.setAttribute("cedulaPaciente", cedulaPaciente);
        int idEspecialidad = Integer.parseInt(request.getParameter("idEspecialidad"));
        Especialidad especialidadM = EspecialidadJDBC.instance().selectEspecialidad(idEspecialidad);
        String especialidad = especialidadM.getNombre();
        request.setAttribute("especialidad", especialidad);
        int valor= especialidadM.getCosto_consulta();
        request.setAttribute("valor", valor);
        
        request.setAttribute("tipoFormulario", "agenda");
        List<Doctor> listaDoctoresE = DoctorJDBC.instance().selectDoctoresE(idEspecialidad);
        request.setAttribute("doctoresE", listaDoctoresE);
        cita = new Cita();
        cita.setIdPaciente(idPaciente);
        cita.setIdEspecialidad(idEspecialidad);
        request.getRequestDispatcher("WEB-INF/citas/mostrar.jsp").forward(request, response);
    }

    private void mostrarAgenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tipoFormulario", "crear");
        request.getRequestDispatcher("WEB-INF/citas/mostrar.jsp").forward(request, response);
    }

}
