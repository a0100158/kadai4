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

	Connection con = null;

	//	本テーブル変数
	private String srtInputBook1;
	private String srtInputBook2;
	private int intInputBook3;
	private String strInputBook4;
	private String strInputBook5;
	private String srtInputBook6;

	//	図書館テーブル変数
	private String srtInputLibrary6;

	//	図書館と本のひも付きテーブル変数
	private int intInputPegging1;
	private int intInputPegging2;

	//	データベースに接続
	public void find(){
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
	public void setBook(String srtInputBook1,String srtInputBook2,int intInputBook3,String strInputBook4,String strInputBook5,String srtInputBook6){
		this.srtInputBook1 = srtInputBook1;
		this.srtInputBook2 = srtInputBook2;
		this.intInputBook3 = intInputBook3;
		this.strInputBook4 = strInputBook4;
		this.strInputBook5 = strInputBook5;
		this.srtInputBook6 = srtInputBook6;
	}

	//	本テーブルにinsert
	void book() throws SQLException{
		int id = 0;
		con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		String bookSql1 = "select max(id) from book";
		java.sql.PreparedStatement bookStatement1 =con.prepareStatement(bookSql1);
		ResultSet bookresult = bookStatement1.executeQuery();
		while(bookresult.next()){
			id = bookresult.getInt(1);
		}
		String bookSql = "insert into book values (?, ?, ?, ?, ?, ?, ?, ?)";
		java.sql.PreparedStatement bookStatement = con.prepareStatement(bookSql);
		bookStatement.setInt(1,id + 1 );
		bookStatement.setString(2,srtInputBook1 );
		bookStatement.setString(3,srtInputBook2 );
		bookStatement.setInt(4,intInputBook3);
		bookStatement.setString(5,strInputBook4);
		bookStatement.setString(6,strInputBook5);
		bookStatement.setString(7,srtInputBook6);
		bookStatement.setString(8,srtInputBook6);
		bookStatement.executeUpdate();
	}

	//図書館テーブル値set
	public void setLibrary(String srtInputLibrary6){
		this.srtInputLibrary6 = srtInputLibrary6;
	}

	//	図書館テーブルにinsert
	void library() throws SQLException{
		int library_id = 0;
		List libraryArrayList = new ArrayList();
		con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		//		図書館テーブルのSQL
		String librarySql1 = "select max(library_id) from library";
		java.sql.PreparedStatement libraryStatement1 =con.prepareStatement(librarySql1);
		ResultSet libraryresult = libraryStatement1.executeQuery();
		while(libraryresult.next()){
			library_id = libraryresult.getInt(1);
		}
		String librarySql = "insert into library values (?,?)";
		java.sql.PreparedStatement libraryStatement = con.prepareStatement(librarySql);
		libraryStatement.setInt(1,library_id + 1 );
		libraryStatement.setString(2,srtInputLibrary6 );
		libraryStatement.executeUpdate();
	}

	//図書館と本のひも付きテーブル値set
	public void setPegging(int intInputPegging1,int intInputPegging2){
		this.intInputPegging1 = intInputPegging1;
		this.intInputPegging2 = intInputPegging2;
	}

	// 図書館と本のひも付きテーブルにinsert
	void pegging() throws SQLException{
		int pegging_id = 0;
		con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
		//		図書館と本のひも付きテーブルのSQL
		String peggingSql1 = "select max(pegging_id) from pegging";
		java.sql.PreparedStatement peggingStatement1 =con.prepareStatement(peggingSql1);
		ResultSet peggingresult = peggingStatement1.executeQuery();
		while(peggingresult.next()){
			pegging_id = peggingresult.getInt(1);
		}
		String peggingSql = "insert into pegging values(?,?,?)";
		java.sql.PreparedStatement peggingStatement = con.prepareStatement(peggingSql);
		peggingStatement.setInt(1,pegging_id + 1 );
		peggingStatement.setInt(2,intInputPegging1);
		peggingStatement.setInt(3,intInputPegging2);
		peggingStatement.executeUpdate();
	}

}
