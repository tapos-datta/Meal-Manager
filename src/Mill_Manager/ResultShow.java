
package Mill_Manager;

import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static Mill_Manager.MillDataUpdate.millDataUpdate;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Tapos
 */
public class ResultShow extends javax.swing.JFrame {

    //variable declaration start
    Initialization result;
    Object rowshow[][];
    static int flag=0;
    double millRate=0.0;
    int height=25;
    String Columnshow[]={"NAME","MILL NUMBER","MILL RATE","COST","DEPOSIT","BALANCE"};
    //end of variable declaration
    
    DecimalFormat four=new DecimalFormat("#0.00");   // set precision is 10^-3
    
    public static ResultShow resultShow;
   
    
    /**
     * constructor of ResultShow class
     * name of frame is "Final Result"
     */
    
    public ResultShow() {
        
        super("Final Result");
        
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setLocationRelativeTo(null);
        setResizable(false);
        File_Load();
        if(flag==0)
        {
            Calculation();
        }
       
    }
    
    
    /**
     * total mill number ,total cost ,mill rate is calculated from initialization.ser file
     * in Calculation method 
     */
    
    void Calculation(){
        
        
       
        
        double totalMill=0.0;
        
        for(int i=0;i<result.member;i++)
        {
            totalMill+=result.rowdata[i][result.numberDate+1];
        }
        
        double totalCost=0.0;
        
        
         for(int i=0;i<result.member;i++)
        {
            double tot=0.0;
            for(int j=1;j<=result.numberDate;j++)
            {
                tot+=result.saveMoney[i][j];
            }
            result.MemberImformation[i].SetDiposite(tot);
        }
        
        for(int i=0;i<result.MemberImformation.length;i++)
        {
            totalCost+=result.MemberImformation[i].diposit1;
        }
        
        if(totalMill==0.0 || totalCost==0.0)
            millRate=0.0;
        else
        millRate=totalCost/totalMill;
        

        for(int i=0;i<result.MemberImformation.length;i++)
        {
            result.MemberImformation[i].SetNumberMeal(result.rowdata[i][result.numberDate+1]);
            result.MemberImformation[i].TotalCost(millRate);
            result.MemberImformation[i].payamount=result.MemberImformation[i].Payamount();
        }
        
        TableSet();
    }
    
    /**
     * calculated all data for members is now set a JTable in TableSet method 
     */
    
    void TableSet(){
        rowshow= new Object[result.member][6];
        
        for(int i=0;i<result.member;i++)
        {
            for(int j=0;j<6;j++)
            {
                if(j==0)
                    rowshow[i][j]=result.MemberImformation[i].memberName;
                if(j==1)
                    rowshow[i][j]=result.MemberImformation[i].numOfMeal;
                if(j==2)
                    rowshow[i][j]=four.format(millRate);
                if(j==3)
                    rowshow[i][j]=four.format(result.MemberImformation[i].cost);
               
                if(j==4)
                    rowshow[i][j]=four.format(result.MemberImformation[i].diposit1);
                if(j==5)
                    rowshow[i][j]=four.format(result.MemberImformation[i].Payamount());
            }
        }
        
        call_table(rowshow,Columnshow);
       
    }
    
         /**
         * to check the initialization.ser file exist or not  in File_Load method
         * 
         */
    
     void File_Load(){
           
        try {
            FileInputStream fin=new FileInputStream("initialization.ser");
            
            ObjectInputStream out=new  ObjectInputStream(fin);
            
            try {
                 result=(Initialization) out.readObject();
                 out.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MillDataUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            flag=1;
           
            JOptionPane.showMessageDialog(null, "Initialize data first\n Thank you");
             MainWindow.mainWindow.setVisible(true);
            
        } catch (IOException ex) {
            Logger.getLogger(MillDataUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
             
           
    }
     
     /**
      * 
      * make a jtable in call_table method  
      * and table cell is not editable
      */
     
      void call_table(Object row[][],String colomn[]){
        
         jTable1.setModel(new DefaultTableModel(row,colomn){
            
            public boolean  isCellEditable(int row, int col){
                return false;     //table data not changeable
            }
          
            
        });
         jTable1.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        
          jTable1.setRowHeight(jTable1.getRowHeight() + height);
        jTable1.getTableHeader().setReorderingAllowed(false);   //column can not be shifted
         height=0;
         
         TableColumn column = null;
         
          for (int i = 0; i < 6; i++) {
            column = jTable1.getColumnModel().getColumn(i);
            
            
                column.setMaxWidth(116);
            
                column.setMinWidth(116);
            
          
        }

    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 102));
        jPanel1.setForeground(new java.awt.Color(153, 255, 0));

        jLabel1.setBackground(new java.awt.Color(102, 255, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("RESULT");

        jTable1.setBackground(new java.awt.Color(255, 255, 51));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(102, 102, 255));
        jScrollPane1.setViewportView(jTable1);

        back.setBackground(new java.awt.Color(255, 255, 0));
        back.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * 
     * @param evt back button
     * this frame is closed and back to Main_Window frame
     */
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        resultShow.setVisible(false);
        MainWindow.mainWindow.setVisible(true);
        resultShow.dispose();
    }//GEN-LAST:event_backActionPerformed

    
    /**
     * run the new Jframe in CallResultShow method
     */
    public static void CallResultShow() {
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
            java.util.logging.Logger.getLogger(ResultShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                resultShow=new ResultShow();
                
                if(flag==0)
                resultShow.setVisible(true);
                else
                    resultShow.dispose();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
