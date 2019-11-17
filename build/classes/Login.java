import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Login extends javax.swing.JFrame {

    ConnectiontoDB connection = new ConnectiontoDB();
    
    public Login() {
        initComponents();
        connection.createConnection();
        mainicon();
        setghost();
    }
    
    public void clearlog()
    {
        musicuserlogin.setText("");
        musicpasslogin.setText("");
        showpass.setSelected(false);
    }
    
    public void logtoplayer()
    {
        try {
            String userL = "";
            String passL = "";
            if(!musicuserlogin.getForeground().equals(Color.GRAY))
               userL = musicuserlogin.getText().trim();
            if(!musicpasslogin.getForeground().equals(Color.GRAY))
               passL = musicpasslogin.getText().trim();
            
            Statement stateL = connection.getconnect().createStatement();
            ResultSet resultL = stateL.executeQuery("SELECT * FROM databasedc.useraccount");
            boolean userE=false, passE=false;
            
            while(resultL.next())
            {
                String usernamedb = resultL.getString("UserName");
                
                if(userL.equals(usernamedb))
                    userE = true;
            }
            
            ResultSet resultP = stateL.executeQuery("SELECT PassWord FROM databasedc.useraccount WHERE UserName = '" + userL + "'");
            while(resultP.next())
            {
                String passworddb = resultP.getString("Password");
                
                if(passL.equals(passworddb))
                    passE = true;
            }
            
            if(userL.equals("")){
                JOptionPane.showMessageDialog(null,"Please Input Your Username","No Username Found!", JOptionPane.WARNING_MESSAGE);
                musicuserlogin.requestFocus();
                if(!musicpasslogin.getForeground().equals(Color.GRAY)){
                  musicpasslogin.setText("");
                  musicpasslogin.setEchoChar((char)0);
                  musicpasslogin.setText("Enter Password");
                  musicpasslogin.setForeground(Color.GRAY);
                }
            }
            else if(!userE){
                JOptionPane.showMessageDialog(null, "Please Input Valid Username", "Username Doesn't Exists", JOptionPane.WARNING_MESSAGE);
                musicuserlogin.requestFocus();
                musicuserlogin.setText("");
                if(!musicpasslogin.getForeground().equals(Color.GRAY)){
                  musicpasslogin.setText("");
                  musicpasslogin.setEchoChar((char)0);
                  musicpasslogin.setText("Enter Password");
                  musicpasslogin.setForeground(Color.GRAY);
                }
            }
            else if(passL.equals("")){
                JOptionPane.showMessageDialog(null,"Please Input Your Password","No Password Found!", JOptionPane.WARNING_MESSAGE);
                musicpasslogin.requestFocus();
            }
            else if(!passE){
                JOptionPane.showMessageDialog(null, "Please Input Valid Password", "Password Doesn't Exists", JOptionPane.WARNING_MESSAGE);
                musicpasslogin.requestFocus();
                musicpasslogin.setText("");
            }
            else
            {   
                stateL.close();
                JOptionPane.showMessageDialog(null, "Log In Successful!"); 
                JFrame frame = (JFrame)SwingUtilities.getWindowAncestor(this); // exit the same frame
                frame.dispose();
                clearlog();
                MusicPlayer musicplayer = new MusicPlayer();
                musicplayer.setcon(connection.getconnect());
                musicplayer.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Musicplayericon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        musicusericon = new javax.swing.JLabel();
        musicuserlogin = new javax.swing.JTextField();
        musicpassicon = new javax.swing.JLabel();
        musicpasslogin = new javax.swing.JPasswordField();
        loginbtn = new javax.swing.JButton();
        regbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        showpass = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(700, 200));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Harlow Solid Italic", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Music Player");

        musicuserlogin.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        musicuserlogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                musicuserloginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                musicuserloginFocusLost(evt);
            }
        });

        musicpasslogin.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        musicpasslogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                musicpassloginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                musicpassloginFocusLost(evt);
            }
        });

        loginbtn.setText("Log In");
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });

        regbtn.setText("Register");
        regbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regbtnActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("or");

        jButton3.setText("Log In as Guest");

        showpass.setText(" Show Password");
        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(regbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Musicplayericon, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(musicpassicon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(musicusericon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(showpass)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(musicuserlogin)
                            .addComponent(musicpasslogin))
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Musicplayericon, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(musicuserlogin, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(musicusericon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(musicpassicon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(musicpasslogin, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(showpass)
                .addGap(18, 18, 18)
                .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void musicuserloginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_musicuserloginFocusGained
        if(musicuserlogin.getForeground().equals(Color.GRAY)){
            musicuserlogin.setText("");
            musicuserlogin.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_musicuserloginFocusGained

    private void musicuserloginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_musicuserloginFocusLost
        if(musicuserlogin.getText().equals("")){
            musicuserlogin.setText("Enter Your Username");
            musicuserlogin.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_musicuserloginFocusLost

    private void musicpassloginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_musicpassloginFocusGained
        if(musicpasslogin.getForeground().equals(Color.GRAY)){
            if(showpass.isSelected())
                musicpasslogin.setEchoChar((char)0);
            else
                musicpasslogin.setEchoChar('*');
            
            musicpasslogin.setText("");
            musicpasslogin.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_musicpassloginFocusGained

    private void musicpassloginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_musicpassloginFocusLost
        if(musicpasslogin.getText().equals("")){
            musicpasslogin.setEchoChar((char)0);
            musicpasslogin.setText("Enter Password");
            musicpasslogin.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_musicpassloginFocusLost

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassActionPerformed
        if(!musicpasslogin.getForeground().equals(Color.GRAY))
        {
            if(showpass.isSelected())
               musicpasslogin.setEchoChar((char)0);
            else
               musicpasslogin.setEchoChar('*');
        }
    }//GEN-LAST:event_showpassActionPerformed

    private void regbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regbtnActionPerformed
        Signup sign = new Signup(this, true);
        sign.setcon(connection.getconnect());
        sign.setVisible(true);
    }//GEN-LAST:event_regbtnActionPerformed

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        logtoplayer();
    }//GEN-LAST:event_loginbtnActionPerformed

    public void setghost()
    {
        musicuserlogin.setText("Enter Your Uesrname");
        musicuserlogin.setForeground(Color.GRAY);
        musicpasslogin.setEchoChar((char)0);
        musicpasslogin.setText("Enter Your Password");
        musicpasslogin.setForeground(Color.GRAY);
    }
    
    public void mainicon()
    {
        BufferedImage imgmusic = null;
        BufferedImage imguser = null;
        BufferedImage imgpass = null;
        
        try {
            imgmusic = ImageIO.read(getClass().getResource("/Icons/musicplayer.png"));
            imguser = ImageIO.read(getClass().getResource("/Icons/musicuser.png"));
            imgpass = ImageIO.read(getClass().getResource("/Icons/musicpass.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
                
        Musicplayericon.setIcon(new ImageIcon(imgmusic.getScaledInstance(135, 113, Image.SCALE_SMOOTH)));
        musicusericon.setIcon(new ImageIcon(imguser.getScaledInstance(70, 54, Image.SCALE_SMOOTH)));
        musicpassicon.setIcon(new ImageIcon(imgpass.getScaledInstance(70, 54, Image.SCALE_SMOOTH)));
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Musicplayericon;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginbtn;
    private javax.swing.JLabel musicpassicon;
    private javax.swing.JPasswordField musicpasslogin;
    private javax.swing.JLabel musicusericon;
    private javax.swing.JTextField musicuserlogin;
    private javax.swing.JButton regbtn;
    private javax.swing.JCheckBox showpass;
    // End of variables declaration//GEN-END:variables
}
