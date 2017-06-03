package org.coach.tdd.template;

/**
 * Created by had on 2017/6/3.
 */
public class Map {
    private Cell[][] map;
    private int dimensionNum;

    public Map(int n) {
        dimensionNum = n;
        map = new Cell[dimensionNum][];
        for (int i = 0; i < n; i++) {
            map[i] = new Cell[dimensionNum];
        }
        for (int i = 0; i < dimensionNum; i++) {
            for (int j = 0; j < dimensionNum; j++) {
                map[i][j] = new Cell(i, j, dimensionNum, false, map);

            }
        }
    }

    public void setAliveCell(int rowIdx, int columnIdx) {
        map[rowIdx][columnIdx].setAlive(true);
    }

    public void update() {
        for (int i = 0; i < dimensionNum; i++) {
            for (int j = 0; j < dimensionNum; j++) {
                map[i][j].update();
            }
        }
    }

    public void display() {
        for (int i = 0; i < dimensionNum; i++) {
            for (int j = 0; j < dimensionNum; j++) {
                if (map[i][j].isAlive()) {
                    System.out.print('*');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
