/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author wilbert
 */
public class Myrender_Ventas extends DefaultTableCellRenderer{
     private int columna_patron ;
     
    public Myrender_Ventas(int Colpatron)
    {
        this.columna_patron = Colpatron;
    }
 
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column ){
        setBackground(new Color(234, 237, 237));//color de fondo
        table.setForeground(Color.black);//color de texto
        try {
            // SI EN CADA FILA DE LA TABLA LA CELDA 8 ES IGUAL A ACTIVO COLOR AZUL
            if( diferenciaFecha(table.getValueAt(row,columna_patron).toString()).equals("ROJO")){
                setBackground( new Color(241, 148, 138) );
             
            }else{
                if( diferenciaFecha(table.getValueAt(row,columna_patron).toString()).equals("AMARILLO")){  
                    //setBackground( new Color(241, 242, 166) );
                    //249, 231, 159  
                    setBackground( new Color(249, 231, 159) );
                    
                }else{
                    if( diferenciaFecha(table.getValueAt(row,columna_patron).toString()).equals("VERDE")) {
                        setBackground( new Color(125, 206, 160) );
                        
                    }else{
                        setBackground( new Color(234, 237, 237) );//Pintamos de Gris
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Myrender_Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
    }
    
    public String diferenciaFecha(String fechaMaximaExportacion) throws ParseException{
        Date fechaActual = new Date(); 
        String  Fecha =new SimpleDateFormat("yyyy-MM-dd").format(fechaActual);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaHoy=dateFormat.parse(Fecha);
        Date fechaDevo=dateFormat.parse(fechaMaximaExportacion);
        int diasAtraso=(int) ((fechaHoy.getTime()-fechaDevo.getTime())/86400000);
        if(diasAtraso >= 15 && diasAtraso <= 30){
            return "ROJO";
        }else{
            if(diasAtraso >= 5 && diasAtraso < 15){
                return "AMARILLO";
            }else{
                if(diasAtraso >= 1 && diasAtraso < 4){
                    return "VERDE";
                    
                }else{
                    return "";//No colocar ningun color
                }
            }
        }      
    }
}
