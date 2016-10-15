import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Kadai4_3_DAO {
	public List<TableValue> findBook(){

		Connection con = null;
		List<TableValue> bookArrayList = new ArrayList<TableValue>();

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystudy_wb1", "root", "mirai910");
//			本テーブルのSQL
			String bookSql = "select * from book";
			PreparedStatement bookStatement =con.prepareStatement(bookSql);
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
				TableValue bookArray = new TableValue(id,genre,title,price,author,publisher,entry_date,update_date);
				bookArrayList.add(bookArray);
			}
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
		return bookArrayList;
	}

	public List<TableValue> findLibrary(){

		Connection con = null;
		List<TableValue> libraryArrayList = new ArrayList<TableValue>();

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystudy_wb1", "root", "mirai910");
//			図書館テーブルのSQL
			String librarySql = "select * from library";
			PreparedStatement libraryStatement =con.prepareStatement(librarySql);
			ResultSet libraryresult = libraryStatement.executeQuery();

			while(libraryresult.next()){
				int library_id = libraryresult.getInt(1);
				String library_name = libraryresult.getString(2);
				TableValue libraryArray = new TableValue(library_id,library_name);
				libraryArrayList.add(libraryArray);
			}
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
		return libraryArrayList;
	}

	public List<TableValue> findPegging(){

		Connection con = null;
		List<TableValue> peggingArrayList = new ArrayList<TableValue>();

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystudy_wb1", "root", "mirai910");
//			図書館と本のひも付きテーブルのSQL
			String peggingSql = "select * from pegging";
			PreparedStatement peggingStatement =con.prepareStatement(peggingSql);
			ResultSet peggingresult = peggingStatement.executeQuery();

			while(peggingresult.next()){
				int pegging_id_pegging = peggingresult.getInt(1);
				int library_id_pegging = peggingresult.getInt(2);
				int id_pegging = peggingresult.getInt(3);
				TableValue peggingArray = new TableValue(pegging_id_pegging,library_id_pegging,id_pegging);
				peggingArrayList.add(peggingArray);
			}
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
		return peggingArrayList;
	}
}
