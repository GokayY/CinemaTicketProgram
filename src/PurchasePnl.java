
import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JCalendar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.SwingUtilities;

public class PurchasePnl extends javax.swing.JPanel {

    int studentTicket;
    int adultTicket;
    int seniorTicket;

    protected IDateEditor dateEditor;
    protected JCalendar jcalendar;
    MoviesPnl movies = new MoviesPnl();
    DBCon connect = new DBCon();
    String movieTitle;

    public void calc_total() {
        //Ticket prices and Calculation of total amount
        int adult = Integer.valueOf(adultPiece.getValue().toString());
        int student = Integer.valueOf(studentPiece.getValue().toString());
        int senior = Integer.valueOf(seniorPiece.getValue().toString());

        int total = (adult * adultTicket) + (student * studentTicket) + (senior * seniorTicket);
        totalAmount.setText(String.valueOf(total));
    }

    public void showPrices() {
        // Showing prices in labels 
        // Prices are located in ADMIN.PRICE table in database.
        
        String sql1 = "SELECT * from ADMIN.PRICE WHERE ticket_type= 'Student' ";
        String sql2 = "SELECT * from ADMIN.PRICE WHERE ticket_type= 'Adult' ";
        String sql3 = "SELECT * from ADMIN.PRICE WHERE ticket_type= 'Senior' ";
        ResultSet rs;

        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql1);
            rs = ps.executeQuery();
            if (rs.next()) {
                studentTicket = rs.getInt("price");
            }
            rs.close();
        } catch (SQLException e) {
            e.getSQLState();
        }
        String studentTicketStr = String.valueOf(studentTicket);
        studentPriceTag.setText(studentTicketStr);

        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql2);
            ResultSet query1 = ps.executeQuery();
            if (query1.next()) {
                adultTicket = query1.getInt("price");
            }
            query1.close();
        } catch (SQLException e) {
            e.getSQLState();
        }
        String adultTicketStr = String.valueOf(adultTicket);
        adultPriceTag.setText(adultTicketStr);

        try {
            PreparedStatement ps = connect.getConnection().prepareStatement(sql3);
            ResultSet query2 = ps.executeQuery();
            if (query2.next()) {
                seniorTicket = query2.getInt("price");
            }
            query2.close();
        } catch (SQLException e) {
            e.getSQLState();
        }
        String seniorTicketStr = String.valueOf(seniorTicket);
        seniorPriceTag.setText(seniorTicketStr);
    }

    public void setDefaultDate() {
        // Setting default date for JCalendar
        dateSelection.setDate(new Date());
    }

    public void setMinSelectableDate(Date min) {
        // Setting minimum selectable date as today for JCalendar
        jcalendar.setMinSelectableDate(min);
        dateEditor.setMinSelectableDate(min);
    }

    public PurchasePnl() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        ticketsPnl = new javax.swing.JPanel();
        studentPiece = new javax.swing.JSpinner();
        adultPiece = new javax.swing.JSpinner();
        seniorPiece = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        purchaseButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        studentPriceTag = new javax.swing.JLabel();
        adultPriceTag = new javax.swing.JLabel();
        seniorPriceTag = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DatePanel = new javax.swing.JPanel();
        dateSelection = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        timeSelection = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(650, 360));
        setMinimumSize(new java.awt.Dimension(650, 360));
        setName("purchasePnl"); // NOI18N
        setPreferredSize(new java.awt.Dimension(650, 360));
        setLayout(new java.awt.GridBagLayout());

        ticketsPnl.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        ticketsPnl.setFocusable(false);
        ticketsPnl.setMaximumSize(new java.awt.Dimension(274, 250));
        ticketsPnl.setMinimumSize(new java.awt.Dimension(274, 250));
        ticketsPnl.setName("ticketsPnl"); // NOI18N
        ticketsPnl.setPreferredSize(new java.awt.Dimension(274, 250));

        studentPiece.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        studentPiece.setMaximumSize(new java.awt.Dimension(39, 28));
        studentPiece.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                studentPieceStateChanged(evt);
            }
        });

        adultPiece.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        adultPiece.setMaximumSize(new java.awt.Dimension(39, 28));
        adultPiece.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                adultPieceStateChanged(evt);
            }
        });

        seniorPiece.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        seniorPiece.setMaximumSize(new java.awt.Dimension(39, 28));
        seniorPiece.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                seniorPieceStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        jLabel3.setText("Student");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        jLabel4.setText("Adult");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        jLabel5.setText("Senior");

        purchaseButton.setBackground(new java.awt.Color(204, 204, 204));
        purchaseButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        purchaseButton.setText("Purchase");
        purchaseButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        purchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Total Amount");

        totalAmount.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        totalAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalAmount.setText("0");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Tickets");

        studentPriceTag.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        studentPriceTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentPriceTag.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        adultPriceTag.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        adultPriceTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adultPriceTag.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        seniorPriceTag.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        seniorPriceTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seniorPriceTag.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seniorPriceTag.setMaximumSize(new java.awt.Dimension(41, 16));
        seniorPriceTag.setMinimumSize(new java.awt.Dimension(41, 16));
        seniorPriceTag.setPreferredSize(new java.awt.Dimension(41, 16));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Type");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Price");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Pieces");

        javax.swing.GroupLayout ticketsPnlLayout = new javax.swing.GroupLayout(ticketsPnl);
        ticketsPnl.setLayout(ticketsPnlLayout);
        ticketsPnlLayout.setHorizontalGroup(
            ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketsPnlLayout.createSequentialGroup()
                .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ticketsPnlLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel8))
                    .addGroup(ticketsPnlLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(seniorPiece, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ticketsPnlLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ticketsPnlLayout.createSequentialGroup()
                                .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ticketsPnlLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(studentPriceTag, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ticketsPnlLayout.createSequentialGroup()
                                        .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(36, 36, 36)
                                        .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(adultPriceTag, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(seniorPriceTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ticketsPnlLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(adultPiece, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ticketsPnlLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(studentPiece, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ticketsPnlLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ticketsPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ticketsPnlLayout.setVerticalGroup(
            ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketsPnlLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ticketsPnlLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(studentPriceTag, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentPiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(adultPiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(adultPriceTag, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ticketsPnlLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ticketsPnlLayout.createSequentialGroup()
                        .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(seniorPriceTag, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(ticketsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(totalAmount)))
                    .addComponent(seniorPiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 48, 50, 25);
        add(ticketsPnl, gridBagConstraints);

        DatePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        DatePanel.setMaximumSize(new java.awt.Dimension(274, 250));
        DatePanel.setMinimumSize(new java.awt.Dimension(274, 250));
        DatePanel.setPreferredSize(new java.awt.Dimension(274, 250));
        DatePanel.setLayout(new java.awt.GridBagLayout());

        dateSelection.setBackground(new java.awt.Color(204, 204, 204));
        dateSelection.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateSelectionPropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 105;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 72, 0, 0);
        DatePanel.add(dateSelection, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 121, 0, 0);
        DatePanel.add(jLabel2, gridBagConstraints);

        timeSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09:00", "12:00", "15:00", "18:00", "21:00" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 112, 44, 0);
        DatePanel.add(timeSelection, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Times");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 120, 0, 0);
        DatePanel.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 269;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 3, 0, 2);
        DatePanel.add(jSeparator1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 29, 50, 0);
        add(DatePanel, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Purchase");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 277, 0, 0);
        add(jLabel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void dateSelectionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateSelectionPropertyChange
        //JCalendar feature
        dateSelection.getJCalendar().setMinSelectableDate(new Date());
    }//GEN-LAST:event_dateSelectionPropertyChange

    private void purchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseButtonActionPerformed
        // Declaring variables 
        Date date = dateSelection.getDate();
        String time = timeSelection.getSelectedItem().toString();
        String adult = adultPiece.getValue().toString();
        String student = studentPiece.getValue().toString();
        String senior = seniorPiece.getValue().toString();
        int total = 0;
        total = Integer.valueOf(totalAmount.getText());
        String id = null;

        //if condition for not to have nullpointerException
        if ((total == 0) || (date == null) || movieTitle == null) {
            JOptionPane.showMessageDialog(null, "Please Specify Movie Name, Tickets, Date and Time.", "Empty Field", ERROR_MESSAGE);
        } else {
            //Booking ID is set as Timestamp
            id = String.valueOf(System.nanoTime());
            
            // Recording info from customer into database
            String sql = "INSERT INTO ADMIN.PURCHASE VALUES ('" + id + "','" + movieTitle + "', '" + time + "','"
                    + DateFormat.getDateInstance().format(date)
                    + "'," + student + "," + adult + "," + senior + "," + total + ")";

            try {
                Statement stmt = connect.getConnection().createStatement();
                stmt.executeUpdate(sql);
                connect.getConnection().commit();
                connect.getConnection().close();
            } catch (SQLException e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());

            }
            
            // Booking information for customer which is shown in JOptionPane
            String thnx = "Booking ID : " + id + "\n"
                    + "Movie Title : " + movieTitle + "\n"
                    + "Date : " + DateFormat.getDateInstance().format(date) + "\n"
                    + "Time : " + time + "\n"
                    + "Adult Ticket : " + adult + "\n"
                    + "Student Ticket : " + student + "\n"
                    + "Senior Ticket : " + senior + "\n"
                    + "Total Amount : " + total + "\n"
                    + "Thank you for your purchase. ";

            JOptionPane.showMessageDialog(null, thnx, "Transaction Completed.", INFORMATION_MESSAGE);
            
            // Creating new instance of the program and closing the active one.
            MainFrame main = new MainFrame();
            SwingUtilities.windowForComponent(this).dispose();
            
        }
    }//GEN-LAST:event_purchaseButtonActionPerformed


    private void seniorPieceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_seniorPieceStateChanged
        calc_total();
    }//GEN-LAST:event_seniorPieceStateChanged

    private void adultPieceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_adultPieceStateChanged
        calc_total();
    }//GEN-LAST:event_adultPieceStateChanged

    private void studentPieceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_studentPieceStateChanged
        calc_total();
    }//GEN-LAST:event_studentPieceStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DatePanel;
    private javax.swing.JSpinner adultPiece;
    private javax.swing.JLabel adultPriceTag;
    private com.toedter.calendar.JDateChooser dateSelection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton purchaseButton;
    private javax.swing.JSpinner seniorPiece;
    private javax.swing.JLabel seniorPriceTag;
    private javax.swing.JSpinner studentPiece;
    private javax.swing.JLabel studentPriceTag;
    private javax.swing.JPanel ticketsPnl;
    private javax.swing.JComboBox<String> timeSelection;
    private javax.swing.JLabel totalAmount;
    // End of variables declaration//GEN-END:variables
}