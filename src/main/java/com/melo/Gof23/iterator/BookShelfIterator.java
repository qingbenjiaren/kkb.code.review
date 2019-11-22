package com.melo.Gof23.iterator;

import java.util.Iterator;

public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index = 0;
    public BookShelfIterator(BookShelf shelf){
        this.bookShelf = shelf;
    }
    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    @Override
    public Object next() {
        return bookShelf.findBookAt(index++);
    }
}
