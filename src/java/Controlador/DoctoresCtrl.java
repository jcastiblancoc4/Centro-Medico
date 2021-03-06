/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import ControlDAO.DoctorJDBC;
import ControlDAO.EspecialidadJDBC;
import Modelo.Doctor;
import Modelo.Especialidad;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicios.Foto;


/**
 *
 * @author jpcas

*/

@WebServlet(name = "DoctoresCtrl", urlPatterns = {"/DoctoresCtrl"})


public class DoctoresCtrl extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("accion") != null) {
            String accion = request.getParameter("accion");
            if (accion.equals("nuevo")) {
                crearDoctor(request, response);
            } else {
                if (accion.equals("editar")) {
                    editarDoctor(request, response);
                }
            }
        } else {
            List<Doctor> listaDoctores = DoctorJDBC.instance().select();
            request.setAttribute("doctores", listaDoctores);
            request.getRequestDispatcher("WEB-INF/doctores/doctorindex.jsp").forward(request, response);
        }
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equals("crear")) {
            try {
                insertarDoctor(request, response);
            } catch (InterruptedException ex) {
                Logger.getLogger(DoctoresCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (accion.equals("actualizar")) {
                try {
                    modificarDoctor(request, response);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DoctoresCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (accion.equals("eliminar")) {
                    eliminarDoctor(request, response);
                }
            }
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void crearDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tipoFormulario", "crear");
        List<Especialidad>listaEspecialidades = EspecialidadJDBC.instance().select();
        request.setAttribute("especialidades", listaEspecialidades);
        request.getRequestDispatcher("WEB-INF/doctores/mostrar.jsp").forward(request, response);
    
    }

    private void insertarDoctor(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String direccion=request.getParameter("direccion");
        String correo=request.getParameter("correo");
        String celular= request.getParameter("celular");
        int especialidad = Integer.parseInt(request.getParameter("idEspecialidad"));
        String tipoPersona = "doctor";
        String cedula = request.getParameter("cedula");
        String rutaFoto = Foto.instance().rutaDestinoFoto(request.getParameter("cedula"),"/web/img/doctores/");
        String rutaOrigen = request.getParameter("foto");
        Doctor doctor = new Doctor(nombre, apellido, direccion, correo, celular, especialidad, tipoPersona, cedula, rutaFoto, rutaOrigen);
        DoctorJDBC.instance().insert(doctor);
        Thread.sleep(2000); 
        response.sendRedirect("DoctoresCtrl");
        
    }

    private void editarDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Doctor doctor = DoctorJDBC.instance().selectDoctor(id);
        request.setAttribute("doctor", doctor);
        request.setAttribute("tipoFormulario", "actualizar");
        List<Especialidad>listaEspecialidades = EspecialidadJDBC.instance().select();
        request.setAttribute("especialidades", listaEspecialidades);
        request.getRequestDispatcher("WEB-INF/doctores/mostrar.jsp").forward(request, response);
    }

    private void modificarDoctor(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String direccion=request.getParameter("direccion");
        String correo=request.getParameter("correo");
        String celular= request.getParameter("celular");
        int especialidad = Integer.parseInt(request.getParameter("idEspecialidad"));
        String tipoPersona = "doctor";
        String cedula = request.getParameter("cedula");
        String rutaFoto = Foto.instance().rutaDestinoFoto(request.getParameter("cedula"),"/web/img/doctores/");
        String rutaOrigen = request.getParameter("foto");
        Doctor doctor = new Doctor(id, nombre, apellido, direccion, correo, celular, especialidad, tipoPersona, cedula, rutaFoto, rutaOrigen);
        DoctorJDBC.instance().update(doctor);
        Thread.sleep(2000); 
        response.sendRedirect("DoctoresCtrl");
    }

    private void eliminarDoctor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String rutaFoto = Foto.instance().rutaDestinoFoto(request.getParameter("cedula"),"/web/img/doctores/");
        String mensaje = DoctorJDBC.instance().delete(id, rutaFoto);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("DoctoresCtrl");
    }

      
    
      
          
      

}
