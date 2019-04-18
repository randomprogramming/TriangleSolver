package TheoremPanels;

import TheoremStuff.Calculator;
import TheoremStuff.InformationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SSA extends JPanel {
    private Calculator t = new Calculator();
    private InformationPanel infopanel = new InformationPanel(t);

    private double a, b, c;
    private double aAngle, bAngle, cAngle;

    private JTextField aSide = new JTextField(10);
    private JTextField bSide = new JTextField(10);
    private JTextField bAngleField = new JTextField(10);

    private JButton calculateButton = new JButton("Solve");

    private JPanel buttons;

    public SSA(){
        setLayout(new BorderLayout());
        //Buttons panel
        this.buttons = new JPanel(new GridBagLayout());
        this.buttons.setPreferredSize(new Dimension(100, 50));

        GridBagConstraints grid = new GridBagConstraints();
        grid.weightx = 1;
        grid.weighty = 0;

        buttons.add(new JLabel("a: "));
        buttons.add(aSide, grid);
        buttons.add(new JLabel("b: "));
        buttons.add(bSide, grid);
        buttons.add(new JLabel("β: "));
        buttons.add(bAngleField, grid);
        buttons.add(calculateButton, grid);

        add(this.buttons, BorderLayout.NORTH);

        //Create the information panel which will show all triangle information
        add(this.infopanel, BorderLayout.CENTER);

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
                    bAngle = Math.toRadians(Double.parseDouble(bAngleField.getText()));
                } catch (NumberFormatException error) {
                    bAngleField.setText("Invalid!");
                }
                if(t.setSideSizes(a, b, c) && calculate()){
                    //If the triangle is possible, calculate the triangle properties
                    calculateAll();
                }
            }
        });
    }
    private boolean calculate(){
        //this is used to calculate all sides and angles
        aAngle = (Math.sin(bAngle) * a) / b;
        cAngle = Math.PI - aAngle - bAngle;

        c = (a * a) + (b * b) - 2 * a * b * Math.cos(cAngle);
        c = Math.sqrt(c);

        if(aAngle <= 0 || bAngle <= 0 || cAngle <= 0){
            return false;
        }
        t.setAngleSizes(Math.toDegrees(aAngle), Math.toDegrees(bAngle), Math.toDegrees(cAngle));
        return true;
    }
    public void calculateAll(){
        infopanel.updateText();
    }
}