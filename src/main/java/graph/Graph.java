package graph;

/**
 *
 * @author mikkomo
 */
public interface Graph {

    int cost(int x, int y);

    public int getSize();

    public String[] getNames();
    
    public String getName(int i);
    
    public int[][] getAdjacencyMatrix();
}
