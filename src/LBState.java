package hw1;

public interface LBState {


	public LBState shelf() throws NotAllowedException;
	public LBState borrow() throws NotAllowedException;
	public LBState extend() throws NotAllowedException;
	public LBState returnBook() throws NotAllowedException;
}
