/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlDAO;

/**
 *
 * @author jpcas
 */
public class AgendaJDBC {
    
     private final String SQL_INSERT = "r, fecha, estado, asistio, hora) VALUES (?, ?, ?, ?, ?, ?, ?);";
    
//    public String insert(Cita cita){
//        String mensaje="";
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int row = 0;
//        try{
//            conn= Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_INSERT);
//            int index = 1;
//            stmt.setInt(index++, cita.getIdPaciente());
//            stmt.setInt(index++, cita.getIdEspecialidad());
//            stmt.setInt(index++, cita.getIdDoctor());
//            stmt.setDate(index++, (Date) cita.getFecha());
//            stmt.setString(index++, cita.getEstado());
//            stmt.setBoolean(index++, cita.getAsistio());
//            row = stmt.executeUpdate();
//        } catch (SQLException e) {
//           System.out.println(mensaje = "Error: " + e.getMessage());
//        } finally {
//            Conexion.closed(stmt);
//            Conexion.closed(conn);
//        }
//        return mensaje;
//    }

    
}
