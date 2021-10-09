package com.wp.tankgame03;

public class Bomb {
    int x,y;
    int life = 9;
    boolean islive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void lifeDowm(){
        if(life > 0){
            System.out.println("life为" + life);
            life--;
        }else{
            System.out.println("life为" + life);
            islive = false;
        }
    }
}
