
package Mill_Manager;

import java.awt.Container;
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
import static Mill_Manager.MillDataUpdate.millDataUpdate;


/**
 * 
 * public class DataStore to store data of member
 */

public class DataStore {
    
    Initialization result;    //object reference of Initialization class
    MemberInfo[] memberImformation;    //object array referece of MemberInfo class
        
        DataStore(){
            File_Load();
            memberImformation=new MemberInfo[result.member];
             createdataset();
        }
        
        /**
         * create member data set from existing file in createdataset method
         */
        
        void createdataset(){
            
            for(int i=0;i<result.member;i++)
            {
                memberImformation[i].SetMemberName(result.nameList[i]);
                memberImformation[i].diposit1=0.0;
               memberImformation[i].SetNumberMeal(0);
               
                memberImformation[i].cost=memberImformation[i].TotalCost(0);
                memberImformation[i].payamount=memberImformation[i].Payamount();
                
            }
            
        }
    
    
        /**
         * Read Initialization.ser file if it exits in File_Load method
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
          
        } catch (IOException ex) {
            Logger.getLogger(MillDataUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
       }
    
    
    
    
    
}
