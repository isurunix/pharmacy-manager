/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vidulaPharma.view.admin;

import java.awt.Dimension;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import vidulaPharma.controller.DrugController;
import vidulaPharma.controller.PharmaNameController;
import vidulaPharma.controller.TradeNameController;
import vidulaPharma.model.Drug;
import vidulaPharma.model.TradeName;

/**
 *
 * @author isuru
 */
public class ViewLowStockForm extends javax.swing.JInternalFrame {

    private static ViewLowStockForm lowStockForm;
    DefaultTableModel defTableModel;
    ArrayList<Drug> lowOnStock = null;
    /**
     * Creates new form ViewLowStockForm
     */
    private ViewLowStockForm() {
        initComponents();
        this.setMaximumSize(new Dimension(this.getMaximumSize()));
        defTableModel = (DefaultTableModel) stockTable.getModel();
        setTableData();
    }

    private void setTableData() {
        
        try {
            lowOnStock = (ArrayList<Drug>) DrugController.getLowOnStock();
        } catch (SQLException ex) {
            Logger.getLogger(ViewLowStockForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Drug drug : lowOnStock) {
            try {
                TradeName tradeName = TradeNameController.searchTradeId(drug.getDrugNameId());
                Object rowData[] = {tradeName,drug.getQtyOnHand()};
                defTableModel.addRow(rowData);
            } catch (SQLException ex) {
                Logger.getLogger(ViewLowStockForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ViewLowStockForm getInstance() {
        if (lowStockForm == null) {
            lowStockForm = new ViewLowStockForm();
        }
        return lowStockForm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        orderButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Items low on stock");
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
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Qty on Hand"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(stockTable);
        stockTable.getColumnModel().getColumn(0).setResizable(false);
        stockTable.getColumnModel().getColumn(1).setResizable(false);

        orderButton.setText("Order");
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(orderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderButton)
                    .addComponent(printButton)
                    .addComponent(cancelButton))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try {
            boolean print = stockTable.print();
        } catch (PrinterException ex) {
            Logger.getLogger(ViewLowStockForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButtonActionPerformed
        AddOrderForm orderForm = AddOrderForm.getInstance();
        System.out.println(lowOnStock.get(stockTable.getSelectedColumn()));
        
        AdminMainForm admin = AdminMainForm.getInstance();
        admin.showForm(orderForm);
        orderForm.setDrug(lowOnStock.get(stockTable.getSelectedRow()));
        //orderForm.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_orderButtonActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        setTableData();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton orderButton;
    private javax.swing.JButton printButton;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables
}
