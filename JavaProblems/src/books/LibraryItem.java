package books;

public interface LibraryItem {
	public void checkOut(String holder);
	public String getID();
	public String getHolder();
}
