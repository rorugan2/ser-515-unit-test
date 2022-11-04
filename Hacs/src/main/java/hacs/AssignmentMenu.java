package hacs;
import javax.swing.*;
/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author mjfindler
 * @version 1.0
 * @author Ram Nagesh Oruganti
 * @version 2.0
 */
abstract class AssignmentMenu extends JDialog {
    final int len = 575;
    final int height = 330;
    abstract void showMenu(Assignment ass, Person per);
    public AssignmentMenu() {
        setModal(true);
        setSize(len, height);
    }
}
