package hw1;

public class Returned implements LBState {

	private String state = "Returned";
	private static Returned instance = null;
	public static Returned getInst(){
		if (instance == null) {
			instance = new Returned();
			System.out.println("Returned Instance Created");
		}
		return instance;
	}
	
	public String toString() {
		return state;
	}
	
	public LBState shelf() {
		LBState temp = Shelved.getInst();
		System.out.println("Leaving State Returned for State Shelved");
		return temp;
	} 
	public LBState borrow() throws NotAllowedException{
		throw new NotAllowedException("Can't use borrow in Returned state");
	} 
	public LBState extend() throws NotAllowedException{
		throw new NotAllowedException("Can't use extend in Returned state");
	} 
	public LBState returnBook() throws NotAllowedException{
		throw new NotAllowedException("Can't use returnBook in Returned state");
	}
}
