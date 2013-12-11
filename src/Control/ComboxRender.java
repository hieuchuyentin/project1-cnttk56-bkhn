package Control;


import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dodan_000
 */
public class ComboxRender extends JLabel implements ListCellRenderer {
    String path="";
    int startIndex;
    public ComboxRender(){
        
    }
    public ComboxRender(String path,int startIndex){
    
        this.path = path;
        this.startIndex = startIndex;
    }

public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setText((String) value);
        setOpaque(true);
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        int i = index + startIndex;
        setIcon(new ImageIcon(path+i+".png"));
        //setFont(list.getFont());
        return this;
    }
}