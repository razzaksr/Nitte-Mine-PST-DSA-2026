package problems.day8;

import java.util.concurrent.CountDownLatch;

class Foo {
    private CountDownLatch latch1 = new CountDownLatch(1);
    private CountDownLatch latch2 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch1.await();
        printSecond.run();
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch2.await();
        printThird.run();
    }
}

public class PrintInOrder {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Runnable r1 = () -> System.out.println("first");
        Runnable r2 = () -> System.out.println("second");
        Runnable r3 = () -> System.out.println("third");
        int[] ins = {3,2,1};
        for(int each:ins){
            if(each==1)
                new Thread(() -> { try { foo.first(r1); } catch(Exception e){} }).start();
            else if(each==2)
                new Thread(() -> { try { foo.second(r2); } catch(Exception e){} }).start();
            else 
                new Thread(() -> { try { foo.third(r3); } catch(Exception e){} }).start();
        }
    }
}
