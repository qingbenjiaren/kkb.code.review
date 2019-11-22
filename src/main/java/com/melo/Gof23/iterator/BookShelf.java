package com.melo.Gof23.iterator;

import java.util.Iterator;

public class BookShelf implements Agreegate{
    private Book books [];
    private int length = 0;
    private int maxSize = 0;
    public BookShelf(int size){
        books = new Book[size];
        maxSize = size;
    }

    public void append(Book book){
        books[length++] = book;
    }

    public Book findBookAt(int index){
        return books[index];
    }
    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }

    public int getLength() {
        return length;
    }
}
