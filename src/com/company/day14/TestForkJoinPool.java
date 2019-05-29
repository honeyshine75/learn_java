package com.company.day14;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author zxd
 * @date 2019/5/29 13:47
 */
public class TestForkJoinPool {
    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 10000000000L);//166//8201
        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗时:" + Duration.between(start, end).toMillis());
    }

    @org.junit.Test
    public void test1(){
        Instant start = Instant.now();
        long sum = 0L;
        for (long i = 0L; i <= 10000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗时:" + Duration.between(start, end).toMillis());//136//8790
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long>{
//    private static final long serialVersionUID = -259195479995561737L;

    private long start;
    private long end;

    private static final long THRESHOLD = 10000L;

    public ForkJoinSumCalculate(long start, long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if(length <= THRESHOLD){
            long sum = 0L;

            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else{
            long middle = (start + end) / 2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
            left.fork();

            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}