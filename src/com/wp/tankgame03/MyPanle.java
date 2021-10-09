package com.wp.tankgame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 坦克大战的绘图区域
 */
//为了监听键盘事件
@
SuppressWarnings({"all"})
public class MyPanle extends JPanel implements KeyListener, Runnable {
    private Hero hero = null;
    private Vector<EnemyTank> enemyTanks = new Vector<>();
    private Bullet bullet = null;
    private int tankNums = 3;
    private Vector<Bomb> bombs = new Vector<>();
    private boolean isOK = false;
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanle() {
        hero = new Hero(300, 200);
        for (int i = 0; i < tankNums; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirection(2);
            Bullet bullet = new Bullet(enemyTank.getDirection(), enemyTank.getX() + 20, enemyTank.getY() + 60);
            enemyTank.shots.add(bullet);
            Thread thread = new Thread(enemyTank);
            thread.start();
            bullet.start();
            enemyTanks.add(enemyTank);

        }
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanle.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanle.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanle.class.getResource("/bomb_3.gif"));
        hero.setSpeed(3);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        if(hero.isLive){
            drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);
        }else{

        }
        for (EnemyTank enemyTank : enemyTanks) {
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
            } else {
                enemyTanks.remove(enemyTank);
            }
            for (int i = 0; i < enemyTank.shots.size(); i++) {
                Bullet shot = enemyTank.shots.get(i);
                if (shot.isLive == true) {
                    drawBullet(shot.getX(), shot.getY(), shot.getDirection(), g);
                } else {
                    enemyTank.shots.remove(shot);
                }

            }
        }
//        if (hero.getBullet() != null && hero.getBullet().isLive == true) {
//            drawBullet(hero.getBullet().getX(), hero.getBullet().getY(), hero.getBullet().getDirection(), g);
//        }
        for (int i = 0; i < hero.getBullets().size(); i++) {
            Bullet bullet = hero.getBullets().get(i);
            if(bullet != null && bullet.isLive == true){
                drawBullet(bullet.getX(),bullet.getY(),bullet.getDirection(),g);
            }else{
                hero.getBullets().remove(bullet);
            }

        }
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            bomb.lifeDowm();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }

        }


    }

    /**
     * @param x         坦克左上角x坐标
     * @param y         坦克左上角y坐标
     * @param g         画笔
     * @param direction 坦克方向
     * @param type      坦克种类
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        //0上1右2下3左
        switch (direction) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);//左轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//矩形
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮
                g.fillOval(x + 10, y + 20, 20, 20);//圆形
                g.drawLine(x + 20, y + 30, x + 20, y - 20);//炮筒
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 80, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 80);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 20, y + 20, x - 30, y + 20);
                break;
            default:
                System.out.println("暂未设置");
        }
    }

    public void drawBullet(int x, int y, int direction, Graphics g) {
        switch (direction) {
            case 0:
                g.fillOval(x, y, 10, 10);//圆形
                break;
            case 1:
                g.fillOval(x, y, 10, 10);//圆形
                break;
            case 2:
                g.fillOval(x, y, 10, 10);//圆形
                break;
            case 3:
                g.fillOval(x, y, 10, 10);//圆形
                break;
            default:
                System.out.println("暂未设置");
        }
    }
    public void hitHero(){
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Bullet bullet = enemyTank.shots.get(j);
                switch (hero.getDirection()){
                    case 0:
                    case 2:
                        if (bullet.getX() > hero.getX() && bullet.getX() < hero.getX() + 40
                                && bullet.getY() > hero.getY()
                                && bullet.getY() < hero.getY() + 60) {
                            bullet.isLive = false;
                            hero.isLive = false;
                            Bomb bomb = new Bomb(hero.getX(), hero.getY());
                            bombs.add(bomb);
                        }
                        break;
                    case 1:
                    case 3:
                        if (bullet.getX() > hero.getX() && bullet.getX() <hero.getX() + 60
                                && bullet.getY() > hero.getY()
                                && bullet.getY() < hero.getY() + 40) {
                            bullet.isLive = false;
                            enemyTank.isLive = false;
                            Bomb bomb = new Bomb(hero.getX(), hero.getY());
                            bombs.add(bomb);
                        }

                        break;
                }

            }
        }
    }
    public void hiTank(Vector<Bullet> bullets, EnemyTank enemyTank) {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            switch (enemyTank.getDirection()) {
                case 0:
                case 2:
                    if (bullet.getX() > enemyTank.getX() && bullet.getX() < enemyTank.getX() + 40
                            && bullet.getY() > enemyTank.getY()
                            && bullet.getY() < enemyTank.getY() + 60) {
                        bullet.isLive = false;
                        enemyTank.isLive = false;
                        Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                        bombs.add(bomb);
                    }
                    break;
                case 1:
                case 3:
                    if (bullet.getX() > enemyTank.getX() && bullet.getX() < enemyTank.getX() + 60
                            && bullet.getY() > enemyTank.getY()
                            && bullet.getY() < enemyTank.getY() + 40) {
                        bullet.isLive = false;
                        enemyTank.isLive = false;
                        Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                        bombs.add(bomb);
                    }

                    break;
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(3);
            hero.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {

                hero.shot();

        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (hero.getBullet() != null && hero.getBullet().isLive) {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    hiTank(hero.getBullets(), enemyTanks.get(i));
                }
            }
            hitHero();
            this.repaint();
        }

    }

    public Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }
}
