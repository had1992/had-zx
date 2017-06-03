package org.coach.tdd.template;

/**
 * Created by had on 2017/6/3.
 */
public class CountAliveCellInMid extends CountAliveCell {
    public CountAliveCellInMid(int r, int c, Cell[][] m) {
        super(r, c, m);
    }

    @Override
    public int count() {
        int countAlive = 0;
        for (int i = 0; i < 3; i++) {
            int tempColumnIdx = columnIdx - 1 + i;
            if (mat[rowIdx - 1][tempColumnIdx].isAlive()) {
                countAlive++;
            }
            if (mat[rowIdx + 1][tempColumnIdx].isAlive()) {
                countAlive++;
            }
        }
        if (mat[rowIdx][columnIdx - 1].isAlive()) {
            countAlive++;
        }
        if (mat[rowIdx][columnIdx + 1].isAlive()) {
            countAlive++;
        }
        return countAlive;
    }
}
