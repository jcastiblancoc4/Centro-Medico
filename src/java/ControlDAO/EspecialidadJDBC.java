/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlDAO;

import Modelo.Especialidad;
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
public class EspecialidadJDBC {
    
    private final String SQL_INSERT = "INSERT INTO Especialidad(nombre, descripcion, costo_consulta, duracion_consulta) VALUES (?, ?, ?, ?);";
    
    public String insert(Especialidad especialidad) {
        String mensaje = "";
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;  //Contador de columnas en el SQL
            stmt.setString(index++, especialidad.getNombre());
            stmt.setString(index++, especialidad.getDescripcion());
            stmt.setInt(index++, especialidad.getCosto_consulta());
            stmt.setTime(index++, especialidad.getDuracion_consulta());
            row = stmt.executeUpdate();
            mensaje = "Se inserto " + row + " registro(s), satisfactoriamente";
        } catch (SQLException e) {
           System.out.print( mensaje = "Error: " + e.getMessage());
        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
        }
        return mensaje;
    }
    
 
    private final String SQL_UPDATE = "UPDATE Especialidad SET nombre=?, descripcion=?, costo_consulta=?, duracion_consulta=? WHERE id=?";
    public String update(Especialidad especialidad) {
        String mensaje = "";
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1; 
            stmt.setString(index++, especialidad.getNombre());
            stmt.setString(index++, especialidad.getDescripcion());
            stmt.setInt(index++, especialidad.getCosto_consulta());
            stmt.setTime(index++, especialidad.getDuracion_consulta());
            stmt.setInt(index++, especialidad.getId());
            row = stmt.executeUpdate();
            mensaje = "Se actualizo" + row + "registro(s), satisfactoriamente";
        } catch (SQLException e) {
            System.out.println("--------------------------------");
           System.out.println(  mensaje = "Error: " + e.getMessage());

        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
        }
        return mensaje;

    }
        
    private final String SQL_SELECT = "SELECT * FROM Especialidad";
    public List<Especialidad> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Especialidad especialidad = null;
        List<Especialidad> especialidades = new ArrayList();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                especialidad = new Especialidad();
                especialidad.setId(rs.getInt(1));
                especialidad.setNombre(rs.getString(2));
                especialidad.setDescripcion(rs.getString(3));
                especialidad.setCosto_consulta(rs.getInt(4));
                especialidad.setDuracion_consulta(rs.getString(5));
                especialidades.add(especialidad);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
            Conexion.closed(rs);
        }
        return especialidades;
    }
    
    private final String SQL_SELECT2 = "SELECT id, nombre, descripcion, costo_consulta, duracion_consulta FROM Especialidad WHERE id=?";
     public Especialidad selectEspecialidad(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Especialidad especialidad = null;
        try{
             conn= Conexion.getConnection();
             stmt = conn.prepareStatement(SQL_SELECT2);
             stmt.setInt(1, id);
             rs = stmt.executeQuery();
             while(rs.next()){
                especialidad= new Especialidad();
                especialidad.setId(rs.getInt(1));
                especialidad.setNombre(rs.getString(2));
                especialidad.setDescripcion(rs.getString(3));
                especialidad.setCosto_consulta(rs.getInt(4));
                especialidad.setDuracion_consulta(rs.getString(5));
             }
         }catch(SQLException e){
             System.out.print(e.getMessage());
         }
        finally{
          Conexion.closed(stmt);
          Conexion.closed(conn);
          Conexion.closed(rs);
         }
       
         return especialidad;
    }
     
       
    private final String SQL_DELETE = "DELETE FROM Especialidad WHERE id=?";
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
        
    private static EspecialidadJDBC especialidadJDBC;
    
    public static EspecialidadJDBC instance() {
        if (especialidadJDBC == null) {
            especialidadJDBC = new EspecialidadJDBC();
        }
        return especialidadJDBC;
    }

   

    

    
    
    
}
