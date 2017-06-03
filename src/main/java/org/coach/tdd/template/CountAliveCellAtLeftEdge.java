package org.coach.tdd.template;

/**
 * Created by had on 2017/6/3.
 */
public class CountAliveCellAtLeftEdge extends CountAliveCell {
    public CountAliveCellAtLeftEdge(int r, int c, Cell[][] m) {
        super(r, c, m);
    }

    @Override
    public int count() {
        int countAlive = 0;
        for (int i = 0; i < 2; i++) {
            int tempColumnIdx = columnIdx + i;
            if (mat[rowIdx - 1][tempColumnIdx].isAlive()) {
                countAlive++;
            }
            if (mat[rowIdx + 1][tempColumnIdx].isAlive()) {
                countAlive++;
            }
        }
        if (mat[rowIdx][columnIdx + 1].isAlive()) {
            countAlive++;
        }
        return countAlive;
    }
}
