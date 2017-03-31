
package Mill_Manager;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static Mill_Manager.MillDataUpdate.millDataUpdate;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Tapos
 */
public class BazarUpdate extends javax.swing.JFrame {

    /**
     * Creates new form BazarUpdate
     */
    
    Initialization result;
   public static BazarUpdate bazarUpdate;
   int height=20;
   static int check=0;
    
    /**
     * constructor of BazarUpdate
     * set name of the frame is "Bazar Data Update"
     */
   
    public BazarUpdate() {
        super("Bazar Data Update");
        
        initComponents();
         this.setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setLocationRelativeTo(null);
        setResizable(false);
        
        File_Load();
        if(check==0)
        call_table(result.newrow,result.newcolomn);
        
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
            check=1;
            Update.updatePart.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MillDataUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
           
           
    }
      
      
      /**
       * 
       * call_table is a method with parameter Object type variable and String variable
       * and in method a table is created which is not editable and represent the bazar list 
       */
      
       void call_table(Object row[][],String colomn[]){
        
         jTable2.setModel(new DefaultTableModel(row,colomn){
            
            public boolean  isCellEditable(int row, int col){
                return false;     //table data not changeable
            }
          
            
        });
         jTable2.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
      
          jTable2.setRowHeight(jTable2.getRowHeight() + height);
          
          height=0;
          
          
          TableColumn column = null;
          
        for (int i = 0; i < 3; i++) {
            column = jTable2.getColumnModel().getColumn(i);
                column.setMaxWidth(1000);
        }
          
          
        jTable2.getTableHeader().setReorderingAllowed(false);   //column can not be shifted
        
        
        jTable2.addMouseListener(new  MouseAdapter() {
             
             //override mouseClicked method
               public void mouseClicked(MouseEvent me){
                   
                  JTable target =(JTable) me.getSource();
                   int ro = target.getSelectedRow();
                   int column = target.getSelectedColumn();
                  
                   if (me.getClickCount() == 2 && column>=1 && column<=2)
                   {
                       try{
                   
        
                           String  name=JOptionPane.showInputDialog("NAME OF MEMBER");
                          double   amount =Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the cost of person of that day"));
                          
                          if(amount<0.0)
                          {
                              throw new NullPointerException();
                          }
                          
                          int t;
                           for( t=0;t<result.nameList.length;t++)
                            {
                                if(result.nameList[t].equals(name))
                                {
                                    result.saveMoney[t][ro+1]=amount;
                                        break   ;
                                }
                            }
                            if(t==result.nameList.length)
                            throw new NullPointerException();
                            
                            result.newrow[ro][1]=name;
                            result.newrow[ro][2]=amount;
                           
                             Object o= jTable2.getValueAt(ro, 1);
                            String s=o.toString();
                            o=jTable2.getValueAt(ro,2);
                            String p=o.toString();
                            
                            jTable2.setValueAt(name, ro, 1);
                            jTable2.setValueAt(amount, ro, 2);
               
                       }
                       catch(NullPointerException e)
                        {
            
                              JOptionPane.showMessageDialog(null, "Something is Wrong");
                        }
       
                        catch(NumberFormatException e)
                         {
                               JOptionPane.showMessageDialog(null, "Invalid formation");
            
                         }
                         
                        file_write();
                }
               }
             
       });
         

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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setForeground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("   BAZAR LIST");

        jTable2.setBackground(new java.awt.Color(153, 255, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        back.setBackground(new java.awt.Color(255, 255, 102));
        back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        back.setText("BACK");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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
        bazarUpdate.setVisible(false);
        Update.updatePart.setVisible(true);
        bazarUpdate.dispose();
    }//GEN-LAST:event_backActionPerformed

    
    
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
                   Logger.getLogger(BazarUpdate.class.getName()).log(Level.SEVERE, null, ex);
               }
           } catch (FileNotFoundException ex) {
               Logger.getLogger(BazarUpdate.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    
    /**
     * Call_bazarUpdate cerate a new Jframe 
     */
    public static  void Call_bazarupdate() {
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
            java.util.logging.Logger.getLogger(BazarUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BazarUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BazarUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BazarUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                bazarUpdate=new BazarUpdate();
                if(check==0)
                bazarUpdate.setVisible(true);
                else
                    bazarUpdate.dispose();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
