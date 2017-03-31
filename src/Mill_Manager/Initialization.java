
package Mill_Manager;

import java.io.Serializable;


/**
 *class Initialization is contain all information of member 
 * 
 */
public class Initialization implements Serializable{
    
    //variable declaration start
    public int month;
    public int year;
    public int numberDate;
    public String nameList[],colomn[],newcolomn[]={"Date","Member Name","Amount of cost"};
    public int member;
    public Object row[][],newrow[][];
    MemberInfo MemberImformation[];
    double  rowdata[][];
    
      double[][] saveMoney;
     //end of variable declaration 
      
    
    
    /**
     *constructor of Initialization class with parameter month,year,member namelist,number of member   
     *
     */
    
    Initialization(int month,int year,int date,String name_list[],int number_of_member){
        
        nameList=new String[number_of_member];
        this.month=month;
        this.year=year;
        numberDate=date;
        member=number_of_member;

        for(int i=0;i<member;i++)
            nameList[i]=name_list[i];
        colomn= new String[numberDate+2];
         MemberImformation =new MemberInfo[member];
        
        SetMealData();
    }
    
    /**
     * setMealData method refers all member's mill data is counted using Object type new object
     */
    
    void SetMealData(){
        
         
       String s;
        colomn[0]="Name/Date";
        for(int i=1;i<=numberDate+1;i++){
            if(i==numberDate+1)
            {
                 s="TOTAL";
            }
            else{
                 s=i+"/"+this.month+"/"+this.year;  
            }
            colomn[i]=s;
        }

        row=new Object[member][(numberDate+2)];
        rowdata=new double[member][(numberDate+2)];
        
       
        for(int i=0;i<member;i++)
        {
                rowdata[i][0]=(i*1.0);
            for(int j=1;j<=numberDate+1;j++)
            {
                row[i][j]=0.0;
                rowdata[i][j]=0.0;
            }
        }
        
        newrow=new Object[numberDate][3];
        
        for(int i=0;i<numberDate;i++)
        {
            s=(i+1)+"/"+this.month+"/"+this.year;
            newrow[i][0]=s;
            newrow[i][1]="NULL";
            newrow[i][2]=0.0;        
        }
        createdataset();
    }
    
    public void firstcolset()
    {
        for(int i=0;i<member;i++)
        {
            row[i][0]=nameList[i];
            MemberImformation[i].SetMemberName(nameList[i]);
        }
    }
    
    /**
     * createdataset method refers all member info 
     * create a object array of MemberInfo class
     * that is name of member,deposit,number of mill,total cost,payamount  
     */
    
     void createdataset(){
         
           

            for(int i=0;i<nameList.length;i++)
            {  
                MemberInfo p=new MemberInfo();
                p.SetMemberName(nameList[i]);
                p.SetDiposite(0.0);
                p.SetNumberMeal(0);
                p.cost=0.0;
                p.payamount=0.0;
                
                
               MemberImformation[i]=p; 
            }
            
             firstcolset();
             
            SetDipositArr();
        }
     
     /**
      * SetDipositArr method initial the save money of member is zero
      */
     
     void SetDipositArr(){
         
         saveMoney=new double [member][numberDate+1];
         
         for(int i=0;i<member;i++)
         {
             for(int j=1;j<=numberDate;j++)
             {
                 saveMoney[i][j]=0;
             }
         }
         
         
     }
}
