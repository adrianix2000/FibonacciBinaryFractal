import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainPanel extends JPanel {
    private List<String> binaryNodes;
    private int filed_x;
    private int filed_y;
    private int filed_size;
    private int vertical_size;
    private int horizontal_size;
    public MainPanel(List<String> binaryNodes) {
        this.binaryNodes = binaryNodes;

        filed_x = binaryNodes.get(binaryNodes.size()-1).length();
        filed_y = binaryNodes.size();

        filed_size = 18;

        horizontal_size = filed_size*filed_x;
        vertical_size = filed_size*filed_y;

        setPreferredSize(new Dimension(horizontal_size, vertical_size));
    }

    @Override
    protected void paintComponent(Graphics g) {
        draw(g);
    }

    private void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, horizontal_size, vertical_size);

        for(int i=0; i<binaryNodes.size(); i++) {
            String currentString = binaryNodes.get(i);
            for(int j=0; j<currentString.length(); j++) {
                if(currentString.charAt(j) == '1') {
                    g.setColor(Color.BLACK);
                    g.fillRect(j*filed_size, i*filed_size, filed_size, filed_size);
                }
            }
        }
    }
}
