package com.coding.leetcode.lyft.t146;

import java.time.LocalDateTime;
import java.util.*;

public class LRUCache01 {

    private final HashMap<Integer, Integer> map;
    private final PriorityQueue<TimeItem> pq;
    private final int capacity;

    public LRUCache01(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        pq = new PriorityQueue<>(capacity);
    }

    public int get(int key) {
        Integer val = map.get(key);
        if (val != null) {
            pq.remove(new TimeItem(key, null));
            pq.add(new TimeItem(key, LocalDateTime.now()));
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Integer curVal = map.get(key);
        if (curVal == null) {
            if (map.size() >= capacity) {
                if (!pq.isEmpty()) {
                    TimeItem timeItem = pq.poll();
                    map.remove(timeItem.getKey());
                }
                pq.add(new TimeItem(key, LocalDateTime.now()));
                map.put(key, value);
            } else {
                pq.add(new TimeItem(key, LocalDateTime.now()));
                map.put(key, value);
            }
        } else {
            pq.remove(new TimeItem(key, null));
            pq.add(new TimeItem(key, LocalDateTime.now()));
            map.put(key, value);
        }
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "map=" + map +
                '}';
    }

    class TimeItem implements Comparable<TimeItem> {
        private final int key;
        private final LocalDateTime dateTime;

        public TimeItem(int key, LocalDateTime dateTime) {
            this.key = key;
            this.dateTime = dateTime;
        }

        public int getKey() {
            return key;
        }

        @Override
        public int compareTo(TimeItem o) {
            if (this.dateTime.isBefore(o.dateTime)) {
                return -1;
            } else if (this.dateTime.isAfter(o.dateTime)) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TimeItem timeItem = (TimeItem) o;
            return key == timeItem.key;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key);
        }
    }
}
