package com.wp.tankgame03;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    Vector<Bullet> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while(isLive){
            if(shots.size() == 0){
                Bullet bullet = null;
                switch (getDirection()){
                    case 0:
                        bullet = new Bullet(getDirection(),getX() + 20,getY() - 20);
                        break;
                    case 1:
                        bullet = new Bullet(getDirection(),getX() + 80,getY() + 20);
                        break;
                    case 2:
                        bullet = new Bullet(getDirection(),getX() + 20,getY() + 80);
                        break;
                    case 3:
                        bullet = new Bullet(getDirection(),getX() - 20,getY() + 20);
                        break;
                }
                shots.add(bullet);
                bullet.start();

            }
            switch (getDirection()){
                case 0:
                    for (int i = 0;i < 30;i++) {
                            moveUp();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0;i < 30;i++) {
                            moveRight();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0;i < 30;i++) {
                            moveDown();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0;i < 30;i++) {
                            moveLeft();
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            setDirection((int)(Math.random() * 4));
        }
    }

}
