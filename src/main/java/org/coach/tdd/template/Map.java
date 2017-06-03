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
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                map[i][j] = new Cell(i,j,N,false,map);

            }
        }
    }

    public void setAliveCell(int rowIdx, int columnIdx){
        map[rowIdx][columnIdx].setAlive(true);
    }

    public void update(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                map[i][j].update();
            }
        }
    }

    public void display(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(map[i][j].isAlive()){
                    System.out.print('*');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private Cell map[][];
    private int N;
}
