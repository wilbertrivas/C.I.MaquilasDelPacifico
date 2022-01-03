package GUI;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Myrender_VentasTablaPorDefecto extends DefaultTableCellRenderer{
    private int columna_patron ;
     
    public Myrender_VentasTablaPorDefecto(int Colpatron){
        this.columna_patron = Colpatron;
    }
    
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column ){
        table.setForeground(Color.black);//color de texto
        setBackground( new Color(234, 237, 237) );
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
    }

}
