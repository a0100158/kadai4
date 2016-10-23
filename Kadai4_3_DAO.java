import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Kadai4_3_DAO {
	String connectionUrl = "jdbc:mysql://localhost:3306/mystudy_wb1";
	String connectionUser = "root";
	String connectionPassword = "mirai910";

	public List find(){
		Connection con = null;
		List listStore = new ArrayList();
		List bookList = new ArrayList();
		List libraryList = new ArrayList();
		List peggingList = new ArrayList();

		try {
			bookList = book();
			libraryList = library();
			peggingList = pegging();
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

	//	本テーブル値取得
	List book() throws SQLException{
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

	//	図書館テーブル値取得
	List library() throws SQLException{
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
	List pegging() throws SQLException{
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
