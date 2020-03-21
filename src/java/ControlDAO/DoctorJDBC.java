/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlDAO;

import Modelo.Doctor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicios.Conexion;
import servicios.Foto;

/**
 *
 * @author jpcas
 */
public class DoctorJDBC {
    
    private final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, direccion, correo, celular, idEspecialidad, tipoPersona, cedula, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
    public String insert(Doctor doctor){
        String mensaje ="";
        String rutaFoto ="img/doctores/";
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;
        try{
            conn= Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, doctor.getNombre());
            stmt.setString(index++, doctor.getApellido());
            stmt.setString(index++, doctor.getDireccion());
            stmt.setString(index++, doctor.getCorreo());
            stmt.setString(index++, doctor.getCelular());
            stmt.setInt(index++, doctor.getIdEspecialidad());
            stmt.setString(index++, doctor.getTipoPersona());
            stmt.setString(index++, doctor.getCedula());
            stmt.setString(index++, rutaFoto+doctor.getCedula()+".png");
            row = stmt.executeUpdate();
        } catch (SQLException e) {
           System.out.println(mensaje = "Error: " + e.getMessage());
        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
            Foto.instance().copiarPegarArchivo(doctor.getRutaOrigen(), doctor.getRutaFoto());
        }
        return mensaje;
    }
    
     private final String SQL_SELECT = "SELECT * FROM persona WHERE tipoPersona='doctor'";
    public List<Doctor> select() throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Doctor doctor = null;
        List<Doctor> doctores = new ArrayList();
            try {
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT);
                rs = stmt.executeQuery();
                while (rs.next()) {
                doctor = new Doctor();
                doctor.setId(rs.getInt(1));
                doctor.setNombre(rs.getString(2));
                doctor.setApellido(rs.getString(3));
                doctor.setDireccion(rs.getString(4));
                doctor.setCorreo(rs.getString(5));
                doctor.setCelular(rs.getString(6));
                doctor.setIdEspecialidad(rs.getInt(7));
                doctor.setTipoPersona(rs.getString(8));
                doctor.setCedula(rs.getString(10));
                doctor.setRutaFoto(rs.getString(11));
                doctores.add(doctor);
                
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
            Conexion.closed(rs);
        }
        return doctores;
    }
    
     private final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, direccion=?, correo=?, celular=?, idespecialidad=?, tipopersona=?, cedula=?, foto=? WHERE id=?;";
    public String update(Doctor doctor) {
        String mensaje = "";
        String rutaFoto ="img/doctores/";
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1; 
            stmt.setString(index++, doctor.getNombre());
            stmt.setString(index++, doctor.getApellido());
            stmt.setString(index++, doctor.getDireccion());
            stmt.setString(index++, doctor.getCorreo());
            stmt.setString(index++, doctor.getCelular());
            stmt.setInt(index++, doctor.getIdEspecialidad());
            stmt.setString(index++, doctor.getTipoPersona());
            stmt.setString(index++, doctor.getCedula());
            stmt.setString(index++, rutaFoto+doctor.getCedula()+".png");
            stmt.setInt(index++, doctor.getId());
            row = stmt.executeUpdate();
            
            mensaje = "Se actualizo" + row + "registro(s), satisfactoriamente";
        } catch (SQLException e) {
            System.out.println(  mensaje = "Error: " + e.getMessage());

        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
        }
        return mensaje;
    }
    
    private final String SQL_SELECT2 = "SELECT id, nombre, apellido, direccion, correo, celular, idespecialidad, tipopersona, cedula FROM persona WHERE id=?;";
     public Doctor selectDoctor(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Doctor doctor = null;
        try{
             conn= Conexion.getConnection();
             stmt = conn.prepareStatement(SQL_SELECT2);
             stmt.setInt(1, id);
             rs = stmt.executeQuery();
             while(rs.next()){
                doctor = new Doctor(); 
                doctor.setId(rs.getInt(1));
                doctor.setNombre(rs.getString(2));
                doctor.setApellido(rs.getString(3));
                doctor.setDireccion(rs.getString(4));
                doctor.setCorreo(rs.getString(5));
                doctor.setCelular(rs.getString(6));
                doctor.setIdEspecialidad(rs.getInt(7));
                doctor.setTipoPersona(rs.getString(8));
                doctor.setCedula(rs.getString(9));
               }
         }catch(SQLException e){
             System.out.print("Error >> " +e.getMessage());
         }
        finally{
          Conexion.closed(stmt);
          Conexion.closed(conn);
          Conexion.closed(rs);
         }
       
         return doctor;
    }
    
    
     private final String SQL_DELETE = "DELETE FROM persona WHERE id=?";
        public String delete(int id, String foto){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        String mensaje="";
            try{
                conn= Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_DELETE);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                }catch(SQLException e){
              mensaje = "Error : " + e.getMessage();
         }finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
            Conexion.closed(rs);
            Foto.instance().eliminarFoto(foto);
        }
      
        return mensaje;        
    }
        
        
        
        
    
    
    
    private static DoctorJDBC doctorJDBC;
    
    public static DoctorJDBC instance() {
        if (doctorJDBC == null) {
            doctorJDBC = new DoctorJDBC();
        }
        return doctorJDBC;
    }
    
}
