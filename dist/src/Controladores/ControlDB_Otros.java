/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

/**
 *
 * @author wrivas
 */
public class ControlDB_Otros {
    public int convertidorValorEstado(int estado){
        int result=0;
        if(estado == 0){
            return 1;
        }else{
            return 0;
        }
    } 
     public String convertidorEstadoID_x_Nombre(int id){
       
        if(id == 0){
            return "Inactivo";
        }else{
            return "Activo";
        }
    } 
}
