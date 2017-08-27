package com.ciciboy.modules.AvgTuFloat;

import com.ciciboy.base.PageWrapper;
import com.ciciboy.base.Util;
import com.ciciboy.components.FloatBar;
import com.ciciboy.exceptions.ValueOutOfBoundsException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AvgTuFloat extends PageWrapper{

    private JPanel self;
    private JButton btn_process;
    private JTextField tf_des;
    private JTextField tf_lower;
    private JTextField tf_upper;
    private JPanel fb_des, fb_avg;
    private JPanel des_pnl;
    private FloatBar des_fb = new FloatBar(), avg_fb = new FloatBar();

    public AvgTuFloat(){
        self.setPreferredSize(Util.STANDARD_SIZE);
        self.setBorder(new EmptyBorder(3, 3, 3, 3));
        fb_des.add(des_fb);
        fb_avg.add(avg_fb);

        btn_process.addActionListener(e -> {
            try {
                des_pnl.setBorder(null);
                double desFl = Double.parseDouble(tf_des.getText());
                double max_fl = Double.parseDouble(tf_upper.getText());
                double min_fl = Double.parseDouble(tf_lower.getText());
                des_fb.setValue(desFl);
                if(desFl > max_fl || desFl < min_fl)
                    throw new ValueOutOfBoundsException();
                double avgFl = (desFl-min_fl)/(max_fl-min_fl);
                avg_fb.setValue(avgFl);
            }catch(Exception ex){
                des_pnl.setBorder(new LineBorder(new Color(172, 0, 0), 2));
            }
        });
    }

    public JPanel getSelf() {
        return self;
    }

}