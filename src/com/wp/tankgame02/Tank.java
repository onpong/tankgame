package com.wp.tankgame02;

public abstract class Tank {
    private int x;
    private int y;
    private int direction = 0;
    private int speed = 1;
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void moveUp(){
        y -= speed;
    }
    public void moveDown(){
        y += speed;
    }
    public void moveLeft(){
        x -= speed;
    }
    public void moveRight(){
        x += speed;
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
