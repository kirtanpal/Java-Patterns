package hw1;

import java.util.ArrayList;

public class LibraryBook {
	
	LBState CurState;
	String bookName;
	private boolean isObserver = false;
	private ArrayList<Observer> observers;
	private ArrayList<Integer> isNewObs;
	
	public LibraryBook(String bookName) {
		this.bookName = bookName;
		CurState = Shelved.getInst();
		observers = new ArrayList<Observer>();
		isNewObs = new ArrayList<Integer>();
	}
	
	public void attach(Observer newObs) {
		isObserver = true;
		isNewObs.add(1);
		observers.add(newObs);
		System.out.println(newObs.toString() + " is now watching " + bookName);
	}
	
	public void detach(Observer detachObs) {
		if(!isObserver) {}
		else {
			int obsIndex = observers.indexOf(detachObs);
			if(obsIndex >= 0) {
				System.out.println(detachObs.toString() + " is no longer watching " + bookName);
				observers.remove(detachObs);
				isNewObs.remove(obsIndex);
			}
		}
	}
	
	public void Notify() {
//		for(Observer observer : observers){
//			observer.Update(this);
//		}
		for(int i = 0; i <  observers.size(); i++) {
			if(isNewObs.get(i) == 1) {
				observers.get(i).Update(true,this);
				isNewObs.set(i, 0);
			}
			else observers.get(i).Update(false,this);
		}
	}
	
	public void shelf() {
		try{
			CurState = CurState.shelf();
			if(isObserver) Notify();
		}
		catch(NotAllowedException err) {
			System.out.println("hw1.NotAllowedException: " + err.getMessage());
		}
	}
	public void borrow() {
		try{
			CurState = CurState.borrow();
			if(isObserver) Notify();
//			if(isObserver) System.out.println("hw1");
		}
		catch(NotAllowedException err) {
			System.out.println("hw1.NotAllowedException: " + err.getMessage());
		}
	} 
	public void extend() {
		try{
			CurState = CurState.extend();
		}
		catch(NotAllowedException err) {
			System.out.println("hw1.NotAllowedException: " + err.getMessage());
		}
	} 
	public void returnBook() {
		
		try{
			CurState = CurState.returnBook();
			if(isObserver) Notify();
		}
		catch(NotAllowedException err) {
			System.out.println("hw1.NotAllowedException: " + err.getMessage());
		}
	}
	
}
