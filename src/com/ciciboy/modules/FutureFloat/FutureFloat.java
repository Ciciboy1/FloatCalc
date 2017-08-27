package com.ciciboy.modules.FutureFloat;

import com.ciciboy.base.PageWrapper;
import com.ciciboy.base.Util;
import com.ciciboy.components.FloatBar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FutureFloat extends PageWrapper{
    private JPanel self;
    private JButton btn_process;
    private JTextField tf_min;
    private JTextField tf_max;
    private JTextField tf_avg;
    private JPanel avgfl_pnl;
    private JPanel desfl_pnl;
    private JPanel pnl_avg;
    private FloatBar des_fb = new FloatBar(), avg_fb = new FloatBar();

    public FutureFloat(){
        self.setPreferredSize(Util.STANDARD_SIZE);
        self.setBorder(new EmptyBorder(3, 3, 3, 3));
        desfl_pnl.add(des_fb);
        avgfl_pnl.add(avg_fb);

        btn_process.addActionListener(e -> {
            try {
                pnl_avg.setBorder(null);
                double avg_fl = Double.parseDouble(tf_avg.getText());
                double max_fl = Double.parseDouble(tf_max.getText());
                double min_fl = Double.parseDouble(tf_min.getText());
                avg_fb.setValue(avg_fl);
                double fut_fl = (max_fl-min_fl)*avg_fl+min_fl;
                des_fb.setValue(fut_fl);
            }catch(Exception ex){
                pnl_avg.setBorder(new LineBorder(new Color(172, 0, 0), 2));
            }
        });
    }

    public JPanel getSelf(){
        return self;
    }
}
