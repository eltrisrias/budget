package budget;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQLiteConnection {

    private static Connection con;
    public static Connection getConnection() {
        try{
            try {
                try {
                    Driver driver = (Driver)Class.forName("org.sqlite.JDBC").newInstance();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (InstantiationException ex) {
                Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:sqlite:testdb.db";
            if(con==null) con= DriverManager.getConnection(url);
            return con;
        }catch(SQLException ex){
        }
//        finally{
//            try{
//                if(con !=null) con.close();
//            }catch(Exception ex){}
//        }
        return con;
    }
}
