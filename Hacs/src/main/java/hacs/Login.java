package hacs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Login extends JDialog {
    private static final long serialVersionUID = 1L;
    boolean mbExit = false;
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JButton loginButton = new JButton();
    JButton buttonExit = new JButton();
    JTextField userNameText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JRadioButton studentRadio = new JRadioButton();
    JRadioButton instructorRadio = new JRadioButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    private String userBox = null;
    private UserInfoItem.UserType userType = UserInfoItem.UserType.STUDENT;
    static final int SET_WIDTH = 300;
    static final int SET_HEIGHT = 300;
    final int x1 = 26, y1 = 52, w1 = 80, h1 = 18;
    final int x2 = 23, y2 = 119, w2 = 80, h2 = 18;
    final int x3 = 31, y3 = 212, w3 = 85, h3 = 28;
    final int x4 = 180, y4 = 211, w4 = 97, h4 = 28;
    final int x5 = 119, y5 = 52, w5 = 144, h5 = 22;
    final int x6 = 118, y6 = 119, w6 = 147, h6 = 22;
    final int x7 = 37, y7 = 164, w7 = 103, h7 = 26;
    final int x8 = 177, y8 = 162, w8 = 103, h8 = 26;
    public Login() {
        try {
            jbInit();
            setSize(SET_WIDTH, SET_HEIGHT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        jLabel1.setText("UserName");
        jLabel1.setBounds(new Rectangle(x1, y1, w1, h1));
        jLabel2.setText("Password");
        jLabel2.setBounds(new Rectangle(x2, y2, w2, h2));
        loginButton.setText("Login");
        loginButton.setBounds(new Rectangle(x3, y3, w3, h3));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginButtonActionPerformed(e);
            }
        });
        buttonExit.setText("Exit");
        buttonExit.setBounds(new Rectangle(x4, y4, w4, h4));
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonExitActionPerformed(e);
            }
        });
        userNameText.setBounds(new Rectangle(x5, y5, w5, h5));
        passwordText.setBounds(new Rectangle(x6, y6, w6, h6));
        studentRadio.setSelected(true);
        studentRadio.setText("Student");
        studentRadio.setBounds(new Rectangle(x7, y7, w7, h7));
        instructorRadio.setText("Instructor");
        instructorRadio.setBounds(new Rectangle(x8, y8, w8, h8));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(loginButton, null);
        this.getContentPane().add(buttonExit, null);
        this.getContentPane().add(userNameText, null);
        this.getContentPane().add(passwordText, null);
        this.getContentPane().add(studentRadio, null);
        this.getContentPane().add(instructorRadio, null);
        buttonGroup1.add(studentRadio);
        buttonGroup1.add(instructorRadio);
    }

    void loginButtonActionPerformed(ActionEvent e) {
        BufferedReader file;
        mbExit = false;
        try {
            if (studentRadio.isSelected()) {
                userType = UserInfoItem.UserType.STUDENT;
                file = new BufferedReader(new FileReader("StuInfo.txt"));
            } else {
                userType = UserInfoItem.UserType.INSTRUCTOR;
                file = new BufferedReader(new FileReader("InsInfor.txt"));
            }
            userBox = userNameText.getText();
            String passwordBox = new String(passwordText.getPassword());
            String loginName = null;
            String aline = null, userName = null, password = null;
            while ((aline = file.readLine()) != null) {
                userName = getUserName(aline);
                password = getPassword(aline);
                if (userName.compareTo(userBox) == 0 && password.compareTo(passwordBox) == 0) {
                    loginName = userName;
                }
            }
            if (loginName != null) {
                this.setVisible(false);
            }
        } catch (Exception ee) {
            System.out.println(ee);
        }

    }

    private String getUserName(String aline) {
        int separator = aline.lastIndexOf(':');
        return aline.substring(0, separator);
    }

    /**
     * This method fetches the password corresponding to the given user
     * @param aline represent the input entry
     * @return represents the password post parsing the input entry
     */
    private String getPassword(String aline) {
        int separator = aline.lastIndexOf(':');
        return aline.substring(separator + 1, aline.length());
    }

    public String getUserName() {
        return userBox;
    }

    /**
     *  This method fetches the type of user
     */
    public UserInfoItem.UserType getUserType() {
        return userType;
    }

    public boolean isExit() {
        return mbExit;
    }

    void buttonExitActionPerformed(ActionEvent e) {
        mbExit = true;
        setVisible(false);
    }
}
