package com.ciciboy.modules.BestTen;

import com.ciciboy.base.PageWrapper;
import com.ciciboy.base.Util;
import com.ciciboy.components.FloatBar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class BestTen extends PageWrapper {

    private JPanel self;
    private JButton btn_process;
    private JTextField tf_des;
    private JPanel sp_wrap;
    private JPanel fbar;
    private JPanel found_fb;
    private JPanel field_pane = new JPanel(new GridLayout(0, 3, 3, 3));
    private JScrollPane spane = new JScrollPane(field_pane);
    private ArrayList<FloatField> fields = new ArrayList<>();
    private FloatBar fb_des = new FloatBar(), fb_found = new FloatBar();
    private Border defaultBorder;

    public BestTen(){
        self.setPreferredSize(Util.STANDARD_SIZE);
        defaultBorder = tf_des.getBorder();
        sp_wrap.add(spane);
        fbar.add(fb_des);
        found_fb.add(fb_found);
        field_pane.setBorder(new EmptyBorder(3, 3, 3, 3));
        spane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        for(int i = 0; i < 60; i++){
            FloatField f = new FloatField();
            fields.add(f);
            field_pane.add(f);
        }
        btn_process.addActionListener(e -> {
            double des_val, found;
            try{
                tf_des.setBorder(defaultBorder);
                des_val = Double.parseDouble(tf_des.getText());
                fb_des.setValue(des_val);
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<FloatField> valFields = new ArrayList<>();
                for(int i = 0; i < fields.size(); i++){
                    try{
                        fields.get(i).setBorder(defaultBorder);
                        values.add(fields.get(i).getValue());
                        valFields.add(fields.get(i));
                    }catch(Exception ex){
                        if(!fields.get(i).getText().isEmpty())
                            fields.get(i).setBorder(new LineBorder(new Color(172, 0, 0), 2));
                        //ex.printStackTrace();
                    }
                }


                int valsize = values.size();
                if(valsize > 10) {
                    int[] indices = new int[10];
                    double best = 10;
                    for (int val1 = 0; val1 < valsize-9; val1++) {
                        for (int val2 = val1+1; val2 < valsize-8; val2++) {
                            for (int val3 = val2+1; val3 < valsize-7; val3++) {
                                for (int val4 = val3+1; val4 < valsize-6; val4++) {
                                    for (int val5 = val4+1; val5 < valsize-5; val5++) {
                                        for (int val6 = val5+1; val6 < valsize-4; val6++) {
                                            for (int val7 = val6+1; val7 < valsize-3; val7++) {
                                                for (int val8 = val7+1; val8 < valsize-2; val8++) {
                                                    for (int val9 = val8+1; val9 < valsize-1; val9++) {
                                                        for (int val10 = val9+1; val10 < valsize; val10++) {

                                                            double test = (values.get(val1) + values.get(val2) + values.get(val3) + values.get(val4) + values.get(val5) + values.get(val6) + values.get(val7) + values.get(val8) + values.get(val9) + values.get(val10))/10;
                                                            double delta = Math.abs(des_val - test);
                                                            if(delta < best) {
                                                                best = delta;
                                                                indices[0] = val1;
                                                                indices[1] = val2;
                                                                indices[2] = val3;
                                                                indices[3] = val4;
                                                                indices[4] = val5;
                                                                indices[5] = val6;
                                                                indices[6] = val7;
                                                                indices[7] = val8;
                                                                indices[8] = val9;
                                                                indices[9] = val10;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    found = 0;
                    for(int k = 0; k < indices.length; k++){
                        found += values.get(indices[k]);
                        System.out.println(values.get(indices[k]));
                        System.out.println(indices[k] + " at " + k);
                        valFields.get(indices[k]).setBorder(new LineBorder(new Color(0, 172, 0), 2));
                    }
                    found /= 10;
                }else{
                    double sum = 0;
                    for(int j = 0; j < valsize; j++){
                        sum += values.get(j);
                    }
                    found = sum/valsize;
                }
                System.out.println(found);
                fb_found.setValue(found);
            }catch (Exception ex){
                ex.printStackTrace();
                tf_des.setBorder(new LineBorder(new Color(172, 0, 0), 2));
            }

        });

    }

    public JPanel getSelf() {
        return self;
    }
}
