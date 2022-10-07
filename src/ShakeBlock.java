import javax.swing.*;
import java.awt.*;

public class ShakeBlock extends JPanel {

    private Rectangle rectangle;
    private Image background = Toolkit.getDefaultToolkit().createImage("shake1.png");
    private int X;
    private int Y;
    private final int size=25;

    ShakeBlock( ){
        super();


    }
    public void addShakeBlock(int X, int Y){
        this.X=X;
        this.Y=Y;
        super.setSize(500,500);
        super.setLocation(0,0);
        super.setBackground(null);
        super.setOpaque(false);

        rectangle=new Rectangle(X,Y,size,size);

    }
    public void setShakeBlock(int X,int Y){
        this.X=X;
        this.Y=Y;

    }
    public int getShakeBlockX(){
        return X;
    }

    public int getShakeBlockY(){
        return Y;
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D d2=(Graphics2D) g;


        d2.drawImage(background,X,Y,null);
        //d2.draw(rectangle);
    }
}
