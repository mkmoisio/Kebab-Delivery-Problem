/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.graph;

/**
 *
 * @author mikkomo
 */
public class Set {

    private  int INC_SIZE = 10;
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

    public void add(int i) {
        if (this.size == array.length) {
            this.inc();
        }
        this.array[size] = i;
        this.size++;
     
    }

    private void inc() {
        int[] tmp = new int[this.array.length + INC_SIZE];
        this.INC_SIZE = INC_SIZE * 2; //?? järkevää??
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

    private void justRemove(int i) {
        int index = this.getIndex(i);
        if (index == -1) {
           throw new RuntimeException("Ei ole tarkoitus poistaa sellaisia alkoita, joita ei joukossa ole");
        }

        for (int j = index; j < this.size - 1; j++) {
            array[j] = array[j + 1];
        }
        this.size--;
    }

    /**
     * 
     * @param i poistettava alkio
     * @return uusi Set joka on vastaava kuin vanha, mutta ilman poistettua alkiota
     */
    public Set remove(int i) {
        
        Set tmpSet = new Set(this.asArray(), this.size);
        tmpSet.justRemove(i);

        return tmpSet;
    }
    

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int[] asArray() {
        int[] tmp = new int[this.size];
        System.arraycopy(this.array, 0, tmp, 0, size);
        return tmp;
    }

    @Override
    public String toString() {
        
        if (this.size == 0) 
            return "Empty set";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.size; i++) {
            sb.append(this.array[i]);
            sb.append(", ");
        }

        return sb.toString();
    }

}
