/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.view.admin;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vidulaPharma.controller.SupplierController;
import vidulaPharma.etc.Validate;
import vidulaPharma.model.Supplier;

/**
 *
 * @author isuru
 */
public class AddSupplierFrame extends javax.swing.JInternalFrame {

    private static AddSupplierFrame addSupplierFrame;

    /**
     * Creates new form AddSupplierFrame
     */
    private AddSupplierFrame() {
        initComponents();
    }

    public static AddSupplierFrame getInstance() {
        if (AddSupplierFrame.addSupplierFrame == null) {
            addSupplierFrame = new AddSupplierFrame();
        }
        return addSupplierFrame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addressText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        telephoneLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        telephoneText = new javax.swing.JTextField();
        cancelButton1 = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Add Supplier");
        setPreferredSize(new java.awt.Dimension(667, 300));

        addressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextActionPerformed(evt);
            }
        });

        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        telephoneLabel.setText("Telephone");

        addressLabel.setText("Address");

        nameLabel.setText(" Name");

        telephoneText.setEditable(false);
        telephoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneTextActionPerformed(evt);
            }
        });
        telephoneText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                telephoneTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                telephoneTextKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telephoneTextKeyTyped(evt);
            }
        });

        cancelButton1.setText("Cancel");
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(addressLabel)
                            .addComponent(telephoneLabel))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressText)
                            .addComponent(nameText)
                            .addComponent(telephoneText, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneLabel))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton1)
                    .addComponent(addButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telephoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneTextActionPerformed
        // TODO add your handling code here:
        addButtonActionPerformed(evt);
    }//GEN-LAST:event_telephoneTextActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        //try {
        // TODO add your handling code here:
        String name = nameText.getText();
        String address = addressText.getText();
        String phone = telephoneText.getText();
        String id = null;
        try {
            id = SupplierController.getNewId();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(AddSupplierFrame.this, "SQL ERROR @ ID : " + ex.getLocalizedMessage());
        }

        System.out.println(id);

        Supplier supplier = new Supplier(id, name, address, phone);

        boolean isAdded = false;
        try {
            isAdded = SupplierController.addSupplier(supplier);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(AddSupplierFrame.this, "SQL ERROR WHILE ADDING");
        }
        if (isAdded) {
            JOptionPane.showMessageDialog(AddSupplierFrame.this, "Added Succesfully");
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
        addressText.requestFocus();
    }//GEN-LAST:event_nameTextActionPerformed

    private void addressTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextActionPerformed
        // TODO add your handling code here:
        telephoneText.setEditable(true);
        telephoneText.requestFocus();
        //telephoneText.setEditable(true);
    }//GEN-LAST:event_addressTextActionPerformed

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        // TODO add your handling code here:
        AddSupplierFrame.this.dispose();
    }//GEN-LAST:event_cancelButton1ActionPerformed

    private void telephoneTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephoneTextKeyPressed
    }//GEN-LAST:event_telephoneTextKeyPressed

    private void telephoneTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephoneTextKeyTyped
        // TODO add your handling code here:
        char keyChar = evt.getKeyChar();
        if(!Character.isDigit(keyChar)){
            evt.consume();
        }
    }//GEN-LAST:event_telephoneTextKeyTyped

    private void telephoneTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephoneTextKeyReleased
         // TODO add your handling code here:
    }//GEN-LAST:event_telephoneTextKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressText;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JTextField telephoneText;
    // End of variables declaration//GEN-END:variables
}
