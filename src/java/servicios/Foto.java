/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author jpcas
 */
public class Foto {
    
    
    public String rutaDestinoFoto(String nombre, String carpeta) {
        String rutaProyecto = this.getClass().getResource("").getPath();
        rutaProyecto = rutaProyecto.substring(0, rutaProyecto.length() - 37);
        String rutaFoto = rutaProyecto + carpeta + nombre + ".png";
        return rutaFoto;
    }
    
    public String copiarPegarArchivo(String rutaOrigen, String rutaDestino) {
        String mensaje = "";
        File origen = new File(rutaOrigen);
        File destino = new File(rutaDestino);
        try {
            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (IOException ioe) {
            System.out.println(mensaje = "ERROR CARGANDO FOTO " + ioe.getMessage());
        }
        return mensaje;
    }

    public void eliminarFoto(String ruta) {
        File imagen = new File(ruta);
        imagen.delete();
        System.out.println("Aqui >>>>>>>>>>>>>>>>");
    }

    private static Foto foto;
    public static Foto instance() {
        if (foto == null) {
            foto = new Foto();
        }
        return foto;
    }
}
