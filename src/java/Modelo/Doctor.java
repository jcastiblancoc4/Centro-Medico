/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import ControlDAO.EspecialidadJDBC;
import java.util.List;



/**
 *
 * @author jpcas
 */
public class Doctor{
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String celular;
    private int idEspecialidad;
    private String tipoPersona;
    private List<Horario> citas;
    private String nombreEspecialidad;
    private int cedula;

    public Doctor(int id, String nombre, String apellido, String direccion, String correo, String celular, int idEspecialidad, String tipoPersona, int cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.celular = celular;
        this.idEspecialidad = idEspecialidad;
        this.tipoPersona = tipoPersona;
        this.citas = citas;
        this.cedula = cedula;
    }

    public Doctor(String nombre, String apellido, String direccion, String correo, String celular, int idEspecialidad, String tipoPersona, int cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.celular = celular;
        this.idEspecialidad = idEspecialidad;
        this.tipoPersona = tipoPersona;
        this.cedula = cedula;
    }

    public Doctor() {
     
    }

    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCelular() {
        return celular;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    
    public String getNombreEspecialidad() {
        Especialidad especialidad = new Especialidad();
        especialidad = EspecialidadJDBC.instance().selectEspecialidad(idEspecialidad);
        nombreEspecialidad = especialidad.getNombre();
        return nombreEspecialidad;
    }
    
    

    public List<Horario> getCitas() {
        return citas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public void setCitas(List<Horario> citas) {
        this.citas = citas;
    }
    
    
    

        
}



//    public String copiarPegarArchivo(){
//        InputStream inputStream = null;
//        OutputStream outputStream = null;
//        File archivoOriginal = null;
//        File archivoCopia = null;
//        try {
//             archivoOriginal = new File(foto);
//             archivoCopia = new File(ruta+archivoOriginal.getName());
//            inputStream = new FileInputStream(archivoOriginal);
//            outputStream = new FileOutputStream(archivoCopia);
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = inputStream.read(buffer)) > 0) {
//                outputStream.write(buffer, 0, length);
//            }
//            inputStream.close();
//            outputStream.close();
//            System.out.println("Archivo copiado.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return archivoCopia.getName();
//}
