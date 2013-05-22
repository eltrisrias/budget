package calendar.app;

import java.util.Calendar;

public class DatePickerExample extends javax.swing.JFrame {

   /**
    * Creates new form DatePickerExample
    */

   public DatePickerExample() {
       initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */

   @SuppressWarnings("unchecked")

   // <editor-fold defaultstate="collapsed" desc="Generated Code">

   private void initComponents() {
     jPanel1 = new javax.swing.JPanel();
       outputtextbox = new javax.swing.JTextField();
      mydatechooser = new com.toedter.calendar.JDateChooser();
       lblCooseDate = new javax.swing.JLabel();
      lblOutput = new javax.swing.JLabel();
       btnGetDate = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       setTitle("Date Picker Example");
       lblCooseDate.setText("Choose Date");
       lblOutput.setText("Output");
      btnGetDate.setText("Get Date");
      
      btnGetDate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton1ActionPerformed(evt);
           }
       });
       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jPanel1Layout.setHorizontalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel1Layout.createSequentialGroup()
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanel1Layout.createSequentialGroup()
                       .addGap(147, 147, 147)
                      .addComponent(lblCooseDate))
                  .addGroup(jPanel1Layout.createSequentialGroup()
                      .addGap(143, 143, 143)
                       .addComponent(btnGetDate))
                   .addGroup(jPanel1Layout.createSequentialGroup()
                      .addGap(165, 165, 165)
                       .addComponent(lblOutput))
                   .addGroup(jPanel1Layout.createSequentialGroup()
                      .addGap(123, 123, 123)
                      .addComponent(mydatechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGroup(jPanel1Layout.createSequentialGroup()
                      .addGap(65, 65, 65)
                       .addComponent(outputtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addContainerGap(83, Short.MAX_VALUE))
       );

      jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
               .addComponent(lblCooseDate)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(mydatechooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(13, 13, 13)
               .addComponent(btnGetDate)
             .addGap(25, 25, 25)
             .addComponent(lblOutput)
               .addGap(18, 18, 18)
              .addComponent(outputtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addContainerGap(25, Short.MAX_VALUE))
      );

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addContainerGap())
       );

      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addContainerGap())
    );
     pack();
 }// </editor-fold>



  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
      Calendar cal = mydatechooser.getCalendar();
      long inte = cal.getTimeInMillis();
      int datevar = cal.get(Calendar.DATE);
      int monthvar = cal.get(Calendar.MONTH);
     int yearvar = cal.get(Calendar.YEAR);
//      outputtextbox.setText("Day: " + datevar + ", Month: " + monthvar + " Year is "+ yearvar + ".");
      outputtextbox.setText(""+inte);
  }

/**
   * @param args the command line arguments
   */

  public static void main(String args[]) {
      /*
       * Set the Nimbus look and feel
      */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">

     /*
       * If Nimbus (introduced in Java SE 6) is not available, stay with the
      * default look and feel. For details see
      * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
       */

      try {
          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
             if ("Nimbus".equals(info.getName())) {
                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
                 break;
             }
          }
      } catch (ClassNotFoundException ex) {
          java.util.logging.Logger.getLogger(DatePickerExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(DatePickerExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(DatePickerExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(DatePickerExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
    /*
       * Create and display the form
      */
      java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
             new DatePickerExample().setVisible(true);
          }
      });
  }

 // Variables declaration - do not modify
  private javax.swing.JButton btnGetDate;
  private javax.swing.JLabel lblCooseDate;
 private javax.swing.JLabel lblOutput;
  private javax.swing.JPanel jPanel1;
  private com.toedter.calendar.JDateChooser mydatechooser;
  private javax.swing.JTextField outputtextbox;
  // End of variables declaration
}