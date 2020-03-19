/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ControlDAO.PacienteJDBC;
import Modelo.Paciente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author jpcas

*/
@MultipartConfig
@WebServlet(name = "PacientesCtrl", urlPatterns = {"/PacientesCtrl"})


public class PacientesCtrl extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion") != null) {
            String accion = request.getParameter("accion");
            if (accion.equals("nuevo")) {
                crearPaciente(request, response);
            } else {
                if (accion.equals("editar")) {
                    editarPaciente(request, response);
                }
            }
        } else {
           
            List<Paciente> listaPacientes = PacienteJDBC.instance().select();
            request.setAttribute("pacientes", listaPacientes);
            request.getRequestDispatcher("WEB-INF/pacientes/pacienteindex.jsp").forward(request, response);
        }
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equals("crear")) {
            insertarPaciente(request, response);
        } else {
            if (accion.equals("actualizar")) {
                modificarPaciente(request, response);
            } else {
                if (accion.equals("eliminar")) {
                    eliminarPaciente(request, response);
                }
            }
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void crearPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tipoFormulario", "crear");
        request.getRequestDispatcher("WEB-INF/pacientes/mostrar.jsp").forward(request, response);
    }

    private void insertarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String direccion=request.getParameter("direccion");
        String correo=request.getParameter("correo");
        String celular= request.getParameter("celular");
        String tipoPersona = "paciente";
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        Paciente paciente = new Paciente(nombre, apellido, direccion, correo, celular, tipoPersona, cedula);
        PacienteJDBC.instance().insert(paciente);
        response.sendRedirect("PacientesCtrl");   
    }

    private void editarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Paciente paciente = PacienteJDBC.instance().selectPaciente(id);
        request.setAttribute("paciente", paciente);
        request.setAttribute("tipoFormulario", "actualizar");
        request.getRequestDispatcher("WEB-INF/pacientes/mostrar.jsp").forward(request, response);
    }

    private void modificarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String direccion=request.getParameter("direccion");
        String correo=request.getParameter("correo");
        String celular= request.getParameter("celular");
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        Paciente paciente = new Paciente(id, nombre, apellido, direccion, correo, celular, cedula);
        String mensaje = PacienteJDBC.instance().update(paciente);
        request.setAttribute("mensaje", mensaje);  
        response.sendRedirect("PacientesCtrl");
    }

    private void eliminarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String mensaje = PacienteJDBC.instance().delete(id);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("PacientesCtrl");
    }



}
