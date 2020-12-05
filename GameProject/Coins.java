import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines coin objects' behaviour.
 * 
 * @author Giuliana Bouzon
 */
public class Coins extends Actor
{
    private int counter,speed, indexCoins;
    private GreenfootImage[] coins;
    public Coins(){
        speed = Greenfoot.getRandomNumber(5)+1;
        coins = new GreenfootImage[10];
        indexCoins = 0;
        for(int i = 0; i<coins.length; i++){
            coins[i] = new GreenfootImage("gold" + (i+1) + ".png");
        }
    }
    /**
     * Method to create character animation.
     */
    private void switchImage(){
       if(counter==4){
            setImage(coins[indexCoins % coins.length]);
            indexCoins++;
            counter = 0;
       }
       else{
            counter++;
       }
    }
    private void detectClass(){
        if(getWorld().getClass() == Snake.class){
            setLocation(getX(), getY()+speed);
            switchImage();
            if(isTouching(Ground.class)){
                ((MyWorld)getWorld()).addScore(-10);
                ((MyWorld)getWorld()).removeObject(this);
            }
        }
        else if(getWorld().getClass() == DinoRush.class){
            setLocation(getX()-1, getY());
            switchImage();
        }else if(getWorld().getClass() == ProperSnake.class){
            setLocation(getX(), getY()+speed);
            if(isTouching (line.class)){
                ((MyWorld)getWorld()).addScore(-1);
                ((MyWorld)getWorld()).removeObject(this);
            }
            else if(isTouching (DBDragon.class)){
                ((MyWorld)getWorld()).addScore(+10);
                ((MyWorld)getWorld()).removeObject(this);
                
            }
        }
    }
    /**
     * Act - do whatever the Coins wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        detectClass();
    }    
}
