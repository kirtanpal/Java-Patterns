package hw1;

public class SourceObserver implements Observer{
		
	private String name;
	private String stateName;
	public SourceObserver(String name) {
		this.name = name;
		stateName = "UNOBSERVED";
	}
	
	public String toString() {
		return name;
	}
	
	@Override
	public void Update(Boolean newBook, LibraryBook book) {
		if(newBook) {
			System.out.println(name + " OBSERVED " + book.bookName + " LEAVING STATE: UNOBSERVED");
		}
		else{
			if( book.CurState.toString() == "Shelved") stateName = "Returned";
			else if( book.CurState.toString() == "OnLoan") stateName = "Shelved";
			else if( book.CurState.toString() == "Returned") stateName = "OnLoan";
			System.out.println(name + " OBSERVED " + book.bookName + " LEAVING STATE: " + stateName);
		}
	}

}
