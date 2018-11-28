
import java.awt.GridBagLayout;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class MainFrame extends javax.swing.JFrame {

    private MoviesPnl moviesPnl;
    private PurchasePnl purchasePnl;

    public MainFrame() {
        // initializing JPanels
        
        initComponents();
        purchasePnl = new PurchasePnl();
        moviesPnl = new MoviesPnl();

        // Putting Jpanels into MainFrame
        homePagePnl.setLayout(new GridBagLayout());
        homePagePnl.add(purchasePnl);
        homePagePnl.add(moviesPnl);

        // Showing Prices from database
        //purchasePnl.showPrices();
        //Set Title
        this.setTitle("Cinema Ticket Machine");
        setVisible(true);

        hideAll(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    public void hideAll(Boolean isInitial) {
        // Initial page is set as MoviesPnl
        moviesPnl.setVisible(isInitial);
        purchasePnl.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        PurchaseButton = new javax.swing.JButton();
        MoviesButton = new javax.swing.JButton();
        ClearSelectionButton = new javax.swing.JButton();
        homePagePnl = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 0));
        setForeground(java.awt.Color.lightGray);
        setLocation(new java.awt.Point(500, 250));
        setMaximumSize(new java.awt.Dimension(875, 440));
        setMinimumSize(new java.awt.Dimension(875, 440));
        setPreferredSize(new java.awt.Dimension(875, 440));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setMaximumSize(new java.awt.Dimension(150, 440));
        jPanel1.setMinimumSize(new java.awt.Dimension(150, 440));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 440));

        PurchaseButton.setBackground(new java.awt.Color(204, 204, 204));
        PurchaseButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PurchaseButton.setText("Purchase");
        PurchaseButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PurchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseButtonActionPerformed(evt);
            }
        });

        MoviesButton.setBackground(new java.awt.Color(204, 204, 204));
        MoviesButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MoviesButton.setText("Movies");
        MoviesButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MoviesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoviesButtonActionPerformed(evt);
            }
        });

        ClearSelectionButton.setBackground(new java.awt.Color(204, 204, 204));
        ClearSelectionButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ClearSelectionButton.setText("Clear Selections");
        ClearSelectionButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ClearSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearSelectionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PurchaseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MoviesButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClearSelectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(MoviesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(PurchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(ClearSelectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        homePagePnl.setBackground(new java.awt.Color(204, 204, 204));
        homePagePnl.setMaximumSize(new java.awt.Dimension(650, 360));
        homePagePnl.setMinimumSize(new java.awt.Dimension(650, 360));

        javax.swing.GroupLayout homePagePnlLayout = new javax.swing.GroupLayout(homePagePnl);
        homePagePnl.setLayout(homePagePnlLayout);
        homePagePnlLayout.setHorizontalGroup(
            homePagePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        homePagePnlLayout.setVerticalGroup(
            homePagePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 40, 0, 40);
        getContentPane().add(homePagePnl, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MoviesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoviesButtonActionPerformed
        hideAll(true);
    }//GEN-LAST:event_MoviesButtonActionPerformed

    private void PurchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseButtonActionPerformed
        // movie title variable from movies panel is set into movie title in purchase panel. This is shown in thnx message
        purchasePnl.movieTitle = moviesPnl.GetSelectedMovie();
        if (purchasePnl.movieTitle == null || purchasePnl.movieTitle.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a movie.", "Selection Error", INFORMATION_MESSAGE);
        } else {
            hideAll(false);
            purchasePnl.setVisible(true);
        }
    }//GEN-LAST:event_PurchaseButtonActionPerformed

    private void ClearSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearSelectionButtonActionPerformed
        // Creating new instance and disposing the active JFrame
        MainFrame main = new MainFrame();
        this.dispose();
    }//GEN-LAST:event_ClearSelectionButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearSelectionButton;
    private javax.swing.JButton MoviesButton;
    private javax.swing.JButton PurchaseButton;
    private javax.swing.JPanel homePagePnl;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
