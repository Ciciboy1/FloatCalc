package com.ciciboy.modules.Donate;

import com.ciciboy.base.PageWrapper;
import com.ciciboy.base.Util;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Donations extends PageWrapper{

    private JPanel self = new JPanel(new GridBagLayout());
    private JButton btn_donate = new JButton("Jetzt spenden");
    private JLabel text1 = new JLabel("Ich würde mich sehr"), text2 = new JLabel("über eine Spende freuen :)");
    private JLabel empty = new JLabel(" ");

    public Donations(){
        self.setPreferredSize(Util.STANDARD_SIZE);
        Font font = new Font(text1.getFont().getName(), Font.PLAIN, 20);
        text1.setFont(font);
        text2.setFont(font);
        empty.setFont(font);
        btn_donate.addActionListener(e -> {
            try {
                Util.openWebpage(new URL("https://steamcommunity.com/tradeoffer/new/?partner=100988694&token=xPozS66M"));
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
        btn_donate.setToolTipText("Öffnet eine externe Webseite: steamcommunity.com");
        GridBagConstraints g = new GridBagConstraints();
        g.gridy = 0;
        self.add(text1, g);
        g.gridy = 1;
        self.add(text2, g);
        g.gridy = 2;
        self.add(empty, g);
        g.gridy = 3;
        self.add(btn_donate, g);
    }

    public JPanel getSelf(){
        return self;
    }
}
