package budget;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;



public class MyComboBoxModelName extends DefaultComboBoxModel  {
    Object names[];

    
    public MyComboBoxModelName(Connection con, String tableName) throws SQLException{
        super();
        getNameContent(con, tableName);
    }
    
    public void getNameContent(Connection con, String tableName) throws SQLException{
        
        ArrayList colNames = new ArrayList(); 
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select name from Actor");        
       
        while(rs.next()){           
            Object cellValue = rs.getString("name");
            colNames.add(cellValue);            
        }
        names = colNames.toArray();
        
       rs.close();
       statement.close();
    }

    @Override
    public int getSize() {
        return names.length;
    }

    @Override
    public Object getElementAt(int index) {
        return names[index];
    }
    
    public Object[] getNames(){
        return names;
    }
}
