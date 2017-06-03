package org.coach.tdd.template;

/**
 * Created by had on 2017/6/3.
 */
public class Cell {
    private static final int[] DX = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static final int[] DY = {-1, 0, 1, 1, 1, 0, -1, -1};
    private int rowIdx;
    private int columnIdx;
    private int status;
    private int dimensionNum;
    private Cell[][] mat;

    public Cell(int a, int b, Cell[][] m) {
        rowIdx = a;
        columnIdx = b;
        status = 0;
        mat = m;
        dimensionNum = m.length;
    }

    public int update() {
        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            int x = rowIdx + DX[k];
            int y = columnIdx + DY[k];
            if (isValid(x, y)) {
                ++cnt;
            }
        }
        status = ensureStatu(status, cnt);
        return status;
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < dimensionNum &&
                y >= 0 && y < dimensionNum &&
                (mat[x][y].getStatus() == 1 || mat[x][y].getStatus() == 2));
    }

    private int ensureStatu(int oldStatu, int count) {
        int statu = oldStatu;
        if (oldStatu != 0 && (count < 2 || count > 3)) {
            statu = 2;
        } else if (oldStatu == 0 && count == 3) {
            statu = 3;
        }
        return statu;
    }

    public boolean getAlive() {
        status %= 2;
        return status == 1;
    }

    public void setAlive(boolean alive) {
        if (alive) {
            status = 1;
        } else {
            status = 0;
        }
    }

    public int getStatus() {
        return status;
    }
}
