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
public class MinDistTest {

    public MinDistTest() {
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
        assertEquals(13, Maths.minDist(-1, 5, 8));
    }

    @Test
    public void secondParamNegative() {
        assertEquals(8, Maths.minDist(8, -1, 5));
    }

    @Test
    public void thirdParamNegative() {
        assertEquals(8, Maths.minDist(8, 5, -1));
    }

    @Test
    public void twoLastParamNegative() {
        assertEquals(8, Maths.minDist(8, -1, -1));
    }

    @Test
    public void firstTwoParamNegative() {
        assertEquals(-1, Maths.minDist(-1, -1, 4));
    }

    @Test
    public void firstAndLastParamNegative() {
        assertEquals(-1, Maths.minDist(-1, 4, -1));
    }

    @Test
    public void allParamNegative() {
        assertEquals(-1, Maths.minDist(-1, -1, -1));

    }

    @Test
    public void firstSmaller() {
        assertEquals(3, Maths.minDist(3, 2, 2));

    }

    @Test
    public void secondSmaller() {
        assertEquals(3, Maths.minDist(4, 3, 0));

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
