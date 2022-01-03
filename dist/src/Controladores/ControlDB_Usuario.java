
package Controladores;
import GUI.EncriptarPassword;
import Modelos.EmpresaLocal;
import Modelos.Usuario;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlDB_Usuario {
    private Connection conexion=null;
    private  ControlDB_DB control=null;  
    private int consecutivoUsuario=0;

    public ControlDB_Usuario() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos(); 
    }
    public int retornarElMaximo(){
         Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM usuario;");
            while(resultSet.next()){ 
                if(resultSet.getString(1) != null){
                    retorno =Integer.parseInt(resultSet.getString(1));
                }
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
            System.exit(1);
        } 
        control.cerrarConexionBaseDatos();
        return retorno;
    }
    public int registrarUsuario(Usuario u, EmpresaLocal emp) throws FileNotFoundException{
        Connection conexion= control.ConectarBaseDatos();
        int result=0;
        try{
            EncriptarPassword cripto = new EncriptarPassword();
            //#########################################################
            try{
                consecutivoUsuario=retornarElMaximo();
                consecutivoUsuario++;
            }catch(Exception e){
                consecutivoUsuario++;                   
            }    
            PreparedStatement r= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[usuario] ([id],[empresaLocal_nit], [empresaLocal_sucursal], [user], [password],"
                                                            + " [nombre], [apellido], [celular], [telefono], [correo], [estado]) VALUES ('"+consecutivoUsuario+"','"+emp.getNit()+"', '"+emp.getSucursal()+"',"
                                                                    + "'"+u.getUser()+"', '"+cripto.md5(u.getPassword())+"', "
                                                            + " '"+u.getNombre()+"', '"+u.getApellido()+"', '"+u.getCelular()+"', '"+u.getTelefono()+"', '"+u.getCorreo()+"','"+u.getEstado()+"');");
                     
            r.execute();
            result=1;
            
            PreparedStatement registrarPermisosUsuario= conexion.prepareStatement("INSERT  INTO maquilas.dbo.permisos_usuario([usuario_id],[permisos_id],[estado]) values " +
"									('"+consecutivoUsuario+"',2,0), " +
"									('"+consecutivoUsuario+"',3,0), " +
"									('"+consecutivoUsuario+"',4,0), " +
"									('"+consecutivoUsuario+"',6,0), " +
"									('"+consecutivoUsuario+"',7,0), " +
"									('"+consecutivoUsuario+"',8,0), " +
"									('"+consecutivoUsuario+"',10,0), " +
"									('"+consecutivoUsuario+"',11,0), " +
"									('"+consecutivoUsuario+"',12,0), " +
"									('"+consecutivoUsuario+"',13,0), " +
"									('"+consecutivoUsuario+"',15,0), " +
"									('"+consecutivoUsuario+"',16,0), " +
"									('"+consecutivoUsuario+"',17,0), " +
"									('"+consecutivoUsuario+"',18,0), " +
"									('"+consecutivoUsuario+"',19,0), " +
"									('"+consecutivoUsuario+"',20,0), " +
"									('"+consecutivoUsuario+"',21,0), " +
"									('"+consecutivoUsuario+"',23,0), " +
"									('"+consecutivoUsuario+"',24,0), " +
"									('"+consecutivoUsuario+"',25,0), " +
"									('"+consecutivoUsuario+"',26,0), " +
"									('"+consecutivoUsuario+"',27,0), " +
"									('"+consecutivoUsuario+"',28,0), " +
"									('"+consecutivoUsuario+"',30,0), " +
"									('"+consecutivoUsuario+"',31,0), " +
"									('"+consecutivoUsuario+"',32,0), " +
"									('"+consecutivoUsuario+"',33,0), " +
"									('"+consecutivoUsuario+"',34,0), " +
"									('"+consecutivoUsuario+"',35,0), " +
"									('"+consecutivoUsuario+"',37,0), " +
"									('"+consecutivoUsuario+"',39,0), " +
"									('"+consecutivoUsuario+"',41,0), " +
"									('"+consecutivoUsuario+"',42,0), " +
"									('"+consecutivoUsuario+"',43,0), " +
"									('"+consecutivoUsuario+"',45,0), " +
"									('"+consecutivoUsuario+"',46,0), " +
"									('"+consecutivoUsuario+"',47,0), " +
"									('"+consecutivoUsuario+"',49,0), " +
"									('"+consecutivoUsuario+"',50,0), " +
"									('"+consecutivoUsuario+"',51,0), " +
"									('"+consecutivoUsuario+"',53,0), " +
"									('"+consecutivoUsuario+"',54,0), " +
"									('"+consecutivoUsuario+"',55,0), " +
"									('"+consecutivoUsuario+"',57,0), " +
"									('"+consecutivoUsuario+"',58,0), " +
"									('"+consecutivoUsuario+"',59,0), " +
"									('"+consecutivoUsuario+"',61,0), " +
"									('"+consecutivoUsuario+"',62,0);");
                     
            registrarPermisosUsuario.execute();
            result=1;
            
            
        }
        catch (SQLException sqlException ){   
            result=0;
            JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
            sqlException.printStackTrace();
        }  
        control.cerrarConexionBaseDatos();
        return result;
    }
    public ArrayList<Usuario> buscarUsuarios(String valorConsulta) throws SQLException{
        control.ConectarBaseDatos();
        ArrayList<Usuario> listadoUsuario= new ArrayList();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[usuario];");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[usuario] WHERE ([id] like '%"+valorConsulta+"%' or [nombre] like '%"+valorConsulta+"%' or [user] like '%"+valorConsulta+"%' or [apellido] like '%"+valorConsulta+"%');");
            }
            while(resultSet.next()){ 
                Usuario u = new Usuario(); 
                //titulo= {"Id","User", "Tipo Usuario", "Nombre", "Apellido", "Estado"};
                u.setId(Integer.parseInt(resultSet.getString(1)));
                u.setEmpresaLocal_nit(resultSet.getString(2));
                u.setEmpresaLocal_sucursal(Integer.parseInt(resultSet.getString(3)));
                u.setUser(resultSet.getString(4));
                u.setPassword(resultSet.getString(5));
                u.setNombre(resultSet.getString(6));
                u.setApellido(resultSet.getString(7));
                u.setCelular(resultSet.getString(8));
                u.setTelefono(resultSet.getString(9));
                u.setCorreo(resultSet.getString(10));
                u.setEstado(resultSet.getString(11));
                listadoUsuario.add(u);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoUsuario;
    } 
    public ArrayList<Usuario> consultarUnicoUsuario(Usuario usu) throws SQLException{
        control.ConectarBaseDatos();
        ArrayList<Usuario> listadoUsuario= new ArrayList();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[usuario] WHERE [id]='"+usu.getId()+"';");
            while(resultSet.next()){ 
                Usuario u = new Usuario(); 
                //titulo= {"Id","User", "Tipo Usuario", "Nombre", "Apellido", "Estado"};
                u.setId(Integer.parseInt(resultSet.getString(1)));
                u.setEmpresaLocal_nit(resultSet.getString(2));
                u.setEmpresaLocal_sucursal(Integer.parseInt(resultSet.getString(3)));
                u.setUser(resultSet.getString(4));
                u.setPassword(resultSet.getString(5));
                u.setNombre(resultSet.getString(6));
                u.setApellido(resultSet.getString(7));
                u.setCelular(resultSet.getString(8));
                u.setTelefono(resultSet.getString(9));
                u.setCorreo(resultSet.getString(10));
                u.setEstado(resultSet.getString(11));
                listadoUsuario.add(u);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoUsuario;
    } 
    public Usuario validarUsuario(Usuario u){
        control.ConectarBaseDatos();
        Statement statement = null;
        Usuario user = null;
        try{
            statement = conexion.createStatement();
            EncriptarPassword cripto = new EncriptarPassword();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[usuario] where [user]='"+u.getUser()+"' and [password]= '"+cripto.md5(u.getPassword())+"';");
            while(resultSet.next()){          
                if(cripto.md5(u.getPassword()).equals(resultSet.getString(5))){
                    user = new Usuario();
                    user.setId(Integer.parseInt(resultSet.getString(1)));
                    user.setEmpresaLocal_nit(resultSet.getString(2));
                    user.setEmpresaLocal_sucursal(Integer.parseInt(resultSet.getString(3)));
                    user.setUser(resultSet.getString(4));
                    user.setPassword(resultSet.getString(5));
                    user.setNombre(resultSet.getString(6));
                    user.setApellido(resultSet.getString(7));
                    user.setCelular(resultSet.getString(8));
                    user.setTelefono(resultSet.getString(9));
                    user.setCorreo(resultSet.getString(10));
                    user.setEstado(resultSet.getString(11));   
                }
            }
            return user;
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al consultar Usuario");
            sqlException.printStackTrace();
            //System.exit(1);
        } 
       control.cerrarConexionBaseDatos();
       return user;
    }
     public String validarTipoUsuario(String usuario){
        control.ConectarBaseDatos();
        Statement statement = null;
        String retorno="";
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT t.[descripcion] FROM usuario AS u, tipousuario t WHERE u.[user]='"+usuario+"' and u.[tipoUsuario_id]= t.id;");
            while(resultSet.next()){          
                retorno=resultSet.getString(1);               
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al consultar Usuario");
            sqlException.printStackTrace();
            System.exit(1);
        }
        control.cerrarConexionBaseDatos();
        return retorno;             
    }
    public int actualizarUsuario(Usuario u) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{
            EncriptarPassword cripto = new EncriptarPassword();
            PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[usuario] SET [user] = '"+u.getUser()+"',"+
                    " [password] = '"+cripto.md5(u.getPassword())+"', [nombre] = '"+u.getNombre()+"', "
                    + "[apellido] = '"+u.getApellido()+"', [celular] = '"+u.getCelular()+"', [telefono] = '"+u.getTelefono()+"', "
                    + "[correo] = '"+u.getCorreo()+"', [estado] = '"+u.getEstado()+"' WHERE [usuario].id = '"+u.getId()+"';");
            r.execute();
            result=1;
        }
        catch (SQLException sqlException ){   
            result=0;
            JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
            sqlException.printStackTrace();
        }  
        control.cerrarConexionBaseDatos();
        return result;
    } 
    
    
    
}
