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

        /**
         * Map from https://appro.limes.fi/restaurants.html
         */
        Application application = new Application("./helsinki.txt");
        application.execute();
    }

}
