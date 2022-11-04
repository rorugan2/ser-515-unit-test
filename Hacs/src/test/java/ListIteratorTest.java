package test;

import hacs.Assignment;
import hacs.ListIterator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class ListIteratorTest {


    /* Test if list iterator has next when added assignment */
    @Test
    public void hasNextTrue() {
        ArrayList<Object> arrayList = new ArrayList<>();
        Assignment assignment = new Assignment();
        arrayList.add(assignment);
        ListIterator listIterator = new ListIterator(arrayList);
        assertTrue(listIterator.hasNext());
    }

    /* Test if the list iterator has next item when looping over arraylist  */
    @Test
    public void hasNextFalse() {
        ArrayList<Object> arrayList = new ArrayList<>();
        ListIterator listIterator = new ListIterator(arrayList);
        assertFalse(listIterator.hasNext());
    }

    /* Test if the list iterator has next when added new assignment to array list */
    @Test
    public void next() {
        ArrayList<Object> arrayList = new ArrayList<>();
        Assignment assignment = new Assignment();
        arrayList.add(assignment);
        ListIterator listIterator = new ListIterator(arrayList);
        assertEquals(assignment, listIterator.next());
    }

    /* Test list iterator has next null when given array list */
    @Test
    public void nextNull() {
        ArrayList<Object> arrayList = new ArrayList<>();
        ListIterator listIterator = new ListIterator(arrayList);
        assertNull(listIterator.next());
    }

    @Test
    void hasNext() {
    }

    @Test
    void remove() {
    }
}