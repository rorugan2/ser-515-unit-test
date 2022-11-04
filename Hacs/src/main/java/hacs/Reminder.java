package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: asu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class Reminder extends JDialog {
    final int l1 = 400;
    final int l2 = 386;
    final int l3 = 38;
    final int l4 = 40;
    final int l5 = 159;
    final int l6 = 17;
    final int l7 = 39;
    final int l8 = 160;
    final int l9 = 161;
    final int l10 = 29;
    final int l11 = 65;
    final int l12 = 340;
    final int l13 = 79;
    final int l14 = 31;
    final int l15 = 187;
    final int l16 = 337;
    final int l17 = 85;
    final int l18 = 149;
    final int l19 = 308;
    final int l20 = 67;
    final int l21 = 37;
    ClassCourseList courseList;
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    java.awt.List listUpcoming = new java.awt.List();
    java.awt.List listOverdue = new java.awt.List();
    Button buttonOK = new Button();

    public Reminder() {
        try {
            jbInit();
            setModal(true);
            setSize(l1, l2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText("Upcoming assignments");
        jLabel1.setBounds(new Rectangle(l3, l4, l5, l6));
        this.getContentPane().setLayout(null);
        jLabel2.setText("OverDue Assignments");
        jLabel2.setBounds(new Rectangle(l7, l8, l9, l6));
        listUpcoming.setBounds(new Rectangle(l10, l11, l12, l13));
        listOverdue.setBounds(new Rectangle(l14, l15, l16, l17));
        buttonOK.setLabel("OK");
        buttonOK.setBounds(new Rectangle(l18, l19, l20, l21));
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonOkActionPerformed(e);
            }
        });
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(listUpcoming, null);
        this.getContentPane().add(listOverdue, null);
        this.getContentPane().add(buttonOK, null);
    }

    void showReminder(ClassCourseList clsCourseList) {
        Assignment assignment;
        ReminderVisitor visitor = new ReminderVisitor(this);
        visitor.visitFacade(Hacs.theFacade);
        setVisible(true);
    }

    void buttonOkActionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
