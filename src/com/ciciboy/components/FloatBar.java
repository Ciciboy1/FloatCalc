package com.ciciboy.components;

import com.ciciboy.exceptions.ValueOutOfBoundsException;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

import static com.ciciboy.base.Util.*;

public class FloatBar extends JProgressBar{

    public FloatBar(){
        super();
        setBorderPainted(true);
        setMaximum(10000);
        setMinimum(0);
        setStringPainted(true);
        setBackground(new Color(64, 64, 64));
        setForeground(new Color(64, 64, 64));
        setString("");
        setFocusable(false);
        setBorderPainted(false);
        setUI(new BasicProgressBarUI() {
            protected Color getSelectionBackground() { return Color.white; }
            protected Color getSelectionForeground() { return Color.white; }
        });
    }

    public void setValue(double value) throws ValueOutOfBoundsException{
        if(value > 1.0 || value < 0.0)
            throw new ValueOutOfBoundsException();
        int new_val = (int) (10000*value);
        super.setValue(new_val);
        Color c = new Color((int) (value*90), (int) (120 - value*100), 0);
        String quality;
        if(value < 0.07){
            quality = "Factory New";
        }else if(value < 0.15){
            quality = "Minimal Wear";
        }else if(value < 0.38){
            quality = "Field Tested";
        }else if(value < 0.45){
            quality = "Well Worn";
        }else{
            quality = "Battle Scarred";
        }
        setForeground(c);
        setBackground(c.darker().darker());
        setString(quality + ": " + ((double)Math.round(value*1000000)/1000000));
    }


}
