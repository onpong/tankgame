package com.wp.tankgame04;


import java.io.*;
import java.util.Vector;

public class Recorder {
    private static int tankNums = 0;
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String pathName = "src\\myRecord.txt";
    private static Vector<EnemyTank> enemyTanks = null;
    private static Vector<Node> nodes = new Vector<>();

    public static Vector<Node> readRecord() throws IOException{
        br = new BufferedReader(new FileReader(pathName));
        tankNums = Integer.parseInt(br.readLine());
        String line = "";
        while((line = br.readLine()) != null){
            String[] temp = line.split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            int dirc = Integer.parseInt(temp[2]);
            nodes.add(new Node(x,y,dirc));
        }
        br.close();
        return nodes;
    }
    public static void keepRecord() throws IOException {
        fw = new FileWriter(pathName);
        bw = new BufferedWriter(fw);
        bw.write(tankNums + "\r\n");
        for (EnemyTank enemyTank : enemyTanks) {
            String content = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection();
            bw.write(content + "\r\n");
        }
        bw.close();
    }
    public static int getAlltankNums(){
        return tankNums;
    }
    public static void setTankNums(int tankNums){
        Recorder.tankNums = tankNums;
    }
    public static void addTankNums(){
        tankNums++;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static String getPathName() {
        return pathName;
    }
}
