package org.coach.tdd.template;

/**
 * Created by had on 2017/6/3.
 */
public class Cell {
    private int rowIdx;
    private int columnIdx;
    private boolean isAlive;
    private Cell[][] mat;
    private CountAliveCell countMethod;

    public Cell(int a, int b, Cell[][] m) {
        rowIdx = a;
        columnIdx = b;
        isAlive = false;
        mat = m;

        countMethod = new CountAliveCell(a, b, m);
    }

    public void update() {
        int aliveNum = countMethod.count();

        if (aliveNum == 3) {
            isAlive = true;
        } else if (aliveNum != 2) {
            isAlive = false;
        }
    }

    public int getRowIdx() {
        return rowIdx;
    }

    public int getColumnIdx() {
        return columnIdx;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
