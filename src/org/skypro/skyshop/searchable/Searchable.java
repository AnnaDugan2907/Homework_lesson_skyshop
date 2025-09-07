package org.skypro.skyshop.searchable;

public interface Searchable {
    public String getSearchTerm();

    public String getContentType();

    public String getName();

    default String getStringRepresentation(){
        return getName() + " - " + getContentType();
    }
}
//