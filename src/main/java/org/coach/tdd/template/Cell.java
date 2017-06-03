package org.coach.tdd.template;

/**
 * Created by had on 2017/6/3.
 */
public class Cell {
    public Cell(int a, int b, Cell[][] m) {
        rowIdx = a;
        columnIdx = b;
        mat = m;
    }

    public void update(){
        int aliveNum = countAliveNum();

        if (aliveNum == 3) {
            isAlive = true;
        } else
        if (aliveNum == 2) {

        } else {
            isAlive = false;
        }
    }

    private int countAliveNum(){
        int result = 0;
        if(!isAtCorner && !isAtEdge){
            result = countAliveNumInMid();
        } else
        if(isAtEdge && !isAtCorner){
            switch (location){
                case 0:
                    result = countAliveNumAtLeftEdge();
                    break;
                case 1:
                    result = countAliveNumAtRightEdge();
                    break;
                case 2:
                    result = countAliveNumAtUpEdge();
                    break;
                case 3:
                    result = countAliveNumAtDownEdge();
                    break;
                default:
                    System.out.println("wrong location");
                    break;
            }
        } else
        if(isAtCorner && !isAtEdge){
            switch (location){
                case 0:
                    result = countAliveNumAtLeftUpCorner();
                    break;
                case 1:
                    result = countAliveNumAtLeftDownCorner();
                    break;
                case 2:
                    result = countAliveNumAtRightUpCorner();
                    break;
                case 3:
                    result = countAliveNumAtRightDownCorner();
                    break;
                default:
                    System.out.println("wrong location");
                    break;
            }
        } else {
            System.out.println("wrong boolen");
        }

        return result;
    }

    private int countAliveNumAtLeftEdge(){
        int countAlive = 0;
        for (int i = 0; i < 2; i++){
            int tempColumnIdx = columnIdx+i;
            if(mat[rowIdx-1][tempColumnIdx].isAlive()) countAlive++;
            if(mat[rowIdx+1][tempColumnIdx].isAlive()) countAlive++;
        }
        if(mat[rowIdx][columnIdx+1].isAlive()) countAlive++;
        return countAlive;
    }

    private int countAliveNumAtRightEdge(){
        int countAlive = 0;
        for (int i = 0; i < 2; i++){
            int tempColumnIdx = columnIdx-i;
            if(mat[rowIdx-1][tempColumnIdx].isAlive()) countAlive++;
            if(mat[rowIdx+1][tempColumnIdx].isAlive()) countAlive++;
        }
        if(mat[rowIdx][columnIdx-1].isAlive()) countAlive++;
        return countAlive;
    }

    private int countAliveNumAtUpEdge(){
        int countAlive = 0;
        for (int i = 0; i < 2; i++){
            int tempRowIdx = rowIdx-i;
            if(mat[tempRowIdx][columnIdx-1].isAlive()) countAlive++;
            if(mat[tempRowIdx][columnIdx+1].isAlive()) countAlive++;
        }
        if(mat[rowIdx+1][columnIdx].isAlive()) countAlive++;
        return countAlive;
    }

    private int countAliveNumAtDownEdge(){
        int countAlive = 0;
        for (int i = 0; i < 2; i++){
            int tempRowIdx = rowIdx+i;
            if(mat[tempRowIdx][columnIdx-1].isAlive()) countAlive++;
            if(mat[tempRowIdx][columnIdx+1].isAlive()) countAlive++;
        }
        if(mat[rowIdx-1][columnIdx].isAlive()) countAlive++;
        return countAlive;
    }

    private int countAliveNumAtLeftUpCorner(){
        int countAlive = 0;
        if(mat[rowIdx][columnIdx+1].isAlive()) countAlive++;
        if(mat[rowIdx+1][columnIdx].isAlive()) countAlive++;
        if(mat[rowIdx+1][columnIdx+1].isAlive()) countAlive++;
        return countAlive;
    }

    private int countAliveNumAtLeftDownCorner(){
        int countAlive = 0;
        if(mat[rowIdx-1][columnIdx].isAlive()) countAlive++;
        if(mat[rowIdx-1][columnIdx+1].isAlive()) countAlive++;
        if(mat[rowIdx][columnIdx+1].isAlive()) countAlive++;
        return countAlive;
    }
    
    private int countAliveNumAtRightUpCorner(){
        int countAlive = 0;
        if(mat[rowIdx][columnIdx-1].isAlive()) countAlive++;
        if(mat[rowIdx+1][columnIdx-1].isAlive()) countAlive++;
        if(mat[rowIdx+1][columnIdx].isAlive()) countAlive++;
        return countAlive;
    }
    
    private int countAliveNumAtRightDownCorner(){
        int countAlive = 0;
        if(mat[rowIdx-1][columnIdx-1].isAlive()) countAlive++;
        if(mat[rowIdx-1][columnIdx].isAlive()) countAlive++;
        if(mat[rowIdx][columnIdx-1].isAlive()) countAlive++;
        return countAlive;
    }
    
    private int countAliveNumInMid(){
        int countAlive = 0;
        for (int i = 0; i < 3; i++){
            int tempColumnIdx = columnIdx-1+i;
            if(mat[rowIdx-1][tempColumnIdx].isAlive()){
                countAlive++;
            }
            if(mat[rowIdx+1][tempColumnIdx].isAlive()){
                countAlive++;
            }
        }
        if(mat[rowIdx][columnIdx-1].isAlive()) countAlive++;
        if(mat[rowIdx][columnIdx+1].isAlive()) countAlive++;
        return countAlive;
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

    public boolean isAtCorner() {
        return isAtCorner;
    }

    public boolean isAtEdge() {
        return isAtEdge;
    }

    private int rowIdx;
    private int columnIdx;
    private boolean isAlive;
    private Cell[][] mat;
    private int location;//Edge:
                         //0:left, 1:right, 2:Up, 3:Down
                         //Corner:
                         //0:leftUp, 1:leftDown, 2:rightUp, 3:rightDown
    private boolean isAtCorner;
    private boolean isAtEdge;
}
