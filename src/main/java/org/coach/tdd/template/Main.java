package org.coach.tdd.template;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(10);
        map.setAliveCell(0, 2);
        map.setAliveCell(2, 2);
        map.setAliveCell(1, 3);
        map.setAliveCell(1, 1);
        map.setAliveCell(1, 4);

        map.display();

        for (int i = 0; i < 10; i++) {
            map.update();
            map.display();
        }
    }
}
