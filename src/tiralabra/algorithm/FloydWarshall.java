package tiralabra.algorithm;

import tiralabra.graph.Graph;
import tiralabra.graph.Node;
import tiralabra.graph.implementations.PathAdjacencyMatrix;
import tiralabra.graph.utils.Maths;
import tiralabra.graph.utils.Result;

/**
 *
 * @author mikkomo
 */
public class FloydWarshall {

    private Result result;

    /**
     * Laskee kaikkien solmujen väliset lyhimmät etäisyyden, jotka tallenntetaan
     * palautettavaan graafiin. Lisäksi sisältää tiedon lyhimmän polun
     * edeltävistä solmuista polkujen uudelleenkonstruoimiseksi.
     *
     * @param graph
     * @return
     */
    public PathAdjacencyMatrix allShortestPaths(Graph graph) {

        this.result = new Result("Floyd-Warshall: Calculating all shortest paths");
        this.result.start();

        int[][] dist = graph.getAdjacencyMatrix();
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
        return new PathAdjacencyMatrix(dist, path);

    }

    public Result getResult() {
        return this.result;
    }

    /**
     * Uudelleenkonstruoi lyhimmän polun noden ja sitä seuraavan noden välillä
     * graafiin tallennetun polkutaulukon perusteella
     *
     * @param graph
     * @param node
     * @return
     */
    public Node reconstructPath(PathAdjacencyMatrix graph, Node node) {
        if (node.getNext() == null) {
            return null;
        }

        Node endNode = node.getNext();

        int end = endNode.getValue();

        int next = graph.getPath(node.getValue(), end);
        
        while (next != end) {

            Node newNode = new Node(next);
          
            node.setNext(newNode);
            node = node.getNext();
//            try {
            next = graph.getPath(next, end);
//            } catch (Exception e) {
//                System.out.println(newNode.toString());
//                System.out.println("next " + next);
//                System.out.println("end " + end);
//            }
        }
        node.setNext(endNode);
        //   endNode.setPrev(node);
        return endNode;
    }

}
