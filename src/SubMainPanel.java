//This is just used to split the window in half

import javax.swing.*;
import java.awt.*;

public class SubMainPanel extends JPanel {
    public SubMainPanel(JPanel left, JPanel right){
        setLayout(new GridLayout(1, 2));
        add(left);
        add(right);
    }
}