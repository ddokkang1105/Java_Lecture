
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
			rs.close();				// C, U, D���� �ʿ����, R ���� �ʿ�
									// insert�ϰ� �Ǹ� NullPointerException�� �߻�
									// -> ��� Exception�� �������� �� ��
		} catch (Exception e) {
//			e.printStackTrace();	// -> �޼��� �Ⱥ����� !!
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
