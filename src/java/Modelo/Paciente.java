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
    private String rutaOrigen;
    private String rutaFoto;
    
    
    
    public Paciente(int id, String nombre, String apellido, String direccion, String correo, String celular, String tipoPersona, String cedula, String rutaOrigen, String rutaFoto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.celular = celular;
        this.tipoPersona = tipoPersona;
        this.cedula = cedula;
        this.rutaOrigen = rutaOrigen;
        this.rutaFoto = rutaFoto;
    }

    public Paciente(String nombre, String apellido, String direccion, String correo, String celular, String tipoPersona, String cedula, String rutaOrigen, String rutaFoto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.celular = celular;
        this.tipoPersona = tipoPersona;
        this.cedula = cedula;
        this.rutaOrigen = rutaOrigen;
        this.rutaFoto = rutaFoto;
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

    public int getNumeroCitas() {
        return numeroCitas;
    }

    public String getCedula() {
        return cedula;
    }

    public String getRutaOrigen() {
        return rutaOrigen;
    }

    public String getRutaFoto() {
        return rutaFoto;
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

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setRutaOrigen(String rutaOrigen) {
        this.rutaOrigen = rutaOrigen;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }
    
}
