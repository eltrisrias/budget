package budget;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SqlBefehl {
    public static void insert(String name, double betrag, String grund) throws SQLException{
        Connection con = SQLiteConnection.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("insert into SQLiteProbe values ('"+name+"',"+betrag+", '"+ grund+"')");
    }
    
    public static void insertMaintable(String name, double betrag, java.sql.Date date, String grund) throws SQLException{
        Connection con = SQLiteConnection.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("insert into MAINTABLE "
                + "(name, betrag, date, grund) "
                + "values "
                + "('"+name+"',"+betrag+", '"+date+"', '"+ grund+"')");
    }
    
    public static void insertName(String name) throws SQLException{
        Connection con = SQLiteConnection.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("insert into Actor "
                + "(name)"
                + " values "
                + "('"+name+"')");
//        INSERT into Actor (name) VALUES ('name')
    }
    
    public static void insertGrund(String grund, String gruppe) throws SQLException{
        Connection con = SQLiteConnection.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("insert into GRUND (name, gruppe) values "
                +"('"+grund+"' , '"+gruppe+"')");
//        insert into GRUND (name , gruppe) values ('probe' , 'Ausgabe')
    }
    
    public static void deleteName(String name) throws SQLException{
        Connection con = SQLiteConnection.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("delete from Actor where name = "
                + "('"+name+"')");
//        DELETE FROM Actor WHERE name='Boris'    
    }
    
    public static void deleteGrund(String grund) throws SQLException{
        Connection con = SQLiteConnection.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("delete from GRUND where name = "
                + "('"+grund+"')");
//        DELETE FROM GRUND WHERE name='Boris'
    }
    
    public static void selectAll(){
        try {
            Connection con = SQLiteConnection.getConnection();
            Statement stm = con.createStatement();
           // String ergeb = stm.execute("Select * from SQLiteProbe");
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlBefehl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
}
