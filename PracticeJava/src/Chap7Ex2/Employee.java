package Chap7Ex2;

public abstract class Employee {
	protected boolean isBusy = false;
	
	public void handleCall(Call c){
		throw new UnsupportedOperationException("Not implemented yet!");
	}
	
	public boolean isBusy(){
		return this.isBusy;
	}
}
