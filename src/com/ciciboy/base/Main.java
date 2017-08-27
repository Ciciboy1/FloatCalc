package com.ciciboy.base;

import com.ciciboy.modules.AvgFloat.AvgFloat;
import com.ciciboy.modules.AvgTuFloat.AvgTuFloat;
import com.ciciboy.modules.BestTen.BestTen;
import com.ciciboy.modules.BugReport.BugReport;
import com.ciciboy.modules.Donate.Donations;
import com.ciciboy.modules.FutureFloat.FutureFloat;
import com.ciciboy.modules.WelcomeScrn.WelcomeScreen;

import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;

import static com.ciciboy.base.Util.loadImg;
import static com.ciciboy.base.Util.openWebpage;

public class Main extends JFrame {

    public static Console console;
    public static PropertyManager propManager;
    AvgFloat avgFloat = new AvgFloat();
    WelcomeScreen welScrn = new WelcomeScreen();
    AvgTuFloat avgTuFloat = new AvgTuFloat();
    BestTen best10 = new BestTen();
    FutureFloat futFloat = new FutureFloat();
    Donations don = new Donations();
    BugReport buggy = new BugReport();
    Options opts = new Options();

    public static BufferedImage logo, gear20, gear128, empty_img, cons_icon, home_icon, help_icon, bug_icon;

    private Main(){
        super("Float Calculator");
        console.log("Float Calculator gestartet");
        setIconImage(logo);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu modules_menu = new JMenu("Module");
        menuBar.add(modules_menu);
        modules_menu.add(new Module(avgFloat, "Durchschnitt aus 10", this));
        modules_menu.add(new Module(best10, "Beste 10 Floats finden", this));
        modules_menu.addSeparator();
        modules_menu.add(new Module(avgTuFloat, "Benötigter Durchschnitt", this));
        modules_menu.add(new Module(futFloat, "Trade-up Float", this));
        JMenu help_menu = new JMenu("Hilfe");
        help_menu.add(new Module(welScrn, "Startseite", this, home_icon));
        JMenuItem about = new JMenuItem("Was sind Floats?", new ImageIcon(help_icon));
        about.addActionListener(e -> openWebpage("https://steamcommunity.com/sharedfiles/filedetails/?id=445322951"));
        about.setToolTipText("Öffnet eine externe Webseite: steamcommunity.com");
        help_menu.add(about);
        help_menu.addSeparator();
        help_menu.add(new Module(don, "Spenden", this));
        help_menu.addSeparator();
        help_menu.add(new Module(buggy, "Bug melden", this, bug_icon));
        help_menu.addSeparator();
        JMenuItem showConsole = new JMenuItem("Konsole anzeigen", new ImageIcon(cons_icon));
        showConsole.addActionListener(e -> console.open());
        help_menu.add(showConsole);
        menuBar.add(help_menu);
        JMenu ext = new JMenu("Extras");
        JMenuItem optionsMenu = new JMenuItem("Optionen", new ImageIcon(gear20));
        optionsMenu.addActionListener(e -> opts.open());
        ext.add(optionsMenu);
        menuBar.add(ext);
        Util.show(welScrn.getSelf(), this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        logo = loadImg("./rsc/textures/fc_logo.png");
        gear20 = loadImg("./rsc/textures/option_gear_20.png");
        gear128 = loadImg("./rsc/textures/option_gear_128.png");
        empty_img = loadImg("./rsc/textures/empty.png");
        cons_icon = loadImg("./rsc/textures/console_icon_20.png");
        home_icon = loadImg("./rsc/textures/home_icon_20.png");
        help_icon = loadImg("./rsc/textures/help_icon_20.png");
        bug_icon = loadImg("./rsc/textures/bug_icon_20.png");
        propManager = new PropertyManager(new File("./rsc/config.properties"));
        String design = propManager.readProperty("Design");
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (design.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

        }
        console = new Console();
        new Main();
    }

}
