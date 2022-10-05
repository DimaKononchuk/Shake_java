import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class MyFrame extends JFrame implements   KeyListener {

    private int num;
    private int cubeSize;
    private int step;
    private boolean up=true;
    static ArrayList<Integer> number;

    private boolean down=false;

    private boolean left=false;

    private boolean right=false;

    private String str="a";
    private boolean initGame=true;
    private  Shake   shake;
    private Apple apple;
    public MyFrame(){
        super();
    };
    public MyFrame(int num,int cubeSize,int step){
        super("Shake javaGUI");
        super.setSize(num,num);
        super.setVisible(true);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(true);
        super.addKeyListener(this);
        this.num=num;
        this.cubeSize=cubeSize;
        this.step=step;
        shake=new Shake();
        shake.addShake(GetRandomNumber(),GetRandomNumber(),25);
        super.add(shake);
        apple =new Apple();
        apple.addApple(GetRandomNumber(),GetRandomNumber());
        super.add(apple);

        LocationCube();

        while(initGame){
            timeDelay(750);
            LocationCube();
            System.out.println("Coordinate: "+ shake.getX()+" "+shake.getY());
            if(initShakeApple()){
                apple.setApple(GetRandomNumber(),GetRandomNumber());
                apple.addApple(GetRandomNumber(),GetRandomNumber());
                System.out.println("OK!");
            }


        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }
    public void initApple(){


    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 87:{
                up=true;
                down=false;
                left=false;
                right=false;
                //label.setLocation(checkNumberNull(label.getX()+step),checkNumberNull(label.getY()));
                break;
            }
            case 38:{
                up=true;
                down=false;
                left=false;
                right=false;
                //label.setLocation(checkNumberNull(label.getX()+step),checkNumberNull(label.getY()));
                break;
            }
            case 83:{
                up=false;
                down=true;
                left=false;
                right=false;
                break;
            }
            case 40:{
                up=false;
                down=true;
                left=false;
                right=false;
                break;
            }
            case 65:{
                up=false;
                down=false;
                left=true;
                right=false;
                break;
            }case 37:{
                up=false;
                down=false;
                left=true;
                right=false;
                break;
            }
            case 68:{
                up=false;
                down=false;
                left=false;
                right=true;
                break;
            }case 39:{
                up=false;
                down=false;
                left=false;
                right=true;
                break;
            }
            case 81:{
                initGame=false;
            }
            default:{
                break;
            }
        }
        timeDelay(5);
        System.out.println("Result" +e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void LocationCube(){

            if(up ){
                shake.setLocation(checkNumberNull(shake.getX()),checkNumberNull(shake.getY()-step));
            }else if(down){
                shake.setLocation(checkNumberNull(shake.getX()),checkNumberNull(shake.getY()+step));
            }else if(left){
                shake.setLocation(checkNumberNull(shake.getX()-step),checkNumberNull(shake.getY()));
            }else if(right){
                shake.setLocation(checkNumberNull(shake.getX()+step),checkNumberNull(shake.getY()));
            }

    }
    public void timeDelay(int num){
        try {
            Thread.sleep(num);


        } catch(InterruptedException ex) {}

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
        return  (int)Math.floor(Math.random()*(super.getWidth()-1)+1);

    }
    public boolean initShakeApple(){
        if(((int)Math.abs(shake.getX()-apple.getAppleX())<=5)&&((int)Math.abs(shake.getY()-apple.getAppleY())<=5)){
            return true;
        }
        return false;
    }
    public int GetRandomNumber()
    {
        int check=0;
        number=new ArrayList<Integer>();
        if(number.isEmpty()){
            for(int i=0;i<(num-40);i+=step){
                number.add(check);
                check+=step;
            }
        }
        int min = 1;
        int max = number.size()-1;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1) + min;
        return number.get(i);
    }

}
