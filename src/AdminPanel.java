
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JFileChooser;

public class AdminPanel extends javax.swing.JFrame {

    // Admin Panel for Cinema Ticket Program
    
    PurchasePnl PurchasePnl;
    NewMovieFrame NewMovieFrame;
    MoviesPnl MoviesPnl;

    DBCon connect;
    Connection connection;

    int studentTicket;
    int adultTicket;
    int seniorTicket;
    Blob blob;
    byte[] image;
    InputStream inputStream;

    public AdminPanel() {
        initComponents();
        PurchasePnl = new PurchasePnl();
        connect = new DBCon();
        connection = connect.getConnection();
        NewMovieFrame = new NewMovieFrame();
        MoviesPnl = new MoviesPnl();

        this.setTitle("Admin Panel");
        this.setPrices();
    }

    private void setPrices() {
        
        // Getting prices from database into JSpinners as default value
        
        String sql1 = "SELECT * from ADMIN.PRICE WHERE ticket_type= 'Student' ";
        String sql2 = "SELECT * from ADMIN.PRICE WHERE ticket_type= 'Adult' ";
        String sql3 = "SELECT * from ADMIN.PRICE WHERE ticket_type= 'Senior' ";
        ResultSet rs;

        try {
            PreparedStatement ps = connection.prepareStatement(sql1);
            rs = ps.executeQuery();
            if (rs.next()) {
                studentTicket = rs.getInt("price");
                studentTicketPrice.setValue(studentTicket);
            }
            rs.close();
        } catch (SQLException e) {
            e.getSQLState();
        }

        try {
            PreparedStatement ps = connection.prepareStatement(sql2);
            ResultSet query1 = ps.executeQuery();
            if (query1.next()) {
                adultTicket = query1.getInt("price");
                adultTicketPrice.setValue(adultTicket);
            }
            query1.close();
        } catch (SQLException e) {
            e.getSQLState();
        }

        try {
            PreparedStatement ps = connection.prepareStatement(sql3);
            ResultSet query2 = ps.executeQuery();
            if (query2.next()) {
                seniorTicket = query2.getInt("price");
                seniorTicketPrice.setValue(seniorTicket);
            }
            query2.close();
        } catch (SQLException e) {
            e.getSQLState();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        studentTicketPrice = new javax.swing.JSpinner();
        adultTicketPrice = new javax.swing.JSpinner();
        seniorTicketPrice = new javax.swing.JSpinner();
        saveButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        CSVUploadButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        NewMovieButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        filePathTag = new javax.swing.JTextPane();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(500, 250));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(274, 250));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Ticket Prices");

        jLabel4.setText("Student Ticket");

        jLabel5.setText("Adult Ticket");

        jLabel6.setText("Senior Ticket");

        studentTicketPrice.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        adultTicketPrice.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        seniorTicketPrice.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(114, 114, 114)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(seniorTicketPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(studentTicketPrice)
                            .addComponent(adultTicketPrice))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentTicketPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adultTicketPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seniorTicketPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(50, 50, 50)
                .addComponent(saveButton))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(274, 250));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        CSVUploadButton.setText("CSV Upload");
        CSVUploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSVUploadButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(51, 18, 0, 17);
        jPanel3.add(CSVUploadButton, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Movies");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 62, 0, 0);
        jPanel3.add(jLabel2, gridBagConstraints);

        NewMovieButton.setText("New Movie");
        NewMovieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewMovieButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 42, 64, 0);
        jPanel3.add(NewMovieButton, gridBagConstraints);

        jLabel7.setText("Note: CSV File format \"Movie Title,Year,Genre,FilePath");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 23, 0, 0);
        jPanel3.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 59, 0, 0);
        jPanel3.add(jSeparator1, gridBagConstraints);

        jLabel8.setText("File Path :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 27, 0, 0);
        jPanel3.add(jLabel8, gridBagConstraints);

        filePathTag.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        filePathTag.setToolTipText("");
        filePathTag.setMaximumSize(new java.awt.Dimension(25, 118));
        filePathTag.setMinimumSize(new java.awt.Dimension(25, 118));
        filePathTag.setPreferredSize(new java.awt.Dimension(25, 118));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 93;
        gridBagConstraints.ipady = -93;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 12, 0, 0);
        jPanel3.add(filePathTag, gridBagConstraints);

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(exitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewMovieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewMovieButtonActionPerformed
        NewMovieFrame newMovie = new NewMovieFrame();
        newMovie.setVisible(true);
    }//GEN-LAST:event_NewMovieButtonActionPerformed

    private void CSVUploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSVUploadButtonActionPerformed
        
        // Uploading movies into movies database with CSV File. 
        
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File file = fc.getSelectedFile();

        // If condition is used for not having nullpointerexception
        if (file != null) {
            String filename = file.getAbsolutePath();
            filePathTag.setText(filename);

            CSVReader reader = null;

            try {
                reader = new CSVReader(new FileReader(filename));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] nextLine;
            int id = 0;
            try {
                String querId = "SELECT MAX(ID) ID FROM MOVIES";
                PreparedStatement ps = connection.prepareStatement(querId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("id");
                }
                while ((nextLine = reader.readNext()) != null) {
                    id ++;
                    
                    // Insert command for database with multiple values
                    
                    String query = "INSERT INTO MOVIES(ID,TITLE,GENRE,YEARSTART,BANNER ) VALUES (?,?,?,?,?)";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setInt(1, id);
                    statement.setString(2, nextLine[0]);
                    statement.setString(3, nextLine[1]);
                    statement.setInt(4, Integer.valueOf(nextLine[2].trim()));
                    String filePath = nextLine[3];

                    InputStream input = getClass().getResourceAsStream(filePath);

                    image = new byte[input.available()];
                    input.read(image);
                    Blob bb = new SerialBlob(image);
                    statement.setBlob(5, bb);
                    statement.executeUpdate();

                }
                connection.commit();
                connection.close();
            } catch (SQLException ex) {
                ex.setNextException(ex);
            } catch (IOException ex) {
                Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_CSVUploadButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
        // Taking price info from JSpinner and Inserting them into database. 
        
        try {
            String querPrStu = "UPDATE ADMIN.PRICE SET PRICE = " + studentTicketPrice.getValue()
                    + "WHERE TICKET_TYPE = 'Student'";
            String querPrAdu = "UPDATE ADMIN.PRICE SET PRICE = " + adultTicketPrice.getValue()
                    + "WHERE TICKET_TYPE = 'Adult' ";
            String querPrSen = "UPDATE ADMIN.PRICE SET PRICE = " + seniorTicketPrice.getValue()
                    + "WHERE TICKET_TYPE = 'Senior' ";
            PreparedStatement execPrStu = connection.prepareStatement(querPrStu);
            PreparedStatement execPrAd = connection.prepareStatement(querPrAdu);
            PreparedStatement execPrSe = connection.prepareStatement(querPrSen);

            execPrStu.executeUpdate();
            execPrAd.executeUpdate();
            execPrSe.executeUpdate();
            connection.commit();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_saveButtonActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CSVUploadButton;
    private javax.swing.JButton NewMovieButton;
    private javax.swing.JSpinner adultTicketPrice;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextPane filePathTag;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton saveButton;
    private javax.swing.JSpinner seniorTicketPrice;
    private javax.swing.JSpinner studentTicketPrice;
    // End of variables declaration//GEN-END:variables
}
