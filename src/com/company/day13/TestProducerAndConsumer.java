package com.company.day13;

/**
 * @author zxd
 * @date 2019/5/28 16:05
 */

/**
 * 生产者和消费者案例
 */
public class TestProducerAndConsumer {
    public static void main(String[] args) {
        Clerk2 clerk = new Clerk2();
        Producer2 producer = new Producer2(clerk);
        Consumer2 consumer = new Consumer2(clerk);
        new Thread(producer, "生产者A").start();
        new Thread(consumer, "消费者B").start();

        new Thread(producer, "生产者C").start();
        new Thread(consumer, "消费者D").start();
    }
}

//店员
class Clerk {
    private int product = 0;

    //进货
    public synchronized void get() {
        while (product >= 1) {//为了避免虚假唤醒问题，应该总是使用在循环中
            System.out.println("产品已满！");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + ++product);
        this.notifyAll();
    }

    //卖货
    public synchronized void sale() {
        while (product <= 0) {
            System.out.println("缺货!");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + --product);
        this.notifyAll();
    }
}

//生产者
class Producer implements Runnable {
    private Clerk2 clerk;

    public Producer(Clerk2 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            clerk.get();
        }
    }
}

//消费者
class Consumer implements Runnable {
    private Clerk2 clerk;

    public Consumer(Clerk2 clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}

