
package Mill_Manager;

import java.io.Serializable;

/**
 *
 * MemberInfo is a class which store  info of member 
 * 
 */
public class MemberInfo  implements Serializable{
    
     public String memberName;
     public double diposit1=0.0;
     public double cost=0.0;
     public double payamount=0.0;
     public double numOfMeal=0.0;
    
   /**
    * 
    *constructor of MemberInfo
    */
   
  public void MemberIn(String a,double b,int c,double d,double e){
       this.memberName=a;
       this.diposit1=b;
       this.numOfMeal=c;
       this.payamount=d;
       this.cost=e; 
      
   }
   
    
    void SetMemberName(String name){        //set member name
        this.memberName=name;
    }
    
    void SetDiposite(double diposit){       // set Deposit
        this.diposit1+=diposit;
    }
    
    void SetNumberMeal(double num_of_meal){    //set number of mill 
        this.numOfMeal=num_of_meal;
    }
            
    double TotalCost(double mealrate){          //return the total cost of a member
        return this.cost=(this.numOfMeal*mealrate);
    }
    double Payamount(){                         //return the amount of payment he needs to pay
        return (this.diposit1-this.cost);
    }
    
}
