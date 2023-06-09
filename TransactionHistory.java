import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Welcome to ATM Inteface");
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter your user id: ");
		int userId = sc.nextInt();
		System.out.println("Enter your user pin: ");
		int userPin = sc.nextInt();
		//if(userId !=0 && userPin!=0)
		int currentBal = 1000;
		System.out.println("Logged In Successfully!!!");
		TransactionHistory transferHistory = new TransactionHistory();
		WithDraw withdraw= new WithDraw();
		Deposit deposit = new Deposit();
		Transfer tranfer = new Transfer();
		while(true) {
		    System.out.println("Enter : ");
		    System.out.println("1. Transaction History ");
		    System.out.println("2. Withdraw ");
		    System.out.println("3. Deposit ");
		    System.out.println("4. Transfer ");
		    System.out.println("5. Quit ");
		    int in = sc.nextInt();
		    switch(in){
		        case 1: transferHistory.getTranstionHistory(userId);
		                break;
		        case 2: System.out.println("Enter amt to withDraw: ");
		            currentBal = withdraw.withdrawAmt(sc.nextInt(),currentBal);
		            break;
		        case 3: System.out.println("Enter amt to Deposit: ");
		            currentBal = deposit.depositAmt(sc.nextInt(),currentBal);
		            break;
		        case 4: System.out.println("Enter amt to Transfer: ");
		                int amt = sc.nextInt();
		                System.out.println("Enter User to Transfer: ");
		                int extuser = sc.nextInt();
		            currentBal = tranfer.transferAmt(amt, currentBal, extuser);
		            break;
		       case 5: new Quit(); break;
		       default: System.out.println("Enter Valid Option"); break;
		        
		            
		    }
		    System.out.println("Current Balance: "+currentBal);
		    
		}
	}
}
class TransactionHistory 
{
    void getTranstionHistory(int userId) {
        System.out.println("userId "+userId+" 100/-" + "Debit to"+"XXXX2344");
        System.out.println("userId "+userId+" 200/-" + "Debit to"+"XXXX2353");
        System.out.println("userId "+userId+" 30/-" + "Debit to"+"XXXX23434");
        System.out.println("userId "+userId+" 2300/-" + "Credited by"+"XXXX2344");
        System.out.println("userId "+userId+" 10/-" + "Debit to"+"XXXX1344");
    }
}

class WithDraw
{
    int withdrawAmt(int amt, int currentBal){
        var x = currentBal - amt;
        if(x < 0) 
            System.out.println("Insufficent funds");
        else{
            System.out.println("Successfully Withdrawn "+ amt+ "\ncurrentBalance "+ x);
        }
        return x;
    }
}

class Deposit
{
    int depositAmt(int amt, int currentBal){
        if(amt<0){
            System.out.println("Plz add amt >0");
            return currentBal;
        }
        int x=  currentBal + amt;
        System.out.println("Successfully deposit "+ amt+ "\ncurrentBalance "+ x);
        return x;
    }
    
}

class Transfer
{
    int transferAmt(int amt, int currentBal, int extUserId){
        var x = currentBal - amt;
        if(x < 0) 
            System.out.println("Insufficent funds");
        else{
            System.out.println("Successfully transfered "+ amt+ "to "+ extUserId+ "\ncurrentBalance "+ x);
        }
        return x;
    }
}

class Quit
{
    Quit(){
        System.exit(0);
    }
}