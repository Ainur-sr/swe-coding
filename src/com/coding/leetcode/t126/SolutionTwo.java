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
    Map<String, List<String>> adjList = new HashMap<String, List<String>>();

    // Текущий путь при backtracking (строится от endWord к beginWord)
    List<String> currPath = new ArrayList<String>();

    // Список всех найденных кратчайших путей
    List<List<String>> shortestPaths = new ArrayList<List<String>>();

    /**
     * Находит все слова из словаря, которые отличаются от word на одну букву
     *
     * @param word     - исходное слово
     * @param wordList - словарь допустимых слов
     * @return список соседних слов
     */
    private List<String> findNeighbors(String word, Set<String> wordList) {
        List<String> neighbors = new ArrayList<String>();
        char charList[] = word.toCharArray();

        // Перебираем каждую позицию в слове
        for (int i = 0; i < word.length(); i++) {
            char oldChar = charList[i]; // Сохраняем оригинальную букву

            // Заменяем i-ю букву на все буквы от a до z (кроме оригинальной)
            for (char c = 'a'; c <= 'z'; c++) {
                charList[i] = c;

                // Пропускаем, если буква та же или слова нет в словаре
                if (c == oldChar || !wordList.contains(String.valueOf(charList))) {
                    continue;
                }

                // Добавляем валидного соседа
                neighbors.add(String.valueOf(charList));
            }

            // Восстанавливаем оригинальную букву для следующей итерации
            charList[i] = oldChar;
        }
        return neighbors;
    }

    /**
     * Backtracking: находит все пути от source до destination
     * Использует ОБРАТНЫЙ граф, поэтому идет от endWord к beginWord
     *
     * @param source      - текущее слово (начинаем с endWord)
     * @param destination - целевое слово (beginWord)
     */
    private void backtrack(String source, String destination) {
        // Базовый случай: достигли beginWord
        if (source.equals(destination)) {
            // Копируем текущий путь
            List<String> tempPath = new ArrayList<String>(currPath);

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
        for (int i = 0; i < adjList.get(source).size(); i++) {
            // Добавляем предшественника в путь
            currPath.add(adjList.get(source).get(i));

            // Рекурсивно идем дальше
            backtrack(adjList.get(source).get(i), destination);

            // Backtracking: удаляем последнее слово для проверки других путей
            currPath.remove(currPath.size() - 1);
        }
    }

    /**
     * BFS: строит ОБРАТНЫЙ граф и находит все кратчайшие пути
     *
     * @param beginWord - начальное слово
     * @param endWord   - целевое слово
     * @param wordList  - словарь допустимых слов (изменяется в процессе)
     */
    private void bfs(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        // Удаляем начальное слово из словаря (это первый уровень BFS)
        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }

        // Отслеживаем, какие слова уже добавлены в очередь
        // Используется вместо distance для экономии памяти
        Map<String, Integer> isEnqueued = new HashMap<String, Integer>();
        isEnqueued.put(beginWord, 1);

        // Основной цикл BFS
        while (q.size() > 0) {
            // visited хранит все слова текущего уровня
            // Удаляем их из словаря только после обработки всего уровня
            List<String> visited = new ArrayList<String>();

            // Обрабатываем все слова текущего уровня
            // ВАЖНО: используем размер очереди ДО начала итерации
            for (int i = q.size() - 1; i >= 0; i--) {
                String currWord = q.peek();
                q.remove();

                // Находим всех соседей текущего слова
                List<String> neighbors = findNeighbors(currWord, wordList);

                for (String word : neighbors) {
                    // Помечаем слово как посещенное на этом уровне
                    visited.add(word);

                    // Инициализируем список предшественников для word, если его нет
                    if (!adjList.containsKey(word)) {
                        adjList.put(word, new ArrayList<String>());
                    }

                    // КЛЮЧЕВОЙ МОМЕНТ: добавляем ребро от word К currWord
                    // Это ОБРАТНОЕ направление (reverse edge)
                    // Позволяет потом идти от endWord к beginWord через backtracking
                    adjList.get(word).add(currWord);

                    // Если слово еще не было добавлено в очередь
                    if (!isEnqueued.containsKey(word)) {
                        q.add(word);
                        isEnqueued.put(word, 1);
                    }
                }
            }

            // Удаляем все слова текущего уровня из словаря
            // Это предотвращает циклы и гарантирует кратчайшие пути
            // Удаление происходит ПОСЛЕ обработки всего уровня,
            // что позволяет найти все пути одинаковой длины
            for (int i = 0; i < visited.size(); i++) {
                if (wordList.contains(visited.get(i))) {
                    wordList.remove(visited.get(i));
                }
            }
        }
    }

    /**
     * Главный метод: находит все кратчайшие последовательности трансформаций
     *
     * @param beginWord - начальное слово
     * @param endWord   - целевое слово
     * @param wordList  - список допустимых промежуточных слов
     * @return список всех кратчайших путей от beginWord до endWord
     */
    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList
    ) {
        // Копируем слова в Set для эффективного удаления в BFS (O(1))
        Set<String> copiedWordList = new HashSet<>(wordList);

        // Шаг 1: Строим ОБРАТНЫЙ граф (DAG) используя BFS
        // Граф содержит ребра от каждого слова к его предшественникам
        bfs(beginWord, endWord, copiedWordList);

        // Шаг 2: Начинаем backtracking от endWord
        currPath.add(endWord);

        // Шаг 3: Обходим граф от endWord к beginWord, собирая все пути
        // Пути строятся в обратном порядке и разворачиваются в backtrack()
        backtrack(endWord, beginWord);

        return shortestPaths;
    }
}
