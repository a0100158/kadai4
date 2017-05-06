import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class  Kadai4_8{
	public static void main(String[] args) throws IOException{

		Kadai4_8_DAO Kadai4_8_DAO = new Kadai4_8_DAO();

		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		System.out.println("■select、insert、update、deleteのうち、1つを入力してください。");
		String srtOneInput = br.readLine();

		//入力した値を渡す。
		choice(srtOneInput);
	}

	public static void choice(String srtOneInput) throws IOException {
		Date date = new Date();
		Kadai4_8_DAO Kadai4_8_DAO = new Kadai4_8_DAO();
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);

		switch(srtOneInput) {
		case "select" :
			System.out.println("検索する本のタイトルを入力してください。");
			String srtBookTitle = br.readLine();
			if(srtBookTitle == null || srtBookTitle.length() == 0){
				System.out.println("未入力です。検索条件を入力してください。");
				break;
			}else{
				List valueList = Kadai4_8_DAO.find(srtBookTitle);
				List libraryFindList = (List)valueList.get(0);
				//		本がある置いてある図書館表示
				List libraryFindAL = new ArrayList();
				for(Object ob : libraryFindList){
					libraryFindAL.add(ob);
				}
				System.out.println(srtBookTitle + "は、以下の図書館にあります。");
				for(Object ob : libraryFindAL){
					System.out.print(((Library) ob).getLibrary_name() + "  ");
				}
				break;
			}
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

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String srtB_Date = sdf.format(date);
			Kadai4_8_DAO.setBook(srtB_Genre,srtB_Title,intB_Price,strB_Author,strB_Publisher,srtB_Date);
			System.out.println();
			System.out.println();

			//図書館テーブルの値入力
			System.out.println("■図書館テーブルのデータを追加します。");
			System.out.println();
			System.out.println("図書館名を入力してください。");
			String strL_Library_name = br.readLine();

			Kadai4_8_DAO.setLibrary(strL_Library_name);
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

			Kadai4_8_DAO.setPegging(intP_Library_id,intP_Id);

			Kadai4_8_DAO.dbConnect();
			break;
		case "update" :
			System.out.println("■更新するテーブルを「本」、「図書館」、「ひも付き」から選んでください。");
			String updateTargetTable = br.readLine();
			if(updateTargetTable == null || updateTargetTable.length() == 0){
				System.out.println("未入力です。検索条件を入力してください。");
				break;
			}

			choiceUpdateTable(updateTargetTable);
			break;
		case "delete" :
			System.out.println("■削除するテーブルを「本」、「図書館」、「ひも付き」から選んでください。");
			String deleteTargetTable = br.readLine();
			if(deleteTargetTable == null || deleteTargetTable.length() == 0){
				System.out.println("未入力です。削除対象テーブルを入力してください。");
				break;
			}

			choiceDleleteTable(deleteTargetTable);
			break;
		default:
			System.out.println("入力した文言が正しくありません。");
		}
	}

	private static void choiceUpdateTable(String updateTargetTable)  throws IOException {
		Date date = new Date();
		Kadai4_8_DAO Kadai4_8_DAO = new Kadai4_8_DAO();
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		switch(updateTargetTable){

		case "本":

			List<Book> UpdateBookTableDataList = Kadai4_8_DAO.getTableData(updateTargetTable);
			System.out.println("■本テーブルのデータは以下になります。");
			for(Book ba : UpdateBookTableDataList){
				System.out.print(ba.getId() + "  ");
				System.out.print(ba.getGenre() + "  ");
				System.out.print(ba.getTitle() + "  ");
				System.out.print(ba.getPrice() + "  ");
				System.out.print(ba.getAuthor() + "  ");
				System.out.print(ba.getPublisher() + "  ");
				System.out.print(ba.getEntry_date() + "  ");
				System.out.println(ba.getUpdate_date());
			}
			System.out.println();
			System.out.println("■更新対象のidを選択してください。");
			String strUpdateTargetBookId = br.readLine();
			int intUpdateTargetBookId = Integer.parseInt(strUpdateTargetBookId);
			System.out.println();
			System.out.println("■更新後の値段を入力してください。");
			String strUpdateBookPrice = br.readLine();
			int intUpdateBookPrice = Integer.parseInt(strUpdateBookPrice);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String srtB_Date = sdf.format(date);

			Kadai4_8_DAO.sendUpdateBookValue(intUpdateBookPrice,srtB_Date,intUpdateTargetBookId);

			System.out.println();
			System.out.println("更新しました。");
			break;

		case "図書館":

			List<Library> UpdateLibraryTableDataList = Kadai4_8_DAO.getTableData(updateTargetTable);
			System.out.println("■図書館テーブルのデータは以下になります。");
			for(Library la : UpdateLibraryTableDataList){
				System.out.print(la.getLibrary_id() + "  ");
				System.out.println(la.getLibrary_name() + "  ");
			}
			System.out.println();
			System.out.println("■更新対象のlibrary_idを選択してください。");
			String strUpdateTargetLibrary_id = br.readLine();
			int intUpdateTargetLibrary_id = Integer.parseInt(strUpdateTargetLibrary_id);
			System.out.println();
			System.out.println("■更新後の図書館名を入力してください。");
			String strUpdateLibrary_name = br.readLine();
			Kadai4_8_DAO.sendUpdateLibraryValue(strUpdateLibrary_name,intUpdateTargetLibrary_id);

			System.out.println();
			System.out.println("更新しました。");
			break;

		case "ひも付き":

			List<Pegging> UpdatePeggingTableDataList = Kadai4_8_DAO.getTableData(updateTargetTable);
			System.out.println("■ひも付きテーブルのデータは以下になります。");
			for(Pegging pa : UpdatePeggingTableDataList){
				System.out.print(pa.getPegging_id() + "  ");
				System.out.print(pa. getLibrary_id() + "  ");
				System.out.println(pa.getId_pegging());
			}
			System.out.println();
			System.out.println("■更新対象のpegging_idを選択してください。");
			String strUpdateTargetPegging_id = br.readLine();
			int intUpdateTargetPegging_id = Integer.parseInt(strUpdateTargetPegging_id);
			System.out.println();
			System.out.println("■更新後のlibrary_idを入力してください。");
			String strUpdateLibrary_id = br.readLine();
			int intUpdateLibrary_id = Integer.parseInt(strUpdateLibrary_id);
			Kadai4_8_DAO.sendUpdatePeggingValue(intUpdateLibrary_id,intUpdateTargetPegging_id);
			System.out.println();
			System.out.println("更新しました。");
			break;

		}
	}

	private static void choiceDleleteTable(String deleteTargetTable)  throws IOException {
		Date date = new Date();
		Kadai4_8_DAO Kadai4_8_DAO = new Kadai4_8_DAO();
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		switch(deleteTargetTable){

		case "本":

			List<Book> deleteBookTableDataList = Kadai4_8_DAO.getTableData(deleteTargetTable);
			System.out.println("■本テーブルのデータは以下になります。");
			for(Book ba : deleteBookTableDataList){
				System.out.print(ba.getId() + "  ");
				System.out.print(ba.getGenre() + "  ");
				System.out.print(ba.getTitle() + "  ");
				System.out.print(ba.getPrice() + "  ");
				System.out.print(ba.getAuthor() + "  ");
				System.out.print(ba.getPublisher() + "  ");
				System.out.print(ba.getEntry_date() + "  ");
				System.out.println(ba.getUpdate_date());
			}
			System.out.println();
			System.out.println("■削除対象のidを選択してください。");
			String strDeleteTargetBookId = br.readLine();
			int intDeleteTargetBookId = Integer.parseInt(strDeleteTargetBookId);
			Kadai4_8_DAO.sendDeleteBookValue(intDeleteTargetBookId);

			System.out.println();
			System.out.println("削除しました。");
			break;

		case "図書館":

			List<Library> deleteLibraryTableDataList = Kadai4_8_DAO.getTableData(deleteTargetTable);
			System.out.println("■図書館テーブルのデータは以下になります。");
			for(Library la : deleteLibraryTableDataList){
				System.out.print(la.getLibrary_id() + "  ");
				System.out.println(la.getLibrary_name() + "  ");
			}
			System.out.println();
			System.out.println("■削除対象のlibrary_idを選択してください。");
			String strDeleteTargetLibrary_id = br.readLine();
			int intDeleteTargetLibrary_id = Integer.parseInt(strDeleteTargetLibrary_id);
			Kadai4_8_DAO.sendDeleteLibraryValue(intDeleteTargetLibrary_id);

			System.out.println();
			System.out.println("削除しました。");
			break;

		case "ひも付き":

			List<Pegging> deletePeggingTableDataList = Kadai4_8_DAO.getTableData(deleteTargetTable);
			System.out.println("■ひも付きテーブルのデータは以下になります。");
			for(Pegging pa : deletePeggingTableDataList){
				System.out.print(pa.getPegging_id() + "  ");
				System.out.print(pa. getLibrary_id() + "  ");
				System.out.println(pa.getId_pegging());
			}
			System.out.println();
			System.out.println("■削除対象のpegging_idを選択してください。");
			String strDeleteTargetPegging_id = br.readLine();
			int intDeleteTargetPegging_id = Integer.parseInt(strDeleteTargetPegging_id);
			Kadai4_8_DAO.sendDeletePeggingValue(intDeleteTargetPegging_id);
			System.out.println();
			System.out.println("削除しました。");
			break;

		}
	}
}