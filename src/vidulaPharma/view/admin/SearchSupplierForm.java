/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.view.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import vidulaPharma.controller.SupplierController;
import vidulaPharma.etc.Validate;
import vidulaPharma.model.Supplier;

/**
 *
 * @author isuru
 */
public class SearchSupplierForm extends javax.swing.JInternalFrame {

    private static SearchSupplierForm searchSupplierForm;
    private Supplier supplier;
    boolean isFirst = true;
    /**
     * Creates new form SearchSupplierForm
     */
    private SearchSupplierForm() {
        initComponents();
    }

    public static SearchSupplierForm getInstance() {
        if (searchSupplierForm == null) {
            searchSupplierForm = new SearchSupplierForm();
        }
        return searchSupplierForm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telephoneText = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        telephoneLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        nameText = new javax.swing.JTextField();
        cancelButton1 = new javax.swing.JButton();
        addressText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplierList = new javax.swing.JList();
        searchText = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Search Supplier");

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

        addressLabel.setText("Address");

        nameLabel.setText(" Name");

        telephoneLabel.setText("Telephone");

        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        nameText.setEditable(false);
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        cancelButton1.setText("Cancel");
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });

        addressText.setEditable(false);
        addressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextActionPerformed(evt);
            }
        });

        supplierList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        supplierList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(supplierList);

        searchText.setText("Type and Press Enter");
        searchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextKeyTyped(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchText)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(telephoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(cancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(telephoneText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addComponent(nameText)
                    .addComponent(addressText))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLabel)
                            .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telephoneLabel)
                            .addComponent(telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton1)
                            .addComponent(saveButton)
                            .addComponent(editButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telephoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneTextActionPerformed
        // TODO add your handling code here:
        //ddBauttonActionPerformed(evt);
    }//GEN-LAST:event_telephoneTextActionPerformed

    private void telephoneTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephoneTextKeyPressed
    }//GEN-LAST:event_telephoneTextKeyPressed

    private void telephoneTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephoneTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneTextKeyReleased

    private void telephoneTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephoneTextKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneTextKeyTyped

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //try {
        // TODO add your handling code here:
        String name = nameText.getText();
        String address = addressText.getText();
        String phone = telephoneText.getText();
        String id = supplier.getSupplierId();
        boolean isUpdated = false;
        if(!name.isEmpty() && !address.isEmpty() && Validate.validateTelephone(phone)){
            try {
                isUpdated = SupplierController.editSupplier(new Supplier(id, name, address, phone));
            } catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(SearchSupplierForm.this, "ERROR : UPDATE FAILED !", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            if (isUpdated) {
                JOptionPane.showInternalMessageDialog(SearchSupplierForm.this, "Update Successful", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

            }
        }else{
            JOptionPane.showInternalMessageDialog(SearchSupplierForm.this, "ERROR : FILL THE FIELDS CORRECTLY"+name.isEmpty(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_saveButtonActionPerformed

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
        addressText.requestFocus();
    }//GEN-LAST:event_nameTextActionPerformed

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        // TODO add your handling code here:
        SearchSupplierForm.this.dispose();
    }//GEN-LAST:event_cancelButton1ActionPerformed

    private void addressTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextActionPerformed
        // TODO add your handling code here:
        telephoneText.setEditable(true);
        telephoneText.requestFocus();
        //telephoneText.setEditable(true);
    }//GEN-LAST:event_addressTextActionPerformed

    private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
        // TODO add your handling code here:
        //
    }//GEN-LAST:event_searchTextActionPerformed

    private void searchTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyTyped
                // TODO add your handling code here:
        if(isFirst){
            searchText.setText("");
            isFirst=false;
        }
        if (!searchText.getText().isEmpty()) {
            this.setListData();
        }
    }//GEN-LAST:event_searchTextKeyTyped

    private void supplierListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierListMouseClicked
        Supplier supplier = (Supplier) supplierList.getSelectedValue();

        if (supplier != null) {
            this.supplier = supplier;
            nameText.setText(supplier.getSupplierName());
            addressText.setText(supplier.getSupplierAddress());
            telephoneText.setText(supplier.getSupplierTelephone());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierListMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        nameText.setEditable(true);
        addressText.setEditable(true);
        telephoneText.setEditable(true);
        nameText.requestFocus();
        saveButton.setEnabled(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void setListData() {
        ArrayList<Supplier> suppliers = null;
        try {
            suppliers = (ArrayList<Supplier>) SupplierController.searchSupplier(searchText.getText(), "name");
        } catch (SQLException ex) {
            Logger.getLogger(SearchSupplierForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultListModel listModel = new DefaultListModel();
        for (Supplier sup : suppliers) {
            listModel.addElement(sup);
        }
        supplierList.setModel(listModel);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressText;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField searchText;
    private javax.swing.JList supplierList;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JTextField telephoneText;
    // End of variables declaration//GEN-END:variables
}
