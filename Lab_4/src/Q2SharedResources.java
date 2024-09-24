class MySharedResource {
    public synchronized void myResource(String threadName) {
        System.out.println(threadName + " has entered the resource.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(threadName + " is leaving the resource.");
    }
}

class MyThread extends Thread {
    MySharedResource resource;
    String threadName;

    public MyThread(MySharedResource resource, String threadName) {
        this.resource = resource;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        resource.myResource(threadName);
    }
}

public class Q2SharedResources {
    public static void main(String[] args) {

        MySharedResource sharedResource = new MySharedResource();

        MyThread t1 = new MyThread(sharedResource, "Thread 1");
        MyThread t2 = new MyThread(sharedResource, "Thread 2");
        MyThread t3 = new MyThread(sharedResource, "Thread 3");

        t1.start();
        t2.start();
        t3.start();

    }
}
