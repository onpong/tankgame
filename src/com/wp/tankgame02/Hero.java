package com.wp.tankgame02;

public class Hero extends Tank {
    private Bullet bullet;
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
        bullet.start();
    }

}
