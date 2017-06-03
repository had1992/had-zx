package org.coach.tdd.template;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by had on 2017/6/3.
 */
public class TestCell {
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


}
