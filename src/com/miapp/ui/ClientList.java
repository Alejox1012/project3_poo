package com.miapp.ui;

import com.miapp.model.Invoice;
import com.miapp.model.Movie;
import com.miapp.model.Person;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

/**
 * ClientList is a GUI component for displaying a table of clients with their IDs.
 * It uses a DefaultTableModel to dynamically add and display client data.
 */
public class ClientList extends javax.swing.JInternalFrame {

    private DefaultTableModel tableModel;
    

    /**
     * Constructs a new ClientList window and initializes the table model.
     */
      public ClientList() {
        initComponents();
        tableModel = new DefaultTableModel(new Object[]{"Client", "ID", "Phone", "Member"}, 0);
        jTable1.setModel(tableModel);
        loadClientsFromFile(); // Load clients from file when starting
    }

    /**
     * Adds a new client to the table.
     *
     * @param name The name of the Person.
     */
    public void addClient(String name, String id, String phone, boolean isMember) {
        tableModel.addRow(new Object[]{name, id, phone, isMember ? "Yes" : "No"}); // Adjusted to include phone and membership status
    }

    
    private void saveClientsToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("clients.txt"))) {
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            String client = (String) tableModel.getValueAt(row, 0);
            String id = (String) tableModel.getValueAt(row, 1);
            String phone = (String) tableModel.getValueAt(row, 2);
            String memberStatus = (String) tableModel.getValueAt(row, 3);

            writer.write(client + "," + id + "," + phone + "," + memberStatus);
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    private void loadClientsFromFile() {
    File file = new File("clients.txt");
    if (!file.exists()) {
        return; // If file doesn't exist, do nothing
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String client = parts[0];
            String id = parts[1];
            String phone = parts[2];
            String memberStatus = parts[3];
            boolean isMember = memberStatus.equalsIgnoreCase("Yes");

            // Add the client to the table
            addClient(client, id, phone, isMember);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}



   /**
     * Adds an invoice for a specific client.
     *
     * @param clientName The name of the client.
     * @param rentedMovie The rented movie.
     * @param daysDelayed The number of delayed days.
     * @param isMember Indicates if the client is a member.
     * @param returnDate The return date of the movie.
     */
  

    /**
     * Returns the table model of the client list.
     *
     * @return The DefaultTableModel used for the client list table.
     */
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Client", "ID", "Phone", "Member"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Closes the ClientList window.
     *
     * @param evt The action event triggered by clicking the Close button.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        saveClientsToFile();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

