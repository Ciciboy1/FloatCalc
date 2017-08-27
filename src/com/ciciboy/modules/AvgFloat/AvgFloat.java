package com.ciciboy.modules.AvgFloat;

import com.ciciboy.base.PageWrapper;
import com.ciciboy.base.Util;
import com.ciciboy.components.FloatBar;
import com.ciciboy.exceptions.ValueOutOfBoundsException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static com.ciciboy.base.Main.console;

public class AvgFloat extends PageWrapper{
    private JPanel self = new JPanel();
    private Field_blpr[] fields = new Field_blpr[10];
    private JButton btn = new JButton("Durchschnitt \r\nberechnen");
    private FloatBar outFloat = new FloatBar();

    public AvgFloat(){
        self.setPreferredSize(Util.STANDARD_SIZE);
        self.setBorder(new EmptyBorder(3, 3, 3, 3));
        self.setLayout(new GridLayout(6, 2, 3, 3));
        for(int i = 0; i < fields.length; i++){
            fields[i] = new Field_blpr(i);
            self.add(fields[i]);
        }
        btn.addActionListener(e -> calculateAvg());
        self.add(btn);
        JPanel out = new JPanel(new GridLayout(2, 1));
        out.add(new JLabel(" Durschnittlicher Float:"));
        out.add(outFloat);
        self.add(out);
    }

    public void calculateAvg(){
        for(int j = 0; j < fields.length; j++){
            fields[j].normalize();
        }

        double sum = 0;
        int count = 0;
        String indices = "";
        for(int i = 0; i < fields.length; i++){
            try {
                double val = Double.parseDouble(fields[i].getValue());
                if(val > 1.0 || val < 0.0)
                    throw new ValueOutOfBoundsException();
                sum += val;
                count++;
            }catch(Exception ex){
                if(!fields[i].getValue().isEmpty()) {
                    fields[i].err();
                    indices += (i + 1) + ", ";
                }
            }finally{
                if(i == fields.length-1)
                    if(!indices.isEmpty()) {
                        indices = indices.substring(0, indices.length() - 2);
                        console.log("Fehlerhafte Eingabe in den Feldern: " + indices);
                    }
                    else{
                    console.log("Durchschnitts Berechnung erfolgreich");
                    }
            }
        }
        try{
            outFloat.setValue(sum / count);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public JPanel getSelf(){
        return self;
    }
}
