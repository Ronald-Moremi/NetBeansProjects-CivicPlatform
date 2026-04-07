package civicplatform;

import javax.swing.*;

public class LoginForm extends JFrame {

    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginForm() {
        initUI();
    }

    private void initUI() {

        setTitle("Civic Platform Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 100, 25);
        add(emailLabel);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 50, 180, 25);
        add(txtEmail);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 90, 100, 25);
        add(passLabel);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 90, 180, 25);
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 140, 100, 30);
        add(btnLogin);

        btnLogin.addActionListener(e -> login());
    }

    private void login() {

        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());

        if (email.equals("admin@civic.com") && password.equals("1234")) {

            JOptionPane.showMessageDialog(this, "Login Successful!");

            new DashboardForm().setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Invalid Credentials");
        }
    }
}