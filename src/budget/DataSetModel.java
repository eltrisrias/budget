/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package budget;

import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.DomainOrder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.time.Month;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author el
 */
public class DataSetModel {
    
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    TimeSeriesCollection datasetXY = new TimeSeriesCollection();
    Connection conn = SQLiteConnection.getConnection();

    /**
     *
     * @throws SQLException
     */
    public DataSetModel(int swtch) throws SQLException, ParseException {
        MyTableModel2 mod = new MyTableModel2(conn, "MAINTABLE");        
        Object[][] data=mod.getContents().clone();        
        switch(swtch){
            case 1: // value,name,date for BarChart
                for(Object[] hz:data){
                    double d = Double.parseDouble((String)(hz[1])); //wert: 50.7                
                    String ab = "Ausgaben";
                    long date = Long.parseLong((String)hz[2]); //1369215449186 
                    SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
                    String dateString = dt.format(new Date(date)); //  22.05.2013 
                    System.out.println(date);
                    dataset.addValue(d, ab, dateString);
                }
                break;                
            case 2: // value,name,date for BarChart
                for(Object[] hz:data){
                    double d = Double.parseDouble((String)(hz[1])); //wert: 50.7                
                    String ab = (String)hz[0]; //name: Thommy
                    long date = Long.parseLong((String)hz[2]); //1369215449186 
                    SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
                    String dateString = dt.format(new Date(date)); //  22.05.2013 
                    System.out.println(date);
                    dataset.addValue(d, ab, dateString);
                }
                break; 
            case 3: //                
                TreeSet<String> namesHS = new TreeSet<String>();
                for(Object[] hz:data){
                   namesHS.add((String)hz[0]);
                }
                Object[] a = namesHS.toArray();
                int lng = a.length;
                //
                TimeSeries[] names1 = new TimeSeries[lng];
                int i=0;
                for(String name:namesHS){
                    names1[i] = new TimeSeries(name, Day.class);
                    i++;
                }
                //                                
                for(Object[] hz:data){
                    String ab = (String)hz[0];
                    int j=0; 
                    while(!(ab.equals((String)a[j]))){
                        j++;
                    };
                    long date = Long.parseLong((String)hz[2]); 
                    Date d = new Date(date);
                    names1[j].add(new Day(d), Double.parseDouble((String)(hz[1])));
                }
                for(int h=0; h<i;h++){
                    datasetXY.addSeries(names1[h]);
                }
                datasetXY.setDomainIsPointsInTime(true);
                break;                 
            default:
                for(Object[] hz:data){
                double d = Double.parseDouble((String)(hz[1])); //wert: 50.7
                String ab = (String)hz[0]; //name: Thommy
                String ac = (String)hz[2]; //date: 2012-12-01
    //            dataset.addValue((Double)hz[1], (String)hz[0], (String)hz[2]);
                dataset.addValue(d, ab, ac);
                }
        }
        int j =5;
    } 
    
    
    
    private static JFreeChart createChart(XYDataset dataset){
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Legal & General Unit Trust Prices", // title
            "Date", // x-axis label
            "Price Per Unit",   // y-axis label
            dataset,    // data
            true,   // create legend?
            true,   // generate tooltips?
            false   // generate URLs?
        );

        chart.setBackgroundPaint(Color.white);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
    
        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
        }
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        return chart;

        
    }
    
//    private static XYDataset createDataset(){
//        
//        
//        TimeSeries s1 = new TimeSeries("Alex", Day.class);
//        s1.add(new Day(1,0,2013), 18.5);
//        
//    }


    
    
}
