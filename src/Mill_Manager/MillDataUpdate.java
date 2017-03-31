
package Mill_Manager;

import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.text.Font.font;



/**
 *
 * @author TAPOS DATTA
 */
public class MillDataUpdate extends javax.swing.JFrame {

    /**
     * Creates new form MillDataUpdate
     */
    
    //variable declaration start
    public static MillDataUpdate millDataUpdate;
    private JTable table1;
    JScrollPane scroll;
    Container contain;
    String column[],colomn[];
    Initialization result;
    int height=20;
    Object row[][];
    static int check=0;
    //end of declaration of variable 
    
    
    /**
     * constructor of MillDataUpdate class
     * name of frame is Mill Data Update
     */
    
    public MillDataUpdate() {
        super("Mill Data Update");
        
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        
         File_Load();
        if(check==0)
            Set_table();
    }
    
    
    
    
        /**
         * to check the initialization.ser file exist or not  in File_Load method
         * 
         */
    
    
    void File_Load(){
           
        try {
            FileInputStream fin=new FileInputStream("Initialization.ser");
            ObjectInputStream out=new  ObjectInputStream(fin);
            
            try {
                 result=(Initialization) out.readObject();
                 out.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MillDataUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
           
            JOptionPane.showMessageDialog(null, "Initialize data first\n Thank you");
            Update.updatePart.setVisible(true);
            check=1;
        } 
        catch (IOException ex) {
            Logger.getLogger(MillDataUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
       }
    
    
    /**
     * updated table data is written in file_write method
     */
    
    void file_write(){
           try {
               FileOutputStream fos= new  FileOutputStream("initialization.ser");
               
               try {
                   ObjectOutputStream out=new ObjectOutputStream(fos);
                   
                   out.writeObject(result);
                   out.close();
               } catch (IOException ex) {
                   Logger.getLogger(Initial.class.getName()).log(Level.SEVERE, null, ex);
               }
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Initial.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    
    
        void Set_table(){

        call_table(result.row,result.colomn);
    }
    
    
        /**
       * 
       * call_table is a method with parameter Object type variable and String variable
       * and in method a table is created which is not editable and represent the mill number of member
       */
       
   
        
    void call_table(Object row[][],String colomn[]){
        
         jTable1.setModel(new DefaultTableModel(row,colomn){
              
            
            public boolean  isCellEditable(int row, int col){
                return false;     //table data not changeable
            }   
        });
         
         jTable1.addMouseListener(new  MouseAdapter() {
             
             //override mouseClicked method
               public void mouseClicked(MouseEvent me){
                   
                  JTable target =(JTable) me.getSource();
                   int ro = target.getSelectedRow();
                   int column = target.getSelectedColumn();
                   
                    if (me.getClickCount() == 2 && column>=1 && column<=result.numberDate)
                    {
                        
                        Object o= jTable1.getValueAt(ro, column);
                        String s=o.toString();
                        o=jTable1.getValueAt(ro,result.numberDate+1 );
                        String p=o.toString();
                        
                        double temTotal=Double.parseDouble(p);
                        double numTotal=Double.parseDouble(s);
                        
                        try
                        {
                            
                            
                            double no_meal=Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the number of meal of that day"));
                        
                              if(no_meal<0.0)
                               {
                                      throw new NullPointerException();
                               }
                             
                            jTable1.setValueAt(no_meal, ro, column);
                            
                            double sumTotal=temTotal-numTotal+no_meal;
                            
                            jTable1.setValueAt(sumTotal, ro, result.numberDate+1);
                            
                            result.row[ro][column]=no_meal;
                            result.rowdata[ro][column]=no_meal;
                            result.rowdata[ro][result.numberDate+1]=sumTotal;
                            result.row[ro][result.numberDate+1]=sumTotal;
                            
//                        System.out.println(result.numberDate+1);
//                        System.out.println("MOUSE CLICKED  "+ro+" "+column +" "+ s +" "+ p);
                         // your valueChanged overridden method 
                 
                        }
                        catch(Exception e){
                          //System.out.println("Exception");  
                        }
                        file_write();
 
                     }  
                 
                 
             }
               
               
          });
         
         
          jTable1.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
         jTable1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
          jTable1.setRowHeight(jTable1.getRowHeight() + height);
        jTable1.getTableHeader().setReorderingAllowed(false);   //column can not be shifted
         height=0;
         
         

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jTable1.setBackground(new java.awt.Color(153, 255, 102));
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
        jScrollPane1.setViewportView(jTable1);

        back.setBackground(new java.awt.Color(255, 255, 102));
        back.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("TABLE OF MILL DATA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(344, 344, 344))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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
    
   
    /**
     * 
     * @param evt back button
     * close the frame and back to Update frame  
     */
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        millDataUpdate.setVisible(false);
               
        Update.updatePart.setVisible(true);
        millDataUpdate.dispose();
    }//GEN-LAST:event_backActionPerformed
    
    /**
     * NumberMealUpdate method update total mill of a member in table's total column 
     */

    
    /**
     * CallMillUpdate cerate a new Jframe for update mill data and record of all data in a table
     */
    public static void CallMillUpdate() {
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
            java.util.logging.Logger.getLogger(MillDataUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MillDataUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MillDataUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MillDataUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                millDataUpdate=new MillDataUpdate();
                if(check==0)
                millDataUpdate.setVisible(true);
                else
                   millDataUpdate.dispose();
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
