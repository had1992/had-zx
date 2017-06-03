package org.coach.tdd.template;

/**
 * Created by had on 2017/6/3.
 */
public class CountAliveCellAtLeftDownCorner extends CountAliveCell {
    public CountAliveCellAtLeftDownCorner(int r, int c, Cell[][] m) {
        super(r, c, m);
    }

    @Override
    public int count() {
        int countAlive = 0;
        if (mat[rowIdx - 1][columnIdx].isAlive()) {
            countAlive++;
        }
        if (mat[rowIdx - 1][columnIdx + 1].isAlive()) {
            countAlive++;
        }
        if (mat[rowIdx][columnIdx + 1].isAlive()) {
            countAlive++;
        }
        return countAlive;
    }
}
