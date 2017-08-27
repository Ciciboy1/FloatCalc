package com.ciciboy.modules.BugReport;

import com.ciciboy.base.PageWrapper;
import com.ciciboy.base.Util;

import javax.swing.*;
import java.awt.*;

public class BugReport extends PageWrapper {

    private JPanel self = new JPanel(new GridBagLayout());
    private JLabel text1 = new JLabel("Du hast einen Bug gefunden?"), text2 = new JLabel("Sende eine Email mit dem Betreff:"), text3 = new JLabel("Bug Report");
    private JLabel text4 = new JLabel("an:"), text5 = new JLabel("ciciboy1@gmail.com");

    public BugReport(){
        self.setPreferredSize(Util.STANDARD_SIZE);
        Font font = new Font(text1.getFont().getName(), Font.PLAIN, 20);
        text1.setFont(font);
        text2.setFont(font);
        text3.setFont(font);
        text3.setForeground(new Color(0, 128, 0));
        text4.setFont(font);
        text5.setFont(font);
        text5.setForeground(new Color(128,0 , 0));
        GridBagConstraints g = new GridBagConstraints();
        g.gridwidth = 1;
        g.gridy = 0;
        self.add(text1, g);
        g.gridy = 1;
        self.add(text2, g);
        g.gridy = 2;
        self.add(text3, g);
        g.gridy = 3;
        self.add(text4, g);
        g.gridy = 4;
        self.add(text5, g);
    }

    public JPanel getSelf(){
        return self;
    }

}
