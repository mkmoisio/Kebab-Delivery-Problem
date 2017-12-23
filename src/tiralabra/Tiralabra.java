/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import tiralabra.graph.utils.UtilityMethods;

/**
 *
 * @author mikkomo
 */
public class Tiralabra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        int[][] map1 = new int[70][70];
        Path p = Paths.get("./helsinki.txt");
        
        List<String> contents = Files.readAllLines(p);
        
        contents.forEach(System.out::println);
        
        System.out.println(Arrays.deepToString(UtilityMethods.fromStringListToint2DArray(contents)));
    }
    
}
