package servicios;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;

public class Conexion {
    private static String JDBC_DRIVER = "org.postgresql.Driver";  // "org.apache.derby.jdbc.ClientDriver"; //"com.mysql.jdbc.Driver";
    private static String DB = "proyecto";
    private static String JDBC_URL = "jdbc:postgresql://localhost:5432/"+ DB; //"jdbc:derby://localhost:1527/" +DB ;//"jdbc:postgresql://localhost:5432/"+ DB;  //"jdbc:mysql://localhost:3306/+DB;
    private static String JDBC_USER = "postgres";  //"root";
    private static String JDBC_PASS = "Abc12345*"; 
    private static int x=0;
    private static Driver driver;
    
    //prueba
    
    public static synchronized Connection getConnection() throws SQLException{
        if(driver ==null){
            try{
               Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
               driver = (Driver)jdbcDriverClass.newInstance();
               DriverManager.registerDriver(driver);
            }catch(ClassNotFoundException  |  InstantiationException | 
                    IllegalAccessException e){
                System.out.println("Fallo en cargar el Driver");
            }
        }
        crearCarpeta();
        return DriverManager.getConnection(JDBC_URL,JDBC_USER, JDBC_PASS);
    }
    
    public static void closed(ResultSet rs){
        try{
            if(rs!=null)
                rs.close();
        }catch(SQLException e){
            
        }
    }
    
    public static void closed(PreparedStatement stmt){
        try{
            if(stmt!=null)
                stmt.close();
        }catch(SQLException e){
            
        }
    }
    
    public static void closed(Connection conn){
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException e){
            
        }
    }
    
    public static void crearCarpeta(){
        
        if(x==0){
        File directorio = new File("c:/fotos");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
    }
    }
        x++;
    }
}


