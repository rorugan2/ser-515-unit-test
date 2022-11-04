package test;

import hacs.Course;
import hacs.CourseMenu;
import hacs.HighLevelCourseMenu;
import hacs.Instructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class InstructorTest {


    /* Testing of creating a new low level course menu */
    @Test
    public void createCourseMenuLowLevel() {
        Instructor instructor = new Instructor();
        Course course = new Course("SER501", 0);
        CourseMenu courseMenu = instructor.createCourseMenu(course, 0);
        assertEquals(courseMenu.getClass(), HighLevelCourseMenu.class);
    }

    /* Testing of creating a new high level course menu */
    @Test
    public void createCourseMenuHighLevel() {
        Instructor instructor = new Instructor();
        Course course = new Course("SER501", 0);
        CourseMenu courseMenu = instructor.createCourseMenu(course, 1);
        assertEquals(courseMenu.getClass(), HighLevelCourseMenu.class);
    }

    /* Testing of adding a new course to the instructor */
    @Test
    public void addCourse() {
        Instructor instructor = new Instructor();
        Course course = new Course("SER501", 0);
        instructor.addCourse(course);
        assertEquals(course, instructor.courseList.get(0));
    }

    /* Test getting the list of courses of an instructor */
    @Test
    public void getCourseList() {
        Instructor instructor = new Instructor();
        Course course = new Course("SER501", 0);
        instructor.addCourse(course);
        assertEquals(course, instructor.getCourseList().get(0));
    }

    @Test
    void createCourseMenu() {
    }

    @Test
    void showMenu() {
    }
}