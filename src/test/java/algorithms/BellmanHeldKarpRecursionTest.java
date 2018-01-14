/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import algorithm.BellmanHeldKarpRecursion;
import algorithm.TSPSolver;
import graph.Graph;
import other.TestGraphs;
import graph.implementations.AdjacencyMatrix;
import graph.utils.AlgorithmResult;

/**
 *
 * @author mikkomo
 */
public class BellmanHeldKarpRecursionTest {

    TSPSolver solver;

    public BellmanHeldKarpRecursionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        this.solver = new BellmanHeldKarpRecursion();
    }

    @Test
    public void testGraphCCorrectResult() {
        Graph G = new AdjacencyMatrix(TestGraphs.c);
        AlgorithmResult result = this.solver.solveTSPpath(G);
        assertEquals(result.getShortestPathLength(), 21);
    }

    @Test
    public void testGraphBelgiumCorrectResult() {
        Graph G = new AdjacencyMatrix(TestGraphs.belgium);
        AlgorithmResult result = this.solver.solveTSPpath(G);
        assertEquals(result.getShortestPathLength(), 253);
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
