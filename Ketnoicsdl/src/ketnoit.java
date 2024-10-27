import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ketnoit {
	private static String DB_URL = "jdbc:sqlserver://Tuanne\\SQLEXPRESS:1433;database=ketnoi;user=sa;password=2542004Tuan@;encrypt=true;trustServerCertificate=true";
	private static String userName = "sa";
	private static String passWord = "2542004Tuan@";
	private static Connection conn = null;
	public static void getConnection(String dbURL, String userName, 
			String password) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		try {
			getConnection(DB_URL, userName, passWord);
			Statement st = conn.createStatement();
//			Cập nhật dữ liệu vô bảng
//			st.executeUpdate("INSERT INTO bang1(id, ten)"
//                    + "VALUES ('5', 'Vinh')");
//			sửa dữ liệu trong bảng
//			String suaDuLieu = "update bang1 set ten = 'tuighetlaptrinh' where id ='25'";
//			st.executeUpdate(suaDuLieu);
//			xóa dữ liệu nếu 0 có where nó sẽ xóa hết
			String xoaDuLieu = "delete from bang1 where id='100'";
			st.executeUpdate(xoaDuLieu);
//			Tham chiếu đến bảng
			ResultSet rs = st.executeQuery("select*from bang1");
			while(rs.next()) {
				System.out.println(rs.getString("id")+" "+rs.getString("ten"));
			}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
