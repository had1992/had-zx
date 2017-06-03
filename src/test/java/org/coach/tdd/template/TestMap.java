package org.coach.tdd.template;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by had on 2017/6/3.
 */
public class TestMap {
    @Test
    public void testGetDimensionNum() {
        Map map = new Map(3);
        assertTrue("error", map.getDimensionNum() == 3);
    }

    @Test
    public void testGetAliveCell() {
        Map map = new Map(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue("error", !map.getAliveCell(i, j));
            }
        }
    }

    @Test
    public void testSetCellAlive() {
        Map map = new Map(3);
        map.setCellAlive(0, 0, true);
        assertTrue("setAliveCell is not correct", map.getAliveCell(0, 0));
        for (int i = 0; i < map.getDimensionNum(); i++) {
            for (int j = 0; j < map.getDimensionNum(); j++) {
                if (i != 0 && j != 0) {
                    assertTrue("setAliveCell is not correct", !map.getAliveCell(i, j));
                }
            }
        }
    }

    @Test
    public void testDisplay() {
        Map map = new Map(4);
        map.setCellAlive(1, 1, true);
        map.setCellAlive(1, 2, true);
        map.setCellAlive(2, 1, true);
        map.setCellAlive(2, 2, true);

        assertTrue("error", map.display().equals("....\n.**.\n.**.\n....\n\n"));
    }
}
