package com.wp.tankgame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 坦克大战的绘图区域
 */
//为了监听键盘事件
public class MyPanle extends JPanel implements KeyListener,Runnable {
    private Hero hero = null;
    private Vector<EnemyTank> enemyTanks = new Vector<>();
    private Bullet bullet = null;
    private int tankNums = 3;
    private boolean isOK = false;
    public MyPanle(){
        hero = new Hero(300,200);
        for (int i = 0; i < tankNums; i++) {
            enemyTanks.add(new EnemyTank(100 * (i + 1),0));
        }
        hero.setSpeed(3);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        drawTank(hero.getX(),hero.getY(),g,hero.getDirection(),0);
        for (EnemyTank enemyTank : enemyTanks) {
            enemyTank.setDirection(2);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirection(),1);
        }
        if(hero.getBullet() != null && hero.getBullet().isLive == true){
            drawBullet(hero.getBullet().getX(),hero.getBullet().getY(),hero.getBullet().getDirection(),g);
        }


    }

    /**
     *
     * @param x 坦克左上角x坐标
     * @param y 坦克左上角y坐标
     * @param g 画笔
     * @param direction 坦克方向
     * @param type  坦克种类
     */
    public void drawTank(int x,int y,Graphics g,int direction,int type){
        switch (type){
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        //0上1右2下3左
        switch (direction){
            case 0:
                g.fill3DRect(x,y,10,60,false);//左轮
                g.fill3DRect(x + 10,y + 10,20,40,false);//矩形
                g.fill3DRect(x + 30,y,10,60,false);//右轮
                g.fillOval(x + 10,y + 20,20,20);//圆形
                g.drawLine(x + 20,y + 30,x + 20, y - 20);//炮筒
                break;
            case 1:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x + 10,y + 10,40,20,false);
                g.fill3DRect(x,y + 30,60,10,false);
                g.fillOval(x + 20,y + 10,20,20);
                g.drawLine(x + 20,y + 20,x + 70, y + 20);
                break;
            case 2:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,20,40,false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fillOval(x + 10,y + 20,20,20);
                g.drawLine(x + 20,y + 30,x + 20, y + 80);
                break;
            case 3:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x + 10,y + 10,40,20,false);
                g.fill3DRect(x,y + 30,60,10,false);
                g.fillOval(x + 20,y + 10,20,20);
                g.drawLine(x + 20,y + 20,x - 30, y + 20);
                break;
            default:
                System.out.println("暂未设置");
        }
    }
    public void drawBullet(int x,int y,int direction,Graphics g){
        switch (direction){
            case 0:
                g.fillOval(x,y,10,10);//圆形
                break;
            case 1:
                g.fillOval(x,y,10,10);//圆形
                break;
            case 2:
                g.fillOval(x,y,10,10);//圆形
                break;
            case 3:
                g.fillOval(x,y,10,10);//圆形
                break;
            default:
                System.out.println("暂未设置");
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirection(0);
            hero.moveUp();
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            hero.setDirection(1);
            hero.moveRight();
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            hero.setDirection(2);
            hero.moveDown();
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirection(3);
            hero.moveLeft();
        }
        if(e.getKeyCode() == KeyEvent.VK_J){
            hero.shot();

        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }

    }
}
