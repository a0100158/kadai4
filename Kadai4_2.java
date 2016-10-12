import java.util.List;

public class Kadai4_2 {
	public static void main(String[] args){
		Kadai4_1_DAO k_4_1_DAO = new Kadai4_1_DAO();
		List<Book> bookArrayList = k_4_1_DAO.findAll();

		System.out.println("■本テーブルのデータ");

		for(Book ba : bookArrayList){
			System.out.print(ba.getId() + "  ");
			System.out.print(ba.getGenre() + "  ");
			System.out.print(ba.getTitle() + "  ");
			System.out.print(ba.getPrice() + "  ");
			System.out.print(ba.getAuthor() + "  ");
			System.out.print(ba.getPublisher() + "  ");
			System.out.print(ba.getEntry_date() + "  ");
			System.out.println(ba.getUpdate_date());
		}
	}
}