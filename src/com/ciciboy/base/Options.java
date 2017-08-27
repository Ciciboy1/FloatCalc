package com.ciciboy.base;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.awt.image.BufferedImage;

import static com.ciciboy.base.Main.*;
import static com.ciciboy.base.Util.STANDARD_SIZE;

public class Options extends JFrame{

    private JPanel self;
    private JComboBox cb_designs;
    private JButton btn_apply;
    private JComboBox cb_langs;

    private UIManager.LookAndFeelInfo[] lafinfos = UIManager.getInstalledLookAndFeels();
    private String[] lafnames;

    //@SuppressWarnings("unchecked")
    public Options() {
        super("Optionen");
        setDefaultDesign();
        setIconImage(gear20);
        self.setPreferredSize(STANDARD_SIZE);
        self.setBorder(new EmptyBorder(4, 4, 4, 4));
        lafnames = new String[lafinfos.length];
        for(int i = 0; i < lafnames.length; i++){
            lafnames[i] = lafinfos[i].getName();
        }
        cb_designs.setModel(new DefaultComboBoxModel(lafnames));
        btn_apply.addActionListener(e -> {
            int sel = cb_designs.getSelectedIndex();
            propManager.writeProperty("Design", lafnames[sel]);

            JOptionPane.showMessageDialog(null, "Einstellungen wurden gepeichert... \r\nEinige Veränderungen wirken erst nach Neustart des Programms!", "Speichern erfolgreich", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            setDefaultDesign();
        });


        add(self);
        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public void open(){
        setVisible(true);
        setDefaultDesign();
    }

    public void setDefaultDesign(){
        cb_designs.setSelectedItem(propManager.readProperty("Design"));
    }

    private void createUIComponents() {
        self = new JPanel(new CardLayout()){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                BufferedImage img = gear128;
                g2d.drawImage(img, (getWidth()-img.getWidth())/2, (getHeight()-img.getHeight())/2, null);
                g2d.setColor(new Color(255, 255, 255, 64));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

    }
}
