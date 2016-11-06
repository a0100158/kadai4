import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

public class Kadai4_4 {
	public static void main(String[] args) throws IOException{
		Kadai4_4_DAO Kadai4_4_DAO = new Kadai4_4_DAO();

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		//本テーブルの値入力
		System.out.println("■本テーブルのデータを追加します。");
		System.out.println();
		System.out.println("①ジャンルを入力してください。");
		String srtB_Genre = br.readLine();
		System.out.println("②タイトルを入力してください。");
		String srtB_Title = br.readLine();
		System.out.println("③価格を数値で入力してください。");
		String srtB_Price = br.readLine();
		int intB_Price = Integer.parseInt(srtB_Price);
		System.out.println("④著者を入力してください。");
		String strB_Author = br.readLine();
		System.out.println("⑤出版社を入力してください。");
		String strB_Publisher = br.readLine();
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String srtB_Date = sdf.format(date);
		Kadai4_4_DAO.setBook(srtB_Genre,srtB_Title,intB_Price,strB_Author,strB_Publisher,srtB_Date);
		System.out.println();
		System.out.println();

		//図書館テーブルの値入力
		System.out.println("■図書館テーブルのデータを追加します。");
		System.out.println();
		System.out.println("図書館名を入力してください。");
		String strL_Library_name = br.readLine();

		Kadai4_4_DAO.setLibrary(strL_Library_name);
		System.out.println();
		System.out.println();

		//図書館と本のひも付きテーブルの値入力
		System.out.println("■図書館と本のひも付きテーブルのデータを追加します。");
		System.out.println();
		System.out.println("①図書館idを数値で入力してください。");
		String strP_Library_id = br.readLine();
		int intP_Library_id = Integer.parseInt(strP_Library_id);
		System.out.println("②本のidを数値で入力してください。");
		String strP_id = br.readLine();
		int intP_Id = Integer.parseInt(strP_id);

		Kadai4_4_DAO.setPegging(intP_Library_id,intP_Id);


		Kadai4_4_DAO.dbConnect();
	}
}