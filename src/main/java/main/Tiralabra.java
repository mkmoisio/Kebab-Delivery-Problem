package main;

import java.io.IOException;
import algorithm.PathSolver;
import graph.Graph;
import graph.utils.PathResult;
import graph.utils.UtilityMethods;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

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

//        try {
//            int upto = Integer.parseInt(args[0]);
            test(15);
//        } catch (Exception e) {
//            /**
//             * Map from https://appro.limes.fi/restaurants.html
//             */
//            Application application = new Application("./helsinki.txt");
//            application.execute();
//        }

    }

    public static void test(int upto) throws IOException {
        Graph graph = UtilityMethods.adjacencyMatrixFromListOfStrings(Files.readAllLines(Paths.get("./helsinki.txt")));
        PathSolver solver = new PathSolver();

        for (int i = 1; i < upto + 1; i++) {

            long runtime = 0;

            for (int j = 0; j < 5; j++) {
                PathResult result = solver.solvePath(graph, generatePoints(i));
                runtime += result.getRunningTimeMs();
            }
            System.out.println("With " + i + " points, running time: " + (runtime / 5) + " ms");
        }
    }

    public static int[] generatePoints(int howMany) {
        Random random = new Random();

        int[] array = new int[howMany];

        for (int i = 0; i < howMany; i++) {

            array[i] = random.nextInt(41);

        }

        return array;
    }

}
