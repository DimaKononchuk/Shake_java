import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private int num;
    private int cubeSize;
    private int step;
    private JLabel label;
    private Action UpButton;

    private Action DownButton;

    private Action LeftButton;

    private Action RightButton;
    public MyFrame(){};
    public MyFrame(int num,int cubeSize,int step){
        super("Shake javaGUI");
        super.setSize(num,num);
        super.setVisible(true);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.num=num;
        this.cubeSize=cubeSize;
        this.step=step;
        UpButton=new UpAction();
        DownButton=new DownAction();
        LeftButton =new LeftAction();
        RightButton=new RightAction();
        Timer timer=new Timer(250,this);
        label=new JLabel();
        label.setBounds(randomNumber(),randomNumber(),cubeSize,cubeSize);
        label.setBackground(Color.GREEN );
        label.setOpaque(true);
        super.setResizable(false);
        super.add(label);
        label.getInputMap().put(KeyStroke.getKeyStroke("UP"),"UpButton");
        label.getActionMap().put("UpButton",UpButton);
        label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"DownButton");
        label.getActionMap().put("DownButton",DownButton);
        label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"LeftButton");
        label.getActionMap().put("LeftButton",LeftButton);
        label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"RightButton");
        label.getActionMap().put("RightButton",RightButton);


    }


    public  class UpAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){
            label.setLocation(checkNumberNull(label.getX()),checkNumberNull(label.getY())-step);
            System.out.println(label.getX()+" "+label.getY());
        }
    }
    public  class DownAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){

            label.setLocation(checkNumberNull(label.getX()),checkNumberNull(label.getY())+step);
            System.out.println(label.getX()+" "+label.getY());
        }
    }
    public  class LeftAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){

            label.setLocation(checkNumberNull(label.getX()-step),checkNumberNull(label.getY()));
            System.out.println(label.getX()+" "+label.getY());
        }
    }
    public  class RightAction extends AbstractAction {

        public void actionPerformed(ActionEvent e){

            label.setLocation(checkNumberNull(label.getX()+step),checkNumberNull(label.getY()));
            System.out.println(label.getX()+" "+label.getY());
        }
    }
    public int checkNumberNull( int number){
        if(number>(super.getWidth()-(cubeSize)) ){
            return -10;

        }else if(number<(-10)){
            return super.getWidth()-(cubeSize-step);
        }else{
            return number;
        }

    }
    public int randomNumber(){
        return (int)Math.random()*(num+1);
    }
}
