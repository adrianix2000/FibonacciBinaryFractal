import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainFrame extends JFrame {
    public MainFrame(java.util.List<String> binaryNodes) throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("binarny frakral");
        add(new MainPanel(binaryNodes));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
