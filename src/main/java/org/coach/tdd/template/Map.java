package org.coach.tdd.template;

/**
 * Created by had on 2017/6/3.
 */
public class Map {
    public Map(int n) {
        N = n;
        map = new Cell[N][];
        for (int i = 0; i < n; i++){
            map[i] = new Cell[N];
        }
    }

    private Cell map[][];
    private int N;
}
