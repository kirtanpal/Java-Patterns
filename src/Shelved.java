package hw1;

public class Shelved implements LBState {
	
	private String state = "Shelved";
	private static Shelved instance = null;
	public static Shelved getInst(){
		if (instance == null) {
			instance = new Shelved();
			System.out.println("Shelved Instance Created");
		}
		return instance;
	}
	
	public String toString() {
		return state;
	}
	
	public LBState shelf() throws NotAllowedException {
		throw new NotAllowedException("Can't use shelf in Shelved state");
	} 
	public LBState borrow(){
		LBState temp = OnLoan.getInst();
		System.out.println("Leaving State Shelved for State OnLoan");
		return temp;
	} 
	public LBState extend() throws NotAllowedException {
		throw new NotAllowedException("Can't use extend in Shelved state");
	} 
	public LBState returnBook() throws NotAllowedException {
		throw new NotAllowedException("Can't use returnBook in Shelved state");
	}
}
