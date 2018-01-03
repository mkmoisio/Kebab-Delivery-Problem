/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph.utils;

/**
 *
 * @author mikkomo
 */
public class Maths {

    /*
     Min(a, (b+c)), negatiiviset arvot = +inf
     */
    public static int minDist(int a, int b, int c) {
        if (b < 0 || c < 0) {
            return a;

        }
        if (a < 0) {
            return b + c;
        }

        return Math.min(a, b + c);
    }
}
