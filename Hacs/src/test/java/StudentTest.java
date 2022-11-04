package test;

import hacs.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StudentTest {


    /* test create new course menu for low level courses */
    @Test
    public void createCourseMenuLowLevel() {
        Student student = new Student();
        Course course = new Course("SER501", 0);
        CourseMenu courseMenu = student.createCourseMenu(course, 0);
    }

    /* test create new course menu for high level courses */
    @Test
    public void createCourseMenuHighLevel() {
        Student student = new Student();
        Course course = new Course("SER515", 0);
        CourseMenu courseMenu = student.createCourseMenu(course, 1);
    }

    /* test add new course to student */
    @Test
    public void addCourse() {
        Student student = new Student();
        Course course = new Course("SER531", 0);
        student.addCourse(course);
        assertEquals(course, student.courseList.get(0));
    }

    /* Test getting all the list of courses to a student after adding one course */
    @Test
    public void getCourseList() {
        Student student = new Student();
        Course course = new Course("SER501", 0);
        student.addCourse(course);
        assertEquals(course, student.getCourseList().get(0));
    }

    @Test
    void createCourseMenu() {
    }

    @Test
    void showMenu() {
    }
}