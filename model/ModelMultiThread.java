/*
 * LUIS J. BRAVO ZÚÑIGA
 * WORKING WITH THREADS
 */
package model;

import java.util.Random;

public class ModelMultiThread extends Thread {

    private static final int SIZE = 100000000;
    private int low, high, id;
    private int[] array;
    private long initialTime;
    private Model model;

    private long getTime() {
        return (System.currentTimeMillis() - this.initialTime) / 1000;
    }

    public ModelMultiThread(int[] array, int low, int high, int id, long initialTime) {
        this.array = array;
        this.low = low;
        this.high = high;
        this.id = id;
        this.model = new Model();
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        System.out.printf("[%d seconds] INIT OF THREAD %d\n", this.getTime(), this.id);
        //System.out.println("ARRAY " + id + ": " + Arrays.toString(this.array));
        this.model.auxQuicksort(this.array, low, high, true);
        //System.out.println("ARRAY " + id + " ORDENADO: " + Arrays.toString(this.array));
        System.out.printf("[%d seconds] FINISH OF THREAD %d\n", this.getTime(), this.id);
    }

    public static void main(String[] args) {
        int[] array = new int[SIZE];
        Random ran = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = ran.nextInt(SIZE);
        }

        Thread t1 = new ModelMultiThread(array, 0, SIZE / 2 - 1, 1, System.currentTimeMillis());
        Thread t2 = new ModelMultiThread(array, SIZE / 2 + 1, SIZE - 1, 2, System.currentTimeMillis());

        t1.start();
        t2.start();
    }

}
