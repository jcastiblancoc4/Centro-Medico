
import ControlDAO.EspecialidadJDBC;
import Modelo.Especialidad;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jpcas
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Especialidad esp = new Especialidad("prueba valor null", "", 40000, "01:20:00");
    EspecialidadJDBC.instance().insert(esp);
    }
    
    
}
