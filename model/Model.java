/*
 * LUIS J. BRAVO ZÚÑIGA
 * WORKING WITH THREADS
 */
 
package model;

public class Model {

	public static void QUICKSORT(int[] array, boolean asc) {
        AUX_QUICKSORT(array, 0, array.length - 1, asc);
    }

    private static void AUX_QUICKSORT(int[] array, int low, int high, boolean asc) {
        if (low < high) {
            int p = PARTITION(array, low, high, asc);
            AUX_QUICKSORT(array, low, p - 1, asc);
            AUX_QUICKSORT(array, p + 1, high, asc);
        }
    }

    private static int PARTITION(int[] array, int low, int high, boolean asc) {
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
	
}



