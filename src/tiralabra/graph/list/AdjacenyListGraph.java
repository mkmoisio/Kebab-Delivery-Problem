/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tiralabra.graph.Graph;
import tiralabra.graph.Node;
import static tiralabra.graph.utils.UtilityMethods.MAGIC_SEVENTY;

/**
 *
 * @author mikkomo
 */
public class AdjacenyListGraph implements Graph {

    private Map<Integer, List<Integer>> map;

    public AdjacenyListGraph(List<String> list) {
        map = new HashMap();

        list.forEach(item -> {
            String[] tmpString = item.split(":");
            int nodeNumber = Integer.parseInt(tmpString[0]);
            List<Integer> tmpList = new ArrayList();
            for (int i = 1; i < tmpString.length; i += 2) {

                tmpList.add(Integer.parseInt(tmpString[i + 1]));
            }

            map.put(nodeNumber, tmpList);
        });

    }

    @Override
    public Graph constructSignificantGraph(int[] significantVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] getAdjacencyMatrix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
