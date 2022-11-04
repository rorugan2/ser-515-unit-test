package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: asu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class StudentAssignmentMenu extends AssignmentMenu {

    //class AssignmentMenu
    private boolean boolSubmit = false;
    private Solution theSolution;
    private Assignment theAssignment;

    JLabel lAssignmentName = new JLabel();
    JLabel lDueDate = new JLabel();
    JTextField tbSolution = new JTextField();
    JLabel lSuggestedSolution = new JLabel();
    JLabel lGrade = new JLabel();
    JButton bSubmit = new JButton();
    JButton bCancel = new JButton();

    JLabel jLabel1 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();

    public StudentAssignmentMenu() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        final int x1 = 20, y1 = 36, z1 = 91;
        final int x2 = 258, y2 = 35, z2 = 282;
        final int x3 = 21, y3 = 81, z3 = 92;
        final int x4 = 254, y4 = 82, z4 = 294;
        final int x5 = 24, y5 = 128, z5 = 93;
        final int x6 = 251, y6 = 127, z6 = 211;
        final int x7 = 24, y7 = 124, z7 = 117;
        final int x8 = 23, y8 = 224, z8 = 41;
        final int x9 = 259, y9 = 169, z9 = 201;
        final int x10 = 258, y10 = 226, z10 = 41;
        final int x11 = 476, y11 = 124, z11 = 79;
        final int x12 = 475, y12 = 164, z12 = 79;
        final int height1 = 18;
        final int height2 = 22;
        final int height3 = 29;
        jLabel1.setText("Assignment : ");
        jLabel1.setBounds(new Rectangle(x1, y1, z1, height1));
        this.getContentPane().setLayout(null);
        lAssignmentName.setText("jLabel2");
        lAssignmentName.setBounds(new Rectangle(x2, y2, z2, height1));
        jLabel3.setText("Due Date");
        jLabel3.setBounds(new Rectangle(x3, y3, z3, height1));
        lDueDate.setText("jLabel4");
        lDueDate.setBounds(new Rectangle(x4, y4, z4, height1));
        jLabel5.setText("Solution");
        jLabel5.setBounds(new Rectangle(x5, y5, z5, height1));
        tbSolution.setText("jTextField1");
        tbSolution.setBounds(new Rectangle(x6, y6, z6, height2));
        jLabel6.setText("Suggested Solution");
        jLabel6.setBounds(new Rectangle(x7, y7, z7, height1));
        jLabel7.setText("Grade");
        jLabel7.setBounds(new Rectangle(x8, y8, z8, height1));
        lSuggestedSolution.setText("jLabel8");
        lSuggestedSolution.setBounds(new Rectangle(x9, y9, z9, height1));
        lGrade.setText("jLabel9");
        lGrade.setBounds(new Rectangle(x10, y10, z10, height1));
        bSubmit.setText("Submit");
        bSubmit.setBounds(new Rectangle(x11, y11, z11, height3));
        bSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bSubmitActionPerformed(e);
            }
        });
        bCancel.setText("Cancel");
        bCancel.setBounds(new Rectangle(x12, y12, z12, height3));
        bCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bCancelActionPerformed(e);
            }
        });
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(lAssignmentName, null);
        this.getContentPane().add(lDueDate, null);
        this.getContentPane().add(tbSolution, null);
        this.getContentPane().add(jLabel7, null);
        this.getContentPane().add(lSuggestedSolution, null);
        this.getContentPane().add(lGrade, null);
        this.getContentPane().add(bSubmit, null);
        this.getContentPane().add(bCancel, null);
    }

    /*
     * check if the student has already had a solution or not. if not , create a new
     * solution for the student. after showing the solution attatch the soluiton;
     */
    public void showMenu(Assignment assignment, Person thePerson) {
        theAssignment = assignment;
        SolutionIterator theIter = theAssignment.getSolutionIterator();
        theSolution = (Solution) theIter.next(thePerson.userName);
        if (theSolution == null) {
            tbSolution.setText("");
            lGrade.setText("-1");
        } else {
            tbSolution.setText(theSolution.solutionFileName);
            lGrade.setText(theSolution.getGradeString());

        }

        lAssignmentName.setText(theAssignment.assName);
        lDueDate.setText(theAssignment.dueDate.toString());
        lSuggestedSolution.setText(theAssignment.suggestSolution.solutionFileName);

        show();

        if (boolSubmit) {
            if (theSolution == null) {
                theSolution = new Solution();
                theAssignment.addSolution(theSolution);
            }
            theSolution.theAuthor = thePerson.userName;
            theSolution.solutionFileName = tbSolution.getText();
            theSolution.theSubmitData = new Date();
        }
    }

    void bSubmitActionPerformed(ActionEvent e) {
        boolSubmit = true;
        hide();
    }

    void bCancelActionPerformed(ActionEvent e) {
        boolSubmit = false;
        setVisible(false);
    }

}

