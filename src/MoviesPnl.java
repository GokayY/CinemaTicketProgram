
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public final class MoviesPnl extends javax.swing.JPanel {

    private DBConnection dbConnection;
    private String selectedMovie;

    public MoviesPnl() {
        initComponents();
        dbConnection = new DBConnection();

        LoadMovieList();
    }

    public void LoadMovieList() {
        // Loading movies from database into the list
        try (Connection connection = dbConnection.getConnection()) {
            String query = "SELECT * FROM MOVIES";
            ResultSet rs;
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                rs = ps.executeQuery();
                DefaultListModel dlm = new DefaultListModel();
                while (rs.next()) {
                    dlm.addElement(rs.getString("Title"));
                }
                moviesList.setModel(dlm);
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e, "Error", ERROR_MESSAGE);
        }
    }

    public String GetSelectedMovie() {
        return selectedMovie;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        moviesList = new javax.swing.JList<>();
        bannerPnl = new javax.swing.JPanel();
        bannerImage = new javax.swing.JLabel();
        title = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(650, 360));
        setMinimumSize(new java.awt.Dimension(650, 360));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(650, 360));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(274, 250));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(274, 250));
        jScrollPane1.setName("listPnl"); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(274, 250));

        moviesList.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        moviesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        moviesList.setToolTipText("");
        moviesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                moviesListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(moviesList);

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

        title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Movies");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        title.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(bannerPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bannerPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void moviesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_moviesListValueChanged
        // Action for showing the banner of the film which is on the left hand side of this panel is fired with list selection.
        if (evt.getValueIsAdjusting()) {
            bannerImage.setText(null);
            bannerImage.setIcon(null);
            selectedMovie = moviesList.getSelectedValue();

            try (Connection connection = dbConnection.getConnection()) {
                String sql = "SELECT * from ADMIN.MOVIES WHERE Title = '" + selectedMovie + "'";
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    InputStream is = rs.getBinaryStream("banner");
                    BufferedImage bi = ImageIO.read(is);
                    Image image = bi;
                    ImageIcon ic = new ImageIcon(image.getScaledInstance(164, 246, Image.SCALE_SMOOTH));
                    bannerImage.setIcon(ic);
                }
            } catch (IOException | SQLException e) {
                bannerImage.setText(null);
                bannerImage.setText("No Image Found.");
            }
        }
    }//GEN-LAST:event_moviesListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bannerImage;
    private javax.swing.JPanel bannerPnl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> moviesList;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
