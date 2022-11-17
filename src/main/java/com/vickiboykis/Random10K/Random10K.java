package com.vickiboykis.Random10K;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Hello world!
 */
public class Random10K {

   public static int sumInts(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        int min = 1;
        int max = 10000;

        PriQueueInterface<Integer> pq = new SortedABPriQ<Integer>();
        PriQueueInterface<Integer> rq = new SortedABPriQ<Integer>(Comparator.reverseOrder());
        PriQueueInterface<Integer> sdq = new SortedABPriQ<Integer>(Comparator.comparing(Random10K::sumInts));

        for (int i = 0; i < 100; i++) {
            int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
            pq.enqueue(random_int);
            rq.enqueue(random_int);
            sdq.enqueue(random_int);
        }


        // Decreasing order
        System.out.println("Decreasing order");
        int len = pq.size() / 10;
        for (int i = 0; i < len; i++) {
            System.out.printf("%d %d %d %d %d %d %d %d %d %d\n"
                    , pq.dequeue(), pq.dequeue(), pq.dequeue(), pq.dequeue(), pq.dequeue(),
                    pq.dequeue(), pq.dequeue(), pq.dequeue(), pq.dequeue(), pq.dequeue());
        }

        // Increasing Order
        int rqLen = rq.size() / 10;
        System.out.println("Increasing Order\n");
        for (int i = 0; i < rqLen; i++) {
            System.out.printf("%d %d %d %d %d %d %d %d %d %d\n"
                    , rq.dequeue(), rq.dequeue(), rq.dequeue(), rq.dequeue(), rq.dequeue(),
                    rq.dequeue(), rq.dequeue(), rq.dequeue(), rq.dequeue(), rq.dequeue());
        }

        // Ordered increasingly by sum of digits in number
        int sdqLen = sdq.size() / 10;
        System.out.println("Ordered by sum of digits in number\n");
        for (int i = 0; i < sdqLen; i++) {
            System.out.printf("%d %d %d %d %d %d %d %d %d %d\n"
                    , sdq.dequeue(), sdq.dequeue(), sdq.dequeue(), sdq.dequeue(), sdq.dequeue(),
                    sdq.dequeue(), sdq.dequeue(), sdq.dequeue(), sdq.dequeue(), sdq.dequeue());
        }

    }

}

