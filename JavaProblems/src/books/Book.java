package books;


public class Book {

	private String theAuthor;
	private String theTitle;
	
	public Book(String author, String title) {
		this.theAuthor = author;
		this.theTitle = title;
	}
	
	public String getAuthor() {
		return theAuthor;
	}
	
	public String getTitle() {
		return theTitle;
	}
	
}
