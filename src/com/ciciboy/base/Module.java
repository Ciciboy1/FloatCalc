package com.ciciboy.base;


import com.sun.istack.internal.Nullable;

import javax.swing.*;

import java.awt.image.BufferedImage;

import static com.ciciboy.base.Main.console;
import static com.ciciboy.base.Main.empty_img;

public class Module extends JMenuItem{

    public Module(PageWrapper page, String moduleName, JFrame mainFrame){
        super(moduleName);
        BufferedImage icon = empty_img;
        setIcon(new ImageIcon(icon));
        addActionListener(e -> {
            Util.show(page.getSelf(), mainFrame);
            console.log("Modul geöffnet: \"" + moduleName + "\"");
        });
    }

    public Module(PageWrapper page, String moduleName, JFrame mainFrame, BufferedImage icon){
        super(moduleName);
        setIcon(new ImageIcon(icon));
        addActionListener(e -> {
            Util.show(page.getSelf(), mainFrame);
            console.log("Modul geöffnet: \"" + moduleName + "\"");
        });
    }


}
