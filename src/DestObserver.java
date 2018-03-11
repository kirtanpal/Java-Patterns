package hw1;

public class DestObserver implements Observer {
	
	private String name;
	public DestObserver(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

	@Override
	public void Update(Boolean newBook,LibraryBook book) {
		System.out.println(name + " OBSERVED " + book.bookName + " REACHING STATE: " + book.CurState.toString());
	}
}
