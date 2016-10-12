import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Kadai4_1_DAO {
	public List<Book> findAll(){

		Connection con = null;

		List<Book> bookArrayList = new ArrayList<Book>();


		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystudy_wb1", "root", "mirai910");
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
				Book bookArray = new Book(id,genre,title,price,author,publisher,entry_date,update_date);
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
}
