package com.wp.tankgame04;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    Vector<Bullet> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }
    Vector<EnemyTank> enemyTanks = null;

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }
    public boolean isTouch(){
        switch (this.getDirection()){
            case 0:
                for (EnemyTank enemyTank : enemyTanks) {
                    if(enemyTank == this)
                        continue;
                    if(enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                        if((getX() <= enemyTank.getX() + 40 && getX() >= enemyTank.getX() ||
                        getX() + 40 <= enemyTank.getX() + 40 && getX() + 40 >= enemyTank.getX()) &&
                        getY() <= enemyTank.getY() + 65)
                            return true;
                        else
                            return false;
                    }else if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3){
                        if((getX() <= enemyTank.getX() + 60 && getX() >= enemyTank.getX() ||
                            getX() + 40 <= enemyTank.getX() + 60 && getX() + 40 >= enemyTank.getX()) &&
                            getY() <= enemyTank.getY() + 45)
                            return true;
                        else
                            return false;
                    }
                }
                break;
            case 1:
                for (EnemyTank enemyTank : enemyTanks) {
                    if(enemyTank == this)
                        continue;
                    if(enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                        if((getY() <= enemyTank.getY() + 60 && getY() >= enemyTank.getY() || getY() + 40
                        <= enemyTank.getY() + 60 && getY() + 40 >= enemyTank.getY())
                                && getX() + 60 >= enemyTank.getX() - 5)
                            return true;
                        else
                            return false;
                    }else if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3){
                        if((getY() <= enemyTank.getY() + 40 && getY() >= enemyTank.getY() || getY() + 40
                                <= enemyTank.getY() + 40 && getY() + 40 >= enemyTank.getY())
                                && getX() + 60 >= enemyTank.getX() - 5)
                            return true;
                        }else
                            return false;
                    }
                break;
            case 2:
                for (EnemyTank enemyTank : enemyTanks) {
                    if(enemyTank == this)
                        continue;
                    if(enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                        if((getX() <= enemyTank.getX() + 40 && getX() >= enemyTank.getX() ||
                                getX() + 40 <= enemyTank.getX() + 40 && getX() + 40 >= enemyTank.getX()) &&
                                getY() + 60 >= enemyTank.getY() - 5)
                            return  true;
                        else
                            return false;
                    }else if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3){
                        if((getX() <= enemyTank.getX() + 60 && getX() >= enemyTank.getX() ||
                                getX() + 40 <= enemyTank.getX() + 60 && getX() + 40 >= enemyTank.getX()) &&
                                getY() + 60 >= enemyTank.getY() - 5)
                            return  true;
                        else
                            return false;
                    }
                }
                break;
            case 3:
                for (EnemyTank enemyTank : enemyTanks) {
                    if(enemyTank == this)
                        continue;
                    if(enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                        if((getY() <= enemyTank.getY() + 60 && getY() >= enemyTank.getY() || getY() + 40
                                <= enemyTank.getY() + 60 && getY() + 40 >= enemyTank.getY())
                                && getX() <= enemyTank.getX() + 45)
                            return true;
                        else
                            return false;
                    }else if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3){
                        if((getY() <= enemyTank.getY() + 40 && getY() >= enemyTank.getY() || getY() + 40
                                <= enemyTank.getY() + 40 && getY() + 40 >= enemyTank.getY())
                                && getX() <= enemyTank.getX() + 65)
                            return true;
                        else
                            return false;
                    }
                }
                break;
        }
        return false;
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
                        if(!isTouch()){
                            moveUp();
                        }
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0;i < 30;i++) {
                        if(!isTouch()){
                            moveRight();
                        }

                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0;i < 30;i++) {
                        if(!isTouch()){
                            moveDown();
                        }

                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0;i < 30;i++) {
                            if(!isTouch()){
                                moveLeft();
                            }
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
