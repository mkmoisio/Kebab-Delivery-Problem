/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import algorithm.FloydWarshall;
import graph.Graph;
import graph.implementations.AdjacencyMatrix;
import other.TestGraphs;

/**
 *
 * @author mikkomo
 */
public class FloydWarshallTest {
    
    FloydWarshall fw;
    Graph graph;
    
    public FloydWarshallTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.fw = new FloydWarshall();
        this.graph = new AdjacencyMatrix(TestGraphs.unitTestGraph);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
   public void allShortestPathsCorrectlyCalculated() {
     Graph newGraph = fw.allShortestPaths(this.graph).getMatrix();
     int[][] newAdjMatrix = newGraph.getAdjacencyMatrix();
     for (int i = 0; i < newAdjMatrix.length; i++) {
         assertTrue(Arrays.equals(newAdjMatrix[i], TestGraphs.unitTestGraphAllShortestPaths[i]));
     }
   } 
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
