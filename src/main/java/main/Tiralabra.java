/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import algorithm.FloydWarshall;
import graph.Graph;
import other.TestGraphs;
import graph.implementations.AdjacencyMatrix;
import graph.utils.UtilityMethods;

/**
 *
 * @author mikkomo
 */
public class Tiralabra {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        
        Application application = new Application("./helsinki.txt");
        application.execute();
    }

}
