package bankSystem;
class Card extends Account{
       private boolean locked = false;
        int pin = 1234;
              

        public boolean pinOK(int p){
        	if(p == pin){
        		System.out.println("********* Access granted ********");
        		return true;
        	}else{
        		
        		return false;
        	}
        }

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
  }