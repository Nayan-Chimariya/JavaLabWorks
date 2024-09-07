import java.util.*;

class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i += 2) {
            System.out.println("Odd number: " + i);
            try {
                Thread.sleep(2000); // 2 seconds pause
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class EvenThread implements Runnable{
    @Override
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println("Even number: " + i);
            try {
                Thread.sleep(3000); // 3 seconds pause
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class q1_threads {
    public static void main(String[] args) {

        OddThread oddThread = new OddThread();
        oddThread.start();

        Thread evenThread = new Thread(new EvenThread());
        evenThread.start();

    }
}

