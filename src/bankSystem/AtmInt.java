package bankSystem;

public interface AtmInt {
	public boolean verifyPin();
	public Integer menu(int i);
	public void withdraw(int amount);
	public void deposit(int amount);
	public int changePin(int newPin);
	public float getBalance();
}
