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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.Foto;


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
            try {
                insertarPaciente(request, response);
            } catch (InterruptedException ex) {
                Logger.getLogger(PacientesCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (accion.equals("actualizar")) {
                try {
                    modificarPaciente(request, response);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PacientesCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
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

    private void insertarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String direccion=request.getParameter("direccion");
        String correo=request.getParameter("correo");
        String celular= request.getParameter("celular");
        String tipoPersona = "paciente";
        String cedula = request.getParameter("cedula");
        String rutaFoto = Foto.instance().rutaDestinoFoto(request.getParameter("cedula"),"/web/img/pacientes/");
        String rutaOrigen = request.getParameter("foto");
        Paciente paciente = new Paciente(nombre, apellido, direccion, correo, celular, tipoPersona, cedula, rutaOrigen, rutaFoto);
        PacienteJDBC.instance().insert(paciente);
         Thread.sleep(2000); 
        response.sendRedirect("PacientesCtrl");   
    }

    private void editarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Paciente paciente = PacienteJDBC.instance().selectPaciente(id);
        request.setAttribute("paciente", paciente);
        request.setAttribute("tipoFormulario", "actualizar");
        request.getRequestDispatcher("WEB-INF/pacientes/mostrar.jsp").forward(request, response);
    }

    private void modificarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String direccion=request.getParameter("direccion");
        String correo=request.getParameter("correo");
        String celular= request.getParameter("celular");
        String cedula = request.getParameter("cedula");
        String rutaFoto = Foto.instance().rutaDestinoFoto(request.getParameter("cedula"),"/web/img/pacientes/");
        String rutaOrigen = request.getParameter("foto");
        Paciente paciente = new Paciente(id, nombre, apellido, direccion, correo, celular, correo, cedula, rutaOrigen, rutaFoto);
        String mensaje = PacienteJDBC.instance().update(paciente);
        request.setAttribute("mensaje", mensaje);  
        Thread.sleep(2000);
        response.sendRedirect("PacientesCtrl");
    }

    private void eliminarPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String rutaFoto = Foto.instance().rutaDestinoFoto(request.getParameter("cedula"),"/web/img/pacientes/");
        String mensaje = PacienteJDBC.instance().delete(id, rutaFoto);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("PacientesCtrl");
    }



}
