package com.ciciboy.modules.WelcomeScrn;

import com.ciciboy.base.Main;
import com.ciciboy.base.PageWrapper;
import com.ciciboy.base.Util;

import javax.swing.*;
import java.awt.*;

import static com.ciciboy.base.Util.loadImg;

public class WelcomeScreen extends PageWrapper{

    private JPanel self = new JPanel();

    public WelcomeScreen(){
        self.setLayout(new GridBagLayout());
        self.setPreferredSize(Util.STANDARD_SIZE);
        GridBagConstraints g = new GridBagConstraints();
        JLabel fc = new JLabel("Float Calculator");
        fc.setFont(new Font(fc.getFont().getName(), Font.BOLD, 30));
        JLabel auth = new JLabel("von Ciciboy1");
        auth.setFont(new Font(auth.getFont().getName(), Font.BOLD, 20));
        JLabel logo = new JLabel(new ImageIcon(Main.logo));
        g.gridwidth = 3;
        g.gridx = 2;
        g.gridy = 0;
        self.add(logo, g);
        g.gridy = 1;
        self.add(fc, g);
        g.gridy = 2;
        self.add(auth, g);
    }

    public JPanel getSelf(){
        return self;
    }
}
