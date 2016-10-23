
public class Pegging {
	//図書館と本のひも付きテーブルの変数
	private int pegging_id;
	private int library_id;
	private int id;

	//図書館と本のひも付きテーブルの値格納
	public Pegging(int pegging_id,int library_id,int id){
		this.pegging_id = pegging_id;
		this.library_id = library_id;
		this.id = id;
	}

	//図書館と本のひも付きテーブルの値返す
	int getPegging_id(){
		return pegging_id;
	}
	int getLibrary_id(){
		return library_id;
	}
	int getId_pegging(){
		return id;
	}
}
