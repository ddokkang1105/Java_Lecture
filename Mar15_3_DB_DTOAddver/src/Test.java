import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String[] restaurant = new String[10];
		
		try {
			con = DdokkangDBManager.connect();
			String sql = "select p_location from mar15_pizzarestaurant";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int i = 0;
				restaurant[i] = rs.getString("p_location");
				System.out.println(restaurant[i]);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DdokkangDBManager.close(con, pstmt, rs);
		
	
	}
}
