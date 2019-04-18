package TheoremPanels;

import TheoremStuff.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SSS extends JPanel {
    private Calculator t = new Calculator();
    private InformationPanel infopanel = new InformationPanel(t);

    private double a, b, c;
    private double aAngle, bAngle, cAngle;

    private JTextField aSide = new JTextField(10);
    private JTextField bSide = new JTextField(10);
    private JTextField cSide = new JTextField(10);

    private JButton calculateButton = new JButton("Solve");

    private JPanel buttons;

    public SSS() {
        setLayout(new BorderLayout());
        //Create the buttons panel with all the buttons and textfields
        this.buttons = new JPanel(new GridBagLayout());
        this.buttons.setPreferredSize(new Dimension(100, 50));

        GridBagConstraints grid = new GridBagConstraints();
        grid.weightx = 1;
        grid.weighty = 0;

        buttons.add(new JLabel("a: "));
        buttons.add(aSide, grid);
        buttons.add(new JLabel("b: "));
        buttons.add(bSide, grid);
        buttons.add(new JLabel("c: "));
        buttons.add(cSide, grid);
        buttons.add(calculateButton, grid);

        add(this.buttons, BorderLayout.NORTH);

        //Create the information panel which will show all triangle information
        add(this.infopanel, BorderLayout.CENTER);


        //On button press
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    a = Double.parseDouble(aSide.getText());
                } catch (NumberFormatException error) {
                    aSide.setText("Invalid!");
                }
                try {
                    b = Double.parseDouble(bSide.getText());
                } catch (NumberFormatException error) {
                    bSide.setText("Invalid!");
                }
                try {
                    c = Double.parseDouble(cSide.getText());
                } catch (NumberFormatException error) {
                    cSide.setText("Invalid!");
                }
                if(t.setSideSizes(a, b, c) && calculate()){
                    //If the triangle is possible, calculate the triangles and all the triangle properties
                    calculateAll();
                }
            }
        });
    }
    private boolean calculate() {
        //this is used to get all sides and angles to feed them to the calculator
        aAngle = (b * b) + (c * c) - (a * a);
        aAngle = aAngle / (2 * b * c);
        aAngle = Math.acos(aAngle);

        bAngle = (a * a) + (c * c) - (b * b);
        bAngle = bAngle / (2 * a * c);
        bAngle = Math.acos(bAngle);

        cAngle = (a * a) + (b * b) - (c * c);
        cAngle = cAngle / (2 * a * b);
        cAngle = Math.acos(cAngle);

        if(aAngle <= 0 || bAngle <= 0 || cAngle <= 0){
            return false;
        }
        t.setAngleSizes(Math.toDegrees(aAngle), Math.toDegrees(bAngle), Math.toDegrees(cAngle));
        return true;
    }
    public void calculateAll(){
        //Update text on button press
        this.infopanel.updateText();
    }
}