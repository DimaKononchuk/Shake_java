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
    private int checkNum;
    private boolean right=false;

    private String str="a";
    private boolean initGame=true;
    private ArrayList<ShakeBlock> blockArr;
    private  Shake   shake;
    private ShakeBlock shakeBlock;
    private Apple apple;
    public MyFrame(){
        super();
    };
    public MyFrame(int num,int cubeSize,int step){

        super("Shake javaGUI");

        int check=1;
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
        blockArr=new ArrayList<ShakeBlock>();
        blockArr.add(new ShakeBlock());
        super.add(blockArr.get(0));
        shakeBlock=new ShakeBlock();

        super.add(apple);


        LocationCube();

        while(initGame){
            timeDelay(750);
            int x=shake.getX();
            int y=shake.getY();
            shakeBlock.addShakeBlock(x,y);
            LocationCube();
            System.out.println("Coordinate: "+ shake.getX()+" "+shake.getY());

            if(initShakeApple()){

                apple.setApple(GetRandomNumber(),GetRandomNumber());
                apple.addApple(GetRandomNumber(),GetRandomNumber());
                blockArr.add(new ShakeBlock());

                super.add(blockArr.get(check));
                check++;



                System.out.println("OK!");
            }
            //shakeBlock.setShakeBlock(GetRandomNumber(),GetRandomNumber());
            //shakeBlock.addShakeBlock(x,y);
            //int x1=blockArr.get(0).getShakeBlockX();

            ArrayList<Integer> x2=new ArrayList<Integer>();
            //int y1=blockArr.get(0).getShakeBlockY();
            ArrayList<Integer> y2=new ArrayList<Integer>();
            for(int i=0;i< blockArr.size();i++){
                x2.add(blockArr.get(i).getShakeBlockX());
                y2.add(blockArr.get(i).getShakeBlockY());
            }
            blockArr.get(0).addShakeBlock(x,y);

            x=shake.getX();
            y=shake.getY();
            for(int i=1;i<blockArr.size();i++){

                blockArr.get(i).addShakeBlock(x2.get(i-1),y2.get(i-1));
                blockArr.get(i).setShakeBlock(x2.get(i-1),y2.get(i-1));
                if(shake.getX()==x2.get(i-1)&&shake.getY()==y2.get(i-1)){
                    initGame=false;
                }

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
                if(checkNum!=83){
                    up=true;
                    down=false;
                    left=false;
                    right=false;
                    checkNum=87;
                }


                break;
            }
            case 38:{
                if(checkNum!=40){
                    up=true;
                    down=false;
                    left=false;
                    right=false;
                    checkNum=38;
                }

                break;
            }
            case 83:{
                if(checkNum!=87){
                    up=false;
                    down=true;
                    left=false;
                    right=false;
                    checkNum=83;

                }

                break;
            }
            case 40:{
                if(checkNum!=38){
                    up=false;
                    down=true;
                    left=false;
                    right=false;
                    checkNum=40;

                }
                break;

            }
            case 65:{
                if(checkNum!=68){
                    up=false;
                    down=false;
                    left=true;
                    right=false;
                    checkNum=65;
                }

                break;
            }case 37:{
                if(checkNum!=39){
                    up=false;
                    down=false;
                    left=true;
                    right=false;
                    checkNum=37;
                }

                break;
            }
            case 68:{
                if(checkNum!=65){
                    up=false;
                    down=false;
                    left=false;
                    right=true;
                    checkNum=68;
                }

                break;
            }case 39:{
                if(checkNum!=37){
                    up=false;
                    down=false;
                    left=false;
                    right=true;
                    checkNum=39;
                }

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
        if(((int)Math.abs(shake.getX()-apple.getAppleX())<=10)&&((int)Math.abs(shake.getY()-apple.getAppleY())<=10)){
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
