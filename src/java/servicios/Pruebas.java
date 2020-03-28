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


		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 
		Date fechaInicial=dateFormat.parse("2020-03-27");
		Date fechaFinal=dateFormat.parse("2020-03-30");
 
		int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
 
		System.out.println("Hay "+dias+" dias de diferencia");
	

    }
    
    
}
