package org.coach.tdd.template;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LibraryTest {
    @Test
    public void shouldSomeLibraryMethodReturnTrue() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
    @Test
    public void testadd(){
        Library t = new Library();
        assertTrue("wrong",3==t.add(1,2));
    }

}
