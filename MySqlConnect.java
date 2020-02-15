
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MySqlConnect {

    private static  Connection conn = null;
   private static final String driver = "com.mysql.jdbc.Driver";
   private static final String user = "user";
   private static final String password = "password";
   private static final String url = "jdbc:mysql://65.19.141.67/user_abonati";

    public static Connection connectDB() {
        
    //Statement st = null;
    //ResultSet rs = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
          //  st = conn.createStatement();
           // rs = st.executeQuery("SELECT * from utilizatori");

     /*   while (rs.next()) {
            String name=rs.getString("User");
            String parola=rs.getString("Password");
            System.out.println(name+" "+parola);
        }
*/
           //JOptionPane.showMessageDialog(null,"Connected to Database");
           return conn;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
       
    }
    
}
