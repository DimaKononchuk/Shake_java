import javax.swing.*;
import java.awt.*;

public class Apple extends JPanel {
    private Image icon;
    private int X;
    private int Y;
    private final int size=25;

    Apple( ){
        super();



    }
    public void addApple(int X, int Y){
        this.X=X;
        this.Y=Y;
        super.setSize(500,500);
        super.setLocation(0,0);
        super.setBackground(null);
        super.setOpaque(false);
        icon=new ImageIcon("apple.png").getImage();

    }
    public void setApple(int X,int Y){
        this.X=X;
        this.Y=Y;
    }
    public int getAppleX(){
        return X;
    }

    public int getAppleY(){
        return Y;
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D d2=(Graphics2D) g;
        d2.drawImage(icon,X,Y,null);
    }
}
