package org.skypro.skyshop.searchEngine;


import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;

public class SearchEngine {

//    private final List<Searchable> searchables = new LinkedList<>();

    private final Set<Searchable> searchables = new HashSet<>();

    public void add(Searchable item) {
        searchables.add(item);
    }

//    public Map<String, Searchable> searchAndSort(String searchString) {
//        Map<String, Searchable> resultMap = new TreeMap<>();
//
//        for (Searchable item : searchables) {
//            if (item != null && item.getSearchTerm().contains(searchString)) {
//                resultMap.put(item.getName(), item);
//            }
//        }
//        return resultMap;
//    }

    public Set<Searchable> searchAndSort(String searchString) {

        Comparator<Searchable> comparator = new Comparator<Searchable>() {

            public int compare(Searchable s1, Searchable s2) {

                int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
                if (lengthCompare != 0) {
                    return lengthCompare;
                }

                return s1.getName().compareTo(s2.getName());
            }
        };

        Set<Searchable> resultSet = new TreeSet<>(comparator);

        for (Searchable item : searchables) {
            if (item != null && item.getSearchTerm().contains(searchString)) {
                resultSet.add(item);
            }
        }
        return resultSet;
    }

    public Searchable search(String search) throws BestResultNotFound {

        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        String searchLower = search.toLowerCase();

//        for (int i = 0; i < searchables.size(); i++) {
//            Searchable item = searchables.get(i);

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
