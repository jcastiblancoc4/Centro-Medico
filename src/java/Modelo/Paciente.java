/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
/**
 *
 * @author jpcas
 */
public class Paciente {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String celular;
    private String tipoPersona;
    private int numeroCitas;
    private String cedula;

    public Paciente(int id, String nombre, String apellido, String direccion, String correo, String celular, String tipoPersona, int numeroCitas, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.celular = celular;
        this.tipoPersona = tipoPersona;
        this.numeroCitas = numeroCitas;
        this.cedula = cedula;
    }

    public Paciente(int id, String nombre, String apellido, String direccion, String correo, String celular, String tipoPersona, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.celular = celular;
        this.tipoPersona = tipoPersona;
        this.cedula = cedula;
    }
    
    

    public Paciente(String nombre, String apellido, String direccion, String correo, String celular, String tipoPersona, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.celular = celular;
        this.tipoPersona = tipoPersona;
        this.cedula = cedula;
    }

    public Paciente(int id, String nombre, String apellido, String direccion, String correo, String celular, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.celular = celular;
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getNumeroCitas() {
        return numeroCitas;
    }

    public Paciente() {
     
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


    public String getTipoPersona() {
        return tipoPersona;
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



    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    
    public void setNumeroCitas(int numeroCitas) {
        this.numeroCitas = numeroCitas;
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
