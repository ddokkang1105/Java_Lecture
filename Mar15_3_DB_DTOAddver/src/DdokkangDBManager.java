
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DdokkangDBManager {
	public static Connection connect() throws SQLException {
		String addr = "jdbc:oracle:thin:@192.168.0.164:1521:xe";
		return DriverManager.getConnection(addr, "ddobot", "1111");
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();				// C, U, D때는 필요없고, R 때만 필요
									// insert하게 되면 NullPointerException이 발생
									// -> 모든 Exception이 잡히도록 할 것
		} catch (Exception e) {
//			e.printStackTrace();	// -> 메세지 안보려고 !!
		}
		try {
			pstmt.close();
		} catch (Exception e) {
		}
		try {
			con.close();
		} catch (Exception e) {
		}
	}
}
