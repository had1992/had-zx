package org.coach.tdd.template;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int mapSize = 0;
        System.out.println("请输入地图大小：");
        mapSize = input.nextInt();


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
        }
    }
}
