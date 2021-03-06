package budget;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;


public class MyTableModel2 extends AbstractTableModel{
        private Object[][] contents; //speichert daten
        private String[] columnNames; // speichert imena stolbzov
        private Class[] columnClasses; // speichert tipi stolbzov
        private String[] dateArray;
        
        public MyTableModel2(){
            
        }
        
        public MyTableModel2(Connection conn, String tableName) throws SQLException{
            super();
            getTableContents(conn, tableName);
        }
        
        private void getTableContents(Connection conn, String tableName) throws SQLException{
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rs = meta.getColumns(null, null, tableName, null);
            ArrayList colNamesList = new ArrayList(); // spisok imen stolbzov
            ArrayList colTypeList = new ArrayList(); // spisok tipov stolbzov

/*************** Kommentieren, wenn unten der switch-case Zeilen zu auskomentieren ist           */
//            colTypeList.add(String.class);
//            colTypeList.add(String.class);
//            colTypeList.add(Long.class);
//            colTypeList.add(String.class);

            while (rs.next()){
                if(rs.getString("COLUMN_NAME").equals("name")||rs.getString("COLUMN_NAME").equals("betrag")||rs.getString("COLUMN_NAME").equals("date")||rs.getString("COLUMN_NAME").equals("grund")){

                colNamesList.add(rs.getString("COLUMN_NAME"));//dobavit v spisok imja stolbza
/*************** Auskommentieren, wenn oben 4 Zeilen zu löschen sind           */
                int dbType = rs.getInt("DATA_TYPE");// opredelit tip stolbza

                switch(dbType){
                    case Types.INTEGER: colTypeList.add(Integer.class); 
                        break;
                    case Types.FLOAT: colTypeList.add(Float.class); 
                        break;
                    case Types.DOUBLE:
                    case Types.REAL: colTypeList.add(Double.class);
                        break;
                    case Types.DATE:
                    case Types.TIME:
                    case Types.TIMESTAMP: colTypeList.add(java.sql.Date.class);
                        break;
                    default: colTypeList.add(String.class);   
                        break;
                }
                }
                else{}
            }   
            
            //Spaltenname in array columnNames speichern
            columnNames = new String[colNamesList.size()];
            colNamesList.toArray(columnNames);

            //Spaltentyp in array columnClasses speichern
            columnClasses= new Class[colTypeList.size()];
            colTypeList.toArray(columnClasses);

            Statement statement = conn.createStatement();

    //        rs = statement.executeQuery("select * from "+tableName);
            rs = statement.executeQuery("select  name, betrag, date, grund from "+tableName+" order by date");

            ArrayList rowList = new ArrayList(); //behält daten aus Tabelle

            //Zikl in für Tabellendaten
            while(rs.next()){
                ArrayList cellList = new ArrayList(); //speichert Daten für jede Zelle

                for(int i=0; i< columnNames.length; i++){
                    Object cellValue = null;
                        if(columnClasses[i] == String.class)
                            cellValue = rs.getString(columnNames[i]);
                        else if((columnClasses[i])== Long.class){                            
                            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy") ;
//                            System.out.println(rs.getLong(columnNames[i]));
                            Date datum = new Date(rs.getLong(columnNames[i]));
//                            System.out.println(datum);
//                            System.out.println(formatter.format(datum));
                            cellValue = new String((String)formatter.format(datum));}
                        else if(columnClasses[i]== Integer.class)
                            cellValue = new Integer(rs.getInt(columnNames[i]));
                        else if(columnClasses[i]== Float.class)
                            cellValue = new Float(rs.getInt(columnNames[i]));
                        else if(columnClasses[i]== Double.class)
                            cellValue = new Double(rs.getInt(columnNames[i]));
                        else if(columnClasses[i]== java.sql.Date.class)
                            cellValue = rs.getDate(columnNames[i]);
                        else System.out.println("Kann nicht den Typ festlegen :" + columnNames[i]);

                    cellList.add(cellValue);}

                Object[] cells = cellList.toArray();
                rowList.add(cells);
            }

    //        rs = statement.executeQuery("select distinct name from "+tableName);
    //        ArrayList nameList = new ArrayList();        
    //        while(rs.next()){
    //            nameList.add(rs.getString("name"));
    //        }

            rs = statement.executeQuery("select distinct date from "+tableName+" order by date");
            ArrayList dateList = new ArrayList();
            while(rs.next()){
                dateList.add(rs.getString("date"));
            }
            dateArray = new String[dateList.size()];
            dateList.toArray(dateArray);
    //        dateArray=(String)dateList.toArray();

            contents = new Object[rowList.size()][];
            for(int i=0; i < contents.length; i++){
                contents[i]=(Object[])rowList.get(i);
            }
            rs.close();
            statement.close();
    }
        
    @Override
    public int getRowCount() {
        return contents.length;
    }

    @Override
    public int getColumnCount() {
        if(contents.length == 0){
            return 0;
        }else{
            return contents[0].length;
        }
    }
    
    public Object[][] getContents(){
        return contents;
    }
    
    public String[] getDateArray(){
        return dateArray;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return contents[row][column];
    }
    
    @Override
    public Class getColumnClass(int col){
        return columnClasses[col];
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
    
    
    
    
    
    
    
    
    
}
