package hacs;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LowLevelCourseMenu extends CourseMenu {
    final int x1 = 389, y1 = 54, w1 = 79, h1 = 29;

    final int x2 = 390, y2 = 125, w2 = 79, h2 = 29;

    final int x3 = 21, y3 = 55, w3 = 103, h3 = 26;
    final int x4 = 21, y4 = 128, w4 = 103, h4 = 26;

    final int x5 = 140, y5 = 57, w5 = 126, h5 = 22;
    final int x6 = 137, y6 = 127, w6 = 126, h6 = 22;

    final int x7 = 290, y7 = 54, w7 = 79, h7 = 29;

    final int x8 = 290, y8 = 124, w8 = 79, h8 = 29;

    final int x9 = 23, y9 = 186, w9 = 432, h9 = 99;
    public LowLevelCourseMenu() {
    }

    void showMenu(Course theCourse) {
        setVisible(true);
    }

    void showAddButtons() {
        assignmentAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assignmentAddButtonActionPerformed(e);
            }
        });
        assignmentAddButton.setText("Add");
        assignmentAddButton.setBounds(new Rectangle(x1, y1, w1, h1));
        optionAddButton.setText("Add");
        optionAddButton.setBounds(new Rectangle(x2, y2, w2, h2));
        this.getContentPane().add(assignmentAddButton, null);
        this.getContentPane().add(optionAddButton, null);
    }

    void showRadios() {
        assignmentRadio.setText("Assignment");
        assignmentRadio.setBounds(new Rectangle(x3, y3, w3, h3));
        this.getContentPane().add(assignmentRadio, null);
        optionRadio.setText("LowLevelExperiment");
        optionRadio.setBounds(new Rectangle(x4, y4, w4, h4));
        this.getContentPane().add(optionRadio, null);
    }

    void showComboxes() {
        assignmentCombox.setBounds(new Rectangle(x5, y5, w5, h5));
        optionCombo.setBounds(new Rectangle(x6, y6, w6, h6));
        this.getContentPane().add(assignmentCombox, null);
        this.getContentPane().add(optionCombo, null);
        refresh();
    }

    void showViewButtons() {
        assignmentViewButton.setText("View");
        assignmentViewButton.setBounds(new Rectangle(x7, y7, w7, h7));
        assignmentViewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assignmentViewButtonActionPerformed(e);
            }
        });
        optionViewButton.setText("View");
        optionViewButton.setBounds(new Rectangle(x8, y8, w8, h8));
        this.getContentPane().add(assignmentViewButton, null);
        this.getContentPane().add(optionViewButton, null);
    }

    void showLabel() {
        assignmentContentLable.setText("AssigmentContent");
        assignmentContentLable.setBounds(new Rectangle(x9, y9, w9, h9));
        this.getContentPane().add(assignmentContentLable, null);
    }
}
