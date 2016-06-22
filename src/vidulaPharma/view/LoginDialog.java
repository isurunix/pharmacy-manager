/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.view;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import javax.swing.UIManager;
import vidulaPharma.view.admin.AdminMainForm;
import vidulaPharma.view.pharmacist.PharamacistForm;

/**
 *
 * @author isuru
 */
public class LoginDialog extends javax.swing.JDialog {

    /**
     * Creates new form LoginDialog
     */
    public LoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userLabel = new javax.swing.JLabel();
        pwdLabel = new javax.swing.JLabel();
        unameText = new javax.swing.JTextField();
        passText = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User Login");

        userLabel.setText("Username");

        pwdLabel.setText("Password");

        unameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameTextActionPerformed(evt);
            }
        });

        passText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTextActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel)
                    .addComponent(pwdLabel))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passText)
                    .addComponent(unameText, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(unameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdLabel)
                    .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        char[] passwd = passText.getPassword();
        String pwd = "";
        for (char ch : passwd) {
            pwd = pwd + ch;
        }
        if ("admin".equals(unameText.getText()) && "admin123".equals(pwd)) {
            new AdminMainForm().setVisible(true);
            LoginDialog.this.dispose();
        }else if("user".equals(unameText.getText()) && pwd.isEmpty()){
            new PharamacistForm().setVisible(true);
            LoginDialog.this.dispose();
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void unameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameTextActionPerformed
        passText.requestFocus();
    }//GEN-LAST:event_unameTextActionPerformed

    private void passTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passTextActionPerformed
        // TODO add your handling code here:
        loginButtonActionPerformed(evt);
    }//GEN-LAST:event_passTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //AluminiumLookAndFeel laf = new AluminiumLookAndFeel();
        try {
            UIManager.setLookAndFeel(new AcrylLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginDialog dialog = new LoginDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passText;
    private javax.swing.JLabel pwdLabel;
    private javax.swing.JTextField unameText;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
