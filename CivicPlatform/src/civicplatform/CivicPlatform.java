package civicplatform;

import javax.swing.SwingUtilities;

public class CivicPlatform {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });

    }
}