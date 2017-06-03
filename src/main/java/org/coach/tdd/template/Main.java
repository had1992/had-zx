package org.coach.tdd.template;

import java.util.Scanner;
import java.lang.Thread;
import java.lang.Runtime;

public class Main {
    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);
        int mapSize = 0;
        System.out.println("请输入地图大小：");
        mapSize = In.nextInt();


        Map map = new Map(mapSize);
        map.setCellAlive(mapSize / 2, mapSize / 2 - 1, true);
        map.setCellAlive(mapSize / 2, mapSize / 2, true);
        map.setCellAlive(mapSize / 2, mapSize / 2 + 1, true);
        map.setCellAlive(mapSize / 2 + 1, mapSize / 2, true);

        System.out.println(map.display());

        Thread thread = Thread.currentThread();

        while (true) {
            map.update();
            System.out.println(map.display());
            try {
                thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Runtime.getRuntime().exec("clear");
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
