package test;

import hacs.Assignment;
import hacs.Solution;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
class AssignmentTest {

    /*
     *  tests whether the due date has been set or not
     * */
    @Test
    public void setDueDate() {
        Date date = new Date(2022 - 11 - 03);
        Assignment assignment = new Assignment();
        assignment.setDueDate(date);
        assertEquals(date, assignment.dueDate);
    }

    /* Test assignment Spec */
    @Test
    public void setAssignmentSpec() {
        Assignment assignment = new Assignment();
        assignment.setAssSpec("Test");
        assertEquals(assignment.assSpec, "Test");
    }

    /* Tests overdue true condition */
    @Test
    public void overDueTrue() {
        Assignment assign = new Assignment();
        Date date = new Date(2022 - 11 - 03);
        assign.setDueDate(date);
        assertTrue(assign.isOverDue());
    }

    /* Test overdue false condition */
    @Test
    public void overDueFalse() {
        Assignment assign = new Assignment();
        assign.setDueDate(new Date());
        assertFalse(assign.isOverDue());
    }

    /* Test adding solution  */
    @Test
    public void addSolution() {
        Assignment assign = new Assignment();
        Solution solution = assign.addSolution();
        assertNotNull(solution);
    }

    /* Test adding solution with attribute */
    @Test
    public void addSolutionWithAttribute() {
        Assignment assignment = new Assignment();
        Solution firstSolution = assignment.addSolution();
        assignment.addSolution(firstSolution);
        Solution testSolution = assignment.theSolutionList.get(0);
        assertEquals(firstSolution, testSolution);
    }


    /* Testing converting to string */
    @Test
    public String toString() {
        Assignment assignment = new Assignment();
        assignment.assSpec = "Test";
        assertEquals("Test", assignment.toString());
        return null;
    }


    @Test
    void getSolutionIterator() {
    }

    @Test
    void getDueDateString() {
    }

    @Test
    void accept() {
    }
}