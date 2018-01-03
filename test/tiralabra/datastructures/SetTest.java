/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.datastructures;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.graph.Set;

/**
 *
 * @author mikkomo
 */
public class SetTest {

    private Set set;

    public SetTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        set = new Set();
        set.add(1);
        set.add(2);
        set.add(3);

    }

    @Test
    public void sizeIsCorrectAfterInitializiation() {
        assertEquals(set.getSize(), 3);
    }

    @Test
    public void sizeIsCorrectAfterInitializiationAndAdding() {
        for (int i = 4; i < 14; i++) {
            set.add(i);

        }
        assertEquals(set.getSize(), 13);

    }

    @Test
    public void setIsClonedWhenRemoveIsCalled() {
        Set set2 = set.remove(1);

        assertEquals(set.getSize(), 3);
        assertEquals(set2.getSize(), 3);

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
