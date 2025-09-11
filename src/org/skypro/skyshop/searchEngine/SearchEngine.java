package org.skypro.skyshop.searchEngine;


import org.skypro.skyshop.searchable.Searchable;

public class SearchEngine {
    private static final int MAX_SIZE = 100;
    private static Searchable[] searchables = new Searchable[MAX_SIZE];
    private int size;

    public Searchable[] searchs(String searchString)  {

        Searchable[] results = new Searchable[5];
        int count = 0;

        for (int i = 0; i < size; i++) {
            Searchable item = searchables[i];
            if (item != null && item.getSearchTerm().contains(searchString)) {
                results[count] = item;
                count++;
                if (count == 5) {
                    break;
                }
            }
        }
        return results;
    }

    public Searchable search(String search) throws BestResultNotFound {
        Searchable[] results = new Searchable[5];
        int count = 0;

        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        String searchLower = search.toLowerCase();

        for (int i = 0; i < size; i++) {
            Searchable item = searchables[i];
            if (item != null) {
                String searchTerm = item.getSearchTerm().toLowerCase();

                // Подсчёт количества вхождений
                int occurrences = countSubstringOccurrences(searchTerm, searchLower);
                results[count] = item;

                if (occurrences > maxCount) {
                    maxCount = occurrences;
                    bestMatch = item;
                }

                count++;
            }
        }

        if (maxCount <= 0) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }


//    public Searchable[] search(String search) throws BestResultNotFound {
//        Searchable[] results = new Searchable[5];
//        int count = 0;
//
//        if (search == null || search.isEmpty()) {
//            throw new BestResultNotFound(search);
//        }
//
//        String searchLower = search.toLowerCase();
//
//        for (int i = 0; i < size; i++) {
//            Searchable item = searchables[i];
//            if (item != null) {
//                String searchTerm = item.getSearchTerm().toLowerCase();
//                int occurrences = countSubstringOccurrences(searchTerm, searchLower);
//                if (occurrences > 0) {
//                    results[count] = item;
//                    count++;
//                }
//            }
//        }
//
//        if (count == 0) {
//            throw new BestResultNotFound(search);
//        }
//
//        // Возвращаем только заполненную часть массива
//        return Arrays.copyOf(results, count);
//    }


    private int countSubstringOccurrences(String str, String sub) {
        int count = 0;
        int fromIndex = 0;
        while ((fromIndex = str.indexOf(sub, fromIndex)) != -1) {
            count++;
            fromIndex += sub.length();
        }
        return count;
    }


    public void add(Searchable items) {
        if (size >= searchables.length) {
            System.out.println("Массив полон, добавление невозможно");
            return;
        }
        searchables[size] = items;
        size++;

    }

}
