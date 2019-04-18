import TheoremPanels.*;
import TheoremStuff.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPanel extends JTabbedPane {

    private BufferedImage sssimage;
    private BufferedImage sasimage;
    private BufferedImage ssaimage;
    private BufferedImage asaimage;
    private BufferedImage aasimage;
    private BufferedImage eqimage;

    public MainPanel(){
        //Sets the size of the actual window
        setPreferredSize(new Dimension(1000, 500));

        //Load images
        try{
            sssimage = ImageIO.read(getClass().getResource("sss.png"));
            sasimage = ImageIO.read(getClass().getResource("sas.png"));
            ssaimage = ImageIO.read(getClass().getResource("ssa.png"));
            asaimage = ImageIO.read(getClass().getResource("asa.png"));
            aasimage = ImageIO.read(getClass().getResource("aas.png"));
            eqimage = ImageIO.read(getClass().getResource("eq.png"));
        }catch(IOException e){
            System.out.println("file not found");
        }

        //Create tabs
        addTab("SSS", new SubMainPanel(new SSS(), new ImagePanel(sssimage)));
        addTab("SAS", new SubMainPanel(new SAS(), new ImagePanel(sasimage)));
        addTab("SSA", new SubMainPanel(new SSA(), new ImagePanel(ssaimage)));
        addTab("ASA", new SubMainPanel(new ASA(), new ImagePanel(asaimage)));
        addTab("AAS", new SubMainPanel(new AAS(), new ImagePanel(aasimage)));
        addTab("Equilateral", new SubMainPanel(new Equilateral(), new ImagePanel(eqimage)));
    }
}