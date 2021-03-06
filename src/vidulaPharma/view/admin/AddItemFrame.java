/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.view.admin;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import vidulaPharma.controller.DrugController;
import vidulaPharma.controller.TradeNameController;
import vidulaPharma.etc.AutoCompletion;
import vidulaPharma.model.Drug;
import vidulaPharma.model.TradeName;

/**
 *
 * @author isuru
 */
public class AddItemFrame extends javax.swing.JInternalFrame {

    private static AddItemFrame addItemFrame;
    private AdminMainForm main;
    private ComboBoxModel typeComboModel;

    /**
     * Creates new form AddItemFrame
     */
    private AddItemFrame(AdminMainForm main) {
        try {
            initComponents();
            this.main = main;
            this.setCombo();
            AutoCompletion.enable(nameCombo);
        } catch (SQLException ex) {
            Logger.getLogger(AddItemFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        typeComboModel = typeCombo.getModel();
        refreshAll();
    }

    public static AddItemFrame getInstance(AdminMainForm main) {
        if (AddItemFrame.addItemFrame == null) {
            addItemFrame = new AddItemFrame(main);
        }
        return addItemFrame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jDayChooser2 = new com.toedter.calendar.JDayChooser();
        brandNameLabel = new javax.swing.JLabel();
        addNewGenereButton = new javax.swing.JButton();
        typeLabel = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox();
        doseLabel = new javax.swing.JLabel();
        doseText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        unitPriceText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        nameCombo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        qtyText = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setTitle("Add New Stock");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameDeiconified(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        brandNameLabel.setText("Brand Name ");

        addNewGenereButton.setText("Add New");
        addNewGenereButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewGenereButtonActionPerformed(evt);
            }
        });

        typeLabel.setText("Type");

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Type", "Oinment(Cream)", "Pill", "Tablet", "Liquid" }));
        typeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboActionPerformed(evt);
            }
        });
        typeCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                typeComboKeyReleased(evt);
            }
        });

        doseLabel.setText("Dose");

        doseText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doseTextActionPerformed(evt);
            }
        });

        jLabel1.setText("Unit Price");

        unitPriceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitPriceTextActionPerformed(evt);
            }
        });

        jLabel2.setText("Expire Date");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        nameCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        nameCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameComboActionPerformed(evt);
            }
        });

        jLabel6.setText("Qty");

        dateChooser.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(doseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(brandNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(addNewGenereButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(typeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(doseText)
                    .addComponent(unitPriceText)
                    .addComponent(qtyText)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 428, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brandNameLabel)
                    .addComponent(addNewGenereButton)
                    .addComponent(nameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeLabel)
                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doseLabel)
                    .addComponent(doseText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(unitPriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(qtyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(addButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unitPriceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitPriceTextActionPerformed
        qtyText.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_unitPriceTextActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        TradeName tradeName = null;
        String type = null;
        if (nameCombo.getSelectedIndex() != 0 || nameCombo.getSelectedIndex() != -1) {
            tradeName = (TradeName) nameCombo.getSelectedItem();
        }
        if (typeCombo.getSelectedIndex() != 0 || typeCombo.getSelectedIndex() != -1) {
            type = (String) typeCombo.getSelectedItem();
        }
        String id = tradeName.getTradeId();
        int dose = Integer.parseInt(doseText.getText());
        double unitPrice = Double.parseDouble(unitPriceText.getText());
        String qty = qtyText.getText();
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumIntegerDigits(2);
        format.setMinimumIntegerDigits(2);
        String expDate = ((JTextField) (dateChooser.getDateEditor().getUiComponent())).getText();
        System.out.println(expDate);
        boolean isAdded = false;
        try {
            isAdded = DrugController.addDrug(new Drug(DrugController.getNewId(), id, type, dose, unitPrice, expDate, qty,true));
        } catch (SQLException ex) {
            Logger.getLogger(AddItemFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (isAdded) {
            JOptionPane.showInternalMessageDialog(AddItemFrame.this, "Successfully Added", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            refreshAll();
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void addNewGenereButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewGenereButtonActionPerformed
        // TODO add your handling code here:
        AddNewBrand addNew = AddNewBrand.getInstance(addItemFrame);
        main.addComponent(addNew);
        addNew.setVisible(true);

    }//GEN-LAST:event_addNewGenereButtonActionPerformed

    private void refreshAll() {
        try {
            setCombo();
        } catch (SQLException ex) {
            Logger.getLogger(AddItemFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        typeCombo.setModel(typeComboModel);
        qtyText.setText("");
        doseText.setText("");
        unitPriceText.setText("");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String format = sdf.format(new Date());
        System.out.println(format);
        dateChooser.setDate(new Date());
    }
    private void nameComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameComboActionPerformed
        // TODO add your handling code here:
        typeCombo.requestFocus();
    }//GEN-LAST:event_nameComboActionPerformed

    private void typeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboActionPerformed
        //doseText.requestFocus();
    }//GEN-LAST:event_typeComboActionPerformed

    private void doseTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doseTextActionPerformed

        unitPriceText.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_doseTextActionPerformed

    private void typeComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_typeComboKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            doseText.requestFocus();    // TODO add your handling code here:
        }
    }//GEN-LAST:event_typeComboKeyReleased

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
        try {
            setCombo();
        } catch (SQLException ex) {
            Logger.getLogger(AddItemFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formInternalFrameDeiconified

    private void setCombo() throws SQLException {
        ArrayList<TradeName> nameList = (ArrayList<TradeName>) TradeNameController.getAll();
        Object[] dataArray = nameList.toArray();
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel(dataArray);
        nameCombo.setModel(comboModel);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addNewGenereButton;
    private javax.swing.JLabel brandNameLabel;
    private javax.swing.JButton cancelButton;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel doseLabel;
    private javax.swing.JTextField doseText;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private com.toedter.calendar.JDayChooser jDayChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox nameCombo;
    private javax.swing.JTextField qtyText;
    private javax.swing.JComboBox typeCombo;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JTextField unitPriceText;
    // End of variables declaration//GEN-END:variables
}
