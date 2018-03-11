package hw1;

public class DatabaseManager {
	private static DatabaseManager firstDbase = null;
	public static DatabaseManager TheDatabaseManager(){
		if (firstDbase == null) {
			firstDbase = new DatabaseManager();
			System.out.println("Instance Created");
		}
		else System.out.println("Previously Created instance returned");
		return firstDbase;
	}
	
}