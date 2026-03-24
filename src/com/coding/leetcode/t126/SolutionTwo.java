package com.coding.leetcode.t126;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SolutionTwo {
    // Граф смежности: ключ = слово, значение = список слов, ИЗ КОТОРЫХ можно попасть в ключ
    // ВАЖНО: это ОБРАТНЫЙ граф (reverse graph) - ребра идут в обратном направлении
    Map<String, List<String>> adjList = new HashMap<>();

    // Список всех найденных кратчайших путей
    List<List<String>> shortestPaths = new ArrayList<>();

    /**
     * Главный метод: находит все кратчайшие последовательности трансформаций
     *
     * @param beginWord - начальное слово
     * @param endWord   - целевое слово
     * @param wordList  - список допустимых промежуточных слов
     * @return список всех кратчайших путей от beginWord до endWord
     */
    public List<List<String>> findLadders(String beginWord,
                                          String endWord,
                                          List<String> wordList) {
        // Копируем слова в Set для эффективного удаления в BFS (O(1))
        Set<String> wordSet = new HashSet<>(wordList);

        // Шаг 1: Строим ОБРАТНЫЙ граф (DAG) используя BFS
        // Граф содержит ребра от каждого слова к его предшественникам
        bfs(beginWord, endWord, wordSet);

        // Шаг 2: Начинаем backtracking от endWord
        // Текущий путь при backtracking (строится от endWord к beginWord)
        List<String> currPath = new ArrayList<>();
        currPath.add(endWord);

        // Шаг 3: Обходим граф от endWord к beginWord, собирая все пути
        // Пути строятся в обратном порядке и разворачиваются в backtrack()
        backtrack(endWord, beginWord, currPath);

        return shortestPaths;
    }

    /**
     * BFS: строит ОБРАТНЫЙ граф и находит все кратчайшие пути
     *
     * @param beginWord - начальное слово
     * @param endWord   - целевое слово
     * @param wordSet   - словарь допустимых слов (изменяется в процессе)
     */
    private void bfs(String beginWord, String endWord, Set<String> wordSet) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // Удаляем начальное слово из словаря (это первый уровень BFS)
        if (wordSet.contains(beginWord)) {
            wordSet.remove(beginWord);
        }

        // Флаг: нашли ли мы endWord на текущем уровне
        // Используется для early stopping - останавливаем BFS сразу после уровня с endWord
        boolean foundEndWord = false;

        // Основной цикл BFS
        // Останавливаемся, если очередь пуста ИЛИ нашли endWord на предыдущем уровне
        while (!queue.isEmpty() && !foundEndWord) {
            // visited хранит все слова текущего уровня
            // Удаляем их из словаря только после обработки всего уровня
            List<String> visited = new ArrayList<>();

            // Обрабатываем все слова текущего уровня
            for (int i = 0; i < queue.size(); i++) {
                String currWord = queue.poll();

                // Находим всех соседей текущего слова
                List<String> neighbors = findNeighbors(currWord, wordSet);

                for (String word : neighbors) {
                    // Помечаем слово как посещенное на этом уровне
                    visited.add(word);

                    // Инициализируем список предшественников для word, если его нет
                    if (!adjList.containsKey(word)) {
                        adjList.put(word, new ArrayList<>());
                    }

                    // КЛЮЧЕВОЙ МОМЕНТ: добавляем ребро от word К currWord
                    // Это ОБРАТНОЕ направление (reverse edge)
                    // Позволяет потом идти от endWord к beginWord через backtracking
                    adjList.get(word).add(currWord);

                    // ОПТИМИЗАЦИЯ: проверяем, достигли ли целевого слова
                    // Устанавливаем флаг, но НЕ прерываем цикл - нужно обработать весь уровень
                    // чтобы найти ВСЕ кратчайшие пути одинаковой длины
                    if (word.equals(endWord)) {
                        foundEndWord = true;
                    }

                    queue.add(word);
                }
            }

            // Удаляем все слова текущего уровня из словаря
            // Это предотвращает циклы и гарантирует кратчайшие пути
            // Удаление происходит ПОСЛЕ обработки всего уровня,
            // что позволяет найти все пути одинаковой длины
            for (int i = 0; i < visited.size(); i++) {
                if (wordSet.contains(visited.get(i))) {
                    wordSet.remove(visited.get(i));
                }
            }
        }

    }


    /**
     * Находит все слова из словаря, которые отличаются от word на одну букву
     *
     * @param word     - исходное слово
     * @param wordList - словарь допустимых слов
     * @return список соседних слов
     */
    private List<String> findNeighbors(String word, Set<String> wordList) {
        List<String> neighbors = new ArrayList<>();
        char charArr[] = word.toCharArray();

        // Перебираем каждую позицию в слове
        for (int i = 0; i < word.length(); i++) {
            char oldChar = charArr[i]; // Сохраняем оригинальную букву

            // Заменяем i-ю букву на все буквы от a до z (кроме оригинальной)
            for (char c = 'a'; c <= 'z'; c++) {
                charArr[i] = c;

                // Пропускаем, если буква та же или слова нет в словаре
                if (c == oldChar || !wordList.contains(String.valueOf(charArr))) {
                    continue;
                }

                // Добавляем валидного соседа
                neighbors.add(String.valueOf(charArr));
            }

            // Восстанавливаем оригинальную букву для следующей итерации
            charArr[i] = oldChar;
        }

        return neighbors;
    }

    /**
     * Backtracking: находит все пути от source до destination
     * Использует ОБРАТНЫЙ граф, поэтому идет от endWord к beginWord
     *
     * @param source      - текущее слово (начинаем с endWord)
     * @param destination - целевое слово (beginWord)
     * @param currPath - Текущий путь при backtracking (строится от endWord к beginWord)
     */
    private void backtrack(String source, String destination, List<String> currPath) {
        // Базовый случай: достигли beginWord
        if (source.equals(destination)) {
            // Копируем текущий путь
            List<String> tempPath = new ArrayList<>(currPath);

            // ВАЖНО: путь построен от конца к началу, поэтому разворачиваем
            Collections.reverse(tempPath);

            // Добавляем в результат
            shortestPaths.add(tempPath);
            return;
        }

        // Если у текущего слова нет предшественников в графе - выходим
        if (!adjList.containsKey(source)) {
            return;
        }

        // Перебираем все слова, ИЗ КОТОРЫХ можно попасть в source
        // (помним, что граф обратный)
        for (String newWord : adjList.get(source)) {
            // Добавляем предшественника в путь
            currPath.add(newWord);

            // Рекурсивно идем дальше
            backtrack(newWord, destination, currPath);

            // Backtracking: удаляем последнее слово для проверки других путей
            currPath.remove(currPath.size() - 1);
        }
    }

}
