package com.company.day13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启3个线程，这三个线程的ID分别为A,B,C，每个线程有自己的ID 在屏幕上打印10遍，要求输出的结果必须按顺序显示。
 * 如：ABCABCABC... 依次递归
 * @author zxd
 * @date 2019/5/28 17:51
 */
public class TestABCAlternate {
    public static void main(String[] args) {
        AlternateDemo alternateDemo = new AlternateDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++){
                    alternateDemo.LoopA(i);
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++){
                    alternateDemo.LoopB(i);
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++){
                    alternateDemo.LoopC(i);
                    System.out.println("----------------------");
                }
            }
        }, "C").start();
    }
}

class AlternateDemo{
    private int number = 1; //表示当前正在执行线程的标记
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    /**
     * @param totalLoop 循环第几轮
     */
    public void LoopA(int totalLoop){
        lock.lock();
        try{
            //1.判断
            if(number != 1){
                condition1.await();
            }
            //2.打印
            for (int i = 1; i <= 5; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            //3.唤醒
            number = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void LoopB(int totalLoop){
        lock.lock();
        try{
            //1.判断
            if(number != 2){
                condition2.await();
            }
            //2.打印
            for (int i = 1; i <= 15; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            //3.唤醒
            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void LoopC(int totalLoop){
        lock.lock();
        try{
            //1.判断
            if(number != 3){
                condition3.await();
            }
            //2.打印
            for (int i = 1; i <= 20; i++){
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            //3.唤醒
            number = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}