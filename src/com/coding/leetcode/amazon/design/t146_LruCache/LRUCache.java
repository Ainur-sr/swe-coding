package com.coding.leetcode.amazon.design.t146_LruCache;

import java.util.HashMap;

public class LRUCache {

    private final Node head;
    private final Node tail;
    private final HashMap<Integer, Node> nodeMap;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodeMap = new HashMap<>();

        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        int result = -1;
        Node node = nodeMap.get(key);
        if (node != null) {
            result =  node.value;
            removeNode(node);
            addNode(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
            addNode(node);
        } else {
            if (nodeMap.size() == capacity) {
                nodeMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            addNode(newNode);
            nodeMap.put(key, newNode);
        }
    }

    private void addNode(Node node) {
        Node headNext = this.head.next;
        this.head.next = node;
        node.prev = this.head;

        node.next = headNext;
        headNext.prev = node;
    }

    private void removeNode(Node node) {
        Node nodeNext = node.next;
        Node nodePrev = node.prev;
        nodeNext.prev = nodePrev;
        nodePrev.next = nodeNext;
    }

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }

}
