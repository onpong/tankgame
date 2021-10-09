package com.wp.tankgame01;

import javax.swing.*;
import java.awt.*;

/**
 * 坦克大战的绘图区域
 */
public class MyPanle extends JPanel {
    Hero hero = null;
    public MyPanle(){
        hero = new Hero(100,100);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        drawTank(hero.getX(),hero.getY(),g,0,0);
        drawTank(hero.getX() + 100,hero.getY(),g,0,1);
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
        switch (direction){
            case 0:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,20,40,false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fillOval(x + 10,y + 20,20,20);
                g.drawLine(x + 20,y + 30,x + 20, y - 20);
                break;
            default:
                System.out.println("暂未设置");
        }
    }
}
