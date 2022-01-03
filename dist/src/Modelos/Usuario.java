
package Modelos;

public class Usuario {
    private int id;
    private String empresaLocal_nit;
    private int empresaLocal_sucursal;
    private String user;
    private String password;
    private String nombre;
    private String apellido;
    private String celular;
    private String telefono;
    private String correo;
    private String estado;
    
    public Usuario(){
    }

    public Usuario(int id, String empresaLocal_nit, int empresaLocal_sucursal, String user, String password, String nombre, String apellido, String celular, String telefono, String correo, String estado) {
        this.id = id;
        this.empresaLocal_nit = empresaLocal_nit;
        this.empresaLocal_sucursal = empresaLocal_sucursal;
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresaLocal_nit() {
        return empresaLocal_nit;
    }

    public void setEmpresaLocal_nit(String empresaLocal_nit) {
        this.empresaLocal_nit = empresaLocal_nit;
    }

    public int getEmpresaLocal_sucursal() {
        return empresaLocal_sucursal;
    }

    public void setEmpresaLocal_sucursal(int empresaLocal_sucursal) {
        this.empresaLocal_sucursal = empresaLocal_sucursal;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
       
}
