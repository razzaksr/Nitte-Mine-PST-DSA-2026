package problems.day8;

import java.util.concurrent.Semaphore;
// Leetcode: 1117. Building H2O
class H2O {
    private Semaphore hSemaphore = new Semaphore(2); // allow 2 H at a time
    private Semaphore oSemaphore = new Semaphore(0); // O waits until 2 H are ready

    public H2O() {}

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSemaphore.acquire();          // acquire permit for H
        releaseHydrogen.run();         // print "H"
        oSemaphore.release();          // signal O that one H is ready
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSemaphore.acquire(2);         // wait until 2 H are ready
        releaseOxygen.run();           // print "O"
        hSemaphore.release(2);         // reset permits for next molecule
    }
}

public class BuildingH2O {
    public static void main(String[] args) {
        H2O h2o = new H2O();

        Runnable printH = () -> System.out.print("H");
        Runnable printO = () -> System.out.print("O");

        // Simulate multiple threads
        Thread t1 = new Thread(() -> { try { h2o.hydrogen(printH); } catch(Exception e){} });
        Thread t2 = new Thread(() -> { try { h2o.hydrogen(printH); } catch(Exception e){} });
        Thread t3 = new Thread(() -> { try { h2o.oxygen(printO); } catch(Exception e){} });

        t1.start();
        t2.start();
        t3.start();
    }
}
