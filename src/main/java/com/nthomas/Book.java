package com.nthomas;

import java.time.LocalDate;
import java.util.List;

public class Book implements Comparable<Book> {
    private Long isbn;
    private String title;
    private List<String> authors;
    private LocalDate printed;

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public LocalDate getPrinted() {
        return printed;
    }

    public void setPrinted(LocalDate printed) {
        this.printed = printed;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public int compareTo(Book o) {
        return 0;
    }
}
