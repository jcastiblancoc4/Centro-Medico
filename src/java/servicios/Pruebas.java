package servicios;


import ControlDAO.CitaJDBC;
import ControlDAO.EspecialidadJDBC;
import Modelo.Cita;
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
    public static void main(String[] args) throws ParseException {
          Date fechaActual = new Date();
          SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
          String fechaSistema=formateador.format(fechaActual);
          System.out.println(fechaSistema);
          Date fecha1 =  formateador.parse(fechaSistema);
          
         String fechaP = "2020-01-10";
          Date fecha2 = formateador.parse(fechaP);
          
          if ( fecha1.before(fecha2) ){
        System.out.print("La Fecha 1 es menor ");
    }else{
     if ( fecha2.before(fecha1) ){
         System.out.print( "La Fecha 1 es Mayor ");
     }else{
      System.out.print("Las Fechas Son iguales ");
     } 
    }
          
    }
    
    
}
