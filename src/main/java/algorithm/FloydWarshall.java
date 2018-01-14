package algorithm;

import graph.Graph;
import graph.Node;
import graph.implementations.PathAdjacencyMatrix;
import graph.utils.AlgorithmResult;
import graph.utils.ArrayCopy;
import other.Maths;

/**
 * Implementation of Floyd-Warshall algorithm as described in
 * https://en.wikipedia.org/wiki/Floyd–Warshall_algorithm
 *
 * @author mikkomo
 */
public class FloydWarshall {

    private AlgorithmResult result;

    /**
     * Laskee kaikkien solmujen väliset lyhimmät etäisyyden, jotka tallenntetaan
     * palautettavaan graafiin. Lisäksi sisältää tiedon lyhimmän polun
     * edeltävistä solmuista polkujen uudelleenkonstruoimiseksi.
     *
     * @param graph
     * @return
     */
    public PathAdjacencyMatrix allShortestPaths(Graph graph) {

        this.result = new AlgorithmResult("Floyd-Warshall: all shortest paths");
        this.result.start();

        int[][] dist = ArrayCopy.clone2DArray(graph.getAdjacencyMatrix());

        int[][] path = new int[graph.getSize()][graph.getSize()];

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                path[i][j] = j;
            }
        }

        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {

                    int before = dist[i][j];
                    dist[i][j] = Maths.minDist(dist[i][j], dist[i][k], dist[k][j]);
                    if (dist[i][j] != before) {
                        path[i][j] = path[i][k];
                    }
                }
            }
        }

        this.result.end();
        return new PathAdjacencyMatrix(dist, path, graph.getNames());

    }

    public AlgorithmResult getResult() {
        return this.result;
    }

    /**
     * Uudelleenkonstruoi lyhimmän polun noden ja sitä seuraavan noden välillä
     * graafiin tallennetun polkutaulukon perusteella
     *
     * @param graph
     * @param node
     * @return Koko polun seuraava merkitsevä solmu
     */
    public Node reconstructPath(PathAdjacencyMatrix graph, Node node) {
        if (node.getNext() == null) {
            return null;
        }

        Node endNode = node.getNext();

        int end = endNode.getValue();

        int next = graph.getPath(node.getValue(), end);

        while (next != end) {

            Node newNode = new Node(next, graph.getName(next));

            node.setNext(newNode);
            node = node.getNext();
            next = graph.getPath(next, end);

        }
        node.setNext(endNode);
        return endNode;
    }

}
