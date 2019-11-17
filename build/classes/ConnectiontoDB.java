import java.sql.*;
import java.util.logging.*;

public class ConnectiontoDB 
{ 
    Connection connect;
    
    public Connection getconnect()
    {
        return this.connect;
    }
    
    public void createConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/databasedc?user=root&password=&useLegacyDatetimeCode=false&serverTimezone=UTC", "root" , "(Hello1!)"); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectiontoDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectiontoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
