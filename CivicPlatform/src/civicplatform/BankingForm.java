/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ronald
 */
package civicplatform;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BankingForm extends JFrame {

    private JTextField txtAccNumber, txtName, txtAmount;
    private JButton btnCreate, btnDeposit, btnWithdraw;
    private JTable table;
    private DefaultTableModel model;

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public BankingForm() {
        initUI();
        
    }

    private void initUI() {

        setTitle("Banking Module");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lbl1 = new JLabel("Account Number:");
        lbl1.setBounds(20, 20, 120, 25);
        add(lbl1);

        txtAccNumber = new JTextField();
        txtAccNumber.setBounds(150, 20, 150, 25);
        add(txtAccNumber);

        JLabel lbl2 = new JLabel("Name:");
        lbl2.setBounds(20, 60, 120, 25);
        add(lbl2);

        txtName = new JTextField();
        txtName.setBounds(150, 60, 150, 25);
        add(txtName);

        JLabel lbl3 = new JLabel("Amount:");
        lbl3.setBounds(20, 100, 120, 25);
        add(lbl3);

        txtAmount = new JTextField();
        txtAmount.setBounds(150, 100, 150, 25);
        add(txtAmount);

        btnCreate = new JButton("Create Account");
        btnCreate.setBounds(350, 20, 200, 30);
        add(btnCreate);

        btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(350, 60, 200, 30);
        add(btnDeposit);

        btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(350, 100, 200, 30);
        add(btnWithdraw);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Account No", "Name", "Balance"});

        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 160, 530, 220);
        add(sp);

        btnCreate.addActionListener(e -> createAccount());
        btnDeposit.addActionListener(e -> deposit());
        btnWithdraw.addActionListener(e -> withdraw());
    }

    private BankAccount findAccount(String accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNo)) {
                return acc;
            }
        }
        return null;
    }

    private void createAccount() {

    String accNo = txtAccNumber.getText();
    String name = txtName.getText();

    if (accNo.isEmpty() || name.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields!");
        return;
    }

    BankAccount acc = new BankAccount(accNo, name, 0.0);
    accounts.add(acc);

    refreshTable();

    // ✅ CLEAR FIELDS AFTER CREATION
    txtAccNumber.setText("");
    txtName.setText("");
    txtAmount.setText("");

    JOptionPane.showMessageDialog(this, "Account Created Successfully!");
}

    private void deposit() {

    String accNo = txtAccNumber.getText();

    if (txtAmount.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter amount!");
        return;
    }

    double amount = Double.parseDouble(txtAmount.getText());

    BankAccount acc = findAccount(accNo);

    if (acc != null) {
        acc.deposit(amount);
        refreshTable();

        txtAmount.setText(""); // clear amount field

        JOptionPane.showMessageDialog(this, "Deposit Successful!");
    } else {
        JOptionPane.showMessageDialog(this, "Account Not Found!");
    }
}

    private void withdraw() {

    String accNo = txtAccNumber.getText();

    if (txtAmount.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter amount!");
        return;
    }

    double amount = Double.parseDouble(txtAmount.getText());

    BankAccount acc = findAccount(accNo);

    if (acc != null) {
        if (acc.withdraw(amount)) {
            refreshTable();

            txtAmount.setText(""); // clear amount field

            JOptionPane.showMessageDialog(this, "Withdraw Successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Insufficient Funds!");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Account Not Found!");
    }
}

    private void refreshTable() {

        model.setRowCount(0);

        for (BankAccount acc : accounts) {
            model.addRow(new Object[]{
                acc.getAccountNumber(),
                acc.getAccountHolder(),
                acc.getBalance()
            });
        }
    }
}
