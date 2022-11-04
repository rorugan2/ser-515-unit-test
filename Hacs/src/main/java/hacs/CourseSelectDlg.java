package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */
public class CourseSelectDlg extends JDialog {
    //0 HighLevel presentation 1 LowLevel Experiment
    final int tr = 18;
    final int xs = 78;
    final int ln = 139;
    final int hs = 79;
    final int kl = 29;
    final int js = 224;
    final int mn = 140;
    final int op = 73;
    final int jk = 31;
    final int ko = 420;
    final int sn = 238;
    final int th = 155;
    final int ki = 41;
    final int hm = 203;
    final int ij = 22;
    final int om = 50;
    final int gk = 87;
    final int pk = 103;
    final int nu = 26;
    final int ok = 39;
    final int ik = 44;
    final int nm = 85;
    final int hj = 236;
    final int gj = 88;

    ClassCourseList theCourseList;
    Course selectedCourse;
    int nCourseLevel = 0;
    boolean mbLogout = false;
    JComboBox courseNameCom = new JComboBox();
    JRadioButton highLevelRadio = new JRadioButton();
    JRadioButton lowLevelRadio = new JRadioButton();
    JLabel jLabel1 = new JLabel();
    JButton okButton = new JButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    JButton buttonLogout = new JButton();

    public CourseSelectDlg() {
        try {
            jbInit();
            setSize(ko, sn);
            setModal(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        courseNameCom.setBounds(new Rectangle(th, kl, hm, ij));
        highLevelRadio.setText("HighLevel");
        highLevelRadio.setBounds(new Rectangle(om, gk, pk, nu));
        lowLevelRadio.setToolTipText("");
        lowLevelRadio.setSelected(true);
        lowLevelRadio.setText("LowLevel");
        lowLevelRadio.setBounds(new Rectangle(hj, gj, pk, nu));
        jLabel1.setText("CourseName");
        jLabel1.setBounds(new Rectangle(ok, ik, nm, tr));
        okButton.setText("OK");
        okButton.setBounds(new Rectangle(xs, ln, hs, ki));
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okButtonActionPerformed(e);
            }
        });
        buttonLogout.setText("Logout");
        buttonLogout.setBounds(new Rectangle(js, mn, op, jk));
        buttonLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonLogoutActionPerformed(e);
            }
        });
        this.getContentPane().add(courseNameCom, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(highLevelRadio, null);
        this.getContentPane().add(lowLevelRadio, null);
        this.getContentPane().add(okButton, null);
        this.getContentPane().add(buttonLogout, null);
        buttonGroup1.add(highLevelRadio);
        buttonGroup1.add(lowLevelRadio);
    }

    /*
     * show the theCourseList in a combox Show the Course type selection button
     * return the pointer pointing to the Course object return the Course Type
     */

    public Course showDlg(ClassCourseList courseList) {

        theCourseList = courseList;
        CourseIterator theIterator = new CourseIterator(theCourseList);
        Course theCourse;
        while ((theCourse = (Course) theIterator.next()) != null) {
            courseNameCom.addItem(theCourse);
        }
        this.setVisible(true);
        return selectedCourse;
    }

    void okButtonActionPerformed(ActionEvent e) {
        selectedCourse = (Course) courseNameCom.getSelectedItem();
        if (highLevelRadio.isSelected()) {
            nCourseLevel = 0; // highlevel course: 0
        } else {
            nCourseLevel = 1; // lowlevel course: 1
        }
        //hide();
    }

    public boolean isLogout() {
        return mbLogout;
    }

    void buttonLogoutActionPerformed(ActionEvent e) {
        mbLogout = true;
        setVisible(false);
    }
}
