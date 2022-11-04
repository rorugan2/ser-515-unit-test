package hacs;
/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighLevelCourseMenu extends CourseMenu {
    final int l1 = 389, l2 = 54, l3 = 79, l4 = 29;
    final int x1 = 390, x2 = 125, x3 = 21, x4 = 55;
    final int y1 = 103, y2 = 26, y3 = 128, y4 = 140;
    final int z1 = 57, z2 = 126, z3 = 22, z4 = 137;
    final int a1 = 127, a2 = 290, a3 = 79, a4 = 124;
    final int b1 = 54, b2 = 23, b3 = 186, b4 = 99, b5 = 432;

    /*
     * JButton AssignmentAddButton = new JButton(); JRadioButton OptionRadio = new
     * JRadioButton(); JComboBox OptionCombo = new JComboBox(); JButton
     * OptionViewButton = new JButton(); JButton OptionAddButton = new JButton();
     */

    public HighLevelCourseMenu() {
    }

    void showMenu(Course theCourse) {
        showViewButtons();
        showRadios();
        showComboxes();
        setVisible(true);
    }

    void showAddButtons() {
        assignmentAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assignmentAddButtonActionPerformed(e);
            }
        });
        assignmentAddButton.setText("Add");
        assignmentAddButton.setBounds(new Rectangle(l1, l2, l3, l4));
        optionAddButton.setText("Add");
        optionAddButton.setBounds(new Rectangle(x1, x2, l3, l4));
        this.getContentPane().add(assignmentAddButton, null);
        this.getContentPane().add(optionAddButton, null);
    }

    void showRadios() {
        assignmentRadio.setText("Assignment");
        assignmentRadio.setBounds(new Rectangle(x3, x4, y1, y2));
        this.getContentPane().add(assignmentRadio, null);
        optionRadio.setText("HighLevel Presentation");
        optionRadio.setBounds(new Rectangle(x3, y3, y1, y2));
        this.getContentPane().add(optionRadio, null);
    }

    void showComboxes() {
        assignmentCombox.setBounds(new Rectangle(y4, z1, z2, z3));
        optionCombo.setBounds(new Rectangle(z4, a1, z2, z3));
        this.getContentPane().add(assignmentCombox, null);
        this.getContentPane().add(optionCombo, null);
        refresh();
    }

    void showViewButtons() {
        assignmentViewButton.setText("View");
        assignmentViewButton.setBounds(new Rectangle(a2, b1, a3, l4));
        assignmentViewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                assignmentViewButtonActionPerformed(e);
            }
        });
        optionViewButton.setText("View");
        optionViewButton.setBounds(new Rectangle(a2, a4, a3, l4));
        this.getContentPane().add(assignmentViewButton, null);
        this.getContentPane().add(optionViewButton, null);
    }

    void showLabel() {
        assignmentContentLable.setText("AssigmentContent");
        assignmentContentLable.setBounds(new Rectangle(b2, b3, b5, b4));
        this.getContentPane().add(assignmentContentLable, null);
    }
}
