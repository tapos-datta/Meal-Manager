
package Mill_Manager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tapos
 * a public class Initial extends JFrame
 * 
 */
public class Initial extends javax.swing.JFrame  {

    // Variables declaration start
    public static Initial initial;
    public static int number;
     public static int Month;
      public static int Year;
     public static String column[];
     public static int numberOfDay;
     int check=0;
     int flag=0;
     Initialization result;
     //end of Variables declaration 
     
     /**
      * constructor is called
      * set the name of frame is INITIALIZATION
      * frame resizable makes false
      * 
      */
    public Initial() {
        
        super("INITIALIZATION");
        initComponents();
         this.setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setLocationRelativeTo(null);
        setResizable(false);
        Check_function();
        TextFiledEdit();
        
    }
    
    /**
     * using MouseListener in three text filed NumberOfMember,year,month
     * to set text is null in TextFiledEdit method
     * 
     */
    
    void TextFiledEdit(){
        
        NumberOfMember.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                  NumberOfMember.setText("");
                }
            });
             
             year.addMouseListener(new MouseAdapter(){
             @Override
                 public void mouseClicked(MouseEvent e){
                    year.setText("");
                 }
             });
            
             month.addMouseListener(new MouseAdapter(){
                 @Override
                  public void mouseClicked(MouseEvent e){
                     month.setText("");
                    }
             });
    }
    
    /**
     * a mathod Check_function to check "is there any file exist the name of Initialization.ser"
     * if the file is found  ,it will set the month number , number of member and year
     * else file is not found ,using flag variable with zero
     */
    
    void Check_function(){
        
        try {
           FileInputStream fin=new FileInputStream("initialization.ser");
           this.flag=1;
            ObjectInputStream out=new  ObjectInputStream(fin);
            
            try {
                 result=(Initialization) out.readObject();
                 out.close();
                 
               NumberOfMember.setText(""+result.member+"");
               year.setText(""+result.year+"");
               month.setText(""+result.month+"");
               
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Initial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            flag=0;
        }
        catch (IOException ex) {
            Logger.getLogger(Initial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NumberOfMember = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        month = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        year = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("HOW MANY MEMBER");

        NumberOfMember.setBackground(new java.awt.Color(102, 255, 255));
        NumberOfMember.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NumberOfMember.setText("0");
        NumberOfMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberOfMemberActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("NUMBER OF MONTH");

        month.setBackground(new java.awt.Color(102, 255, 255));
        month.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        month.setText("1 to 12");
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(255, 0, 51));
        back.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("YEAR");

        year.setBackground(new java.awt.Color(102, 255, 255));
        year.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        year.setText("input must be up to 2014");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(year, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(month)
                            .addComponent(NumberOfMember))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumberOfMember, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(month)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(year))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NumberOfMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumberOfMemberActionPerformed
               
    }//GEN-LAST:event_NumberOfMemberActionPerformed
    
    /**
     * 
     * @param evt of jButton1 for user input
     * for user input three text field is found in the frame 
     * one of is number of member ,other number of month of year and year
     * after completing the previous task 
     * read the text from those text field and get members name from user
     * 
     */
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
       // Check_function();
        if(flag==0)
        {
            check=0;    // check all data valid or not,'0' is valid '1' is not valid 
          try{
            
         String  s=NumberOfMember.getText();
        number=Integer.parseInt(s);
        
        s=month.getText();
        Month=Integer.parseInt(s);
        
        s=year.getText();
       
        Year=Integer.parseInt(s);
        
       
        
        if(number<=0 || Month<=0 || Month>12 || Year<2014)
            throw new NullPointerException();
        
        
        column =new String[number];
        
        for(int i=0;i<number;i++)
        {
             s=JOptionPane.showInputDialog(null,(i+1)+ " .ENTER THE MEMBER NAME ");
            
            if(s.isEmpty())
            {
                i--;
                continue;
            }
            
            column[i]=s;
        }
        
        numberOfDay=initial.day_check(Month,Year);
      
        
        }
        catch(Exception e){
            check=1;
           
            JOptionPane.showMessageDialog(null,"PLEASE ENTER VALID DATA AND TRY AGAIN");
        }
          
          
        if(check==0)
        {
            JOptionPane.showMessageDialog(null, "Initialization is successfully done");
            File_save();       //to save data call File_save mathod
            flag=1;            // if flag is 1 that means one file already initialized 
           
        }
        
        }
        else
        {
           JOptionPane.showMessageDialog(null,"Already initialaized\nClean data first then initialaize"); 
        }
    
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    /**
     * 
     * @param evt of back Button
 close the Initialization frame 
 and open the MainWindow frame
     */
    
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
      
        MainWindow.mainWindow.setVisible(true);
        initial.dispose();
        
    }//GEN-LAST:event_backActionPerformed

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
    
    }//GEN-LAST:event_monthActionPerformed

    /**
     * set a object of Initialization and run a new JFrame
     * 
     */
    public static void call_initial() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Initial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Initial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Initial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Initial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
     
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow.mainWindow.setVisible(false);
               initial= new Initial();
               initial.setVisible(true);
              
               
            }
        });
    }
    
        /**
         * create a object of Initialization 
         * and write a object file as name initialization.ser of  Initialization object
         */
    
    
   static void  File_save(){
       
       Initialization ini=new Initialization(Month, Year,numberOfDay,column, number);
      
           try {
               FileOutputStream fos= new  FileOutputStream("initialization.ser");
               
               try {
                   ObjectOutputStream out=new ObjectOutputStream(fos);
                   
                   out.writeObject(ini);
                   out.close();
               } catch (IOException ex) {
                   Logger.getLogger(Initial.class.getName()).log(Level.SEVERE, null, ex);
               }
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Initial.class.getName()).log(Level.SEVERE, null, ex);
           }
       
        
    }
   
    /**
     * 
     * number of day is found by using  month and year in day_check method
     */
    
    
    public static int day_check(int _month,int _year){
        
        int arr[]=new int[13];
        arr[1]=31;
        arr[2]=28;
        arr[3]=31;
        arr[4]=30;
        arr[5]=31;
        arr[6]=30;
        arr[7]=31;
        arr[8]=31;
        arr[9]=30;
        arr[10]=31;
        arr[11]=30;
        arr[12]=31;
        
        if(((_year%4==0 && _year%100!=0)|| _year%400==0) && _month==2)
            return 29;
        else
            return arr[_month];
   
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NumberOfMember;
    private javax.swing.JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField month;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables

   
}
