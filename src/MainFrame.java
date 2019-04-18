import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        //add the main panel to the frame, set default close operation, set title, make it open in the middle, pack.
        getContentPane().add(new MainPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Triangle solver");
        //setLocationRelativeTo(null);
        pack();
    }
}
