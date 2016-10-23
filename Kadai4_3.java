import java.util.ArrayList;
import java.util.List;

public class Kadai4_3 {
	public static void main(String[] args){
		Kadai4_3_DAO Kadai4_3_DAO = new Kadai4_3_DAO();
		List valueList = Kadai4_3_DAO.find();
		List bookList = (List) valueList.get(0);
		List libraryList = (List) valueList.get(1);
		List peggingList = (List) valueList.get(2);

		//		本テーブルのデータ表示
		List al1 = new ArrayList();
		for(Object ob : bookList){
			al1.add(ob);
		}
		System.out.println("■本テーブルのデータ");
		for(Object ob : al1){
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
		List al2 = new ArrayList();
		for(Object ob : libraryList){
			al2.add(ob);
		}
		System.out.println("■図書館テーブルのデータ");
		for(Object ob : al2){
			System.out.print(((Library) ob).getLibrary_id() + "  ");
			System.out.println(((Library) ob).getLibrary_name() + "  ");
		}

		System.out.println();

		//		図書館と本のひも付きテーブルのデータ表示
		List al3 = new ArrayList();
		for(Object ob : peggingList){
			al3.add(ob);
		}
		System.out.println("■図書館と本のひも付きテーブルのデータ");
		for(Object ob : al3){
			System.out.print(((Pegging) ob).getPegging_id() + "  ");
			System.out.print(((Pegging) ob).getLibrary_id() + "  ");
			System.out.println(((Pegging) ob).getId_pegging());
		}
	}
}