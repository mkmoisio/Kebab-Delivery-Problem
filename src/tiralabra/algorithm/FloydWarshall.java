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
     * palautettavaan graafiin. Lisäksi sisältää tiedon lyhimmän polun
     * edeltävistä solmuista polkujen uudelleenkonstruoimiseksi.
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
    
        int end = endNode.getValue();
        
        int next = graph.getPath(node.getValue(), end);
        while (next != end) {

            Node newNode = new Node(next);
            newNode.setName("FW reconstruction");
            node.setNext(newNode);
            node = node.getNext();
            next = graph.getPath(next, end);
        }
        node.setNext(endNode);
     //   endNode.setPrev(node);
        return endNode;
    }

}
