package hacs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 *
 *          Update to Jave 8
 */
public class Facade {
    int userType;
    private Course theSelectedCourse = null;
    private int nCourseLevel = 0;
    ClassCourseList theCourseList;
    public Person thePerson;

    public Facade() {
    }

    static boolean login(UserInfoItem userinfoItem) {
        Login login = new Login();
        login.setModal(true);
        login.setVisible(true);
        userinfoItem.strUserName = login.getUserName();
        userinfoItem.userType = login.getUserType();
        return login.isExit();
    }

    /*
     * When click the add button of the CourseMenu , call this function. this
     * function will new an assignment fill the required information this function
     * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
     * type of the user it will not update the course menu. the course menu need to
     * refreshed outside the function
     */

    public void addAssignment(Course theCourse) {
        AssignmentMenu theAssignmentMenu;
        if (thePerson.type == 0) {
            theAssignmentMenu = new StudentAssignmentMenu();
        } else {
            theAssignmentMenu = new InstructorAssignmentMenu();
        }
        Assignment theAssignment = new Assignment();
        theAssignmentMenu.showMenu(theAssignment, thePerson);
        theCourse.addAssignment(theAssignment);
    }

    /*
     * When click the view button of the CourseMenu , call this function and pass
     * the pointer of the Assignment and the person pointer to this function. This
     * function will new an assignment fill the required information this function
     * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
     * type of the user
     */
    void viewAssignment(Assignment theAssignment) {
        AssignmentMenu theAssignmentMenu;
        if (thePerson.type == 0) {
            theAssignmentMenu = new StudentAssignmentMenu();
        } else {
            theAssignmentMenu = new InstructorAssignmentMenu();
        }
        theAssignmentMenu.showMenu(theAssignment, thePerson);
    }

    /*
     * this function will grade the give Solution: theSolution this function calls
     */

    void gradeSolution(Solution theSolution) {
        SolutionMenu solutionMenu = new SolutionMenu();
        solutionMenu.showMenu(theSolution);
    }

    void reportSolutions(Assignment theAssignment) {
        Solution theSolution;
        SolutionIterator theSolutionIterator;
        theSolutionIterator = theAssignment.getSolutionIterator();
        theSolution = (Solution) theSolutionIterator.next();
        while (theSolution != null) {
            theSolution.setReported(true);
            theSolution = (Solution) theSolutionIterator.next();
        }
    }

    //functions for StudentAssignmentMenu
    void submitSolution(Assignment theAssignment, Solution theSolution) {
        theAssignment.addSolution(theSolution);
    }
    void remind() {
        Reminder theReminder = new Reminder();
        theReminder.showReminder(thePerson.getCourseList());
    }

    public void createUser(UserInfoItem userinfoitem) {
        if (userinfoitem.userType == UserInfoItem.UserType.STUDENT) {
            thePerson = new Student();
        } else {
            thePerson = new Instructor();
        }
        thePerson.userName = userinfoitem.strUserName;
    }

    /*
     * create a course list and initialize it with the file CourseInfo.txt
     */
    void createCourseList() {
        theCourseList = new ClassCourseList();
        theCourseList.initializeFromFile("CourseInfo.txt");
    }

    /*
     * call this function after create user, create courselist read the
     * UserCourse.txt file match the coursename with theCouresList attach the
     * Matched course object to the new create user Facade.thePerson.CourseList
     */
    void attachCourseToUser() {
        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader("UserCourse.txt"));
            String aline, strUserName, strCourseName;
            while ((aline = file.readLine()) != null) {
                strUserName = getUserName(aline);
                strCourseName = getCourseName(aline);
                if (strUserName.compareTo(thePerson.userName) == 0) {
                    theSelectedCourse = findCourseByCourseName(strCourseName);
                    if (theSelectedCourse != null) {
                        thePerson.addCourse(theSelectedCourse);
                    }
                }
            }
        } catch (IOException ee) {
            System.out.println(ee);
        }
    }

    /*
     * get the username from aline UserName:courseName
     */
    private String getUserName(String aline) {
        int sep = aline.lastIndexOf(':');
        return aline.substring(0, sep);
    }

    /*
     * get the courseName from aline UserName:courseName
     */
    private String getCourseName(String aline) {
        int sep = aline.lastIndexOf(':');
        return aline.substring(sep + 1, aline.length());
    }

    /*
     * show the course selection dlg, show the course attatched to theperson and
     * return the selected course and assign the course to the class member
     * theSelectedCourse, the Course Level to courseLevel CourseLeve=0 High,
     * CourseLeve = 1 Low
     */
    public boolean selectCourse() {
        CourseSelectDlg theDlg = new CourseSelectDlg();
        theSelectedCourse = theDlg.showDlg(thePerson.courseList);
        thePerson.currentCourse = theSelectedCourse;
        nCourseLevel = theDlg.nCourseLevel;
        return theDlg.isLogout();
    }

    /*
     * call the thePerson.CreateCourseMenu according to the really object(student or
     * instructor) and the nCourseLevel it will call different menu creater and show
     * the menu;
     */

    public boolean courseOperation() {
        thePerson.createCourseMenu(theSelectedCourse, nCourseLevel);
        return thePerson.showMenu(); //// 0: logout 1 select another course
    }

    /*
     * find the course in theCourseList that matches strCourseName 1 create a
     * CourseIterator for the List 2 Find the Course with the Iterator return the
     * pointer of the Course if not fine, return null;
     */
    private Course findCourseByCourseName(String strCourseName) {
        CourseIterator iterator = new CourseIterator(theCourseList);
        return (Course) iterator.next(strCourseName);
    }
}
