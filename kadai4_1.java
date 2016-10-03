import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class kadai4_1 {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystudy_wb1", "root", "mirai910");
            System.out.println("接続できました。");
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
}