package test;

import hacs.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FacadeTest {

    /* Testing adding a new assignment to course through facade */
    @Test
    public void addAssignment() {
        Facade facade = new Facade();
        Course course = new Course("SER501", 0);
        facade.thePerson = new Student();
        facade.addAssignment(course);
        assertEquals(course.assignmentList.get(0).getClass(), Assignment.class);
    }

    /* Testing creating new user info item from facade */
    @Test
    public void createUser() {
        Facade facade = new Facade();
        UserInfoItem userInfoItem = new UserInfoItem();
        userInfoItem.userType = UserInfoItem.UserType.STUDENT;
        userInfoItem.strUserName = "user";
        facade.createUser(userInfoItem);
        assertEquals(facade.thePerson.userName, "user");
    }

    @Test
    void login() {
    }

    @Test
    void viewAssignment() {
    }

    @Test
    void remind() {
    }

    @Test
    void createCourseList() {
    }

    @Test
    void attachCourseToUser() {
    }

    @Test
    void selectCourse() {
    }

    @Test
    void courseOperation() {
    }
}