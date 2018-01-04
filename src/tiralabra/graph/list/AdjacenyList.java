
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
public class AdjacenyList implements Graph {

    private Map<Integer, List<Integer>> map;

    public AdjacenyList(int[][] matrix) {

    }

    @Override
    public int cost(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNodeCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
