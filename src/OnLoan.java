package hw1;

public class OnLoan implements LBState{
	
	private String state = "OnLoan";
	private static OnLoan instance = null;
	public static OnLoan getInst(){
		if (instance == null) {
			instance = new OnLoan();
			System.out.println("OnLoan Instance Created");
		}
		return instance;
	}
	
	public String toString() {
		return state;
	}
	
	public LBState shelf() throws NotAllowedException {
		throw new NotAllowedException("Can't use shelf in OnLoan state");
	} 
	public LBState borrow() throws NotAllowedException {
		throw new NotAllowedException("Can't use borrow in OnLoan state");
	} 
	public LBState extend() {
		System.out.println("Leaving State OnLoan for State OnLoan");
		return this;
	} 
	public LBState returnBook() {
		LBState temp = Returned.getInst();
		System.out.println("Leaving State OnLoan for State Returned");
		return temp;
	}
}
