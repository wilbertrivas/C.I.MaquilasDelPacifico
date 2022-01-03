package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControlDB_DB {
    private Connection conexion=null;
    private String login="";
    private String pass="";
    private String ruta="jdbc:sqlserver://";
    public int result;
    public ControlDB_DB(){
       //this.login="root_maquilas";
       //this.pass="r00t_m4qu1l4s";
       //this.ruta="jdbc:mysql://127.0.0.1/maquilas";
       /*this.ruta="jdbc:sqlserver://192.168.1.12:1433;databaseName=maquilas;user=sa;pasword=root";*/
       this.login="sa";
       this.pass="root";
       this.ruta="jdbc:sqlserver://192.168.1.12:1433;databaseName=maquilas;";
       //this.ruta="jdbc:sqlserver://127.0.0.1:1433;databaseName=maquilas;";
       result=0;
    }
    public Connection ConectarBaseDatos(){
        try{
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            conexion=DriverManager.getConnection(ruta+"user="+login+";password="+pass);
            if(conexion!=null){
               return conexion;      
            }
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se encuetra la Clase para conectar con SQLSERVER");
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,  "Error al querer conectar con SQLSERVER");
        }
        finally{
            return conexion;
        }
    }
    public void cerrarConexionBaseDatos(){
        try{
            conexion.close();
        }
        catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cerrar la Conexion a la Base de Datos");
        }
    }
}
