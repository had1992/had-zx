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
                map[i][j] = new Cell(i, j, map);
            }
        }
    }

    public void update() {
        for (int i = 0; i < dimensionNum; i++) {
            for (int j = 0; j < dimensionNum; j++) {
                map[i][j].update();
            }
        }
        for (int i = 0; i < dimensionNum; ++i) {
            for (int j = 0; j < dimensionNum; ++j) {
                map[i][j].getAlive();
            }
        }
    }

    public String display() {
        String print = "";
        for (int i = 0; i < dimensionNum; i++) {
            for (int j = 0; j < dimensionNum; j++) {
                if (map[i][j].getAlive()) {
                    print += "*";
                } else {
                    print += ".";
                }
            }
            print += "\n";
        }
        print += "\n";
        return print;
    }

    public boolean getAliveCell(int i, int j) {
        return map[i][j].getAlive();
    }

    public int getDimensionNum() {
        return dimensionNum;
    }

    public void setCellAlive(int rowIdx, int columnIdx, boolean isAlive) {
        map[rowIdx][columnIdx].setAlive(isAlive);
    }

    public Cell getCell(int i, int j) {
        return map[i][j];
    }
}
