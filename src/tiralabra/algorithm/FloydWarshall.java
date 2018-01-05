package tiralabra.algorithm;

import tiralabra.graph.Graph;
import tiralabra.graph.implementations.PathAdjacencyMatrix;
import tiralabra.graph.utils.Maths;

/**
 *
 * @author mikkomo
 */
public class FloydWarshall {

    /**
     * Laskee kaikkien solmujen väliset lyhimmät etäisyyden, jotka tallenntetaan
     * palautettavan taulukon [i][j][0] tasoon. [i][j][1] tasoon tallennetaan
     * lyhin polku.(KESKEN)
     *
     * @param graph
     * @return
     */
    public PathAdjacencyMatrix allShortestPaths(Graph graph) {

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
        return new PathAdjacencyMatrix(dist, path);

    }

}
