import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Kadai4_5_DAO {
	String connectionUrl = "jdbc:mysql://localhost:3306/mystudy_wb1";
	String connectionUser = "root";
	String connectionPassword = "mirai910";

	Connection con = null;

	//本テーブル変数
	private String srtB_Genre;
	private String srtB_Title;
	private int intB_Price;
	private String strB_Author;
	private String strB_Publisher;
	private String srtB_Date;

	//図書館テーブル変数
	private String strL_Library_name;

	//図書館と本のひも付きテーブル変数
	private int intP_Library_id;
	private int intP_Id;

	//データベースに接続
	public void dbConnect(){
		Connection con = null;
		try {
			book();
			library();
			pegging();
		} catch (SQLException e) {
			System.out.println("接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("クローズできませんでした。");
				}
			}
		}
	}

	//本テーブル値set
	public void setBook(String srtB_Genre,String srtB_Title,int intB_Price,String strB_Author,String strB_Publisher,String srtB_Date){
		this.srtB_Genre = srtB_Genre;
		this.srtB_Title = srtB_Title;
		this.intB_Price = intB_Price;
		this.strB_Author = strB_Author;
		this.strB_Publisher = strB_Publisher;
		this.srtB_Date = srtB_Date;
	}

	//本テーブルにinsert
	void book() throws SQLException{
		int id = 0;
		con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		String bookSelect = "select max(id) from book";
		PreparedStatement bookStatement1 =con.prepareStatement(bookSelect);
		ResultSet bookresult = bookStatement1.executeQuery();
		while(bookresult.next()){
			id = bookresult.getInt(1);
		}
		String bookInsert = "insert into book values (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement bookStatement = con.prepareStatement(bookInsert);
		bookStatement.setInt(1,id + 1 );
		bookStatement.setString(2,srtB_Genre );
		bookStatement.setString(3,srtB_Title );
		bookStatement.setInt(4,intB_Price);
		bookStatement.setString(5,strB_Author);
		bookStatement.setString(6,strB_Publisher);
		bookStatement.setString(7,srtB_Date);
		bookStatement.setString(8,srtB_Date);
		bookStatement.executeUpdate();
	}

	//図書館テーブル値set
	public void setLibrary(String srtInputLibrary6){
		this.strL_Library_name = srtInputLibrary6;
	}

	//図書館テーブルにinsert
	void library() throws SQLException{
		int library_id = 0;
		List libraryArrayList = new ArrayList();
		con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		//図書館テーブルのSQL
		String librarySelect = "select max(library_id) from library";
		PreparedStatement libraryStatement1 =con.prepareStatement(librarySelect);
		ResultSet libraryresult = libraryStatement1.executeQuery();
		while(libraryresult.next()){
			library_id = libraryresult.getInt(1);
		}
		String libraryInsert = "insert into library values (?,?)";
		PreparedStatement libraryStatement = con.prepareStatement(libraryInsert);
		libraryStatement.setInt(1,library_id + 1 );
		libraryStatement.setString(2,strL_Library_name );
		libraryStatement.executeUpdate();
	}

	//図書館と本のひも付きテーブル値set
	public void setPegging(int intP_Library_id,int intP_Id){
		this.intP_Library_id = intP_Library_id;
		this.intP_Id = intP_Id;
	}

	//図書館と本のひも付きテーブルにinsert
	void pegging() throws SQLException{
		int pegging_id = 0;
		con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		//図書館と本のひも付きテーブルのSQL
		String peggingSelect = "select max(pegging_id) from pegging";
		PreparedStatement peggingStatement1 =con.prepareStatement(peggingSelect);
		ResultSet peggingresult = peggingStatement1.executeQuery();
		while(peggingresult.next()){
			pegging_id = peggingresult.getInt(1);
		}
		String peggingInsert = "insert into pegging values(?,?,?)";
		PreparedStatement peggingStatement = con.prepareStatement(peggingInsert);
		peggingStatement.setInt(1,pegging_id + 1 );
		peggingStatement.setInt(2,intP_Library_id);
		peggingStatement.setInt(3,intP_Id);
		peggingStatement.executeUpdate();
	}


	public List find(){
		Connection con = null;
		List listStore = new ArrayList();
		List bookList = new ArrayList();
		List libraryList = new ArrayList();
		List peggingList = new ArrayList();

		//データベースに接続
		try {
			bookList = bookSelect();
			libraryList = librarySelect();
			peggingList = peggingSelect();
		} catch (SQLException e) {
			System.out.println("接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("クローズできませんでした。");
				}
			}
		}
		listStore.add(bookList);
		listStore.add(libraryList);
		listStore.add(peggingList);
		return listStore;
	}

	//		本テーブル値取得
	List bookSelect() throws SQLException{
		List bookArrayList = new ArrayList();
		Connection con = null;
		con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		//		本テーブルのSQL
		String bookSql = "select * from book";
		java.sql.PreparedStatement bookStatement =con.prepareStatement(bookSql);
		ResultSet bookresult = bookStatement.executeQuery();
		while(bookresult.next()){
			int id = bookresult.getInt(1);
			String genre = bookresult.getString(2);
			String title = bookresult.getString(3);
			int price = bookresult.getInt(4);
			String author = bookresult.getString(5);
			String publisher = bookresult.getString(6);
			String entry_date = bookresult.getString(7);
			String update_date = bookresult.getString(8);
			Book bookArray = new Book(id,genre,title,price,author,publisher,entry_date,update_date);
			bookArrayList.add(bookArray);
		}
		return bookArrayList;
	}

	//		図書館テーブル値取得
	List librarySelect() throws SQLException{
		List libraryArrayList = new ArrayList();
		Connection con = null;
		con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		//		図書館テーブルのSQL
		String librarySql = "select * from library";
		java.sql.PreparedStatement libraryStatement =con.prepareStatement(librarySql);
		ResultSet libraryresult = libraryStatement.executeQuery();
		while(libraryresult.next()){
			int library_id = libraryresult.getInt(1);
			String library_name = libraryresult.getString(2);
			Library libraryArray = new Library(library_id,library_name);
			libraryArrayList.add(libraryArray);
		}
		return libraryArrayList;
	}

	// 図書館と本のひも付きテーブル値取得
	List peggingSelect() throws SQLException{
		List peggingArrayList = new ArrayList();
		Connection con = null;
		con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		//		図書館と本のひも付きテーブルのSQL
		String peggingSql = "select * from pegging";
		java.sql.PreparedStatement peggingStatement =con.prepareStatement(peggingSql);
		ResultSet peggingresult = peggingStatement.executeQuery();
		while(peggingresult.next()){
			int pegging_id = peggingresult.getInt(1);
			int library_id = peggingresult.getInt(2);
			int id = peggingresult.getInt(3);
			Pegging PeggingArray = new Pegging(pegging_id,library_id,id);
			peggingArrayList.add(PeggingArray);
		}
		return peggingArrayList;
	}
}
