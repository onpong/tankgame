package com.wp.draw;

import javax.swing.*;
import java.awt.*;

public class drawpic extends JFrame{
    private MyPanel mp = null;
    public static void main(String[] args) {
        new drawpic();
    }
    public drawpic(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("被调用");

    }
}