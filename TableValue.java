
public class TableValue {
//	本テーブルの変数
	private int id;
	private String genre;
	private String title;
	private int price;
	private String author;
	private String publisher;
	private String entry_date;
	private String update_date;

//図書館テーブルの変数
	private int library_id;
	private String library_name;

//	図書館と本のひも付きテーブルの変数
	private int pegging_id_pegging;
	private int library_id_pegging;
	private int id_pegging;

//	本テーブルの値格納
	public TableValue(int id,String genre,String title,int price,String author,String publisher,String entry_date,String update_date){
		this.id = id;
		this.genre = genre;
		this.title = title;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.entry_date = entry_date;
		this.update_date = update_date;
	}

//	本テーブルの値返す
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

//	図書館テーブルの値格納
	public TableValue(int library_id,String library_name){
		this.library_id = library_id;
		this.library_name = library_name;
	}

//	図書館テーブルの値返す
	int getLibrary_id(){
		return library_id;
	}
	String getLibrary_name(){
		return library_name;
	}

//	図書館と本のひも付きテーブルの値格納
	public TableValue(int pegging_id_pegging,int library_id_pegging,int id_pegging){
		this.pegging_id_pegging = pegging_id_pegging;
		this.library_id_pegging = library_id_pegging;
		this.id_pegging = id_pegging;
	}

//	図書館と本のひも付きテーブルの値返す
	int getPegging_id(){
		return pegging_id_pegging;
	}
	int getLibrary_id_pegging(){
		return library_id_pegging;
	}
	int getId_pegging(){
		return id_pegging;
	}
}
