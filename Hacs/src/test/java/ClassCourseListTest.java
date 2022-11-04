package test;

import hacs.ClassCourseList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ClassCourseListTest {

    /* Testing finding a course by its name */
    @Test
    public void findCourseByName() {
        ClassCourseList classCourseList = new ClassCourseList();
        String fileName = "CourseInfo.txt";
        classCourseList.initializeFromFile(fileName);
        assertEquals(null, classCourseList.findCourseByCourseName("CSE240"));
    }

}