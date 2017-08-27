package com.ciciboy.base;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Console extends JFrame{

    private String content = "";
    private JTextArea tf;
    JScrollPane spane;

    public Console(){
        super("Konsole");
        setIconImage(Main.cons_icon);
        tf = new JTextArea();
        spane = new JScrollPane(tf, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spane.setBorder(new EmptyBorder(0, 4, 0, 0));
        spane.setBackground(Color.BLACK);
        tf.setFont(new Font("Monospaced", Font.BOLD, 12));
        tf.setBackground(Color.BLACK);
        tf.setForeground(Color.WHITE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(new Dimension(500, 300));
        JScrollBar hbar = spane.getHorizontalScrollBar();
        hbar.setAutoscrolls(true);
        spane.getHorizontalScrollBar().setAutoscrolls(false);
        add(spane);
    }

    public void log(String s){
        if(!content.isEmpty())
            s = "\r\n" + s;
        content += s;
        tf.append(s);
        repaint();
    }

    public void open(){
        setVisible(true);
        log("Konsole geöffnet");
        tf.setText(content);
    }


}
