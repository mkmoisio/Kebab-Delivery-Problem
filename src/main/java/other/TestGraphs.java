package other;

/**
 *
 * @author mikkomo
 */
public class TestGraphs {

 // Unit test graph:
// Lyhin polku nollasta alkaen joka käy kaikissa solmuissa on
// luonnollisesti 0 - 4 - 3 - 1 - 3 - 4 - 2 - 4 - 0
//    {0}---3---{4}---7---{1}
//               |   \      |
//               4     2    1
//               |       \  |
//              {2}        {3}
    public static int[][] unitTestGraph = new int[][]{
        {0, -1, -1, -1, 3},
        {-1, 0, -1, 1, 7},
        {-1, -1, 0, -1, 4},
        {-1, 1, -1, 0, 2},
        {3, 7, 4, 2, 0}
    };
    public static int[][] unitTestGraphAllShortestPaths = new int[][]{
        {0, 6, 7, 5, 3},
        {6, 0, 7, 1, 3},
        {7, 7, 0, 6, 4},
        {5, 1, 6, 0, 2},
        {3, 3, 4, 2, 0}
    };

    public static int[][] a = new int[][]{
        {0, 3, 2, 4, 3},
        {4, 0, 3, 6, 6},
        {5, 3, 0, 4, 4},
        {3, 5, 1, 0, 6},
        {5, 4, 2, 3, 0}
    };

    public static int[][] b = new int[][]{
        {0, 3, 2, 4, 3, 6, 3, 2, 4, 3, 5, 3, 2, 4},
        {4, 0, 3, 6, 6, 4, 3, 2, 4, 3, 3, 3, 2, 4},
        {5, 3, 0, 4, 4, 4, 3, 2, 4, 3, 5, 3, 2, 4},
        {3, 5, 1, 0, 6, 9, 3, 2, 4, 3, 5, 3, 2, 4},
        {5, 4, 2, 3, 0, 5, 3, 2, 4, 3, 1, 3, 2, 4},
        {5, 4, 2, 3, 0, 0, 3, 2, 4, 3, 9, 3, 2, 4},
        {3, 5, 1, 0, 6, 8, 0, 2, 4, 3, 6, 3, 2, 4},
        {3, 5, 1, 3, 6, 2, 3, 0, 4, 3, 4, 3, 2, 4},
        {3, 5, 1, 6, 6, 4, 3, 2, 0, 3, 2, 3, 2, 4},
        {3, 5, 1, 7, 6, 6, 3, 2, 4, 0, 0, 3, 2, 4},
        {3, 5, 1, 6, 6, 2, 3, 2, 4, 3, 0, 3, 2, 4},
        {3, 5, 1, 6, 6, 1, 3, 2, 4, 3, 5, 0, 2, 4},
        {3, 5, 1, 9, 6, 4, 3, 2, 4, 3, 3, 3, 0, 4},
        {3, 5, 1, 4, 6, 5, 3, 2, 4, 3, 7, 3, 2, 0},};

    public static int[][] c = new int[][]{
        {0, 2, 9, 10},
        {1, 0, 6, 4},
        {15, 7, 0, 8},
        {6, 3, 12, 0}
    };

    public static int[][] d = new int[][]{
        {0, 20, 42, 35},
        {20, 0, 30, 34},
        {42, 30, 0, 12},
        {35, 34, 12, 0}
    };

    public static int[][] belgium = new int[][]{
        {0, 29, 20, 21, 16, 31, 100, 12, 4, 31, 18},
        {29, 0, 15, 29, 28, 40, 72, 21, 29, 41, 12},
        {20, 15, 0, 15, 14, 25, 81, 9, 23, 27, 13},
        {21, 29, 15, 0, 4, 12, 92, 12, 25, 13, 25},
        {16, 28, 14, 4, 0, 16, 94, 9, 20, 16, 22},
        {31, 40, 25, 12, 16, 0, 95, 24, 36, 3, 37},
        {100, 72, 81, 92, 94, 95, 0, 90, 101, 99, 84},
        {12, 21, 9, 12, 9, 24, 90, 0, 15, 25, 13},
        {4, 29, 23, 25, 20, 36, 101, 15, 0, 35, 18},
        {31, 41, 27, 13, 16, 3, 99, 25, 35, 0, 38},
        {18, 12, 13, 25, 22, 37, 84, 13, 18, 38, 0}
    };
    public static String[] belgiumNames = new String[]{
        "maastricht",
        "aachen",
        "heerlen",
        "sittard",
        "geleen",
        "echt",
        "bonn",
        "hulsberg",
        "kanne",
        "ohe",
        "epen"
    };

    public static int[][] simple = new int[][]{
        {0, 1, 5, -1},
        {1, 0, 5, 1},
        {5, 5, 0, 5},
        {-1, 1, 5, 0}
    };

}
