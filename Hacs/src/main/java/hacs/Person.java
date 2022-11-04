package hacs;

import java.util.*;

/**
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

public abstract class Person {
    int type = 0; // type=0 : student, type=1 instructor
    public String userName;
    public ClassCourseList courseList;
    CourseMenu theCourseMenu;
    Course currentCourse;
    Assignment currentAssignment;

    public Person() {
        courseList = new ClassCourseList();
    }

    abstract CourseMenu createCourseMenu(Course theCourse, int theLevel);

    public void showAddButton() {
        theCourseMenu.showAddButtons();
    }

    public void showViewButtons() {
        theCourseMenu.showViewButtons();
    }

    public void showComboxes() {
        theCourseMenu.showComboxes();
    }

    public void showRadios() {
        theCourseMenu.showRadios();
    }

    public void show() {
        theCourseMenu.setVisible(true);
    }

    public boolean ifLogout() {
        return theCourseMenu.ifLogout();
    }

    // show the assignment list
    public boolean showMenu() {
        // create a iterator for the assignment list
        //    Iterator theIter=new ListIterator(CurrentCourse.AssList );
        Iterator theIter = currentCourse.assignmentList.iterator();
        theCourseMenu.theCourse = currentCourse;
        Assignment theAssignment;
        while (theIter.hasNext()) {
            theAssignment = (Assignment) theIter.next();
            theCourseMenu.assignmentCombox.addItem(theAssignment);
        }
        return false;
    }

    public ClassCourseList getCourseList() {
        return courseList;
    }

    public void addCourse(Course theCourse) {
        courseList.add(theCourse);
    }
}
