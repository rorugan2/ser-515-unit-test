package test;

import hacs.Assignment;
import hacs.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CourseTest {

    /* Testing adding a new assignment to a course */
    @Test
    public void addAssignment() {
        Course course = new Course("SER501", 0);
        Assignment assignment = new Assignment();
        course.addAssignment(assignment);
        assertEquals(assignment, course.assignmentList.get(0));
    }

    /* Testing converting course object to string */
    @Test
    public String toString() {
        Course course = new Course("SER501", 0);
        assertEquals("SER501", course.toString());
        return null;
    }

    @Test
    void accept() {
    }
}