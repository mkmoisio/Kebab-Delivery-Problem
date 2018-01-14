package graph.utils;

/**
 *
 * @author mikkomo
 */
public class ArrayCopy {

    public static int[][] clone2DArray(int[][] src) {
        int[][] dst = new int[src.length][src.length];

        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, src.length);
        }
        return dst;
    }
    

}
