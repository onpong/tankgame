package com.wp.tankgame02;

public class Bullet extends Thread{
    private int direction;
    private int x;
    private int y;
    private int speed = 12;
    boolean isLive = true;
    @Override
    public void run() {
        while(true){


            switch (direction){
                case 0:
                   y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
                default:
                    System.out.println("暂未设置");
            }
            System.out.println("当前的最标为" + x + "  " + y);
            if(y <0 || x < 0 || x > 1000 || y > 750){
                isLive = false;
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Bullet(int direction, int x, int y) {
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
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
