package org.coach.tdd.template;

/**
 * Created by had on 2017/6/3.
 */
public class CountAliveCell {
    protected int rowIdx;
    protected int columnIdx;
    protected Cell[][] mat;
    private int dimisionNum;

    public CountAliveCell(int r, int c, Cell[][] m) {
        rowIdx = r;
        columnIdx = c;
        mat = m;
        dimisionNum = m.length;
    }

    public int count() {
        int result = 0;

        result += add(rowIdx - 1, columnIdx - 1);
        result += add(rowIdx - 1, columnIdx);
        result += add(rowIdx, columnIdx - 1);
        result += add(rowIdx + 1, columnIdx + 1);
        result += add(rowIdx, columnIdx + 1);
        result += add(rowIdx + 1, columnIdx);
        result += add(rowIdx + 1, columnIdx - 1);
        result += add(rowIdx - 1, columnIdx + 1);

        return result;
    }

    private int add(int r, int c) {
        int result = 0;
        if (r < 0 || c < 0 || r >= dimisionNum || c >= dimisionNum) {
            result = 0;
        } else if (mat[r][c].isAlive()) {
            result = 1;
        }
        return result;
    }
}
