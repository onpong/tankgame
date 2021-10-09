package com.wp.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame{
    private MyPanel mp;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }
    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(mp);
        this.setSize(400,300);
        this.setVisible(true);
    }

}
class MyPanel extends JPanel implements KeyListener {
    private int x = 10;
    private int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }
    //有字符输出时，该方法会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //当某个键按下，该方法触发
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyCode() + "被触发");
        if(e.getKeyCode() == KeyEvent.VK_UP){
            y--;
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            y++;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x--;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x++;
        }
        repaint();
    }
    //某个键释放该方法触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}