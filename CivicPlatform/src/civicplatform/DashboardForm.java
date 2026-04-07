package civicplatform;

import javax.swing.*;

public class DashboardForm extends JFrame {

    public DashboardForm() {
        initUI();
        
    }

    private void initUI() {

        setTitle("Civic Platform Dashboard");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton bankingBtn = new JButton("Banking Module");
        bankingBtn.setBounds(150, 80, 200, 40);
        add(bankingBtn);

        JButton docsBtn = new JButton("Document Services");
        docsBtn.setBounds(150, 140, 200, 40);
        add(docsBtn);

        JButton jobsBtn = new JButton("Job Tracker");
        jobsBtn.setBounds(150, 200, 200, 40);
        add(jobsBtn);
        
        bankingBtn.addActionListener(e -> {
    new BankingForm().setVisible(true);
});
    }
}