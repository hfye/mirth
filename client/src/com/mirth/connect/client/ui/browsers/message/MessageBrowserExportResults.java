/*
 * Copyright (c) Mirth Corporation. All rights reserved.
 * http://www.mirthcorp.com
 * 
 * The software in this package is published under the terms of the MPL
 * license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 */

package com.mirth.connect.client.ui.browsers.message;

import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;

import org.apache.log4j.Logger;

import com.mirth.connect.client.core.ClientException;
import com.mirth.connect.client.ui.Frame;
import com.mirth.connect.client.ui.UIConstants;
import com.mirth.connect.donkey.model.message.ContentType;
import com.mirth.connect.model.filters.MessageFilter;
import com.mirth.connect.util.export.MessageExportOptions;
import com.mirth.connect.util.export.MessageExporter.MessageExporterUserError;

/**
 *
 * @author brentm
 */
public class MessageBrowserExportResults extends javax.swing.JDialog {
    private Frame parent;
    private String channelId;
    private MessageFilter messageFilter;
    private int pageSize;
    private Logger logger = Logger.getLogger(this.getClass());
    
    /**
     * Creates new form MessageBrowserExportResults
     */
    public MessageBrowserExportResults(Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        initComponentsCustom();
        reset();
    }
    
    private void initComponentsCustom() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("XML serialized message");
        
        for (ContentType contentType : ContentType.values()) {
            model.addElement(contentType);
        }
        
