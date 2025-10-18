package org.skypro.skyshop.searchEngine;


import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private final Set<Searchable> searchables = new HashSet<>();

    public void add(Searchable item) {
        searchables.add(item);
    }

    public Set<Searchable> searchAndSort(String searchString) {

        Comparator<Searchable> comparator = (s1, s2) -> {
            int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s1.getName().compareTo(s2.getName());
        };

        return searchables.stream()
                .filter(Objects::nonNull)
                .filter(item -> item.getSearchTerm().contains(searchString))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }

    public Searchable search(String search) throws BestResultNotFound {

        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        String searchLower = search.toLowerCase();

        for (Searchable item : searchables) {
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
