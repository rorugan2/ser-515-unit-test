package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */
public class InstructorAssignmentMenu extends AssignmentMenu {
    final int l1 = 25, l2 = 31, l3 = 118, l4 = 18;
    final int l5 = 192, l6 = 341, l7 = 22, l8 = 28;
    final int l9 = 90, l10 = 113, l11 = 195, l12 = 87;
    final int l13 = 337, l14 = 151, l15 = 197, l16 = 149;
    final int l17 = 339, l18 = 458, l19 = 199, l20 = 79;
    final int l21 = 29, l22 = 365, l23 = 249, l24 = 253;
    final int l25 = 86, l26 = 32, l27 = 413, l28 = 204;

    /*class AssignmentMenu*/
    private boolean bSubmit = false;
    private Solution theSolution;
    private Assignment theAssignment;
    JComboBox combSolutionList = new JComboBox();
    JTextField tbAssignmentName = new JTextField();
    JTextField tbDueDate = new JTextField();
    JTextField tbSuggestedSolution = new JTextField();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JButton buttonGrade = new JButton();
    JButton buttonReport = new JButton();
    JButton buttonClose = new JButton();
    public InstructorAssignmentMenu() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void jbInit() throws Exception {
        jLabel1.setText("Assignment Name");
        jLabel1.setBounds(new Rectangle(l1, l2, l3, l4));
        this.getContentPane().setLayout(null);
        tbAssignmentName.setText("jTextField1");
        tbAssignmentName.setBounds(new Rectangle(l5, l2, l6, l7));
        jLabel2.setText("Due Date");
        jLabel2.setBounds(new Rectangle(l8, l9, l10, l4));
        tbDueDate.setText("tbDueDate");
        tbDueDate.setBounds(new Rectangle(l11, l12, l13, l7));
        jLabel3.setText("Suggested Solution");
        jLabel3.setBounds(new Rectangle(l8, l14, l3, l4));
        tbSuggestedSolution.setText("jTextField2");
        tbSuggestedSolution.setBounds(new Rectangle(l15, l16, l17, l7));
        buttonGrade.setText("Grade");
        buttonGrade.setBounds(new Rectangle(l18, l19, l20, l21));
        buttonGrade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonGradeActionPerformed(e);
            }
        });
        buttonReport.setText("Report");
        buttonReport.setBounds(new Rectangle(l22, l23, l20, l21));
        buttonReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonReportActionPerformed(e);
            }
        });
        buttonClose.setText("Close");
        buttonClose.setBounds(new Rectangle(l25, l24, l20, l21));
        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonCloseActionPerformed(e);
            }
        });
        combSolutionList.setBounds(new Rectangle(l26, l28, l27, l7));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tbAssignmentName, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(tbDueDate, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(tbSuggestedSolution, null);
        this.getContentPane().add(buttonClose, null);
        this.getContentPane().add(combSolutionList, null);
        this.getContentPane().add(buttonGrade, null);
        this.getContentPane().add(buttonReport, null);
    }
    public void showMenu(Assignment assignment, Person person) {
        theAssignment = assignment;
        tbAssignmentName.setText(theAssignment.assName);

        DateFormat theDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        tbDueDate.setText(theDateFormat.format(theAssignment.dueDate));
        tbSuggestedSolution.setText(theAssignment.suggestSolution.solutionFileName);
        refreshSolutionList();
        setVisible(true);
    }

    void buttonCloseActionPerformed(ActionEvent e) {
        theAssignment.assName = tbAssignmentName.getText();
        DateFormat tempDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        try {
            theAssignment.dueDate = tempDateFormat.parse(tbDueDate.getText());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        theAssignment.suggestSolution.solutionFileName = tbSuggestedSolution.getText();
        setVisible(false);
    }

    void buttonGradeActionPerformed(ActionEvent e) {
        Solution sol = (Solution) combSolutionList.getSelectedItem();
        if (sol == null) {
            return;
        }
        SolutionGradingDlg dlg = new SolutionGradingDlg();
        dlg.show(sol);
        refreshSolutionList();
    }

    void buttonReportActionPerformed(ActionEvent e) {
        SolutionIterator iter = new SolutionIterator(theAssignment.theSolutionList);
        while (iter.hasNext()) {
            Solution asolution = (Solution) iter.next();
            asolution.setReported(true);
        }
        refreshSolutionList();
    }
    private void refreshSolutionList() {
        combSolutionList.removeAllItems();
        SolutionIterator solIter = new SolutionIterator(theAssignment.theSolutionList);
        while (solIter.hasNext()) {
            theSolution = (Solution) solIter.next();
            combSolutionList.addItem(theSolution);
        }
    }
}
