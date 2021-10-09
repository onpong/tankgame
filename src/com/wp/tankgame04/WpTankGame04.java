package com.wp.tankgame04;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

public class WpTankGame04 extends JFrame {
    private MyPanle mp;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        WpTankGame04 wpTankGame02 = new WpTankGame04();
    }

    public WpTankGame04() {
        System.out.println("请选择 1.新游戏 2.上一局");
        String key = scanner.next();
        mp = new MyPanle(key);
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1300,950);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("退出成功");
                try {
                    Recorder.keepRecord();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}
