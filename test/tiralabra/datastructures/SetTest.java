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
        assertEquals(set2.getSize(), 2);
        Set set3 = set2.remove(2);
        assertEquals(set3.getSize(), 1);

    }

    @Test
    public void removeLastElement() {
         System.out.println(set.toString());
        set = set.remove(2);
        System.out.println(set.toString());
        set = set.remove(3);
         System.out.println(set.toString());
        set = set.remove(1);
        assertEquals(set.getSize(), 0);
        System.out.println(set.toString());

    }

    @Test
    public void elementCanBeAdded() {
        set.add(5);
        assertEquals(set.getSize(), 4);
        System.out.println(set.toString());
    }

    @Test
    public void elementsCanBeAddedUntilFull() {
        for (int j = 4; j < 14; j++) {
            set.add(j);
        }
        
        assertEquals(set.toString(), "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, ");
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
