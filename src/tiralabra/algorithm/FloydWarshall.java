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

    private Result FWresult;

    /**
     * Laskee kaikkien solmujen väliset lyhimmät etäisyyden, jotka tallenntetaan
     * palautettavan taulukon [i][j][0] tasoon. [i][j][1] tasoon tallennetaan
     * lyhin polku.(KESKEN)
     *
     * @param graph
     * @return
     */
    public PathAdjacencyMatrix allShortestPaths(Graph graph) {

        Result result = new Result();
        result.start();

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
                        path[i][j] = dist[i][k];
                    }
                }
            }
        }

        this.FWresult = result;
        return new PathAdjacencyMatrix(dist, path);

    }

    public Result getFWresult() {
        return FWresult;
    }

    public Node reconstructPath(PathAdjacencyMatrix graph, Node node) {
        if (node.getNext() == null) {
            return null;
        }

        Node endNode = node.getNext();
        int startValue = node.getValue();
        int endValue = node.getNext().getValue();
        int v = graph.getPath(startValue, endValue);
        while (v != endValue) {

            Node newNode = new Node(v);
            System.out.println("asd");
            node.setNext(newNode);
            node = node.getNext();
            v = graph.getPath(v, endValue);
        }
        node.setNext(endNode);
        endNode.setPrev(node);
        return endNode;
    }

}
