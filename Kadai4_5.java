import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Kadai4_5 {
	public static void main(String[] args) throws IOException{
		Kadai4_5_DAO Kadai4_5_DAO = new Kadai4_5_DAO();

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		System.out.println("select、insert、update、deleteのうち、1つを入力してください。");
		String srtOneInput = br.readLine();

		switch(srtOneInput) {
		case "select" :
			List valueList = Kadai4_5_DAO.find();
			List bookList = (List) valueList.get(0);
			List libraryList = (List) valueList.get(1);
			List peggingList = (List) valueList.get(2);


			//		本テーブルのデータ表示
			List bookAL = new ArrayList();
			for(Object ob : bookList){
				bookAL.add(ob);
			}
			System.out.println("■本テーブルのデータ");
			for(Object ob : bookAL){
				System.out.print(((Book) ob).getId() + "  ");
				System.out.print(((Book) ob).getGenre() + "  ");
				System.out.print(((Book) ob).getTitle() + "  ");
				System.out.print(((Book) ob).getPrice() + "  ");
				System.out.print(((Book) ob).getAuthor() + "  ");
				System.out.print(((Book) ob).getPublisher() + "  ");
				System.out.print(((Book) ob).getEntry_date() + "  ");
				System.out.println(((Book) ob).getUpdate_date() + "  ");
			}

			System.out.println();

			//		図書館テーブルのデータ表示
			List libraryAL = new ArrayList();
			for(Object ob : libraryList){
				libraryAL.add(ob);
			}
			System.out.println("■図書館テーブルのデータ");
			for(Object ob : libraryAL){
				System.out.print(((Library) ob).getLibrary_id() + "  ");
				System.out.println(((Library) ob).getLibrary_name() + "  ");
			}

			System.out.println();

			//		図書館と本のひも付きテーブルのデータ表示
			List peggingAL = new ArrayList();
			for(Object ob : peggingList){
				peggingAL.add(ob);
			}
			System.out.println("■図書館と本のひも付きテーブルのデータ");
			for(Object ob : peggingAL){
				System.out.print(((Pegging) ob).getPegging_id() + "  ");
				System.out.print(((Pegging) ob).getLibrary_id() + "  ");
				System.out.println(((Pegging) ob).getId_pegging());
			}
			break;

		case "insert" :
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
			Kadai4_5_DAO.setBook(srtB_Genre,srtB_Title,intB_Price,strB_Author,strB_Publisher,srtB_Date);
			System.out.println();
			System.out.println();

			//図書館テーブルの値入力
			System.out.println("■図書館テーブルのデータを追加します。");
			System.out.println();
			System.out.println("図書館名を入力してください。");
			String strL_Library_name = br.readLine();

			Kadai4_5_DAO.setLibrary(strL_Library_name);
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

			Kadai4_5_DAO.setPegging(intP_Library_id,intP_Id);

			Kadai4_5_DAO.dbConnect();
			break;
		case "update" :
			System.out.println("updateはまだ実装していません。");
			break;
		case "delete" :
			System.out.println("deleteはまだ実装していません。");
			break;
		}
	}
}