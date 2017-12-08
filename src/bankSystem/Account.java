package bankSystem;
class Account {
       private int balance = 50;

       public boolean debit(int a) {
              if((balance-a) > 0) {
                     balance = balance -a;
                     System.out.println(balance);
                     return true;//debit successful
              }
              else {
            	  System.out.println("insufficient funds");
                     return false;//insufficient funds
              }
       }

	public int getBalance() {
		return balance;
	}
}