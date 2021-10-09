package com.wp.tankgame03;

import java.util.Vector;

public class Hero extends Tank {
    private Bullet bullet;
    private Vector<Bullet> bullets = new Vector<>();
    boolean isLive = true;
    public Hero(int x, int y) {
        super(x,y);
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void shot(){
        switch(getDirection()){
            case 0:
                bullet = new Bullet(getDirection(),getX() + 15,getY() - 25);
                break;
            case 1:
                bullet = new Bullet(getDirection(),getX() + 70,getY() + 15);
                break;
            case 2:
                bullet = new Bullet(getDirection(),getX() + 15,getY() + 80);
                break;
            case 3:
                bullet = new Bullet(getDirection(),getX() - 35,getY() + 15);
                break;

        }
        if(bullets.size() < 5){
            bullets.add(bullet);
        }
        bullet.start();
    }



    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }
}
