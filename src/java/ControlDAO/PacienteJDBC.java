/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlDAO;

import Modelo.Doctor;
import Modelo.Paciente;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicios.Conexion;

/**
 *
 * @author jpcas
 */
public class PacienteJDBC {
    
    private final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, direccion, correo, celular, tipoPersona, cedula) VALUES (?, ?, ?, ?, ?, ?, ?);";
    
    public String insert(Paciente paciente){
        String mensaje ="";
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;
        try{
            conn= Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setString(index++, paciente.getNombre());
            stmt.setString(index++, paciente.getApellido());
            stmt.setString(index++, paciente.getDireccion());
            stmt.setString(index++, paciente.getCorreo());
            stmt.setString(index++, paciente.getCelular());
            stmt.setString(index++, paciente.getTipoPersona());
            stmt.setInt(index++, paciente.getCedula());
            row = stmt.executeUpdate();
        } catch (SQLException e) {
           System.out.println(mensaje = "Error: " + e.getMessage());
        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
        }
        return mensaje;
    }
    
     private final String SQL_SELECT = "SELECT * FROM persona WHERE tipopersona='paciente'";
    public List<Paciente> select() throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente paciente = null;
        List<Paciente> pacientes = new ArrayList();
            try {
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT);
                rs = stmt.executeQuery();
                while (rs.next()) {
                paciente = new Paciente();
                paciente.setId(rs.getInt(1));
                paciente.setNombre(rs.getString(2));
                paciente.setApellido(rs.getString(3));
                paciente.setDireccion(rs.getString(4));
                paciente.setCorreo(rs.getString(5));
                paciente.setCelular(rs.getString(6));
                paciente.setTipoPersona(rs.getString(8));
                paciente.setNumeroCitas(rs.getInt(9));
                paciente.setCedula(rs.getInt(10));
                pacientes.add(paciente);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
            Conexion.closed(rs);
        }
            System.out.print(rs);
        return pacientes;
    }
    
     private final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, direccion=?, correo=?, celular=?, cedula=? WHERE id=?;";
    public String update(Paciente paciente) {
        String mensaje = "";
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1; 
            stmt.setString(index++, paciente.getNombre());
            stmt.setString(index++, paciente.getApellido());
            stmt.setString(index++, paciente.getDireccion());
            stmt.setString(index++, paciente.getCorreo());
            stmt.setString(index++, paciente.getCelular());
            stmt.setInt(index++, paciente.getCedula());
            stmt.setInt(index++, paciente.getId());
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
    
    private final String SQL_SELECT2 = "SELECT id, nombre, apellido, direccion, correo, celular, cedula FROM persona WHERE id=?;";
     public Paciente selectPaciente(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Paciente paciente = null;
        try{
             conn= Conexion.getConnection();
             stmt = conn.prepareStatement(SQL_SELECT2);
             stmt.setInt(1, id);
             rs = stmt.executeQuery();
             while(rs.next()){
                paciente = new Paciente(); 
                paciente.setId(rs.getInt(1));
                paciente.setNombre(rs.getString(2));
                paciente.setApellido(rs.getString(3));
                paciente.setDireccion(rs.getString(4));
                paciente.setCorreo(rs.getString(5));
                paciente.setCelular(rs.getString(6));
                paciente.setCedula(rs.getInt(7));
             }
         }catch(SQLException e){
             System.out.print("-------------"+e.getMessage());
         }
        finally{
          Conexion.closed(stmt);
          Conexion.closed(conn);
          Conexion.closed(rs);
         }
       
         return paciente;
    }
    
    
     private final String SQL_DELETE = "DELETE FROM persona WHERE id=?";
    public String delete(int id){
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
        }
      
        return mensaje;        
    }
    
    
    private static PacienteJDBC pacienteJDBC;
    
    public static PacienteJDBC instance() {
        if (pacienteJDBC == null) {
            pacienteJDBC = new PacienteJDBC();
        }
        return pacienteJDBC;
    }

    
}
