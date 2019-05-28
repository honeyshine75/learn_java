class MyRunnable implements Runnable {
    @Override
    public void run() {
        go();
    }
    public void go(){
        doMore();
    }
    public void doMore(){
        System.out.println("top o' the stack");
    }
}

public class ThreadTester {
    public static void main(String[] args) {
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);
        myThread.start();

        System.out.println("back in main");
    }
}