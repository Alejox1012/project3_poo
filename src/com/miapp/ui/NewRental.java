package com.miapp.ui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import com.miapp.model.Invoice;
import com.miapp.model.Movie;
import com.miapp.model.RegularMovie;
import com.miapp.model.PremiumMovie;
/**
 * NewRental is a GUI component for creating new rental transactions.
 * It allows users to select a client and a movie for rental.
 */
public class NewRental extends javax.swing.JInternalFrame {
  private ClientList clientList;
    private MovieInventory movieInventory;

    public NewRental(ClientList clientList, MovieInventory movieInventory) {
        initComponents();
        this.clientList = clientList;
        this.movieInventory = movieInventory;
        setClosable(true); // Allows closing the form
        populateMovieComboBoxes(); // Populate movie combo boxes with available movies
    }

    private void populateMovieComboBoxes() {
        DefaultTableModel movieModel = movieInventory.getMovieTableModel();
        for (int i = 0; i < movieModel.getRowCount(); i++) {
            String movieTitle = (String) movieModel.getValueAt(i, 0);
            String movieCode = (String) movieModel.getValueAt(i, 1); // Assuming the movie code is in the second column

            if (movieCode != null && movieTitle != null) {
                String displayString = movieCode + " - " + movieTitle;
                jComboBox1.addItem(displayString);
                jComboBox2.addItem(displayString);
                jComboBox3.addItem(displayString);
            }
        }
    }

    private boolean verifyClientExists(String clientName) {
        // Check if the client exists in the client list
        return clientList.getTableModel().getDataVector().stream()
                .anyMatch(row -> ((String) row.get(0)).equalsIgnoreCase(clientName));
    }

    private boolean verifyMembership(String clientName) {
        // Check if the client is a member
        return clientList.getTableModel().getDataVector().stream()
                .filter(row -> ((String) row.get(0)).equalsIgnoreCase(clientName))
                .anyMatch(row -> ((String) row.get(3)).equalsIgnoreCase("Yes"));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Factura = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("NEW RENTAL");

        jLabel2.setText("Client");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setText("Movie3");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Movie1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Movie2");

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, 0, 202, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(40, 40, 40))
        );

        Factura.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(Factura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Factura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String clientName = jTextField1.getText().trim();

    if (!verifyClientExists(clientName)) {
        JOptionPane.showMessageDialog(this, "Client not found.");
        return;
    }

    boolean hasMembership = verifyMembership(clientName);

    // Obtener las películas seleccionadas
    Movie movie1 = movieInventory.findMovieByCode(getMovieCode(jComboBox1.getSelectedItem().toString()));
    Movie movie2 = movieInventory.findMovieByCode(getMovieCode(jComboBox2.getSelectedItem().toString()));
    Movie movie3 = movieInventory.findMovieByCode(getMovieCode(jComboBox3.getSelectedItem().toString()));

    // Crear y guardar la factura
    Invoice invoice = new Invoice(LocalDate.now(), clientName, movie1, movie2, movie3, hasMembership);
    String invoiceFilePath = invoice.generateInvoiceFile(); // Llama a tu método para generar la factura

    if (invoiceFilePath != null) {
        JOptionPane.showMessageDialog(this, "Invoice saved to " + invoiceFilePath);
    } else {
        JOptionPane.showMessageDialog(this, "Error saving invoice.");
    }

    // Limpiar campos después de guardar
    jTextField1.setText("");
    jComboBox1.setSelectedIndex(0);
    jComboBox2.setSelectedIndex(0);
    jComboBox3.setSelectedIndex(0);
}
private String getMovieCode(String movieSelection) {
    String[] parts = movieSelection.split(" - ");
    return parts[0]; // Suponiendo que el código está antes del guión
}
  
    private double calculateMoviePrice(String movieSelection) {
        String[] parts = movieSelection.split(" - "); // Split to get the code
        String movieCode = parts[0]; // Get the movie code
        Movie movie = movieInventory.findMovieByCode(movieCode); // Assume this method retrieves the movie by code

        if (movie instanceof RegularMovie) {
            return 10000; // Fixed price for regular movies
        } else if (movie instanceof PremiumMovie) {
            return 13000; // Fixed price for premium movies
        }
        return 0.0; // Default case
    }


private boolean isPremiumMovie(String movieTitle) {
    // Implement your logic to determine if the movie is premium
    // Example: Check against a list of premium movies
    // For simplicity, let's assume movies with "Premium" in their title are premium.
    return movieTitle != null && movieTitle.contains("Prm");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed
   

  /**
     * Updates the client list in the JComboBox.
     */ 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Factura;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
