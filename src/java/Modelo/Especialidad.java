package Modelo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import org.hibernate.validator.internal.util.logging.Log;

public class Especialidad {

private int id;
private String nombre;
private String descripcion;
private int costo_consulta;
private Time duracion_consulta; 

    public Especialidad(int id, String nombre, String descripcion, int costo_consulta, String duracion_consulta) {
        this.id = id;
        this.nombre = nombre;
	this.descripcion = descripcion;
        this.costo_consulta = costo_consulta;
	this.duracion_consulta = java.sql.Time.valueOf(duracion_consulta);
    }

 
 public Especialidad(String nombre, String descripcion, int costo_consulta, String duracion_consulta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo_consulta = costo_consulta;
        this.duracion_consulta = java.sql.Time.valueOf(duracion_consulta);
    }

    public Especialidad() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto_consulta() {
        return costo_consulta;
    }

    public Time getDuracion_consulta() {
       // String duracion= duracion_consulta.substring(1, 5);
        return duracion_consulta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto_consulta(int costo_consulta) {
        this.costo_consulta = costo_consulta;
    }

    public void setDuracion_consulta(String duracion_consulta) {
        this.duracion_consulta = java.sql.Time.valueOf(duracion_consulta);
    }
    
    

    @Override
    public String toString() {
        return "Especialidad{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio_consulta=" + costo_consulta + ", duracion_consulta=" + duracion_consulta + '}';
    }

 
    

}
