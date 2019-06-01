/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DatabaseAccessObjects.QueryObjects.AddReportTitleAttributes;
import DatabaseAccessObjects.ResultObjects.DomainQueryResult;
import DatabaseAccessObjects.ResultObjects.ReportTitleQueryResult;
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
public class UpdateReportTitleForm extends javax.swing.JFrame {

    /**
     * Creates new form verifyStudentForm
     */
    boolean correctInput = true;
    Color forgroundColor = new Color(131, 56, 209);
    Color backgroundColor=new Color(235, 232, 247);
    List<ReportTitleQueryResult> reportTitleQueryResultList=new ArrayList<>();
    List<DomainQueryResult> domainQueryResultList=new ArrayList<>();
  

    public UpdateReportTitleForm(List<ReportTitleQueryResult> reportTitleQueryResultList, List<DomainQueryResult> domainQueryResultList) {
        initComponents();
        this.reportTitleQueryResultList=reportTitleQueryResultList;
        this.domainQueryResultList=domainQueryResultList;
        
         domainIDComboBox.removeAllItems();
        for (int i = 0; i < domainQueryResultList.size(); i++) {
            domainIDComboBox.addItem(domainQueryResultList.get(i).domain_id + " : " + domainQueryResultList.get(i).domain_name);
        }
        domainIDComboBox.setSelectedIndex(-1);
        domainIDComboBox.setForeground(forgroundColor);
        domainIDComboBox.setBackground(backgroundColor);
        
        selectReportIDComboBox.removeAllItems();
        for (int i = 0; i < this.reportTitleQueryResultList.size(); i++) {
            selectReportIDComboBox.addItem(this.reportTitleQueryResultList.get(i).report_title);
        }
        selectReportIDComboBox.setSelectedIndex(-1);
        selectReportIDComboBox.setForeground(forgroundColor);
        selectReportIDComboBox.setBackground(backgroundColor);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateReportTitlePanel = new javax.swing.JPanel();
        updateReportTitleLable = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        cupboardNoLabel = new javax.swing.JLabel();
        domainIDLabel = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        titleText = new javax.swing.JTextField();
        cupboardNoText = new javax.swing.JTextField();
        shelfNoText = new javax.swing.JTextField();
        domainIDComboBox = new javax.swing.JComboBox<>();
        selectReportIDComboBox = new javax.swing.JComboBox<>();
        shelfNoLabel1 = new javax.swing.JLabel();
        reportIDLabel = new javax.swing.JLabel();
        reportIDText = new javax.swing.JTextField();
        selectReportLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SKNCOECDIS v.18.1 - Departmental Library");
        setResizable(false);

        updateReportTitlePanel.setBackground(new java.awt.Color(235, 232, 247));

        updateReportTitleLable.setFont(new java.awt.Font("Century Schoolbook", 3, 28)); // NOI18N
        updateReportTitleLable.setForeground(new java.awt.Color(131, 56, 209));
        updateReportTitleLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateReportTitleLable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/64px/Edit2.png"))); // NOI18N
        updateReportTitleLable.setText("Update Report Title");

        titleLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(131, 56, 209));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titleLabel.setText("title : ");

        cupboardNoLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        cupboardNoLabel.setForeground(new java.awt.Color(131, 56, 209));
        cupboardNoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cupboardNoLabel.setText("cupboard no : ");

        domainIDLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        domainIDLabel.setForeground(new java.awt.Color(131, 56, 209));
        domainIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        domainIDLabel.setText("domain id : ");

