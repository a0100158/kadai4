
public class Library {
	//図書館テーブルの変数
	private int library_id;
	private String library_name;

	//図書館テーブルの値格納
	public Library(int library_id,String library_name){
		this.library_id = library_id;
		this.library_name = library_name;
	}

	//図書館テーブルの値返す
	int getLibrary_id(){
		return library_id;
	}
	String getLibrary_name(){
		return library_name;
	}
}
