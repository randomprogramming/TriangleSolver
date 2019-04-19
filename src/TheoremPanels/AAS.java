package TheoremPanels;

import TheoremStuff.Calculator;
import TheoremStuff.InformationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AAS extends JPanel {
    private Calculator t = new Calculator();
    private InformationPanel infopanel = new InformationPanel(t);

    private double a, b, c;
    private double aAngle, bAngle, cAngle;

    private JTextField aAngleField = new JTextField(10);
    private JTextField bAngleField = new JTextField(10);
    private JTextField aSide = new JTextField(10);

    private JButton calculateButton = new JButton("Solve");

    private JPanel buttons;
    public AAS(){
        setLayout(new BorderLayout());
        //Create the buttons panel with all the buttons and textfields
        this.buttons = new JPanel(new GridBagLayout());
        this.buttons.setPreferredSize(new Dimension(100, 50));

        GridBagConstraints grid = new GridBagConstraints();
        grid.weightx = 1;
        grid.weighty = 0;

        buttons.add(new JLabel("α: "));
        buttons.add(aAngleField, grid);
        buttons.add(new JLabel("β: "));
        buttons.add(bAngleField, grid);
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
                    aAngle = Math.toRadians(Double.parseDouble(aAngleField.getText()));
                } catch (NumberFormatException error) {
                    aAngleField.setText("Invalid!");
                }
                try {
                    bAngle = Math.toRadians(Double.parseDouble(bAngleField.getText()));
                } catch (NumberFormatException error) {
                    bAngleField.setText("Invalid!");
                }
                try {
                    a = Double.parseDouble(aSide.getText());
                } catch (NumberFormatException error) {
                    aSide.setText("Invalid!");
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
        cAngle = Math.PI - aAngle - bAngle;

        b = (a * Math.sin(bAngle)) / Math.sin(aAngle);
        c = (a * Math.sin(cAngle)) / Math.sin(aAngle);

        t.setAngleSizes(Math.toDegrees(aAngle), Math.toDegrees(bAngle), Math.toDegrees(cAngle));
    }
}