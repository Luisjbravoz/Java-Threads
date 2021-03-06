/*
 * LUIS J. BRAVO ZÚÑIGA
 * WORKING WITH THREADS
 */
package model;

public class ModelExtendsThread extends Thread {

    private int id;
    private Model model;
    private long initialTime;
    private int[] array;

    private long getTime() {
        return (System.currentTimeMillis() - this.initialTime) / 1000;
    }

    public ModelExtendsThread(int id, long initialTime, int size) {
        this.id = id;
        this.model = new Model();
        this.initialTime = initialTime;
        this.array = this.model.getArray(size);
    }

    public void run() {
        System.out.printf("[%d seconds] INIT OF THREAD %d\n", this.getTime(), this.id);
        //System.out.println("ARRAY " + id + ": " + Arrays.toString(this.array));
        this.model.quicksort(this.array, true);
        //System.out.println("ARRAY " + id + " ORDENADO: " + Arrays.toString(this.array));
        System.out.printf("[%d seconds] FINISH OF THREAD %d\n", this.getTime(), this.id);
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Threads with priority = 5");
        Thread t1 = new ModelExtendsThread(1, System.currentTimeMillis(), 100000000);
        Thread t2 = new ModelExtendsThread(2, System.currentTimeMillis(), 1000000);
        Thread t3 = new ModelExtendsThread(3, System.currentTimeMillis(), 10000000);

        t1.start();
        t2.start();
        t3.start();

    }

} //CLASS KEY
