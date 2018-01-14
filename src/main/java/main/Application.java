package main;

import algorithm.PathSolver;
import graph.Graph;
import graph.utils.UtilityMethods;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import other.Prints;

/**
 *
 * @author mikkomo
 */
public class Application {

    private PathSolver solver;
    private Scanner scanner;
    private Graph graph;

    public Application(String path) throws IOException {
        this.graph = UtilityMethods.adjacencyMatrixFromListOfStrings(Files.readAllLines(Paths.get("./helsinki.txt")));
        this.solver = new PathSolver();
        this.scanner = new Scanner(System.in);
    }

    void execute() {
        System.out.println(Prints.ohjeet);

        while (true) {
            String input = scanner.nextLine();

            String[] tmpString = input.split(":");

            int[] pointsToVisit = new int[tmpString.length];

            for (int i = 0; i < tmpString.length; i++) {
                try {
                    int value = Integer.parseInt(tmpString[i]);
                    pointsToVisit[i] = value;
                } catch (Exception e) {
                    System.out.println(Prints.huonoSyote);
                }

            }
            System.out.println(this.solver.solvePath(graph, pointsToVisit));
        }
    }
}
