package TheoremPanels;

import TheoremStuff.Calculator;
import TheoremStuff.InformationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Equilateral extends JPanel {
    private Calculator t = new Calculator();
    private InformationPanel infopanel = new InformationPanel(t);

    private double a, b, c;
    private double aAngle, bAngle, cAngle;

    private JTextField aSide = new JTextField(10);

    private JButton calculateButton = new JButton("Solve");

    private JPanel buttons;

    public Equilateral(){
        setLayout(new BorderLayout());
        //Create the buttons panel with all the buttons and textfields
        this.buttons = new JPanel(new GridBagLayout());
        this.buttons.setPreferredSize(new Dimension(100, 50));

        GridBagConstraints grid = new GridBagConstraints();
        grid.weightx = 1;
        grid.weighty = 0;

        buttons.add(new JLabel("a: "));
        buttons.add(aSide, grid);
        buttons.add(calculateButton, grid);

        add(this.buttons, BorderLayout.NORTH);

        //Create the information panel which will show all triangle information
        add(this.infopanel, BorderLayout.CENTER);

        this.calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    a = Double.parseDouble(aSide.getText());
                    b = c = a;
                } catch (NumberFormatException error) {
                    aSide.setText("Invalid!");
                }
                if(calculate() && t.setSideSizes(a, b, c)){
                    //If the triangle is possible, calculate the triangles and all the triangle properties
                    calculateAll();
                }
            }
        });
    }
    private boolean calculate(){
        cAngle = (a * a) + (b * b) - (c * c);
        cAngle /= 2 * a * b;
        cAngle = Math.acos(cAngle);
        aAngle = bAngle = cAngle;

        t.setAngleSizes(Math.toDegrees(aAngle), Math.toDegrees(bAngle), Math.toDegrees(cAngle));
        return true;
    }
    public void calculateAll(){
        //Update text on button press
        this.infopanel.updateText();
    }
}