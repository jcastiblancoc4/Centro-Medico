/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ControlDAO.CitaJDBC;
import Modelo.Cita;
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

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        if (request.getParameter("accion") != null) {
            String accion = request.getParameter("accion");
            if (accion.equals("nuevo")) {
               // crearDoctor(request, response);
            } else {
                if (accion.equals("editar")) {
                 //   editarDoctor(request, response);
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
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
