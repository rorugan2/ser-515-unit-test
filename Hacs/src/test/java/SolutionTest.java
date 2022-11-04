package test;

import hacs.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SolutionTest {


    /* Test solution status not reported */
    @Test
    public void toStringNotReported() {
        Solution solution = new Solution();
        solution.theAuthor = "ram";
        solution.solutionFileName = "Solution";
        solution.theGrade = 6;
        solution.reported = false;
        String string = "ram" + "  " + "Solution" + " Grade=" + "6" + "  " + "not reported";
        assertEquals(solution.toString(), string);
    }

    /*  Test if solution status is marked as reported */
    @Test
    public void toStringReported() {
        Solution solution = new Solution();
        solution.theAuthor = "ram";
        solution.solutionFileName = "Solution";
        solution.theGrade = 6;
        solution.reported = true;
        String string = "ram" + "  " + "Solution" + " Grade=" + "6" + "  " + "reported";
        assertEquals(solution.toString(), string);
    }

    /* test of solution grade is set */
    @Test
    public void getGradeIntReported() {
        Solution solution = new Solution();
        solution.theAuthor = "ram";
        solution.solutionFileName = "Solution";
        solution.theGrade = 6;
        solution.reported = true;
        assertEquals("6", solution.getGradeString());
    }

    /* Test solution grade when solution is not reported */
    @Test
    public void getGradeIntNotReported() {
        Solution solution = new Solution();
        solution.theAuthor = "ram";
        solution.solutionFileName = "Solution";
        solution.theGrade = 6;
        solution.reported = false;
        assertEquals("-1", solution.getGradeString());
    }

    /* test solution grade type casting to int */
    @Test
    public void getGradeInt() {
        Solution solution = new Solution();
        solution.theAuthor = "ram";
        solution.solutionFileName = "Solution";
        solution.theGrade = 6;
        assertEquals(6, solution.getGradeInt());
    }

    /* Test solution not reported function */
    @Test
    public void setReported() {
        Solution solution = new Solution();
        solution.theAuthor = "ram";
        solution.solutionFileName = "Solution";
        solution.setReported(false);
        assertEquals(false, solution.reported);
    }

    /* Test solution set reported function */
    @Test
    public void isReported() {
        Solution solution = new Solution();
        solution.theAuthor = "ram";
        solution.solutionFileName = "Solution";
        solution.setReported(false);
        assertEquals(false, solution.isReported());
    }


    @Test
    void testToString() {
    }

    @Test
    void getGradeString() {
    }

}