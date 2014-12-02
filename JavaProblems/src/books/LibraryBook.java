package books;

public class LibraryBook extends Book implements LibraryItem {

	private String uniqueID;
	private String holder;
	
	public LibraryBook(String id, String author, String title) {
		super(author, title);
		this.uniqueID = id;
		this.holder = null;
	}
	
	@Override
	public void checkOut(String name) {
		this.holder = name;
	}

	@Override
	public String getID() {
		return uniqueID;
	}

	@Override
	public String getHolder() {
		return holder;
	}

}
