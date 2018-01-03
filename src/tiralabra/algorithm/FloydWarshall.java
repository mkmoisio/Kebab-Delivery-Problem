/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.algorithm;

import tiralabra.graph.utils.ArrayCopy;
import tiralabra.graph.utils.Maths;

/**
 *
 * @author mikkomo
 */
public class FloydWarshall {

    
    /**
     * Laskee kaikkien solmujen väliset lyhimmät etäisyyden, jotka tallenntetaan palautettavan taulukon [i][j][0] tasoon.
     * [i][j][1] tasoon tallennetaan lyhin polku.(KESKEN)
     * @param adjMatrix
     * @return 
     */
    public int[][][] allShortestPathsBetweenTwoVerticesAsMatrix(int[][] adjMatrix) {

        int[][][] dist = ArrayCopy.clone2DArrayTo3D(adjMatrix);

        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {

                    int before = dist[i][j][0];
                    dist[i][j][0] = Maths.minDist(dist[i][j][0], dist[i][k][0], dist[k][j][0]);
                    if (dist[i][j][0] != before) {
                        dist[i][j][1] = dist[i][k][0];
                    }
                }
            }
        }
        return dist;
    }

}
