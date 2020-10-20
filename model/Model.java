/*
 * LUIS J. BRAVO ZÚÑIGA
 * WORKING WITH THREADS
 */
 
package model;

import java.util.Random;

public class Model {

    private static final int MAX = 100000;

    private void auxQuicksort(int[] array, int low, int high, boolean asc) {
        if (low < high) {
            int p = partition(array, low, high, asc);
            auxQuicksort(array, low, p - 1, asc);
            auxQuicksort(array, p + 1, high, asc);
        }
    }

    private int partition(int[] array, int low, int high, boolean asc) {
        int pivote = array[high], i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (asc) {
                if (array[j] < pivote) {
                    int c = array[++i];
                    array[i] = array[j];
                    array[j] = c;
                }
            } else {
                if (array[j] > pivote) {
                    int c = array[++i];
                    array[i] = array[j];
                    array[j] = c;
                }
            }
        }
        int c = array[++i];
        array[i] = array[high];
        array[high] = c;
        return i;
    }

	public void quicksort(int[] array, boolean asc) {
        auxQuicksort(array, 0, array.length - 1, asc);
    }

    public int[] getArray(int size) {
        int[] array = new int[size];
        Random ran = new Random();
        for(int i = 0; i < size; i++) {
            array[i] = ran.nextInt(MAX);
        }
        return array;
    }
	
} //CLASS KEY



