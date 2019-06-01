/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DatabaseAccessObjects.ResultObjects.BookIssueConstraintsQueryResult;
import LibraryIncharge.ServerRequests;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class UpdateBookIssueConstraintsForm extends javax.swing.JFrame {

    /**
     * Creates new form verifyStudentForm
     */
    boolean correctInput = true;
    Color forgroundColor = new Color(131, 56, 209);
    Color backgroundColor = new Color(235, 232, 247);
    List<BookIssueConstraintsQueryResult> bookIssueConstraintsQueryResultsSet = new ArrayList<>();

    public UpdateBookIssueConstraintsForm(List<BookIssueConstraintsQueryResult> bookIssueConstraintsQueryResultsSet) {
        initComponents();
        this.bookIssueConstraintsQueryResultsSet = bookIssueConstraintsQueryResultsSet;
        maximumDaysText.setText(String.valueOf(bookIssueConstraintsQueryResultsSet.get(0).constraint_value));
        finePerDayText.setText(String.valueOf(bookIssueConstraintsQueryResultsSet.get(1).constraint_value));
        maximumBooksText.setText(String.valueOf(bookIssueConstraintsQueryResultsSet.get(2).constraint_value));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateBookIssueConstraintsPanel = new javax.swing.JPanel();
        updateBookIssueConstraintsLable = new javax.swing.JLabel();
        maximumDaysTextLabel = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        maximumDaysText = new javax.swing.JTextField();
        maximumBooksText = new javax.swing.JTextField();
        maximumBooksTextLabel = new javax.swing.JLabel();
        finePerDayTextLabel = new javax.swing.JLabel();
        finePerDayText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SKNCOECDIS v.18.1 - Departmental Library");
        setResizable(false);

        updateBookIssueConstraintsPanel.setBackground(new java.awt.Color(235, 232, 247));

        updateBookIssueConstraintsLable.setFont(new java.awt.Font("Century Schoolbook", 3, 28)); // NOI18N
        updateBookIssueConstraintsLable.setForeground(new java.awt.Color(131, 56, 209));
        updateBookIssueConstraintsLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateBookIssueConstraintsLable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/64px/Edit2.png"))); // NOI18N
        updateBookIssueConstraintsLable.setText("Update Constraints");

        maximumDaysTextLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        maximumDaysTextLabel.setForeground(new java.awt.Color(131, 56, 209));
        maximumDaysTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maximumDaysTextLabel.setText("maximum days : ");

        messageLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(131, 56, 209));
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setText("update book issue constraints");

        cancelButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(131, 56, 209));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/32px/CancelButton.png"))); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        updateButton.setForeground(new java.awt.Color(131, 56, 209));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/32px/UpdateButton.png"))); // NOI18N
        updateButton.setText("Update");
        updateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        maximumDaysText.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        maximumDaysText.setForeground(new java.awt.Color(131, 106, 209));
        maximumDaysText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 106, 209)));
        maximumDaysText.setSelectionColor(new java.awt.Color(203, 192, 235));
        maximumDaysText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                maximumDaysTextKeyReleased(evt);
            }
        });

        maximumBooksText.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        maximumBooksText.setForeground(new java.awt.Color(131, 106, 209));
        maximumBooksText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 106, 209)));
        maximumBooksText.setSelectionColor(new java.awt.Color(203, 192, 235));
        maximumBooksText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                maximumBooksTextKeyReleased(evt);
            }
        });

        maximumBooksTextLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        maximumBooksTextLabel.setForeground(new java.awt.Color(131, 56, 209));
        maximumBooksTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maximumBooksTextLabel.setText("maximum books : ");

        finePerDayTextLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        finePerDayTextLabel.setForeground(new java.awt.Color(131, 56, 209));
        finePerDayTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        finePerDayTextLabel.setText("fine per day : ");

        finePerDayText.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        finePerDayText.setForeground(new java.awt.Color(131, 106, 209));
        finePerDayText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 106, 209)));
        finePerDayText.setSelectionColor(new java.awt.Color(203, 192, 235));
        finePerDayText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finePerDayTextActionPerformed(evt);
            }
        });
        finePerDayText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                finePerDayTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout updateBookIssueConstraintsPanelLayout = new javax.swing.GroupLayout(updateBookIssueConstraintsPanel);
        updateBookIssueConstraintsPanel.setLayout(updateBookIssueConstraintsPanelLayout);
        updateBookIssueConstraintsPanelLayout.setHorizontalGroup(
            updateBookIssueConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateBookIssueConstraintsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updateBookIssueConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateBookIssueConstraintsLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateBookIssueConstraintsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(updateBookIssueConstraintsPanelLayout.createSequentialGroup()
                        .addGroup(updateBookIssueConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maximumBooksTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(maximumDaysTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(finePerDayTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(updateBookIssueConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maximumBooksText, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                            .addComponent(maximumDaysText)
                            .addComponent(finePerDayText))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        updateBookIssueConstraintsPanelLayout.setVerticalGroup(
            updateBookIssueConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateBookIssueConstraintsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateBookIssueConstraintsLable, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(updateBookIssueConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finePerDayTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finePerDayText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updateBookIssueConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maximumDaysTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maximumDaysText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updateBookIssueConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maximumBooksTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maximumBooksText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(updateBookIssueConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updateBookIssueConstraintsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updateBookIssueConstraintsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        boolean enteredAllAttributes = true;
        try {
            if (!maximumDaysText.getText().equals("")) {
                bookIssueConstraintsQueryResultsSet.get(0).constraint_value = Integer.parseInt(maximumDaysText.getText());
            } else {
                enteredAllAttributes = false;
            }
            if (!finePerDayText.getText().equals("")) {
                bookIssueConstraintsQueryResultsSet.get(1).constraint_value = Integer.parseInt(finePerDayText.getText());
            } else {
                enteredAllAttributes = false;
            }
            if (!maximumBooksText.getText().equals("")) {
                bookIssueConstraintsQueryResultsSet.get(2).constraint_value = Integer.parseInt(maximumBooksText.getText());
            } else {
                enteredAllAttributes = false;
            }
            if (enteredAllAttributes && correctInput) {
                boolean updated_successfully;
                updated_successfully = ServerRequests.updateBookIssueConstraints(bookIssueConstraintsQueryResultsSet);
                if (updated_successfully) {
                    GUI.libraryInchargeInterfacePanel.showRequestResult("book issue constraints updated successfully");
                } else {
                    GUI.libraryInchargeInterfacePanel.showRequestResult("book issue constraints didn't updated");
                }
                GUI.libraryInchargeInterfaceFrame.setEnabled(true);
                this.dispose();
            } else if (!enteredAllAttributes) {
                JOptionPane.showMessageDialog(null, "all fields are mandatory");
            } else if (!correctInput) {
                JOptionPane.showMessageDialog(null, "incorrect input");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "invalid number format");
        } catch (IOException ex) {
            Logger.getLogger(AddReportTitleForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateBookIssueConstraintsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        GUI.libraryInchargeInterfacePanel.showRequestResult("book issue constraints didn't updated");
        GUI.libraryInchargeInterfaceFrame.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void maximumDaysTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maximumDaysTextKeyReleased
        try {
            if (Integer.parseInt(maximumDaysText.getText()) >= 65535 || Integer.parseInt(maximumDaysText.getText()) < 1) {
                messageLabel.setForeground(Color.MAGENTA);
                messageLabel.setText("*maximum range is 0-65535");
                maximumDaysText.setForeground(Color.MAGENTA);
                correctInput = false;
            } else {
                messageLabel.setForeground(forgroundColor);
                messageLabel.setText("update book issue constraints");
                maximumDaysText.setForeground(forgroundColor);
                correctInput = true;
            }
        } catch (NumberFormatException e) {
            messageLabel.setForeground(Color.MAGENTA);
            messageLabel.setText("*number input only");
            maximumDaysText.setForeground(Color.MAGENTA);
            correctInput = false;
        }
    }//GEN-LAST:event_maximumDaysTextKeyReleased

    private void maximumBooksTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maximumBooksTextKeyReleased
        try {
            if (Integer.parseInt(maximumBooksText.getText()) >= 65535 || Integer.parseInt(maximumBooksText.getText()) < 1) {
                messageLabel.setForeground(Color.MAGENTA);
                messageLabel.setText("*maximum range is 0-65535");
                maximumBooksText.setForeground(Color.MAGENTA);
                correctInput = false;
            } else {
                messageLabel.setForeground(forgroundColor);
                messageLabel.setText("update book issue constraints");
                maximumBooksText.setForeground(forgroundColor);
                correctInput = true;
            }
        } catch (NumberFormatException e) {
            messageLabel.setForeground(Color.MAGENTA);
            messageLabel.setText("*number input only");
            maximumBooksText.setForeground(Color.MAGENTA);
            correctInput = false;
        }
    }//GEN-LAST:event_maximumBooksTextKeyReleased

    private void finePerDayTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_finePerDayTextKeyReleased
        try {
            if (Integer.parseInt(maximumBooksText.getText()) >= 65535 || Integer.parseInt(maximumBooksText.getText()) < 1) {
                messageLabel.setForeground(Color.MAGENTA);
                messageLabel.setText("*maximum range is 0-65535");
                finePerDayText.setForeground(Color.MAGENTA);
                correctInput = false;
            } else {
                messageLabel.setForeground(forgroundColor);
                messageLabel.setText("update book issue constraints");
                finePerDayText.setForeground(forgroundColor);
                correctInput = true;
            }
        } catch (NumberFormatException e) {
            messageLabel.setForeground(Color.MAGENTA);
            messageLabel.setText("*number input only");
            finePerDayText.setForeground(Color.MAGENTA);
            correctInput = false;
        }
    }//GEN-LAST:event_finePerDayTextKeyReleased

    private void finePerDayTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finePerDayTextActionPerformed

    }//GEN-LAST:event_finePerDayTextActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(verifyStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(verifyStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(verifyStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(verifyStudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VerifyStudentForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField finePerDayText;
    private javax.swing.JLabel finePerDayTextLabel;
    private javax.swing.JTextField maximumBooksText;
    private javax.swing.JLabel maximumBooksTextLabel;
    private javax.swing.JTextField maximumDaysText;
    private javax.swing.JLabel maximumDaysTextLabel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel updateBookIssueConstraintsLable;
    private javax.swing.JPanel updateBookIssueConstraintsPanel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
