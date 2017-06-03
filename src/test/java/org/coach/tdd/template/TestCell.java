package org.coach.tdd.template;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by had on 2017/6/3.
 */
public class TestCell {
    @Test
    public void testSetAlive() {
        Cell[][] m = new Cell[1][1];
        Cell cell = new Cell(0, 0, m);
        cell.setAlive(true);
        assertTrue("error", cell.getAlive());

        cell.setAlive(false);
        assertTrue("error", !cell.getAlive());
    }

    @Test
    public void testGetStatus() {
        Cell[][] m = new Cell[1][1];
        Cell cell = new Cell(0, 0, m);
        assertTrue("error", cell.getStatus() == 0);
    }

    @Test
    public void testGetAlive() {
        Cell[][] m = new Cell[1][1];
        Cell cell = new Cell(0, 0, m);
        assertTrue("error", !cell.getAlive());

        cell.setAlive(true);
        assertTrue("error", cell.getAlive());
    }

    @Test
    public void testUpdate() {
        Map map = new Map(4);
        map.setCellAlive(1, 1, true);
        map.setCellAlive(1, 2, true);
        map.setCellAlive(2, 1, true);
        map.setCellAlive(2, 2, true);

        int testStatu = map.getCell(1, 1).update();
        assertTrue("error", testStatu == 1);

        testStatu = map.getCell(0, 0).update();
        assertTrue("error", testStatu == 0);
    }

    @Test
    public void testUpdate1() {
        Map map = new Map(4);
        map.setCellAlive(1, 1, true);

        int testStatu = map.getCell(1, 1).update();
        assertTrue("error", testStatu == 2);
    }

    @Test
    public void testUpdate2() {
        Map map = new Map(4);
        map.setCellAlive(1, 1, true);
        map.setCellAlive(1, 0, true);
        map.setCellAlive(0, 1, true);

        int testStatu = map.getCell(0, 0).update();
        assertTrue("error", testStatu == 3);
    }

}
