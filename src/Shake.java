import javax.swing.*;
import java.awt.*;

public class Shake extends JPanel {
    private JLabel label;
    private ImageIcon icon;
    public Shake(){
        super();


    }
    public void addShake(int X,int Y,int size){
        label=new JLabel();
        super.setBounds(X,Y,size,size);
        super.setLayout(null);
        super.add(label);
        super.setBackground(Color.GREEN);
        super.setOpaque(true);



    }
}
