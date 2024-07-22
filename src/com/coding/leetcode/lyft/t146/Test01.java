package com.coding.leetcode.lyft.t146;

public class Test01 {

    public static void main(String[] args) throws InterruptedException {
        LRUCache01 cache = new LRUCache01(2);

        cache.put(1, 1);
        System.out.println(cache);
        System.out.println("*** *** ***");
        Thread.sleep(100);

        cache.put(2, 2);
        System.out.println(cache);
        System.out.println("*** *** ***");
        Thread.sleep(100);

        int i1 = cache.get(1);
        System.out.println(i1);
        System.out.println("*** *** ***");
        Thread.sleep(100);

        cache.put(3, 3);
        System.out.println(cache);
        System.out.println("*** *** ***");
        Thread.sleep(100);

        int i2 = cache.get(2);
        System.out.println(i2);
        System.out.println("*** *** ***");
        Thread.sleep(100);

        cache.put(4, 4);
        System.out.println(cache);
        System.out.println("*** *** ***");
        Thread.sleep(100);

        int i3 = cache.get(1);
        System.out.println(i3);
        System.out.println("*** *** ***");
        Thread.sleep(100);

        int i4 = cache.get(3);
        System.out.println(i4);
        System.out.println("*** *** ***");
        Thread.sleep(100);

        int i5 = cache.get(4);
        System.out.println(i5);
        System.out.println("*** *** ***");
        Thread.sleep(100);
    }


}
