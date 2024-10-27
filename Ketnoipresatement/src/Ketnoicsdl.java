import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ketnoicsdl {

	private static String url = "jdbc:sqlserver://Tuanne\\SQLEXPRESS:1433;database=bansach;user=sa;password=2542004Tuan@;encrypt=true;trustServerCertificate=true";
	private static String tenTaiKhoan = "sa";
	private static String matKhau = "2542004Tuan@";
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
		getConnection(url, tenTaiKhoan, matKhau);
		PreparedStatement ds = conn.prepareStatement("select*from thongtincs");
//		thêm dữ liệu vô bảng 
//		String themDuLieu = "INSERT INTO thongtincs (macuonsach, ten,namsanxuat) VALUES (?, ?, ?) ";
//		PreparedStatement ps = conn.prepareStatement(themDuLieu);
//		ps.setString(1, "CS003");    // Gán giá trị cho cột macuonsach
//		ps.setString(2, "Sach A");   // Gán giá trị cho cột ten
//		ps.setInt(3, 2023);          // Gán giá trị cho cột namsanxuat
//		ps.executeUpdate();
//		sửa đổi cơ sở dữ liệu, nếu 0 có câu dk where nó sẽ thay đổi hết 
//		còn xóa thì tương tự 
		PreparedStatement suaDuLieu = conn.prepareStatement("update thongtincs set ten= ?, namsanxuat = ? where macuonsach = ?");
		suaDuLieu.setString(1,"tuan");
		suaDuLieu.setInt(2, 2023);
		suaDuLieu.setString(3,"CS001");
		suaDuLieu.executeUpdate();
		ResultSet rs = ds.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("macuonsach")+" "+rs.getString("ten")+" "+rs.getInt("namsanxuat"));
		}
		conn.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
