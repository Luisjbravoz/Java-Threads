/*
 * LUIS J. BRAVO ZÚÑIGA
 * WORKING WITH THREADS
 */
package model;

public class ModelSynchronization implements Runnable {

    private int id;
    private Model model;
    private long initialTime;

    private long getTime() {
        return (System.currentTimeMillis() - this.initialTime) / 1000;
    }

    public ModelSynchronization(int id, long initialTime) {
        this.id = id;
        this.model = new Model();
        this.initialTime = initialTime;
    }

    public void run() {
        System.out.printf("[%d seconds] INIT OF THREAD %d\n", this.getTime(), this.id);
        int result = this.model.sum();
        System.out.printf("[%d seconds] FINISH OF THREAD %d COUNT = %d\n", this.getTime(), this.id, result);
    }

    public int getId() {
        return this.id;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ModelSynchronization(1, System.currentTimeMillis()));
        Thread t2 = new Thread(new ModelSynchronization(2, System.currentTimeMillis()));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            System.out.printf("Interrupted thread %d\n", Thread.currentThread().getId());
        }
    }

} //CLASS KEY
