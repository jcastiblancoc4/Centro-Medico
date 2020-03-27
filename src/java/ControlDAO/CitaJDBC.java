/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlDAO;

import Modelo.Cita;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import servicios.Conexion;

/**
 *
 * @author jpcas
 */
public class CitaJDBC {
    
    private final String SQL_INSERT = "INSERT INTO cita(id_paciente, id_especialidad, id_doctor, fecha, estado, asistio, hora) VALUES (?, ?, ?, ?, ?, ?, ?);";
    
    public String insert(Cita cita){
        String mensaje="";
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;
        try{
            conn= Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;
            stmt.setInt(index++, cita.getIdPaciente());
            stmt.setInt(index++, cita.getIdEspecialidad());
            stmt.setInt(index++, cita.getIdDoctor());
            java.sql.Date fechaSQL = new java.sql.Date(cita.getFecha().getTime());
            stmt.setDate(index++, fechaSQL);
            stmt.setString(index++, cita.getEstado());
            stmt.setBoolean(index++, cita.getAsistio());
            stmt.setTime(index++, cita.getHora());
            row = stmt.executeUpdate();
        } catch (SQLException e) {
           System.out.println(">>>> Error: " + e.getMessage());
        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
        }
        return mensaje;
    }
           
    private final String SQL_SELECT = "SELECT * FROM cita";
    public List<Cita> select() throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cita cita = null;
        List<Cita> citas = new ArrayList();
            try {
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT);
                rs = stmt.executeQuery();
                while (rs.next()) {
                cita = new Cita();
                cita.setId(rs.getInt(1));
                cita.setIdPaciente(rs.getInt(2));
                cita.setIdEspecialidad(rs.getInt(3));
                cita.setIdDoctor(rs.getInt(4));
                cita.setFecha(rs.getDate(5));
                cita.setEstado(rs.getString(6));
                cita.setAsistio(rs.getBoolean(7));
                cita.setHora(rs.getTime(8));
                citas.add(cita);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
            Conexion.closed(rs);
        }
        return citas;
    }
    
    
    
    
    private final String SQL_SELECT_P = "SELECT * FROM cita WHERE id_paciente=?";
    public List<Cita> selectCitaPaciente(int id) throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cita cita = null;
        List<Cita> citas = new ArrayList();
            try {
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT_P);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                while (rs.next()) {
                cita = new Cita();
                cita.setId(rs.getInt(1));
                cita.setIdPaciente(rs.getInt(2));
                cita.setIdEspecialidad(rs.getInt(3));
                cita.setIdDoctor(rs.getInt(4));
                cita.setFecha(rs.getDate(5));
                cita.setEstado(rs.getString(6));
                cita.setAsistio(rs.getBoolean(7));
                cita.setHora(rs.getTime(8));
                citas.add(cita);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
            Conexion.closed(rs);
        }
        return citas;
    }
    
    private final String SQL_SELECT_D = "SELECT * FROM cita WHERE id_doctor=?";
    public List<Cita> selectCitaDoctor(int id) throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cita cita = null;
        List<Cita> citas = new ArrayList();
            try {
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT_D);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                while (rs.next()) {
                cita = new Cita();
                cita.setId(rs.getInt(1));
                cita.setIdPaciente(rs.getInt(2));
                cita.setIdEspecialidad(rs.getInt(3));
                cita.setIdDoctor(rs.getInt(4));
                cita.setFecha(rs.getDate(5));
                cita.setEstado(rs.getString(6));
                cita.setAsistio(rs.getBoolean(7));
                cita.setHora(rs.getTime(8));
                citas.add(cita);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
            Conexion.closed(rs);
        }
        return citas;
    }
    
    
    private final String SQL_SELECT_E = "SELECT * FROM cita WHERE id_especialidad=?";
    public List<Cita> selectCitaEspecialidad(int id) throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cita cita = null;
        List<Cita> citas = new ArrayList();
            try {
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT_E);
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                while (rs.next()) {
                cita = new Cita();
                cita.setId(rs.getInt(1));
                cita.setIdPaciente(rs.getInt(2));
                cita.setIdEspecialidad(rs.getInt(3));
                cita.setIdDoctor(rs.getInt(4));
                cita.setFecha(rs.getDate(5));
                cita.setEstado(rs.getString(6));
                cita.setAsistio(rs.getBoolean(7));
                cita.setHora(rs.getTime(8));
                citas.add(cita);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
            Conexion.closed(rs);
        }
        return citas;
    }
    
    private final String SQL_SELECT_F = "SELECT * FROM cita WHERE fecha=?";
    public List<Cita> selectCitaFecha(Date fecha) throws IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cita cita = null;
        List<Cita> citas = new ArrayList();
            try {
                conn = Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT_F);
                java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
                stmt.setDate(1, fechaSQL);
                rs = stmt.executeQuery();
                while (rs.next()) {
                cita = new Cita();
                cita.setId(rs.getInt(1));
                cita.setIdPaciente(rs.getInt(2));
                cita.setIdEspecialidad(rs.getInt(3));
                cita.setIdDoctor(rs.getInt(4));
                cita.setFecha(rs.getDate(5));
                cita.setEstado(rs.getString(6));
                cita.setAsistio(rs.getBoolean(7));
                cita.setHora(rs.getTime(8));
                citas.add(cita);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            Conexion.closed(stmt);
            Conexion.closed(conn);
            Conexion.closed(rs);
        }
        return citas;
    }
    
    
    
    private final String SQL_UPDATE = "UPDATE cita SET id_paciente=?, id_especialidad=?, id_doctor=?, fecha=?, estado=?, asistio=?, hora=?WHERE id=?;";
    public String update(Cita cita) {
        String mensaje = "";
        Connection conn = null;
        PreparedStatement stmt = null;
        int row = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1; 
            stmt.setInt(index++, cita.getIdPaciente());
            stmt.setInt (index++, cita.getIdEspecialidad());
            stmt.setInt (index++, cita.getIdDoctor());
            stmt.setDate (index++, (java.sql.Date) cita.getFecha());
            stmt.setString (index++, cita.getEstado());
            stmt.setBoolean (index++, cita.getAsistio());
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
    
    private final String SQL_SELECT2 = "SELECT id, id_paciente, id_especialidad, id_doctor, fecha, estado, asistio, hora FROM cita WHERE id=?;";
     public Cita selectCita(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Cita cita = null;
        try{
             conn= Conexion.getConnection();
             stmt = conn.prepareStatement(SQL_SELECT2);
             stmt.setInt(1, id);
             rs = stmt.executeQuery();
             while(rs.next()){
                cita = new Cita(); 
                cita.setId(rs.getInt(1));
                cita.setIdPaciente(rs.getInt(2));
                cita.setIdEspecialidad(rs.getInt(3));
                cita.setIdDoctor(rs.getInt(4));
                cita.setFecha(rs.getDate(5));
                cita.setEstado(rs.getString(6));
                cita.setAsistio(rs.getBoolean(7));
                cita.setHora(rs.getTime(8));
               }
         }catch(SQLException e){
             System.out.print("Error >> " +e.getMessage());
         }
        finally{
          Conexion.closed(stmt);
          Conexion.closed(conn);
          Conexion.closed(rs);
         }
       
         return cita;
    }
     
    private final String SQL_VALIDAR_A = "SELECT COUNT(*) FROM cita WHERE fecha=? AND hora=? and (estado='efectiva' OR estado='agendada')";
    public int selectFecha(Date fecha, Time hora){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        int cantidadCitas=-1;
        try{
            conn= Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_VALIDAR_A);
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            stmt.setDate(1, fechaSQL);
            stmt.setTime(2, hora);
            rs = stmt.executeQuery();
            while(rs.next()){
                cantidadCitas = rs.getInt(1);
            }
        }catch(SQLException e){
             System.out.print("Error >> " +e.getMessage());
         }
        finally{
          Conexion.closed(stmt);
          Conexion.closed(conn);
          Conexion.closed(rs);
         }
       
         return cantidadCitas;
    }
    
    private final String SQL_VALIDAR_C = "SELECT COUNT(*) FROM cita WHERE id_paciente=? AND id_especialidad=? and (estado='efectiva' OR estado='agendada')";
    public int selectNumeroCitas(int idPaciente, int idEspecialidad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        int cantidadCitas=-1;
        try{
            conn= Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_VALIDAR_C);
            
            stmt.setInt(1, idPaciente);
            stmt.setInt(2, idEspecialidad);
            rs = stmt.executeQuery();
            while(rs.next()){
                cantidadCitas = rs.getInt(1);
            }
        }catch(SQLException e){
             System.out.print("Error >> " +e.getMessage());
         }
        finally{
          Conexion.closed(stmt);
          Conexion.closed(conn);
          Conexion.closed(rs);
         }
         return cantidadCitas;
    }
    
    
     
     private final String SQL_DELETE = "DELETE FROM cita WHERE id=?";
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
    
     private static CitaJDBC citaJDBC;
    
    public static CitaJDBC instance() {
        if (citaJDBC == null) {
            citaJDBC = new CitaJDBC();
        }
        return citaJDBC;
    }

    
    
}

