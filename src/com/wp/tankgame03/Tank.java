package com.wp.tankgame03;

import java.util.Vector;

public abstract class Tank {
    private int x;
    private int y;

    private int direction = 0;
    private int speed = 1;
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void moveUp(){
        if(getY() - 20 > 0){
           y -= speed;
        }
    }
    public void moveDown(){
        if(getY() + 80 < 750){
            y += speed;
        }
    }
    public void moveLeft(){
        if(getX() - 20 > 0){
            x -= speed;
        }
    }
    public void moveRight(){
        if(getX() + 80 < 1000){
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
