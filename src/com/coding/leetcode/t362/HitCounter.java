package com.coding.leetcode.t362;

public class HitCounter {

    private static final int WINDOW_SIZE = 300;

    private final int times[] = new int[WINDOW_SIZE];
    private final int hits[] = new int[WINDOW_SIZE];

    /**
     * Record a hit at the given timestamp
     *
     * @param timestamp - the current timestamp (in seconds granularity)
     */
    public void hit(int timestamp) {
        int idx = timestamp % WINDOW_SIZE;

        if (times[idx] != timestamp) {
            times[idx] = timestamp;
            hits[idx] = 1;
        } else {
            hits[idx]++;
        }
    }


    /**
     * Return the number of hits in the past 5 minutes (300 seconds)
     *
     * @param timestamp - the current timestamp (in seconds granularity)
     * @return number of hits in the past 300 seconds from the given timestamp
     */
    public int getHits(int timestamp) {
        int count = 0;

        for (int i = 0; i < WINDOW_SIZE; i++) {
            if (timestamp - times[i] < 300) {
                count = count + hits[i];
            }
        }

        return count;
    }

}

