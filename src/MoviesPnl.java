
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public final class MoviesPnl extends javax.swing.JPanel {

    DBCon connect = new DBCon();
    public String movieSelection;

    public void LoadList() {
        // Loading database information into the list
        try {
            String query = "SELECT Id,Title,genre,yearstart FROM MOVIES";
            ResultSet rs;
            try (PreparedStatement ps = connect.getConnection().prepareStatement(query)) {
                rs = ps.executeQuery();
                DefaultListModel dlm = new DefaultListModel();
                while (rs.next()) {
                    dlm.addElement(rs.getString("Title"));
                }
                moviesList.setModel(dlm);
            }
            rs.close();
        } catch (SQLException e) {
            e.getErrorCode();
        }
    }

    public MoviesPnl() {
        initComponents();
        LoadList();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bannerPnl = new javax.swing.JPanel();
        bannerImage = new javax.swing.JLabel();
        listPnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        moviesList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(650, 360));
        setMinimumSize(new java.awt.Dimension(650, 360));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(650, 360));

        bannerPnl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bannerPnl.setMaximumSize(new java.awt.Dimension(274, 250));
        bannerPnl.setMinimumSize(new java.awt.Dimension(274, 250));
        bannerPnl.setPreferredSize(new java.awt.Dimension(274, 250));

        bannerImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout bannerPnlLayout = new javax.swing.GroupLayout(bannerPnl);
        bannerPnl.setLayout(bannerPnlLayout);
        bannerPnlLayout.setHorizontalGroup(
            bannerPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bannerPnlLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(bannerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        bannerPnlLayout.setVerticalGroup(
            bannerPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bannerImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        listPnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        moviesList.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        moviesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        moviesList.setToolTipText("");
        moviesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                moviesListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(moviesList);

        javax.swing.GroupLayout listPnlLayout = new javax.swing.GroupLayout(listPnl);
        listPnl.setLayout(listPnlLayout);
        listPnlLayout.setHorizontalGroup(
            listPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        listPnlLayout.setVerticalGroup(
            listPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Movies");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(listPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(bannerPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bannerPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void moviesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_moviesListValueChanged
        // Action for showing the banner of the film which is on the left hand side of this panel is fired with list selection.
        
        if (evt.getValueIsAdjusting()) {
            movieSelection = moviesList.getSelectedValue();
            try {
                String sql = "SELECT * from ADMIN.MOVIES WHERE TITLE = '" + movieSelection + "'";
                PreparedStatement ps = connect.getConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    InputStream is = rs.getBinaryStream("banner");
                    BufferedImage bi = ImageIO.read(is);
                    Image image = bi;
                    ImageIcon ic = new ImageIcon(image.getScaledInstance(164, 246, Image.SCALE_SMOOTH));
                    bannerImage.setIcon(ic);
                }
            } catch (IOException | SQLException e) {
                bannerImage.setText("No Image Found.");
            }
        }
    }//GEN-LAST:event_moviesListValueChanged

    public String getSelection() {
        return movieSelection;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bannerImage;
    private javax.swing.JPanel bannerPnl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel listPnl;
    private javax.swing.JList<String> moviesList;
    // End of variables declaration//GEN-END:variables
}
