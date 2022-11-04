package hacs;

import java.util.*;
public class ListIterator implements Iterator<Object> {
    ArrayList<Object> theList;
    int currentNumber = -1;

    public ListIterator() {
    }

    public ListIterator(ArrayList<Object> list) {
        theList = list;
    }

    public boolean hasNext() {
        boolean cond = currentNumber >= theList.size() - 1;
        return !cond;
    }

    public Object next() {
        boolean b = hasNext();
        if (b) {
            currentNumber++;
            return theList.get(currentNumber);
        } else {
            return null;
        }
    }

    public void remove() {
        theList.remove(currentNumber);
    }
}
