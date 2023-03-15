import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPassword = new JPasswordField();
    JLabel userIdLabel = new JLabel("Username");
    JLabel userPasswordLabel = new JLabel("Password");
    JLabel messageLabel = new JLabel("Please log in");

    private HashMap<String, String> loginInfo;

    public LoginPage(HashMap<String, String> input) {
        this.loginInfo = input;

        userIdLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 50, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        userPassword.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPassword);
        frame.add(loginButton);
        frame.add(resetButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()==resetButton) {
             userIDField.setText("");
             userPassword.setText("");
         }

         if (e.getSource()==loginButton) {
             String userId = userIDField.getText();
             String userPasswordInserted = String.valueOf(this.userPassword.getPassword());

             if (this.loginInfo.containsKey(userId)) {
                 if (this.loginInfo.get(userId).equals(userPasswordInserted)) {
                     messageLabel.setForeground(Color.green);
                     messageLabel.setText("Login successful!");
                     frame.dispose();
                     WelcomePage welcomePage = new WelcomePage(userId);
                 } else {
                     messageLabel.setForeground(Color.red);
                     messageLabel.setText("Wrong password!");
                 }
             } else {
                 messageLabel.setForeground(Color.RED);
                 messageLabel.setText("Username not found!");
             }
         }
    }
}
