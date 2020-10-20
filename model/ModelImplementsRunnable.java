/*
 * LUIS J. BRAVO ZÚÑIGA
 * WORKING WITH THREADS
 */
package model;

public class ModelImplementsRunnable implements Runnable {

    private int id;
    private Model model;
    private long initialTime;
    private int[] array;

    private long getTime() {
        return (System.currentTimeMillis() - this.initialTime) / 1000;
    }

    public ModelImplementsRunnable(int id, long initialTime, int size) {
        this.id = id;
        this.model = new Model();
        this.initialTime = initialTime;
        this.array = this.model.getArray(size);
    }

    public void run() {
        System.out.printf("[%d seconds] INIT OF THREAD %d\n", this.getTime(), this.id);
        //System.out.println("ARRAY " + id + ": " + Arrays.toString(this.array));
        this.model.quicksort(this.array, false);
        //System.out.println("ARRAY " + id + " ORDENADO: " + Arrays.toString(this.array));
        System.out.printf("[%d seconds] FINISH OF THREAD %d\n", this.getTime(), this.id);
    }

    public static void main(String[] args) {
        System.out.println("Threads with priority = 10");
        Thread t1 = new Thread(new ModelImplementsRunnable(4, System.currentTimeMillis(), 1000000));
        Thread t2 = new Thread(new ModelImplementsRunnable(5, System.currentTimeMillis(), 100000000));
        Thread t3 = new Thread(new ModelImplementsRunnable(6, System.currentTimeMillis(), 1000));
        
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        
        t1.start();
        t2.start();
        t3.start();
    }

} //CLASS KEY
