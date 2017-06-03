package org.coach.tdd.template;

/**
 * Created by had on 2017/6/3.
 */
public class Map {
    private Cell[][] map;
    private int dimensionNum;
    private int[][] status;
    private int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
    private int dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};

    public Map(int n) {
        dimensionNum = n;
        map = new Cell[dimensionNum][];
        status = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = new Cell[dimensionNum];
        }
        for (int i = 0; i < dimensionNum; i++) {
            for (int j = 0; j < dimensionNum; j++) {
                map[i][j] = new Cell(i, j, map);
                status[i][j] = 0;
            }
        }
    }

    public void Update() {
        for (int i = 0; i < dimensionNum; i++) {
            for (int j = 0; j < dimensionNum; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < dimensionNum && y >= 0 && y < dimensionNum && (status[x][y] == 1 || status[x][y] == 2)) {
                        ++cnt;
                    }
                }
                if (status[i][j] != 0 && (cnt < 2 || cnt > 3)) status[i][j] = 2;
                else if (status[i][j] == 0 && cnt == 3) status[i][j] = 3;
            }
        }
        for (int i = 0; i < dimensionNum; ++i) {
            for (int j = 0; j < dimensionNum; ++j) {
                status[i][j] %= 2;
                if (status[i][j] == 0) {
                    map[i][j].setAlive(false);
                } else {
                    map[i][j].setAlive(true);
                }
            }
        }

    }

    public String Display() {
        String print = "";
        for (int i = 0; i < dimensionNum; i++) {
            for (int j = 0; j < dimensionNum; j++) {
                if (map[i][j].isAlive()) {
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
        return map[i][j].isAlive();
    }

    public int getDimensionNum() {
        return dimensionNum;
    }

    public void setCellAlive(int rowIdx, int columnIdx, boolean isAlive) {
        if (isAlive) {
            status[rowIdx][columnIdx] = 1;
        } else {
            status[rowIdx][columnIdx] = 0;
        }
        map[rowIdx][columnIdx].setAlive(isAlive);
    }
}
