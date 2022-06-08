package abc_atm;

import java.util.HashMap;
import java.util.Scanner;


public class ABCATM {
		
 public static void main(String args[]) {
	

		HashMap<Integer, Integer> balance = new HashMap<Integer, Integer>();
		balance.put(2000,0);
		balance.put(500, 0);
		balance.put(200, 0);
		balance.put(100, 0);
	    
		System.out.println("Welcome to ABC ATM");
		System.out.println("1. Deposit Money to your account");
		System.out.println("2. Withdraw Money from your account");
		System.out.println("3. Check Current Balance");
		System.out.println("0. Exit");     
	
	
	 Scanner sc = new Scanner(System.in); 
	int choice;
	System.out.println("Enter your Choice: ");
	choice=sc.nextInt();
	
	while(choice!=0) {
		
		if(choice==1)deposit(balance,sc);
		else if(choice==2)withdraw(balance,sc);
		else if(choice==3)currentbalance(balance);
		System.out.println("Welcome to ABC ATM");
		System.out.println("1. Deposit Money to your account");
		System.out.println("2. Withdraw Money from your account");
		System.out.println("3. Check Current Balance");
		System.out.println("0. Exit");
		System.out.println("Enter your Choice: ");
		choice=sc.nextInt();
		
	}
	
	

 	}

private static void withdraw(HashMap<Integer, Integer> balance, Scanner sc) {
	int with2000=0,with500=0,with200=0,with100=0;
	
	int cb=currentbalance(balance);
	int amnt;
	System.out.println("How many money you want to withdraw?");
	amnt = sc.nextInt();
	if(amnt>cb || amnt<=0) {
		System.out.println("Incorrect os insufficient Balance");
	} 
	else {
		while(balance.get(2000)!=0 && 2000<=amnt) {
            with2000++;
            balance.replace(2000, balance.get(2000)-1);
            amnt-=2000;
        }
        
		while(balance.get(500)!=0 && 500<=amnt) {
            with500++;
            balance.replace(500, balance.get(500)-1);
            amnt-=500;
        }
		while(balance.get(200)!=0 && 200<=amnt) {
            with200++;
            balance.replace(200, balance.get(200)-1);
            amnt-=200;
        }
		while(balance.get(100)!=0 && 100<=amnt) {
            with100++;
            balance.replace(100, balance.get(100)-1);
            amnt-=100;
        }        
      System.out.println("Dispensed: 2000s="+with2000+",500s="+with500+",200s="+with200+",100s="+with100);
        
        System.out.println("Balance: 2000s="+balance.get(2000)+",500s="+balance.get(500)+",200s="+balance.get(200)+",100s="+balance.get(100)+", Total="+currentbalance(balance));
 
        
		
		
		}
}

private static int currentbalance(HashMap<Integer,Integer> balance) {
	
	
	return (2000*balance.get(2000)+500*balance.get(500)+200*balance.get(200)+100*balance.get(100));
}

public static void deposit(HashMap<Integer,Integer> balance,Scanner sc) {
	int dep2000,dep500,dep200,dep100;
	
	System.out.println("How many notes of 2000?");
	dep2000=sc.nextInt();
	System.out.println("How many notes of 500?");
	dep500=sc.nextInt();
	
	System.out.println("How many notes of 200?");
	dep200=sc.nextInt();
	
	System.out.println("How many notes of 100?");
	dep100=sc.nextInt();
	
	if(dep2000<0 || dep500<0 || dep200<0 || dep100<0) {
		System.out.println("Incorrect deposit amount");
		return;
	}
	else if(dep2000==0 && dep500==0 && dep200==0 && dep100==0)
	{
		System.out.println("Deposit amount cannot be zero");
		return;
	}
	else {
	balance.replace(2000, dep2000);
	balance.replace(500, dep500);
	balance.replace(200, dep200);
	balance.replace(100, dep100);
	}
	
	System.out.println("Balance: 2000s="+balance.get(2000)+",500s="+balance.get(500)+",200s="+balance.get(200)+",100s="+balance.get(100)+", Total="+currentbalance(balance));
    	 
}
 
}