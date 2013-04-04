package budget;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;



public class MyComboBoxModelGrund extends DefaultComboBoxModel  {
    Object grunden[];

    
    public MyComboBoxModelGrund(Connection con, String tableName) throws SQLException{
        super();
        getGrundContent(con, tableName);
    }
    
    public void getGrundContent(Connection con, String tableName) throws SQLException{
        
        ArrayList colNames = new ArrayList(); 
        Statement statement = con.createStatement();
//        ResultSet rs = statement.executeQuery("select name from GRUND");            
        ResultSet rs=null;
        
        if(GUIBudget.rbtnAusgabe.isSelected()||GUIBudget.rbtnAusgabeVerwalt.isSelected()){
            rs = statement.executeQuery("select name from GRUND where gruppe='Ausgabe'");
        }else
        if(GUIBudget.rbtnEinnahme.isSelected() || GUIBudget.rbtnEinnahmeVerwalt.isSelected()){
            rs = statement.executeQuery("select name from GRUND where gruppe='Einnahme'");
        }else {
            rs = statement.executeQuery("select name from GRUND where gruppe='nothing'");
        }
           
        while(rs.next()){           
            Object cellValue = rs.getString("name");
            colNames.add(cellValue);            
        }
        grunden = colNames.toArray();
        
       rs.close();
       statement.close();
    }

    @Override
    public int getSize() {
        return grunden.length;
    }

    @Override
    public Object getElementAt(int index) {
        return grunden[index];
    }
}
