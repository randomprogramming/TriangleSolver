package TheoremPanels;

import TheoremStuff.Calculator;
import TheoremStuff.InformationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SAS extends JPanel {
    private Calculator t = new Calculator();
    private InformationPanel infopanel = new InformationPanel(t);

    private double a, b, c;
    private double aAngle, bAngle, cAngle;

    private JTextField aSide = new JTextField(10);
    private JTextField cAngleField = new JTextField(10);
    private JTextField bSide = new JTextField(10);

    private JButton calculateButton = new JButton("Solve");

    private JPanel buttons;
    public SAS(){
        setLayout(new BorderLayout());
        //Create the buttons panel with all the buttons and textfields
        this.buttons = new JPanel(new GridBagLayout());
        this.buttons.setPreferredSize(new Dimension(100, 50));

        GridBagConstraints grid = new GridBagConstraints();
        grid.weightx = 1;
        grid.weighty = 0;

        buttons.add(new JLabel("a: "));
        buttons.add(aSide, grid);
        buttons.add(new JLabel("γ: "));
        buttons.add(cAngleField, grid);
        buttons.add(new JLabel("b: "));
        buttons.add(bSide, grid);
        buttons.add(calculateButton, grid);

        add(this.buttons, BorderLayout.NORTH);

        //Create the information panel which will show all triangle information
        add(this.infopanel, BorderLayout.CENTER);

        this.calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    a = Double.parseDouble(aSide.getText());
                } catch (NumberFormatException error) {
                    aSide.setText("Invalid!");
                }
                try {
                    cAngle = Math.toRadians(Double.parseDouble(cAngleField.getText()));
                } catch (NumberFormatException error) {
                    cAngleField.setText("Invalid!");
                }
                try {
                    b = Double.parseDouble(bSide.getText());
                } catch (NumberFormatException error) {
                    bSide.setText("Invalid!");
                }
                calculate();
                if(t.checkAngles() && t.setSideSizes(a, b, c)){
                    //If the triangle is possible, calculate the triangles and all the triangle properties
                    infopanel.updateText();
                }
            }
        });
    }
    private void calculate(){
        c = (a * a) + (b * b) - 2 * a * b * Math.cos(cAngle);
        c = Math.sqrt(c);

        aAngle = (b * b) + (c * c) - (a * a);
        aAngle = aAngle / (2 * b * c);
        aAngle = Math.acos(aAngle);

        bAngle = Math.PI - aAngle - cAngle;

        t.setAngleSizes(Math.toDegrees(aAngle), Math.toDegrees(bAngle), Math.toDegrees(cAngle));
    }
}