        formatComboBox.setModel(model);
    }
    
    public void loadChannel(String channelId) {
        this.channelId = channelId;
    }
    
    public void setMessageFilter(MessageFilter messageFilter) {
        this.messageFilter = messageFilter;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formatButtonGroup = new javax.swing.ButtonGroup();
        compressionButtonGroup = new javax.swing.ButtonGroup();
        destinationButtonGroup = new javax.swing.ButtonGroup();
        containerPanel = new javax.swing.JPanel();
        formatPanel = new javax.swing.JPanel();
        formatComboBox = new com.mirth.connect.client.ui.components.MirthComboBox();
        formatFileMultiple = new javax.swing.JRadioButton();
        formatFileSingle = new javax.swing.JRadioButton();
        destinationPanel = new javax.swing.JPanel();
        exportTypeLocal = new javax.swing.JRadioButton();
        exportTypeServer = new javax.swing.JRadioButton();
        exportTypeLocalText = new javax.swing.JTextField();
        exportTypeServerText = new javax.swing.JTextField();
        exportTypeLocalBrowse = new com.mirth.connect.client.ui.components.MirthButton();
        compressionPanel = new javax.swing.JPanel();
        compressionNone = new javax.swing.JRadioButton();
        compressionEach = new javax.swing.JRadioButton();
        compressionArchive = new javax.swing.JRadioButton();
        buttonExport = new com.mirth.connect.client.ui.components.MirthButton();
        buttonCancel = new com.mirth.connect.client.ui.components.MirthButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Export Messages");
        setBackground(java.awt.Color.white);
        setLocation(new java.awt.Point(300, 150));
        setResizable(false);

        containerPanel.setBackground(new java.awt.Color(255, 255, 255));

        formatPanel.setBackground(new java.awt.Color(255, 255, 255));
        formatPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Format"));

        formatFileMultiple.setBackground(new java.awt.Color(255, 255, 255));
        formatButtonGroup.add(formatFileMultiple);
        formatFileMultiple.setSelected(true);
        formatFileMultiple.setText("Multiple Files");

        formatFileSingle.setBackground(new java.awt.Color(255, 255, 255));
        formatButtonGroup.add(formatFileSingle);
        formatFileSingle.setText("One File");

        javax.swing.GroupLayout formatPanelLayout = new javax.swing.GroupLayout(formatPanel);
        formatPanel.setLayout(formatPanelLayout);
        formatPanelLayout.setHorizontalGroup(
            formatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formatComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(formatFileMultiple)
                .addGap(18, 18, 18)
                .addComponent(formatFileSingle)
                .addGap(32, 32, 32))
        );
        formatPanelLayout.setVerticalGroup(
            formatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formatPanelLayout.createSequentialGroup()
                .addGroup(formatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatFileMultiple)
                    .addComponent(formatFileSingle))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        destinationPanel.setBackground(new java.awt.Color(255, 255, 255));
        destinationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Destination"));

        exportTypeLocal.setBackground(new java.awt.Color(255, 255, 255));
        destinationButtonGroup.add(exportTypeLocal);
        exportTypeLocal.setSelected(true);
        exportTypeLocal.setText("Export to local filesystem");
        exportTypeLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportTypeLocalActionPerformed(evt);
            }
        });

        exportTypeServer.setBackground(new java.awt.Color(255, 255, 255));
        destinationButtonGroup.add(exportTypeServer);
        exportTypeServer.setText("Export to server filesystem");
        exportTypeServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportTypeServerActionPerformed(evt);
            }
        });

        exportTypeLocalText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exportTypeLocalTextFocusGained(evt);
            }
        });

        exportTypeServerText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exportTypeServerTextFocusGained(evt);
            }
        });

        exportTypeLocalBrowse.setText("Browse...");
        exportTypeLocalBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportTypeLocalBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout destinationPanelLayout = new javax.swing.GroupLayout(destinationPanel);
        destinationPanel.setLayout(destinationPanelLayout);
        destinationPanelLayout.setHorizontalGroup(
            destinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(destinationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(destinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(destinationPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(destinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exportTypeLocalText)
                            .addComponent(exportTypeServerText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportTypeLocalBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(destinationPanelLayout.createSequentialGroup()
                        .addGroup(destinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exportTypeLocal)
                            .addComponent(exportTypeServer))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        destinationPanelLayout.setVerticalGroup(
            destinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(destinationPanelLayout.createSequentialGroup()
                .addComponent(exportTypeLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(destinationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportTypeLocalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportTypeLocalBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exportTypeServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportTypeServerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        compressionPanel.setBackground(new java.awt.Color(255, 255, 255));
        compressionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Compression"));

        compressionNone.setBackground(new java.awt.Color(255, 255, 255));
        compressionButtonGroup.add(compressionNone);
        compressionNone.setSelected(true);
        compressionNone.setText("No Compression");

        compressionEach.setBackground(new java.awt.Color(255, 255, 255));
        compressionButtonGroup.add(compressionEach);
        compressionEach.setText("Compress Each File");

        compressionArchive.setBackground(new java.awt.Color(255, 255, 255));
        compressionButtonGroup.add(compressionArchive);
        compressionArchive.setText("Compress to Archive");

        javax.swing.GroupLayout compressionPanelLayout = new javax.swing.GroupLayout(compressionPanel);
        compressionPanel.setLayout(compressionPanelLayout);
        compressionPanelLayout.setHorizontalGroup(
            compressionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compressionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(compressionNone)
                .addGap(18, 18, 18)
                .addComponent(compressionEach)
                .addGap(18, 18, 18)
                .addComponent(compressionArchive)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        compressionPanelLayout.setVerticalGroup(
            compressionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compressionPanelLayout.createSequentialGroup()
                .addGroup(compressionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compressionNone)
                    .addComponent(compressionEach)
                    .addComponent(compressionArchive))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        buttonExport.setText("Export");
        buttonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExportActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(compressionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(destinationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(formatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(destinationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(compressionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExportActionPerformed
        MessageExportOptions options = new MessageExportOptions();
        options.setChannelId(channelId);
        options.setMessageFilter(messageFilter);
        
        Object format = formatComboBox.getSelectedItem();
        
        if (format instanceof ContentType) {
            options.setContentType((ContentType) format);
        }
        
        options.setBufferSize(pageSize);
        
        if (formatFileSingle.isSelected()) {
            if (compressionNone.isSelected()) {
                options.setOutputType(MessageExportOptions.SINGLE);
            } else {
                options.setOutputType(MessageExportOptions.SINGLE_COMPRESSED);
            }
        } else {
            if (compressionNone.isSelected()) {
                options.setOutputType(MessageExportOptions.MULTIPLE);
            } else if (compressionEach.isSelected()) {
                options.setOutputType(MessageExportOptions.MULTIPLE_COMPRESSED_EACH);
            } else {
                options.setOutputType(MessageExportOptions.MULTIPLE_COMPRESSED_ARCHIVE);
            }
        }
        
        if (format instanceof ContentType) {
            options.setContentType((ContentType) format);
        }
        
        options.setEncrypt(false);
        options.setCharset(UIConstants.CHARSET);
        
        try {
            int exportCount = 0;
            
            if (exportTypeLocal.isSelected()) {
                String folderText = exportTypeLocalText.getText();
                
                if (folderText.isEmpty()) {
                    parent.alertError(parent, "Please specify a destination folder");
                    return;
                } else {
                    options.setFolder(folderText);
                }
                
                exportCount = parent.mirthClient.exportMessagesLocal(options);
            } else {
                String folder = exportTypeServerText.getText();
                
                if (folder.isEmpty()) {
                    parent.alertError(parent, "Please specify a destination folder");
                    return;
                }
                
                options.setFolder(folder);
                
                exportCount = parent.mirthClient.exportMessagesServer(options);
            }
            
            setVisible(false);
            parent.alertInformation(parent, exportCount + " message" + ((exportCount == 1) ? " has" : "s have") + " been successfully exported to: " + options.getFolder());
            reset();
        } catch (ClientException e) {
            // TODO: find a way to detect user-related errors so that we can show a simple error message instead of the exception message and stack trace
//            MessageExporterUserError userError = (MessageExporterUserError) findCause(e, MessageExporterUserError.class);
            
//            if (userError != null) {
//                parent.alertError(parent, userError.getMessage());
//            } else {            
                Throwable cause = (e.getCause() == null) ? e : e.getCause();
                parent.alertException(parent, cause.getStackTrace(), cause.getMessage());
//            }
        }
    }//GEN-LAST:event_buttonExportActionPerformed

//    private Throwable findCause(Throwable e, Class searchClass) {
//        Throwable cause = e.getCause();
//        
//        if (cause != null) {
//            return searchClass.isInstance(cause) ? cause : findCause(cause, searchClass);
//        }
//        
//        return null;
//    }
    
    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        setVisible(false);
        reset();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void exportTypeLocalBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportTypeLocalBrowseActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            exportTypeLocalText.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_exportTypeLocalBrowseActionPerformed

    private void exportTypeLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportTypeLocalActionPerformed
        exportTypeLocalBrowse.setEnabled(true);
    }//GEN-LAST:event_exportTypeLocalActionPerformed

    private void exportTypeServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportTypeServerActionPerformed
        exportTypeLocalBrowse.setEnabled(false);
    }//GEN-LAST:event_exportTypeServerActionPerformed

    private void exportTypeLocalTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exportTypeLocalTextFocusGained
        exportTypeLocal.setSelected(true);
        exportTypeLocalBrowse.setEnabled(true);
    }//GEN-LAST:event_exportTypeLocalTextFocusGained

    private void exportTypeServerTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exportTypeServerTextFocusGained
        exportTypeServer.setSelected(true);
        exportTypeLocalBrowse.setEnabled(false);
    }//GEN-LAST:event_exportTypeServerTextFocusGained
    
    private void reset() {
        formatComboBox.setSelectedIndex(0);
        formatFileMultiple.setSelected(true);
        exportTypeLocal.setSelected(true);
        exportTypeLocalText.setText(null);
        exportTypeLocalBrowse.setEnabled(true);
        exportTypeServerText.setText(null);
        compressionNone.setSelected(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mirth.connect.client.ui.components.MirthButton buttonCancel;
    private com.mirth.connect.client.ui.components.MirthButton buttonExport;
    private javax.swing.JRadioButton compressionArchive;
    private javax.swing.ButtonGroup compressionButtonGroup;
    private javax.swing.JRadioButton compressionEach;
    private javax.swing.JRadioButton compressionNone;
    private javax.swing.JPanel compressionPanel;
    private javax.swing.JPanel containerPanel;
    private javax.swing.ButtonGroup destinationButtonGroup;
    private javax.swing.JPanel destinationPanel;
    private javax.swing.JRadioButton exportTypeLocal;
    private com.mirth.connect.client.ui.components.MirthButton exportTypeLocalBrowse;
    private javax.swing.JTextField exportTypeLocalText;
    private javax.swing.JRadioButton exportTypeServer;
    private javax.swing.JTextField exportTypeServerText;
    private javax.swing.ButtonGroup formatButtonGroup;
    private com.mirth.connect.client.ui.components.MirthComboBox formatComboBox;
    private javax.swing.JRadioButton formatFileMultiple;
    private javax.swing.JRadioButton formatFileSingle;
    private javax.swing.JPanel formatPanel;
    // End of variables declaration//GEN-END:variables
}
