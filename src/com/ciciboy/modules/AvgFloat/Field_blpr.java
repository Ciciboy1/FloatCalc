package com.ciciboy.modules.AvgFloat;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Field_blpr extends JPanel{

    private JPanel self;
    private JTextField textField1;
    private JLabel lbl;

    public Field_blpr(int number){
        super();
        this.add(self);
        lbl.setText("Float " + (number+1) + ":");
    }

    public String getValue(){
        return textField1.getText();
    }

    public void err(){
        this.setBorder(new LineBorder(new Color(172, 0, 0), 2));
    }

    public void normalize(){
        this.setBorder(null);
    }

}
