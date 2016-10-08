
public class BookArray {
	private int id;
	private String genre;
	private String title;
	private int price;
	private String author;
	private String publisher;
	private String entry_date;
	private String update_date;

	public BookArray(int id,String genre,String title,int price,String author,String publisher,String entry_date,String update_date){
		this.id = id;
		this.genre = genre;
		this.title = title;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.entry_date = entry_date;
		this.update_date = update_date;
	}

	int getId(){
		return id;
	}

	String getGenre(){
		return genre;
	}

	String getTitle(){
		return title;
	}

	int getPrice(){
		return price;
	}

	String getAuthor(){
		return author;
	}

	String getPublisher(){
		return publisher;
	}

	String getEntry_date(){
		return entry_date;
	}

	String getUpdate_date(){
		return update_date;
	}
}
