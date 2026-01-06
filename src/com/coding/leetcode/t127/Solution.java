package com.coding.leetcode.t127;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String beginWord = "hall";
        String endWord = "walk";
        List<String> list = List.of("ball","wall", "walk");
        int i = sol.ladderLength(beginWord, endWord, list);
        System.out.println(i);
    }

    /**
     * Находит длину кратчайшей последовательности трансформаций от beginWord до endWord.
     * Каждая трансформация изменяет только одну букву, и промежуточные слова должны быть в wordList.
     *
     * @param beginWord начальное слово
     * @param endWord целевое слово
     * @param wordList список допустимых слов для трансформации
     * @return длина кратчайшей последовательности или 0, если путь не существует
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Преобразуем список в HashSet для быстрой проверки наличия слова O(1)
        Set<String> wordSet = new HashSet<>(wordList);

        // Если целевое слово отсутствует в списке, путь невозможен
        if (!wordSet.contains(endWord)) return 0;

        // Очередь для BFS: хранит слова на текущем уровне трансформации
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // level отслеживает количество слов в текущей последовательности (включая beginWord)
        int level = 1;

        // BFS: обрабатываем слова уровень за уровнем
        while (!queue.isEmpty()) {
            // Количество слов на текущем уровне
            int size = queue.size();

            // Обрабатываем все слова текущего уровня
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // Если достигли целевого слова, возвращаем длину пути
                if (current.equals(endWord)) return level;

                // Преобразуем текущее слово в массив символов для модификации
                char[] chars = current.toCharArray();

                // Пробуем изменить каждую позицию в слове
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j]; // Сохраняем оригинальный символ

                    // Пробуем заменить текущую букву на все возможные ('a' до 'z')
                    for (char c = 'a'; c <= 'z'; c++) {
                        // Пропускаем, если буква не изменилась
                        if (c == original) continue;

                        // Заменяем букву на позиции j
                        chars[j] = c;
                        String next = new String(chars);

                        // Если новое слово есть в допустимом списке
                        if (wordSet.contains(next)) {
                            // Добавляем его в очередь для обработки на следующем уровне
                            queue.offer(next);
                            // Удаляем из множества, чтобы избежать повторного посещения
                            wordSet.remove(next);
                        }
                    }

                    // Восстанавливаем оригинальный символ для следующей итерации
                    chars[j] = original;
                }
            }

            // Переходим на следующий уровень (увеличиваем длину последовательности)
            level++;
        }

        // Если очередь опустела и endWord не найден, путь не существует
        return 0;
    }
}
