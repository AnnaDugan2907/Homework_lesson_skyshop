package org.skypro.skyshop.searchEngine;


import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.Searchable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {

    private final List<Searchable> searchables = new LinkedList<>();
    private int size;

    public void add(Searchable item) {

         searchables.add(item);

    }


    public List<Searchable> searchs(String searchString)  {

        List<Searchable> results = new ArrayList<>();
       // int count = 0;

        if (searchString == null || searchString.isEmpty()) {
            return results;
        }

        for (int i = 0; i < searchables.size(); i++) {
            Searchable item = searchables.get(i);
            if (item != null && item.getSearchTerm().contains(searchString)) {

                results.add(item);
               // results.set(count, item);
               // count++;

            }
        }
        return results;
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
              //  results[count] = item;

                if (occurrences > maxCount) {
                    maxCount = occurrences;
                    bestMatch = item;
                }

                //count++;
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
