package com.ciciboy.base;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static com.ciciboy.base.Main.console;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class Util {

    private Util(){}

    public static final Dimension STANDARD_SIZE = new Dimension(360, 330);
    public static final Color FN = new Color(10, 172, 0);
    public static final Color MW = new Color(30, 140, 0);
    public static final Color FT = new Color(60, 110, 0);
    public static final Color WW = new Color(90, 90, 0);
    public static final Color BS = new Color(100, 60, 0);
    public static final BufferedImage DEFAULT_TEXTURE = makeDefTex();

    private static BufferedImage makeDefTex(){
        BufferedImage img = new BufferedImage(16, 16, TYPE_INT_RGB);
        Graphics g = img.createGraphics();
        g.setColor(new Color(255, 0, 255));
        g.fillRect(0, 0, 8, 8);
        g.fillRect(8, 8, 8, 8);
        return img;
    }

    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                console.log("Webseite geöffnet: " + uri.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void openWebpage(String url) {
        try {
            openWebpage(new URL(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage loadImg(String path){
        BufferedImage img = null;
        try{
             img = ImageIO.read(new File(path));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        if(img != null)
            return img;
        else
            return DEFAULT_TEXTURE;
    }

    public static void show(JPanel jpl, JFrame frame){
        frame.setContentPane(jpl);
        frame.pack();
        frame.repaint();
    }
}
