package com.coding.leetcode.amazon.custom.t1_parking_lot;

public class ParkingLot {

    public boolean canParkWithHeads(int n, int[] preferences) {
        // Массив head-узлов: heads[i] указывает на первое свободное место >= i
        Node[] heads = new Node[n + 1];

        // Создаем односвязный список: 0 -> 1 -> 2 -> ... -> n-1 -> null
        Node dummy = new Node(-1);
        Node current = dummy;

        for (int i = 0; i < n; i++) {
            current.next = new Node(i);
            current = current.next;
            heads[i] = current;
        }
        heads[n] = null; // Граничный случай

        // Обрабатываем каждую машину
        for (int pref : preferences) {
            if (pref < 0 || pref >= n) {
                return false;
            }

            // Находим первое свободное место
            Node freeNode = heads[pref];

            if (freeNode == null) {
                return false; // Нет свободных мест
            }

            // Обновляем head: теперь heads[pref] указывает на следующее свободное
            heads[pref] = freeNode.next;
        }

        return true;
    }

    /**
     * Узел односвязного списка для отслеживания свободных мест
     */
    private static class Node {
        int spot;           // Номер парковочного места
        Node next;          // Ссылка на следующее свободное место

        Node(int spot) {
            this.spot = spot;
            this.next = null;
        }
    }

}
