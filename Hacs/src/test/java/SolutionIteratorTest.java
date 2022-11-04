package test;

import hacs.Solution;
import hacs.SolutionIterator;
import hacs.SolutionList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SolutionIteratorTest {


    /* Test it solution iterator has next when given solution to solution list */
    @Test
    public void hasNext() {
        Solution sol = new Solution();
        sol.solutionFileName = "ram";
        SolutionList list = new SolutionList();
        list.add(sol);
        SolutionIterator test = new SolutionIterator(list);
        assertEquals(true, test.hasNext());
    }

    /* Test if solution iterator has next when given empty solution list */
    @Test
    public void hasNextNull() {
        SolutionList solutionList = new SolutionList();
        SolutionIterator solutionIterator = new SolutionIterator(solutionList);
        assertEquals(false, solutionIterator.hasNext());
    }

    /* test if solution iterator has next when given a new solution and added to solution list */
    @Test
    public void next() {
        Solution solution = new Solution();
        solution.solutionFileName = "ram";
        SolutionList solutionList = new SolutionList();
        solutionList.add(solution);
        SolutionIterator solutionIterator = new SolutionIterator(solutionList);
        Solution testSolution = (Solution) solutionIterator.next();
        assertEquals(solution.solutionFileName, testSolution.solutionFileName);
    }

    /* Test whether solution iterator becomes null when given empty solution list */
    @Test
    public void nextNull() {
        SolutionList solutionList = new SolutionList();
        SolutionIterator solutionIterator = new SolutionIterator(solutionList);
        Solution solution = (Solution) solutionIterator.next();
        assertNull(solution);
    }


    @Test
    void moveToHead() {
    }

    @Test
    void remove() {
    }
}