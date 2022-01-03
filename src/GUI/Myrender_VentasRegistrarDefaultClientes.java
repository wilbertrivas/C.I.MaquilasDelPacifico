/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Myrender_VentasRegistrarDefaultClientes extends DefaultTableCellRenderer{
    public Myrender_VentasRegistrarDefaultClientes(){
    }
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )   {
        //setBackground(Color.white);//color de fondo
        table.setForeground(Color.black);//color de texto
        table.setBackground(new Color(153,204,255));//color de texto
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
    }
   
}
