package com.wp.tankgame03;

import javax.swing.*;

public class WpTankGame03 extends JFrame {
    private MyPanle mp;
    public static void main(String[] args) {
        WpTankGame03 wpTankGame02 = new WpTankGame03();
    }

    public WpTankGame03() {
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
