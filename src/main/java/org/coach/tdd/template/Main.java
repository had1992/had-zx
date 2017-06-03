package org.coach.tdd.template;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(50);
        map.setCellAlive(25, 24,true);
        map.setCellAlive(25, 25,true);
        map.setCellAlive(25, 26,true);
        map.setCellAlive(26, 25,true);

        System.out.println(map.Display());

        for (int i = 0; i < 100; i++) {
            map.Update();
            System.out.println(map.Display());
        }
    }
}
