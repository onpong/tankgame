package com.wp.tankgame04;

public abstract class Tank {
    private int x;
    private int y;

    private int direction = 0;
    private int speed = 1;
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void moveUp(){
        if(getY()> 0){
           y -= speed;
        }
    }
    public void moveDown(){
        if(getY() + 60 < 750){
            y += speed;
        }
    }
    public void moveLeft(){
        if(getX()> 0){
            x -= speed;
        }
    }
    public void moveRight(){
        if(getX() + 60 < 1000){
            x += speed;
        }
    }


    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
