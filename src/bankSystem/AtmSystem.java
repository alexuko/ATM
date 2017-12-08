package bankSystem;
import java.util.Scanner;

public class AtmSystem implements AtmInt{
	public final String bank ="Bank of Ireland";
	Card crd;
	Account acc=new Account();
	Scanner sc=new Scanner(System.in);
	Integer balance=acc.getBalance();
	public AtmSystem(){
		
		System.out.println("**************  " + bank +"  ************\n\n\nPlease insert your card......\n");
		crd=new Card();
		if(crd.isLocked()==true){
			System.out.println("Your Card is Locked.. please contanct your Bank");
			System.exit(0);

		}else{
			try {
				Thread.sleep(4000);
				verifyPin();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new AtmSystem();
	}

	@Override
	public  boolean verifyPin(){

		crd=new Card();
		int pinTries=3;
		System.out.println("Type-in your PIN number\nPIN: ");
		int p=sc.nextInt();
		try{
			if(crd.pinOK(p)){
				menu(p);
			}else{
				System.out.println("****** Wrong PIN ******");
				while(crd.pinOK(p)==false||pinTries==0){
					pinTries--;
					System.out.println("Please try again\n PIN:");
					p=sc.nextInt();
					if(pinTries==1 && crd.pinOK(p)==false){
						crd.setLocked(true);
						System.out.println("Card has been blocked");
						System.exit(0);						
					}
				}
				menu(p);
			}
		}catch(Exception e){
			System.out.println(e);

		}
		return false;
	}

	@Override
	public Integer menu(int i){
		System.out.println("Choose one of the following Options\n1) Deposit \n2) Withdrwraw\n3) View Current Balance\n4) Change PIN\n5) Exit");
		Integer option = sc.nextInt();
		switch(option){
		case 1: 
			deposit(option);
			break;
		case 2:
			withdraw(option);
			break;
		case 3:
			System.out.println("Your current balance is: £" + getBalance());
			System.out.println("Would you like to print a receipt?\n1)Yes\n2)No");
			option = sc.nextInt();
			if(option==1){
				System.out.println("........Receipt printing\n\n Please take your Card and your receipt");
			}else {
				System.out.println("Please take your Card and Thanks for your visit");

			}	
			
			break;
		case 4:
			changePin(option);
			break;
		case 5:System.exit(0);
		break;
		}
		return i;
	}

	@Override
	public void withdraw(int amount) {
		System.out.println("Choose the amount:\n1)20£\n2)40£\n3)50£\n4)Return");
		int p=sc.nextInt();
		switch(p){
		case 1:acc.debit(p);
		balance=balance-20;
		System.out.println("** Succesful transaction **\nNew balance: "+balance);
		try {
			Thread.sleep(4000);
			menu(p);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}break;
		case 2:
			balance=balance-40;
			System.out.println("** Succesful transaction **\nNew balance: "+balance);
			try {
				Thread.sleep(4000);
				menu(p);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}break;
		case 3:
			balance=balance-50;
			System.out.println("** Succesful transaction **\nNew balance: "+balance);
			try {
				Thread.sleep(4000);
				menu(p);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}break;
		case 4:
			menu(p);
			break;
		default:
			break;
		}
	}

	@Override
	public void deposit(int amount) {
		System.out.println("Deposit:\n1)20£\n2)40£\n3)60£\n4)Return");
		int p=sc.nextInt();
		switch(p){
		case 1:
			balance=balance+20;
			System.out.println("** Succesful transaction **\nNew balance: "+balance);
			try {
				Thread.sleep(4000);
				menu(p);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}break;
		case 2:
			balance=balance+40;
			System.out.println("** Succesful transaction **\nNew balance: "+balance);
			try {
				Thread.sleep(4000);
				menu(p);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}break;
		case 3:
			balance=balance+60;
			System.out.println("** Succesful transaction **\nNew balance: "+balance);
			try {
				Thread.sleep(4000);
				menu(p);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}break;
		case 4:
			menu(p);
			break;
		default:
			break;
		}
	}

	@Override
	public int changePin(int newPin) {
		try{

			System.out.println("Type your new PIN:\n ");
			int pinTyped=sc.nextInt();
			crd.setPin(pinTyped);
			newPin=pinTyped;
			System.out.println("Your PIN number has been changed succesfully " + newPin);
			try {
				Thread.sleep(3000);
				menu(pinTyped);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}catch(Exception e){
			System.out.println(e);
		}
		return newPin;
	}

	@Override
	public float getBalance() {
		return balance;
	}

}