        messageLabel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(131, 56, 209));
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setText("select & update report title");

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

        titleText.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        titleText.setForeground(new java.awt.Color(131, 106, 209));
        titleText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 106, 209)));
        titleText.setSelectionColor(new java.awt.Color(203, 192, 235));
        titleText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                titleTextKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                titleTextKeyTyped(evt);
            }
        });

        cupboardNoText.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cupboardNoText.setForeground(new java.awt.Color(131, 106, 209));
        cupboardNoText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 106, 209)));
        cupboardNoText.setSelectionColor(new java.awt.Color(203, 192, 235));
        cupboardNoText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cupboardNoTextKeyReleased(evt);
            }
        });

        shelfNoText.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        shelfNoText.setForeground(new java.awt.Color(131, 106, 209));
        shelfNoText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 106, 209)));
        shelfNoText.setSelectionColor(new java.awt.Color(203, 192, 235));
        shelfNoText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                shelfNoTextKeyReleased(evt);
            }
        });

        domainIDComboBox.setBackground(new java.awt.Color(235, 232, 247));
        domainIDComboBox.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        domainIDComboBox.setForeground(new java.awt.Color(131, 106, 209));
        domainIDComboBox.setToolTipText("");
        domainIDComboBox.setAutoscrolls(true);
        domainIDComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domainIDComboBoxActionPerformed(evt);
            }
        });

        selectReportIDComboBox.setBackground(new java.awt.Color(235, 232, 247));
        selectReportIDComboBox.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        selectReportIDComboBox.setForeground(new java.awt.Color(131, 106, 209));
        selectReportIDComboBox.setToolTipText("");
        selectReportIDComboBox.setAutoscrolls(true);
        selectReportIDComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectReportIDComboBoxItemStateChanged(evt);
            }
        });
        selectReportIDComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectReportIDComboBoxMousePressed(evt);
            }
        });
        selectReportIDComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectReportIDComboBoxActionPerformed(evt);
            }
        });
        selectReportIDComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                selectReportIDComboBoxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                selectReportIDComboBoxKeyTyped(evt);
            }
        });

        shelfNoLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        shelfNoLabel1.setForeground(new java.awt.Color(131, 56, 209));
        shelfNoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        shelfNoLabel1.setText("shelf no : ");

        reportIDLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        reportIDLabel.setForeground(new java.awt.Color(131, 56, 209));
        reportIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        reportIDLabel.setText("report id : ");

        reportIDText.setEditable(false);
        reportIDText.setBackground(new java.awt.Color(235, 232, 247));
        reportIDText.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        reportIDText.setForeground(new java.awt.Color(131, 106, 209));
        reportIDText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 106, 209)));
        reportIDText.setSelectionColor(new java.awt.Color(203, 192, 235));
        reportIDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportIDTextActionPerformed(evt);
            }
        });
        reportIDText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                reportIDTextKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reportIDTextKeyTyped(evt);
            }
        });

        selectReportLabel.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        selectReportLabel.setForeground(new java.awt.Color(131, 56, 209));
        selectReportLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        selectReportLabel.setText("select report : ");

        javax.swing.GroupLayout updateReportTitlePanelLayout = new javax.swing.GroupLayout(updateReportTitlePanel);
        updateReportTitlePanel.setLayout(updateReportTitlePanelLayout);
        updateReportTitlePanelLayout.setHorizontalGroup(
            updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateReportTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateReportTitleLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateReportTitlePanelLayout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(updateReportTitlePanelLayout.createSequentialGroup()
                        .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateReportTitlePanelLayout.createSequentialGroup()
                                .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(selectReportLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(reportIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectReportIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reportIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(updateReportTitlePanelLayout.createSequentialGroup()
                                .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cupboardNoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                        .addComponent(domainIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(shelfNoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(domainIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cupboardNoText, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(shelfNoText, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateReportTitlePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        updateReportTitlePanelLayout.setVerticalGroup(
            updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateReportTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateReportTitleLable, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectReportIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reportIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(domainIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(domainIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cupboardNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cupboardNoText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shelfNoText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shelfNoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(updateReportTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updateReportTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updateReportTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
       boolean enteredAllAttributes = true;
        AddReportTitleAttributes addReportTitleAttributes = new AddReportTitleAttributes();
        try {
            if(!reportIDText.getText().equals("")){
                addReportTitleAttributes.report_id=Integer.parseInt(reportIDText.getText());
            }
            else{
                enteredAllAttributes=false;
            }
            if (!titleText.getText().equals("")) {
                addReportTitleAttributes.report_title = titleText.getText();
            } else {
                enteredAllAttributes = false;
            }

            if (domainIDComboBox.getSelectedIndex() > -1) {
                addReportTitleAttributes.domain_id = Integer.parseInt(String.valueOf(domainIDComboBox.getSelectedItem().toString().toCharArray(), 0, domainIDComboBox.getSelectedItem().toString().indexOf(':') - 1));
            } else {
                enteredAllAttributes = false;
            }

            if (!cupboardNoText.getText().equals("")) {
                addReportTitleAttributes.cupboard_no = Integer.parseInt(cupboardNoText.getText());
            } else {
                enteredAllAttributes = false;
            }

            if (!shelfNoText.getText().equals("")) {
                addReportTitleAttributes.shelf_no = Integer.parseInt(shelfNoText.getText());
            } else {
                enteredAllAttributes = false;
            }
            if (enteredAllAttributes && correctInput) {
                boolean updated_successfully;
                updated_successfully = ServerRequests.updateReportTitle(addReportTitleAttributes);
                if (updated_successfully) {
                    GUI.libraryInchargeInterfacePanel.showRequestResult("report title updated successfully");
                } else {
                    GUI.libraryInchargeInterfacePanel.showRequestResult("report didn't updated,updated report title might be already present");
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
            Logger.getLogger(UpdateReportTitleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        GUI.libraryInchargeInterfacePanel.showRequestResult("report title not updated");
        GUI.libraryInchargeInterfaceFrame.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void domainIDComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domainIDComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_domainIDComboBoxActionPerformed

    private void titleTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titleTextKeyTyped
        if (titleText.getText().length() >= 200) {
            evt.consume();
            messageLabel.setForeground(Color.MAGENTA);
            messageLabel.setText("*maximum charchter length is 200");
        }
    }//GEN-LAST:event_titleTextKeyTyped

    private void titleTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titleTextKeyReleased
        messageLabel.setForeground(forgroundColor);
        messageLabel.setText("select & update report title");
    }//GEN-LAST:event_titleTextKeyReleased

    private void cupboardNoTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cupboardNoTextKeyReleased
        try {
            if (Integer.parseInt(cupboardNoText.getText()) >= 256 || Integer.parseInt(cupboardNoText.getText()) < 1) {
                messageLabel.setForeground(Color.MAGENTA);
                messageLabel.setText("*maximum range is 0-255");
                cupboardNoText.setForeground(Color.MAGENTA);
                correctInput = false;
            } else {
                messageLabel.setForeground(forgroundColor);
                messageLabel.setText("select & update report title");
                cupboardNoText.setForeground(forgroundColor);
                correctInput = true;
            }
        } catch (NumberFormatException e) {
            messageLabel.setForeground(Color.MAGENTA);
            messageLabel.setText("*number input only");
            cupboardNoText.setForeground(Color.MAGENTA);
            correctInput = false;
        }
    }//GEN-LAST:event_cupboardNoTextKeyReleased

    private void shelfNoTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_shelfNoTextKeyReleased
        try {
            if (Integer.parseInt(shelfNoText.getText()) >= 256 || Integer.parseInt(shelfNoText.getText()) < 1) {
                messageLabel.setForeground(Color.MAGENTA);
                messageLabel.setText("*maximum range is 0-255");
                shelfNoText.setForeground(Color.MAGENTA);
                correctInput = false;
            } else {
                messageLabel.setForeground(forgroundColor);
                messageLabel.setText("select & update report title");
                shelfNoText.setForeground(forgroundColor);
                correctInput = true;
            }
        } catch (NumberFormatException e) {
            messageLabel.setForeground(Color.MAGENTA);
            messageLabel.setText("*number input only");
            shelfNoText.setForeground(Color.MAGENTA);
            correctInput = false;
        }
    }//GEN-LAST:event_shelfNoTextKeyReleased

    private void reportIDTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reportIDTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_reportIDTextKeyReleased

    private void reportIDTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reportIDTextKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_reportIDTextKeyTyped

    private void reportIDTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportIDTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportIDTextActionPerformed

    private void selectReportIDComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectReportIDComboBoxActionPerformed
         int selectedIndex=selectReportIDComboBox.getSelectedIndex();
        if(selectedIndex>-1){
            reportIDText.setText(String.valueOf(reportTitleQueryResultList.get(selectedIndex).report_id));
            titleText.setText(reportTitleQueryResultList.get(selectedIndex).report_title);
            cupboardNoText.setText(String.valueOf(reportTitleQueryResultList.get(selectedIndex).cupboard_no));
            shelfNoText.setText(String.valueOf(reportTitleQueryResultList.get(selectedIndex).shelf_no));

             for(int i=0;i<domainQueryResultList.size();i++){
                 if(domainQueryResultList.get(i).domain_id==reportTitleQueryResultList.get(selectedIndex).domain_id){
                   domainIDComboBox.setSelectedIndex(i);
                   break;
                 }
             }
        }
        else{
            reportIDText.setText("");
            titleText.setText("");
            cupboardNoText.setText("");
            shelfNoText.setText("");
            domainIDComboBox.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_selectReportIDComboBoxActionPerformed

    private void selectReportIDComboBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_selectReportIDComboBoxKeyReleased

    }//GEN-LAST:event_selectReportIDComboBoxKeyReleased

    private void selectReportIDComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectReportIDComboBoxItemStateChanged
        
    }//GEN-LAST:event_selectReportIDComboBoxItemStateChanged

    private void selectReportIDComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectReportIDComboBoxMousePressed
        
    }//GEN-LAST:event_selectReportIDComboBoxMousePressed

    private void selectReportIDComboBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_selectReportIDComboBoxKeyTyped

    }//GEN-LAST:event_selectReportIDComboBoxKeyTyped

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
    private javax.swing.JLabel cupboardNoLabel;
    private javax.swing.JTextField cupboardNoText;
    private javax.swing.JComboBox<String> domainIDComboBox;
    private javax.swing.JLabel domainIDLabel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel reportIDLabel;
    private javax.swing.JTextField reportIDText;
    private javax.swing.JComboBox<String> selectReportIDComboBox;
    private javax.swing.JLabel selectReportLabel;
    private javax.swing.JLabel shelfNoLabel1;
    private javax.swing.JTextField shelfNoText;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleText;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel updateReportTitleLable;
    private javax.swing.JPanel updateReportTitlePanel;
    // End of variables declaration//GEN-END:variables
}
