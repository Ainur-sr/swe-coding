package com.coding.leetcode.t126;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();

        // Создаем HashSet для быстрой проверки наличия слова в словаре O(1)
        Set<String> dict = new HashSet<>(wordList);

        // Если целевого слова нет в словаре - трансформация невозможна
        if (!dict.contains(endWord)) {
            return ans;
        }

        // Очередь хранит ПОЛНЫЕ ПУТИ (списки слов), а не отдельные слова
        Queue<List<String>> queue = new LinkedList<>();

        // Инициализируем очередь начальным путем из одного слова
        List<String> initialPath = new ArrayList<>();
        initialPath.add(beginWord);
        queue.add(initialPath);

        // Список слов, использованных на текущем уровне BFS
        // Удаляем их из словаря только после обработки всего уровня
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord); // Помечаем начальное слово как использованное

        // Текущий уровень BFS (длина пути - 1)
        int level = 0;

        // Флаг: нашли ли мы хотя бы один путь до endWord
        boolean found = false;

        // Основной цикл BFS
        while (!queue.isEmpty()) {
            // Извлекаем текущий путь из очереди
            List<String> currentPath = queue.poll();

            // Если размер пути больше текущего уровня -> переходим на новый уровень
            if (currentPath.size() > level) {
                level++;

                // Удаляем все слова, использованные на предыдущем уровне
                // Это предотвращает циклы и гарантирует кратчайшие пути
                for (String word : usedOnLevel) {
                    dict.remove(word);
                }
                usedOnLevel.clear();

                // Если уже нашли путь, не обрабатываем следующие уровни
                if (found) {
                    break;
                }
            }

            // Берем последнее слово из текущего пути
            String lastWord = currentPath.get(currentPath.size() - 1);

            // Если достигли целевого слова - добавляем путь в результат
            if (lastWord.equals(endWord)) {
                found = true;
                ans.add(new ArrayList<>(currentPath));
                continue; // Не генерируем новые пути из endWord
            }

            // Генерируем все возможные слова, отличающиеся на одну букву
            char[] chars = lastWord.toCharArray();

            // Перебираем каждую позицию в слове
            for (int i = 0; i < chars.length; i++) {
                char originalChar = chars[i];

                // Пробуем заменить букву на каждую букву алфавита
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) continue; // Пропускаем ту же букву

                    chars[i] = c;
                    String newWord = new String(chars);

                    // Если новое слово есть в словаре
                    if (dict.contains(newWord)) {
                        // Создаем новый путь: копируем текущий + добавляем новое слово
                        List<String> newPath = new ArrayList<>(currentPath);
                        newPath.add(newWord);

                        // Добавляем новый путь в очередь
                        queue.add(newPath);

                        // Помечаем слово как использованное на этом уровне
                        // Не удаляем сразу, чтобы найти все пути одинаковой длины
                        usedOnLevel.add(newWord);
                    }
                }

                // Восстанавливаем оригинальную букву для следующей итерации
                chars[i] = originalChar;
            }
        }

        return ans;
    }

}
