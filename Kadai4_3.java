import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

public class Kadai4_3 {
	public static void main(String[] args) throws IOException{
		Kadai4_3_DAO Kadai4_3_DAO = new Kadai4_3_DAO();

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		//		本テーブルの値入力
		System.out.println("■本テーブルのデータを追加します。");
		System.out.println();
		System.out.println("①ジャンルを入力してください。");
		String srtInputBook1 = br.readLine();
		System.out.println("②タイトルを入力してください。");
		String srtInputBook2 = br.readLine();
		System.out.println("③価格を数値で入力してください。");
		String srtInputBook3 = br.readLine();
		int intInputBook3 = Integer.parseInt(srtInputBook3);
		System.out.println("④著者を入力してください。");
		String strInputBook4 = br.readLine();
		System.out.println("⑤出版社を入力してください。");
		String strInputBook5 = br.readLine();
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String srtInputBook6 = sdf.format(date);
		Kadai4_3_DAO.setBook(srtInputBook1,srtInputBook2,intInputBook3,strInputBook4,strInputBook5,srtInputBook6);
		System.out.println();
		System.out.println();

		//		図書館テーブルの値入力
		System.out.println("■図書館テーブルのデータを追加します。");
		System.out.println();
		System.out.println("図書館名を入力してください。");
		String srtInputLibrary6 = br.readLine();

		Kadai4_3_DAO.setLibrary(srtInputLibrary6);
		System.out.println();
		System.out.println();

		//		図書館と本のひも付きテーブルの値入力
		System.out.println("■図書館と本のひも付きテーブルのデータを追加します。");
		System.out.println();
		System.out.println("①図書館idを数値で入力してください。");
		String strInputPegging1 = br.readLine();
		int intInputPegging1 = Integer.parseInt(strInputPegging1);
		System.out.println("②本のidを数値で入力してください。");
		String strInputPegging2 = br.readLine();
		int intInputPegging2 = Integer.parseInt(strInputPegging2);

		Kadai4_3_DAO.setPegging(intInputPegging1,intInputPegging2);


		Kadai4_3_DAO.find();
	}
}