/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import ControlDAO.EspecialidadJDBC;

import Modelo.Especialidad;
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
@WebServlet(name = "EspecialidadesCtrl", urlPatterns = {"/EspecialidadesCtrl"})
public class EspecialidadesCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    if (request.getParameter("accion") != null) {
        String accion = request.getParameter("accion");
        if (accion.equals("nueva")) {
            crearEspecialidad(request, response);
            } else {
                if (accion.equals("editar")) {
                    editarEspecialidad(request, response);
                } 
            }

        } else {
            List<Especialidad> listaEspecialidades = EspecialidadJDBC.instance().select();
            request.setAttribute("especialidades", listaEspecialidades);
            request.getRequestDispatcher("WEB-INF/especialidades/especialidadindex.jsp").forward(request, response);
        }

    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equals("crear")) {
        insertarEspecialidad(request, response);
        } else {
            if (accion.equals("actualizar")) {
                modificarEspecialidad(request, response);
            } else {
                if (accion.equals("eliminar")) {
                   eliminarEspecialidad(request, response);
                }

            }

        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void crearEspecialidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tipoFormulario", "crear");
        request.getRequestDispatcher("WEB-INF/especialidades/mostrar.jsp").forward(request, response);
    
        
         }

    private void insertarEspecialidad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre=request.getParameter("nombre");
        String descripcion=request.getParameter("descripcion");
        double costo_consulta=Integer.parseInt(request.getParameter("costo_consulta"));
        String duracion_consulta = request.getParameter("duracion_consulta");
        Especialidad especialidad = new Especialidad(nombre, descripcion, costo_consulta, duracion_consulta);
        EspecialidadJDBC.instance().insert(especialidad);
        response.sendRedirect("EspecialidadesCtrl");    
    
    
    }

    private void editarEspecialidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Especialidad especialidad = EspecialidadJDBC.instance().selectEspecialidad(id);
        request.setAttribute("especialidad", especialidad);
        request.setAttribute("tipoFormulario", "actualizar");
        request.getRequestDispatcher("WEB-INF/especialidades/mostrar.jsp").forward(request, response);
        
    }
 
    private void modificarEspecialidad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre= request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double costo_consulta = Double.parseDouble(request.getParameter("costo_consulta"));
        String duracion_consulta = request.getParameter("duracion_consulta");
        Especialidad especialidad=new Especialidad(id, nombre, descripcion, costo_consulta, duracion_consulta);
        String mensaje = EspecialidadJDBC.instance().update(especialidad);
        request.setAttribute("mensaje", mensaje);  
        response.sendRedirect("EspecialidadesCtrl");
    }

    private void eliminarEspecialidad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String mensaje = EspecialidadJDBC.instance().delete(id);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("EspecialidadesCtrl");
    }

  
 


}
