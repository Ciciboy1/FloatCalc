package com.ciciboy.modules.BestTen;

import com.ciciboy.exceptions.ValueOutOfBoundsException;

import javax.swing.*;
import java.awt.*;

public class FloatField extends JTextField {

    public FloatField(){
        super();
        setHorizontalAlignment(CENTER);
        setMinimumSize(new Dimension(50, 18));
        setPreferredSize(new Dimension(-1, 20));
        setMaximumSize(new Dimension(-1, 22));
    }

    public double getValue(){
        double val = -1;
        try{
            val = Double.parseDouble(getText());
        }catch(Exception ex){
            if(!getText().isEmpty())
                throw new IllegalArgumentException();
        }
            if(val > 1 || val < 0)
                throw new ValueOutOfBoundsException();
        return val;
    }


}
