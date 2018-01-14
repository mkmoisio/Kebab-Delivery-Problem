/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import algorithm.PathSolver;
import graph.Graph;
import graph.implementations.AdjacencyMatrix;
import graph.utils.PathResult;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import other.TestGraphs;

/**
 *
 * @author mikkomo
 */
public class PathSolverTest {

    PathSolver solver;
    Graph graph;

    public PathSolverTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.graph = new AdjacencyMatrix(TestGraphs.unitTestGraph, new String[]{"0", "1", "2", "3", "4"});
        solver = new PathSolver();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void correctOutputWithTestGraph() {

        int[] tmp = new int[]{0, 1, 2, 3, 4};
        PathResult result = this.solver.solvePath(this.graph, tmp);
        System.out.println(result.toString());

        assertTrue(result.toString().contains("* [0] 0 * \n"
                + "[4] 4 \n"
                + "[3] 3 \n"
                + "* [1] 1 * \n"
                + "* [3] 3 * \n"
                + "[4] 4 \n"
                + "* [2] 2 * \n"
                + "* [4] 4 * \n"
                + "* [0] 0 * \n"
                + "20 meters."));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
