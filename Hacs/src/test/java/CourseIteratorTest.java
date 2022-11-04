package test;

import hacs.ClassCourseList;
import hacs.Course;
import hacs.CourseIterator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CourseIteratorTest {

    /* Testing has next functionality of course iterator */
    @Test
    public void courseIteratorHasNext() {

    }

    /* Testing initialisation of course list */
    @Test
    public void courseListInitialisation() {
        ClassCourseList classCourseList = new ClassCourseList();
        String fileName = "CourseInfo.txt";
        classCourseList.initializeFromFile(fileName);
    }

    /* Testing null value for course iterator */
    @Test
    public void courseIteratorNextNull() {

    }

    /* Testing initialisation of class course list from file */
    @Test
    public void classCourseListInitFromFile() {
        ClassCourseList classCourseList = new ClassCourseList();
        String fileName = "CourseInfo.txt";
        classCourseList.initializeFromFile(fileName);
    }

    /* Test if course iterator has next null when given attribute */
    @Test
    public void nextWithAttributeNull() {
        ClassCourseList classCourseList = new ClassCourseList();
        String fileName = "CourseInfo.txt";
        classCourseList.initializeFromFile(fileName);
        CourseIterator courseIterator = new CourseIterator(classCourseList);
        Course course = (Course) courseIterator.next("CSE900");
        assertNull(course);
    }


    @Test
    void hasNext() {
    }

    @Test
    void next() {
    }

    @Test
    void remove() {
    }

}