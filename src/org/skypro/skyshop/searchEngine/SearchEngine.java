package org.skypro.skyshop.searchEngine;


import org.skypro.skyshop.searchable.Searchable;

public class SearchEngine {
    private static final int MAX_SIZE = 100;
    private static Searchable[] searchables = new Searchable[MAX_SIZE];
    private int size;

    public Searchable[] search(String searchString) {

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

     public void add(Searchable items) {
        if (size >= searchables.length) {
            System.out.println("Массив полон, добавление невозможно");
            return;
        }
        searchables[size] = items;
        size++;

    }

}
