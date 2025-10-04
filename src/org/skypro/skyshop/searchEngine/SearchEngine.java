package org.skypro.skyshop.searchEngine;


import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;

public class SearchEngine {

    private final List<Searchable> searchables = new LinkedList<>();

    public void add(Searchable item) {
         searchables.add(item);
    }

    public Map<String, Searchable> searchAndSort(String searchString) {
        Map<String, Searchable> resultMap = new TreeMap<>();

        for (Searchable item : searchables) {
            if (item != null && item.getSearchTerm().contains(searchString)) {
                resultMap.put(item.getName(), item);
            }
        }
        return resultMap;
    }

    public Searchable search(String search) throws BestResultNotFound {

        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        String searchLower = search.toLowerCase();

        for (int i = 0; i < searchables.size(); i++) {
            Searchable item = searchables.get(i);
            if (item != null) {
                String searchTerm = item.getSearchTerm().toLowerCase();

                int occurrences = countSubstringOccurrences(searchTerm, searchLower);

                if (occurrences > maxCount) {
                    maxCount = occurrences;
                    bestMatch = item;
                }
            }
        }

        if (maxCount <= 0 || bestMatch == null) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }

    private int countSubstringOccurrences(String str, String sub) {
        int count = 0;
        int fromIndex = 0;
        while ((fromIndex = str.indexOf(sub, fromIndex)) != -1) {
            count++;
            fromIndex += sub.length();
        }
        return count;
    }
}
