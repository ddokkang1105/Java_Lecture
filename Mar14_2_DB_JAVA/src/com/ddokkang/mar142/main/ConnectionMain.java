package com.ddokkang.mar142.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 원래 : cmd기반 sqlplus라는 프로그램으로 OracleDB제어
//				cmd기반 불편
// 사제품 : orange, toad, eclipse, dbeaver, sqldeveloper, ...

// Socket통신
// HTTP통신

// DB서버와 통신 : Java에 내장되어 있음 (미완성상태)
//		DB 메이커가 많기 때문에,,, => 메이커 별로 통신이 조금씩 다르다 !
//		연결할 DB에 맞춰서 조금씩 터치를 해줘야 함 !!

// JDBC (Java DataBase Connectivity) : 자바에서 DB프로그래밍을 하기 위해 사용되는 API
// OracleDB를 사용중 ! -> 여기에 맞춰서 터치를 해야 !
//		=> 그 기능은 ojdbc8.jar에 다 있음 

//		ojdbc8.jar 넣기만 하면 알아서 사용할 수 있음 !!

public class ConnectionMain {
	public static void main(String[] args) {
		Connection con = null;
		try {
			// 연결할 DB서버 주소 (메이커별로 형식이 다르다)
			// Data Source Explorer (없으면 Window - Show view - Other - Data Source Explorer)
			// - 서버 이름쪽에 오른쪽 마우스 버튼 클릭
			//		- Properties - Driver Properties - Connection URL 값을 복사 ! (jdbc:oracle:thin:@192.168.0.164:1521:xe)
			
			String addr = "jdbc:oracle:thin:@192.168.0.164:1521:xe";
			
			con = DriverManager.getConnection(addr, "ddobot", "1111");
			System.out.println("Success !");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();				// close 철저히 하세요 !
										// 내가 안 닫으면 다른 사람이 못써요 !
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
