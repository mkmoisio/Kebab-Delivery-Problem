/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.other;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import other.Maths;

/**
 *
 * @author mikkomo
 */
public class MinTest {

    public MinTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void firstParamNegative() {
        assertEquals(99, Maths.min(-1, 99));
    }

    @Test
    public void secondParamNegative() {
        assertEquals(99, Maths.min(99, -1));
    }

    @Test
    public void firstSmaller() {
        assertEquals(24, Maths.min(24, 25));
    }

    @Test
    public void secondSmaller() {
        assertEquals(24, Maths.min(25, 24));
    }

    @Test
    public void sameValues() {
        assertEquals(24, Maths.min(24, 24));
    }

    @Test
    public void bothNegative() {
        assertEquals(-1, Maths.min(-24, -24));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
