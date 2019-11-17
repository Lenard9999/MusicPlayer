import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Search extends javax.swing.JDialog {

    public Search(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchtext = new javax.swing.JTextField();
        searchbox = new javax.swing.JComboBox<>();
        okbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        searchbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Artist", "Listener", "Playlist", "Album", "Song" }));

        okbtn.setText("OK");
        okbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(okbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchtext, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchtext, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okbtn)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void searching() // NOT DONE
    {
        try{
            String text = searchtext.getText();
        
            if(text.equals(""))
                JOptionPane.showMessageDialog(null, "Please Input Something To Search");
            else{
                if(searchbox.getSelectedItem().equals("None"))
                    JOptionPane.showMessageDialog(null, "Please Choose A Category to Search!");
                else if(searchbox.getSelectedItem().equals("Artist")){
                    DefaultTableModel model = (DefaultTableModel) artistSearchResultTable.getModel();
                    model.setRowCount(0);
                    
                    Statement searchArtist = getcon().createStatement;
                    ResultSet rsSearchArtist = searchArtist.executeQuery("SELECT * FROM databasedc.useraccount WHERE Type = '"+"Artist"+"'");
                    
                    while(rsSearchArtist.next()){
                        String artistUsername = rsSearchArtist.getString("UserName");
                        
                        if(artistUsername.contains(text)){
                            model.insertRow(artistSearchResultTable.getRowCount(), new Object[]{
                                artistUsername
                            });
                        }
                    }
                }
                else if(searchbox.getSelectedItem().equals("Listener")){
                    DefaultTableModel model = (DefaultTableModel) listenerSearchResultTable.getModel();
                    model.setRowCount(0);
                    
                    Statement searchListener = getcon().createStatement;
                    ResultSet rsSearchListener = searchListener.executeQuery("SELECT * FROM databasedc.useraccount WHERE Type = '"+"Registered"+"'");
                    
                    while(rsSearchListener.next()){
                        String listenerUsername = rsSearchListener.getString("UserName");
                        
                        if(listenerUsername.contains(text)){
                            model.insertRow(listenerSearchResultTable.getRowCount(), new Object[]{
                                listenerUsername
                            });
                        }
                    }
                }
                else if(searchbox.getSelectedItem().equals("Playlist")){
                    DefaultTableModel model = (DefaultTableModel) playlistSearchResultTable.getModel();
                    model.setRowCount(0);
                    
                    Statement searchPlaylist = getcon().createStatement;
                    ResultSet rsSearchPlaylist = searchPlaylist.executeQuery("SELECT * FROM databasedc.playlistdc NATURAL JOIN databasedc.useraccount WHERE UserID != '"+getuser().getid()+"' AND Type != '"+"Guest"+"'");
                    
                    while(rsSearchPlaylist.next()){
                        String playlistName = rsSearchPlaylist.getString("PlaylistName");
                        
                        if(playlistName.contains(text)){
                            model.insertRow(playlistSearchResultTable.getRowCount(), new Object[]{
                                rsSearchPlaylist.getString("UserName"),
                                playlistName
                            });
                        }
                    }
                }
                else if(searchbox.getSelectedItem().equals("Album")){
                    DefaultTableModel model = (DefaultTableModel) albumSearchResultTable.getModel();
                    model.setRowCount(0);
                    
                    Statement searchAlbum = getcon().createStatement;
                    ResultSet rsSearchAlbum = searchAlbum.executeQuery("SELECT * FROM databasedc.albumdc NATURAL JOIN databasedc.useraccount WHERE UserID != '"+getuser().getid()+"' AND Type != '"+"Guest"+"'");
                    
                    while(rsSearchAlbum.next()){
                        String albumName = rsSearchAlbum.getString("AlbumName");
                        
                        if(albumName.contains(text)){
                            model.insertRow(albumSearchResultTable.getRowCount(), new Object[]{
                                rsSearchAlbum.getString("UserName"),
                                albumName
                            });
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void okbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okbtnActionPerformed
        searching();
    }//GEN-LAST:event_okbtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Search dialog = new Search(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton okbtn;
    private javax.swing.JComboBox<String> searchbox;
    private javax.swing.JTextField searchtext;
    // End of variables declaration//GEN-END:variables
}
