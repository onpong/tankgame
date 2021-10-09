package com.wp.tankgame02;

import javax.swing.*;

public class WpTankGame02 extends JFrame {
    private MyPanle mp;
    public static void main(String[] args) {
        WpTankGame02 wpTankGame02 = new WpTankGame02();
    }

    public WpTankGame02() {
        mp = new MyPanle();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
