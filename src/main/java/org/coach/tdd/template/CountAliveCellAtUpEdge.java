package org.coach.tdd.template;

/**
 * Created by had on 2017/6/3.
 */
public class CountAliveCellAtUpEdge extends CountAliveCell {
    public CountAliveCellAtUpEdge(int r, int c, Cell[][] m) {
        super(r, c, m);
    }

    @Override
    public int count() {
        int countAlive = 0;
        for (int i = 0; i < 2; i++) {
            int tempRowIdx = rowIdx + i;
            if (mat[tempRowIdx][columnIdx - 1].isAlive()) {
                countAlive++;
            }
            if (mat[tempRowIdx][columnIdx + 1].isAlive()) {
                countAlive++;
            }
        }
        if (mat[rowIdx + 1][columnIdx].isAlive()) {
            countAlive++;
        }
        return countAlive;
    }
}
