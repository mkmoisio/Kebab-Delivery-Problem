/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph;

import java.util.Arrays;

/**
 *
 * @author mikkomo
 */
public class Set {

    private final int INC_SIZE = 10;
    private final int INIT_SIZE = 10;
    private int[] array;
    private int size;

    public Set() {
        this.size = 0;
        array = new int[INIT_SIZE];
    }

    private Set(int[] array, int size) {
        this.size = size;
        this.array = array;
    }

    //       System.arraycopy(vanha, 0, uusi, 0, vanha.length);

    public Set add(int i) {
        if (this.size == array.length) {
            this.inc();
        }
        this.array[size] = i;
        this.size++;
        return this;
    }

    private void inc() {
        int[] tmp = new int[this.array.length + INC_SIZE];
        System.arraycopy(this.array, 0, tmp, 0, this.array.length);

        this.array = tmp;
    }

    private int getIndex(int i) {
        for (int j = 0; j < this.size; j++) {
            if (i == array[j]) {
                return j;
            }
        }
        return -1;
    }

    public Set remove(int i) {
        int[] tmp = new int[this.size];
        int tmpSize = this.size;
        System.arraycopy(this.array, 0, tmp, 0, this.size);

        // TÄSSÄ VAIHEESSA TAULUKOT VIELÄ SAMAT JOTEN INDEX OSUU OIKEAAN KOHTAAN
        int index = this.getIndex(i);
        if (index != -1) {
            for (int j = index; j < this.size - 1; j++) {
                tmp[j] = tmp[j + 1];
            }
            tmpSize--;
        }
        return new Set(tmp, tmpSize);
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int[] asArray() {
        int[] tmp = new int[this.size + INC_SIZE];
        System.arraycopy(this.array, 0, tmp, 0, size);
        return tmp;
    }
    
    @Override
    public String toString() {
     return  Arrays.toString(this.array);
    }

}
