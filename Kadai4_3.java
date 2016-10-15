import java.util.List;

public class Kadai4_3 {
	public static void main(String[] args){
		Kadai4_3_DAO Kadai4_3_DAO = new Kadai4_3_DAO();




//		本テーブルのデータ表示
		List<TableValue> bookArrayList = Kadai4_3_DAO.findBook();
		System.out.println("■本テーブルのデータ");

		for(TableValue ba : bookArrayList){
			System.out.print(ba.getId() + "  ");
			System.out.print(ba.getGenre() + "  ");
			System.out.print(ba.getTitle() + "  ");
			System.out.print(ba.getPrice() + "  ");
			System.out.print(ba.getAuthor() + "  ");
			System.out.print(ba.getPublisher() + "  ");
			System.out.print(ba.getEntry_date() + "  ");
			System.out.println(ba.getUpdate_date() + "  ");
		}

		System.out.println();

//		図書館テーブルのデータ表示
		List<TableValue> libraryArrayList = Kadai4_3_DAO.findLibrary();
		System.out.println("■図書館テーブルのデータ");

		for(TableValue la : libraryArrayList){
			System.out.print(la.getLibrary_id() + "  ");
			System.out.println(la.getLibrary_name() + "  ");
		}

		System.out.println();

//		図書館と本のひも付きテーブルのデータ表示
		List<TableValue> peggingArrayList = Kadai4_3_DAO.findPegging();
		System.out.println("■図書館と本のひも付きテーブルのデータ");

		for(TableValue pa : peggingArrayList){
			System.out.print(pa.getPegging_id() + "  ");
			System.out.print(pa.getLibrary_id_pegging() + "  ");
			System.out.println(pa.getId_pegging());
		}
	}
}