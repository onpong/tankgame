package com.wp.tankgame01;

import javax.swing.*;

public class WpTankGame01 extends JFrame {
    private MyPanle mp;
    public static void main(String[] args) {
        WpTankGame01 wpTankGame01 = new WpTankGame01();
    }

    public WpTankGame01() {
        mp = new MyPanle();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
