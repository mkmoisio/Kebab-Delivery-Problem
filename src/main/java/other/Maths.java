/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

/**
 *
 * @author mikkomo
 */
public class Maths {

    /**
     * Min(a, (b+c)), negatiiviset arvot = +inf
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int minDist(int a, int b, int c) {

        if (a < 0 && b < 0 && c < 0) {
            return -1;
        }
        if (b < 0 || c < 0) {
            return a;

        }
        if (a < 0) {
            return b + c;
        }

        int d = b + c;
        if (a > d) {
            return d;
        } else {
            return a;
        }
    }

    /**
     * Min(a, b), negatiiviset arvot = +inf
     *
     * @param a
     * @param b
     * @return
     */
    public static int min(int a, int b) {
        
        if (a < 0 && b < 0)
            return -1;
        if (a < 0) {
            return b;
        }
        if (b < 0) {
            return a;
        }
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }
}
